package com.herton.module.basicdata.cashbank.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import org.springframework.stereotype.Component;

@Component
public class AccountingSubjectDTOConverter extends SimpleDTOConverter<AccountingSubjectDTO, AccountingSubject> {
}
