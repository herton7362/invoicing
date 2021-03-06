package com.herton.module.codenumber.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.domain.CodeNumberRepository;
import com.herton.module.codenumber.dto.CodeNumberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class CodeNumberServiceImpl extends AbstractCrudService<CodeNumber, CodeNumberDTO> implements CodeNumberService {
    private final SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");

    @Override
    public CodeNumber generateNextCode(CodeNumber.BusinessType businessType) {
        if(businessType == null) {
            throw new InvalidParamException("业务类型不能为空");
        }
        Map<String, String> param = new HashMap<>();
        param.put("businessType", businessType.name());
        List<CodeNumberDTO> codeNumbers = findAll(param);
        CodeNumber codeNumber;
        if(codeNumbers != null && !codeNumbers.isEmpty()) {
            codeNumber = codeNumbers.get(0).convert();
            String time1 = s.format(codeNumber.getUpdatedDate());
            String time2 = s.format(new Date());
            // 如果日期变了则重新开始计数
            if(time1.equals(time2)) {
                codeNumber.setNextCode(String.format("%03d", Integer.valueOf(codeNumber.getNextCode()) + 1));
            } else {
                codeNumber.setNextCode(String.format("%03d", 1));
            }
            pageRepository.save(codeNumber);
            return codeNumber;
        } else {
            codeNumber = new CodeNumber();
            codeNumber.setBusinessType(businessType);
            codeNumber.setNextCode(String.format("%03d", 1));
            pageRepository.save(codeNumber);
            return codeNumber;
        }
    }

    @Override
    public String getCodeByBusinessType(CodeNumber.BusinessType businessType) {
        if(businessType == null) {
            throw new InvalidParamException("业务类型不能为空");
        }
        Map<String, String> param = new HashMap<>();
        param.put("businessType", businessType.name());
        List<CodeNumberDTO> codeNumbers = findAll(param);
        if(codeNumbers != null && !codeNumbers.isEmpty()) {
            return formatCode(codeNumbers.get(0));
        } else {
            CodeNumber codeNumber = generateNextCode(businessType);
            return formatCode(new CodeNumberDTO().convertFor(codeNumber));
        }
    }

    private String formatCode (CodeNumberDTO codeNumber) {

        return String.format("%s-%s-%s",
                codeNumber.getBusinessType().name(), s.format(new Date()), codeNumber.getNextCode());
    }
}
