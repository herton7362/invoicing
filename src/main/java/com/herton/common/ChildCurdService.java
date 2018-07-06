package com.herton.common;

import com.herton.dto.BaseDTO;
import com.herton.entity.BaseEntity;

import java.util.List;

public interface ChildCurdService<E extends BaseEntity, D extends BaseDTO<D, E>> extends CrudService<E, D> {
    /**
     * 保存子表，针对一对多关系
     * @param parentId 父集id
     * @param dList 需要保存的实体列表
     * @return 保存后的列表
     */
    List<D> saveAsChildren(String parentId, List<D> dList) throws Exception;
}
