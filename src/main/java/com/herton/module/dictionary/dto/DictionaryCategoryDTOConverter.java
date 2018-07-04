package com.herton.module.dictionary.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.dictionary.domain.DictionaryCategory;
import org.springframework.stereotype.Component;

@Component
public class DictionaryCategoryDTOConverter extends SimpleDTOConverter<DictionaryCategoryDTO, DictionaryCategory> {
}
