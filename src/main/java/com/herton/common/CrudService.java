package com.herton.common;

import com.herton.dto.BaseDTO;
import com.herton.entity.BaseEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface CrudService<E extends BaseEntity, D extends BaseDTO<D, E>> {
    /**
     * 分页查询
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link PageResult} spring boot 分页类
     */
    PageResult<D> findAll(PageRequest pageRequest, D param);

    /**
     * 分页查询
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link PageResult} spring boot 分页类
     */
    PageResult<E> findAllEntities(PageRequest pageRequest, E param);

    /**
     * 分页查询
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link PageResult} spring boot 分页类
     */
    PageResult<D> findAll(PageRequest pageRequest, Map<String, ?> param);

    /**
     * 分页查询
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link PageResult} spring boot 分页类
     */
    PageResult<E> findAllEntities(PageRequest pageRequest, Map<String, ?> param);

    /**
     * 列表查询
     * @param param 查询条件
     * @return 实体列表
     */
    List<D> findAll(Map<String, ?> param);

    /**
     * 列表查询
     * @param param 查询条件
     * @return 实体列表
     */
    List<E> findAllEntities(Map<String, ?> param);

    /**
     * 查询一个
     * @param id 主键
     * @return 实体
     */
    D findOne(String id);

    /**
     * 查询一个
     * @param id 主键
     * @return 实体
     */
    E findOneEntity(String id);

    /**
     * 删除
     * @param id 主键
     */
    void delete(String id);

    /**
     * 删除
     * @param ts 待删除的列表
     */
    void delete(Iterable<? extends D> ts);

    /**
     * 删除
     * @param ts 待删除的列表
     */
    void deleteEntities(Iterable<? extends E> ts);

    /**
     * 根据条件删除删除
     * @param param 删除条件
     */
    void deleteByCondition(Map<String, ?> param);

    /**
     * 新增或修改
     * @param d 实体，如果主键不为空则修改，为空则保存
     * @return 保存后的实体
     */
    D save(D d);

    /**
     * 新增或修改
     * @param d 实体，如果主键不为空则修改，为空则保存
     * @return 保存后的实体
     */
    E saveEntity(E e);

    /**
     * 批量保存
     * @param dList 需要保存的实体列表
     * @return 保存后的列表
     */
    List<D> save(Iterable<D> dList);

    /**
     * 批量保存
     * @param dList 需要保存的实体列表
     * @return 保存后的列表
     */
    List<E> saveEntities(Iterable<E> eList);

    /**
     * 调整排序
     * @param ts 调整后的顺序列表
     */
    void sort(List<E> ts);

    /**
     * 启用
     * @param id 主键
     */
    void enable(String id);

    /**
     * 停用
     * @param id 主键
     */
    void disable(String id);

    /**
     * 获取数量
     * @param param 查询条件
     * @return 数量
     */
    Long count(Map<String, ?> param);
}
