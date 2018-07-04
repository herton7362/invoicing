package com.herton.module.basicdata.store.service;

import com.herton.common.CrudService;
import com.herton.module.basicdata.store.domain.Counter;
import com.herton.module.basicdata.store.dto.CounterDTO;

public interface CounterService extends CrudService<Counter, CounterDTO> {
    /**
     * 获取收银台数量
     * @param storeId 门店id
     * @return 收银台数量
     */
    Integer getStoreCounterCount(String storeId) throws Exception;
}
