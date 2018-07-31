package com.herton.module.orderform.transfer.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.dto.AdminDTO;
import com.herton.module.auth.service.AdminService;
import com.herton.module.orderform.transfer.domain.TransferOrder;
import com.herton.module.orderform.transfer.service.TransferOrderSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransferOrderDTOConverter extends SimpleDTOConverter<TransferOrderDTO, TransferOrder> {
    @Autowired
    private TransferOrderSkuService transferOrderSkuService;
    @Autowired
    private AdminService adminService;
    @Override
    protected TransferOrderDTO doBackward(TransferOrder transferOrder) {
        TransferOrderDTO transferOrderDTO = super.doBackward(transferOrder);
        Map<String, String> param = new HashMap<>();
        param.put("transferOrderId", transferOrderDTO.getId());
        transferOrderDTO.setItems(transferOrderSkuService.findAll(param));
        AdminDTO admin = adminService.findOne(transferOrder.getCreateUserId());
        if(admin != null) {
            transferOrderDTO.setCreateUserName(admin.getName());
        }
        transferOrderDTO.setStatusName(transferOrder.getStatus().getDisplayName());
        return transferOrderDTO;
    }
}
