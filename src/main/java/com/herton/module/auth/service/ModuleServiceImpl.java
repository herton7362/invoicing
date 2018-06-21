package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ModuleServiceImpl extends AbstractCrudService<Module> implements ModuleService {
}
