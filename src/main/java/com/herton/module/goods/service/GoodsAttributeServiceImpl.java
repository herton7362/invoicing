package com.herton.module.goods.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.dto.GoodsAttributeDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsAttributeServiceImpl extends AbstractChildCrudService<GoodsAttribute, GoodsAttributeDTO>
        implements GoodsAttributeService {
}
