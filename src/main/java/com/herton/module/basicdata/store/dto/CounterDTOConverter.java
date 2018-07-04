package com.herton.module.basicdata.store.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.store.domain.Counter;
import org.springframework.stereotype.Component;

@Component
public class CounterDTOConverter extends SimpleDTOConverter<CounterDTO, Counter> {
}
