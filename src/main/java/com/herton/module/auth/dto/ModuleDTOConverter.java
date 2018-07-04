package com.herton.module.auth.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.Module;
import org.springframework.stereotype.Component;

@Component
public class ModuleDTOConverter extends SimpleDTOConverter<ModuleDTO, Module> {
}
