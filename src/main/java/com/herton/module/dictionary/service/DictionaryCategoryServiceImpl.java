package com.herton.module.dictionary.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.dictionary.domain.DictionaryCategory;
import com.herton.module.dictionary.domain.DictionaryCategoryRepository;
import com.herton.module.dictionary.dto.DictionaryCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DictionaryCategoryServiceImpl extends AbstractCrudService<DictionaryCategory, DictionaryCategoryDTO>
        implements DictionaryCategoryService {
}
