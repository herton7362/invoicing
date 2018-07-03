package com.herton.module.basicdata.businessrelatedunit.dto;

import com.herton.dto.DTOConverter;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BusinessRelatedUnitDTOConverter extends DTOConverter<BusinessRelatedUnitDTO, BusinessRelatedUnit> {
    @Override
    protected BusinessRelatedUnit doForward(BusinessRelatedUnitDTO businessRelatedUnitDTO) {
        BusinessRelatedUnit businessRelatedUnit = new BusinessRelatedUnit();
        BeanUtils.copyProperties(businessRelatedUnitDTO, businessRelatedUnit);
        return businessRelatedUnit;
    }

    @Override
    protected BusinessRelatedUnitDTO doBackward(BusinessRelatedUnit businessRelatedUnit) {
        BusinessRelatedUnitDTO businessRelatedUnitDTO = new BusinessRelatedUnitDTO();
        BeanUtils.copyProperties(businessRelatedUnit, businessRelatedUnitDTO);
        return businessRelatedUnitDTO;
    }
}
