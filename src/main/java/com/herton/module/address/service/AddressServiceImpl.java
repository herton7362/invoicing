package com.herton.module.address.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.address.domain.Address;
import com.herton.module.address.domain.AddressRepository;
import com.herton.module.address.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AddressServiceImpl extends AbstractCrudService<Address, AddressDTO> implements AddressService {
}
