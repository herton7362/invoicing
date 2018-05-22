package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.domain.GoodsAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsAttributeServiceImpl extends AbstractCrudService<GoodsAttributeRepository, GoodsAttribute>
        implements GoodsAttributeService {
}
