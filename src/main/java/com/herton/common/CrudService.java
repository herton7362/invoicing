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
    PageResult<D> findAll(PageRequest pageRequest, Map<String, ?> param) throws Exception;

    /**
     * 列表查询
     * @param param 查询条件
     * @return 实体列表
     */
    List<D> findAll(Map<String, ?> param) throws Exception;

    /**
     * 查询一个
     * @param id 主键
     * @return 实体
     */
    D findOne(String id) throws Exception;

    /**
     * 删除
     * @param id 主键
     */
    void delete(String id) throws Exception;

    /**
     * 删除
     * @param ts 待删除的列表
     */
    void delete(Iterable<? extends D> ts) throws Exception;

    /**
     * 根据条件删除删除
     * @param param 删除条件
     */
    void deleteByCondition(Map<String, ?> param) throws Exception;

    /**
     * 新增或修改
     * @param d 实体，如果主键不为空则修改，为空则保存
     * @return 保存后的实体
     */
    D save(D d) throws Exception;

    /**
     * 批量保存
     * @param dList 需要保存的实体列表
     * @return 保存后的列表
     */
    List<D> save(Iterable<D> dList) throws Exception;

    /**
     * 调整排序
     * @param ts 调整后的顺序列表
     */
    void sort(List<E> ts) throws Exception;

    /**
     * 启用
     * @param id 主键
     */
    void enable(String id) throws Exception;

    /**
     * 停用
     * @param id 主键
     */
    void disable(String id) throws Exception;

    /**
     * 获取数量
     * @param param 查询条件
     * @return 数量
     */
    Long count(Map<String, ?> param) throws Exception;
}
