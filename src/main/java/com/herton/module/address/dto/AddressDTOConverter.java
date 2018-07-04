package com.herton.module.address.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.address.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOConverter extends SimpleDTOConverter<AddressDTO, Address> {
}
