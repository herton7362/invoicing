package com.herton.module.basicdata.store.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.store.domain.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreDTOConverter extends SimpleDTOConverter<StoreDTO, Store> {
}
