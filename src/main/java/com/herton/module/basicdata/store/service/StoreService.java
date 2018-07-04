package com.herton.module.basicdata.store.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.store.domain.Store;
import com.herton.module.basicdata.store.dto.StoreDTO;

public interface StoreService extends CrudService<Store, StoreDTO> {
    /**
     * 获取收银台数量
     * @param id 门店id
     * @return 收银台数量
     */
    Integer getCounterCount(String id) throws Exception;
}
