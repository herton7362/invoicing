package com.herton.module.basicdata.member.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.basicdata.member.domain.MemberCardType;
import com.herton.module.basicdata.member.domain.MemberCardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MemberCardTypeServiceImpl extends AbstractCrudService<MemberCardType>
        implements MemberCardTypeService {
}
