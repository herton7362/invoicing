package com.herton.module.basicdata.businessrelatedunit.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BusinessRelatedUnitDTOConverter extends SimpleDTOConverter<BusinessRelatedUnitDTO, BusinessRelatedUnit> {
}
