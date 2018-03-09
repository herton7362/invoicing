package com.herton.module.dictionary.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.dictionary.domain.Dictionary;
import com.herton.module.dictionary.domain.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DictionaryServiceImpl extends AbstractCrudService<Dictionary> implements DictionaryService {
    private final DictionaryRepository dictionaryRepository;
    @Override
    protected PageRepository<Dictionary> getRepository() {
        return dictionaryRepository;
    }

    @Autowired
    public DictionaryServiceImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }
}
