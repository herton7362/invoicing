package com.herton.module.dictionary.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.dictionary.domain.Dictionary;
import org.springframework.stereotype.Component;

@Component
public class DictionaryDTOConverter extends SimpleDTOConverter<DictionaryDTO, Dictionary> {
}
