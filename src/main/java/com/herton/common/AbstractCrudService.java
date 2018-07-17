package com.herton.common;

import com.herton.common.utils.CacheUtils;
import com.herton.common.utils.ReflectionUtils;
import com.herton.common.utils.SpringUtils;
import com.herton.common.utils.StringUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.CascadePersistHelper;
import com.herton.dto.Children;
import com.herton.entity.BaseEntity;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.auth.UserThread;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 抽象service提供基本的增删改查操作
 * @author tang he
 * @since 1.0.0
 * @param <E> 增删改查的实体
 * @param <D> DTO对象
 */
public abstract class AbstractCrudService<E extends BaseEntity, D extends BaseDTO<D, E>> implements CrudService<E, D> {
    protected final CacheUtils cache = CacheUtils.getInstance();
    @Value("${service.showAllEntities}")
    private Boolean showAllEntities;

    // JPA查询工厂
    protected JPAQueryFactory queryFactory;

    @Autowired
    private EntityManager em;

    @Autowired
    protected BaseDTO<D, E> baseDTO;

    @PostConstruct
    public void initFactory() {
        queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 获取实体Repository
     * {@link PageRepository} 实现类
     */
    @Autowired
    protected PageRepository<E> pageRepository;

    private Map<String, String[]> manufactureQueryParam(Map<String, ?> param) {
        Map<String, String[]> newParam = new HashMap<>();
        if(param == null) {
            return newParam;
        }
        param.forEach((key, entry) ->{
            if(entry == null) {
                return;
            }
            if(entry.getClass().isArray()) {
                newParam.put(key, (String[]) entry);
            } else {
                newParam.put(key, new String[]{String.valueOf(entry)});
            }
        });
        return newParam;
    }

    @Override
    public PageResult<D> findAll(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        Page<E> page = pageRepository.findAll(getSpecification(param), pageRequest);
        PageResult<D> pageResult = new PageResult<>();
        pageResult.setContent(baseDTO.convertFor(page.getContent()));
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setSize(page.getSize());
        pageResult.setNumber(page.getNumber());
        pageResult.setTotalPages(page.getTotalPages());
        return pageResult;
    }

    @Override
    public List<D> findAll(Map<String, ?> param) throws Exception {
        return baseDTO.convertFor(pageRepository.findAll(getSpecification(param)));
    }

    @Override
    @SuppressWarnings("unchecked")
    public D findOne(String id) {
        if(id == null) {
            return null;
        }
        if(cache.get(id) != null) {
            return (D) cache.get(id);
        }
        E e = pageRepository.findOne(id);
        D d = baseDTO.convertFor(e);
        cache.set(id, d);
        return d;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(String id) throws Exception {
        if(id == null) {
            return;
        }
        D d = findOne(id);
        List<Field> childrenFields = d.getChildrenFields((Class<D>) d.getClass());
        if(!childrenFields.isEmpty()) {
            for (Field childrenField : childrenFields) {
                Children children = childrenField.getAnnotation(Children.class);
                ChildCurdService childCurdService = SpringUtils.getBean(children.service());
                List list = (List) ReflectionUtils.getFieldValue(d, childrenField.getName());
                if(list == null) {
                    continue;
                }
                childCurdService.delete(list);
            }

        }
        pageRepository.delete(id);
        cache.remove(id);
    }

    @Override
    public void deleteByCondition(Map<String, ?> param) throws Exception {
        if(param == null) {
            throw new InvalidParamException("删除条件不能为空");
        }
        delete(findAll(param));
    }

    @Override
    @SuppressWarnings("unchecked")
    public D save(D d) throws Exception {
        if(d == null) {
            return null;
        }
        E e = pageRepository.save(d.convert());
        d.setId(e.getId());
        CascadePersistHelper.saveChildren(d);
        d = baseDTO.convertFor(e);
        cache.set(e.getId(), d);
        return d;
    }


    @Override
    public List<D> save(Iterable<D> dList) throws Exception {
        if(dList == null) {
            return null;
        }
        List<D> result = new ArrayList<>();
        for (D d : dList) {
            result.add(save(d));
        }
        return result;
    }

    @Override
    public void delete(Iterable<? extends D> ts) throws Exception {
        if(ts == null) {
            return;
        }
        for (D t : ts) {
            delete(t.getId());
            cache.remove(t.getId());
        }
    }

    /**
     * 提供重写查询的入口
     * @param param 用户传入的查询条件
     * @return {@link Specification}
     */
    protected Specification<E> getSpecification(Map<String, ?> param) {
        return new SimpleSpecification(param, showAllEntities);
    }

    /**
     * 提供重写查询的入口
     * @param param 用户传入的查询条件
     * @return {@link Specification}
     */
    protected Specification<E> getSpecificationForAllEntities(Map<String, ?> param) {
        return new SimpleSpecification(param, true);
    }

    /**
     * 查询条件实现，实现思路：
     * 1、获取当前实体的所有属性并且循环
     * 2、判断属性是否与网页传来的参数的key相同
     * 3、当属性类型为字符串时则用like判断
     * 4、当属性类型为数字时则用equal判断
     * 5、当属性类型为数字时并且value为两个是则用between判断
     */
    @SuppressWarnings("unchecked")
    protected class SimpleSpecification implements Specification<E> {
        protected Map<String, String[]> params;
        protected String currentKey;
        protected Attribute currentAttribute;
        protected Boolean allEntities;
        public SimpleSpecification(Map<String, ?> params, Boolean allEntities) {
            this.params = manufactureQueryParam(params);
            this.allEntities = allEntities;
        }
        @Override
        public Predicate toPredicate(Root<E> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Set<Attribute<? super E, ?>> attributes =  root.getModel().getAttributes();
            List<Predicate> predicate = new ArrayList<>();
            String key;
            String[] values;
            Attribute attribute;
            Set<Map.Entry<String, String[]>> set = params.entrySet();
            for (Map.Entry<String, String[]> param : set) {

                if(!containsKey(param.getKey(), attributes))  {
                    continue;
                }

                key = this.currentAttribute.getName();
                attribute = this.currentAttribute;
                Assert.isTrue(
                        !attribute.getJavaType().isPrimitive(),
                        "实体[" + root.getModel().getName() + "]:["+attribute.getName()+"]" +
                                "为基本类型，不要将实体属性设置成基本类型"
                );


                values = param.getValue();

                if(values == null || StringUtils.isBlank(values[0])) {
                    continue;
                }

                if("isNull".equals(values[0])) {
                    predicate.add(criteriaBuilder.isNull(root.get(key)));
                } else if(attribute.getJavaType().equals(String.class)) {
                    if(values.length == 1) {
                        predicate.add(criteriaBuilder.like(root.get(key), "%"+ values[0] +"%"));
                    } else {
                        for (String value : values) {
                            if("isNull".equals(value)) {
                                criteriaBuilder.or(criteriaBuilder.isNull(root.get(key)));
                                break;
                            }
                        }

                        predicate.add(criteriaBuilder.in(root.get(key)).value(Arrays.asList(values)));
                    }
                } else if(attribute.getJavaType().equals(Boolean.class)) {
                    predicate.add(criteriaBuilder.equal(root.get(key), Boolean.valueOf(values[0])));
                } else if(attribute.getJavaType().getSuperclass().equals(Enum.class)) {
                    predicate.add(criteriaBuilder.equal(root.get(key), Enum.valueOf(attribute.getJavaType(), values[0])));
                } else if(attribute.getJavaType().getSuperclass().equals(Number.class)) {
                    NumberFormat nf = NumberFormat.getInstance();
                    if(values.length == 1) {
                        try {
                            predicate.add(criteriaBuilder.equal(root.get(key), nf.parse(values[0])));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    } else if(values.length == 2) {
                        try {
                            predicate.add(criteriaBuilder.and(
                                    criteriaBuilder.gt(root.get(key), nf.parse(values[0])),
                                    criteriaBuilder.lt(root.get(key), nf.parse(values[1]))
                            ));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else if(attribute.getJavaType().equals(Date.class)) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if(values.length == 1) {
                        try {
                            predicate.add(criteriaBuilder.equal(root.get(key), df.parse(values[0])));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    } else if(values.length == 2) {
                        try {
                            predicate.add(criteriaBuilder.and(
                                    criteriaBuilder.greaterThanOrEqualTo(root.get(key), df.parse(values[0])),
                                    criteriaBuilder.lessThanOrEqualTo(root.get(key), df.parse(values[1]))
                            ));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else if(BaseEntity.class.isAssignableFrom(attribute.getJavaType())) {
                    String field = this.getFiled();
                    if(StringUtils.isBlank(field)) {
                        continue;
                    }
                    EntityManager entityManager = SpringUtils.getBean(EntityManager.class);
                    Query query = entityManager.createQuery("select m from "+
                            getEntityName(attribute.getJavaType(), root, key)+" m where m."+field+" like :" + field);
                    query.setParameter(field, "%" + values[0] + "%");
                    List list = query.getResultList();
                    if(!list.isEmpty()) {
                        predicate.add(criteriaBuilder.in(root.get(key)).value(list));
                    } else {
                        predicate.add(criteriaBuilder.isNull(root.get(key)));
                    }
                }
            }
            String clientId = UserThread.getInstance().getClientId();
            if(StringUtils.isNotBlank(clientId) && !this.allEntities) {
                predicate.add(criteriaBuilder.equal(root.get("clientId"), UserThread.getInstance().getClientId()));
            }
            return criteriaBuilder.and(predicate.toArray(new Predicate[]{}));
        }

        private String getEntityName(Class<?> clazz, Root<E> root, String key) {
            if("parent".equals(key)) {
                return root.getJavaType().getSimpleName();
            }
            return clazz.getSimpleName();
        }

        private Boolean containsKey(String k, Set<Attribute<? super E, ?>> attributes) {
            String key;
            for(Attribute attribute : attributes) {
                key = attribute.getName();
                if (k.split("\\.")[0].equals(key)
                        || k.split("\\[")[0].equals(key)) {
                    this.currentKey = k;
                    this.currentAttribute = attribute;
                    return true;
                }
            }
            return false;
        }

        private String getFiled() {
            String field = null;
            if(currentKey.contains(".")) {
                field = currentKey.split("\\.")[1];
            } else if (currentKey.contains("[")) {
                field = currentKey.split("\\[")[1];
                if(StringUtils.isNotBlank(field)) {
                    field = field.split("]")[0];
                }
            }
            return field;
        }
    }

    public void sort(List<E> ts) throws Exception {
        E t;
        for (int i = 0; i < ts.size(); i++) {
            if(StringUtils.isBlank(ts.get(i).getId())) {
                throw new InvalidParamException("参数不正确，缺失主键");
            }
            t = pageRepository.findOne(ts.get(i).getId());
            t.setSortNumber(i);
            pageRepository.save(t);
        }
    }

    public void enable(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("id不能为空");
        }
        E t = pageRepository.findOne(id);
        if(!t.getLogicallyDeleted()) {
            return;
        }
        t.setLogicallyDeleted(false);
        pageRepository.save(t);
    }

    public void disable(String id) throws Exception {
        if(StringUtils.isBlank(id)) {
            throw new InvalidParamException("id不能为空");
        }
        E t = pageRepository.findOne(id);
        if(t.getLogicallyDeleted()) {
            return;
        }
        t.setLogicallyDeleted(true);
        pageRepository.save(t);
    }

    @Override
    public Long count(Map<String, ?> param) {
        return pageRepository.count(getSpecification(manufactureQueryParam(param)));
    }
}
