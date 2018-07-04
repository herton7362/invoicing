package com.herton.module.goods.type.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.dto.GoodsTypeDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsTypeServiceImpl extends AbstractCrudService<GoodsType, GoodsTypeDTO> implements GoodsTypeService {
}
