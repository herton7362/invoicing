package com.herton.module.goods.type.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.type.domain.GoodsTypeAttribute;
import com.herton.module.goods.type.domain.GoodsTypeAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsTypeAttributeServiceImpl extends AbstractCrudService<GoodsTypeAttribute>
        implements GoodsTypeAttributeService {
}
