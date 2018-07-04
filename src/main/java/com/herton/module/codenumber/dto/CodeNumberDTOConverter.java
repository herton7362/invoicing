package com.herton.module.codenumber.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.codenumber.domain.CodeNumber;
import org.springframework.stereotype.Component;

@Component
public class CodeNumberDTOConverter extends SimpleDTOConverter<CodeNumberDTO, CodeNumber> {
}
