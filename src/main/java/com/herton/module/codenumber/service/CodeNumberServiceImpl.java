package com.herton.module.codenumber.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.codenumber.domain.CodeNumber;
import com.herton.module.codenumber.domain.CodeNumberRepository;
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
public class CodeNumberServiceImpl extends AbstractCrudService<CodeNumber> implements CodeNumberService {
    private final CodeNumberRepository codeNumberRepository;
    private final SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
    @Override
    protected PageRepository<CodeNumber> getRepository() {
        return codeNumberRepository;
    }

    @Override
    public CodeNumber generateNextCode(String businessType) throws Exception {
        if(StringUtils.isBlank(businessType)) {
            throw new BusinessException("业务类型不能为空");
        }
        if(CodeNumber.BusinessType.valueOf(businessType) == null) {
            throw new BusinessException("业务类型不正确");
        }
        Map<String, String> param = new HashMap<>();
        param.put("businessType", businessType);
        List<CodeNumber> codeNumbers = findAll(param);
        CodeNumber codeNumber;
        if(codeNumbers != null && !codeNumbers.isEmpty()) {
            codeNumber = codeNumbers.get(0);
            String time1 = s.format(codeNumber.getUpdatedDate());
            String time2 = s.format(new Date());
            // 如果日期变了则重新开始计数
            if(time1.equals(time2)) {
                codeNumber.setNextCode(String.format("%03d", Integer.valueOf(codeNumber.getNextCode()) + 1));
            } else {
                codeNumber.setNextCode(String.format("%03d", 1));
            }
            codeNumberRepository.save(codeNumber);
            return codeNumber;
        } else {
            codeNumber = new CodeNumber();
            codeNumber.setBusinessType(CodeNumber.BusinessType.valueOf(businessType));
            codeNumber.setNextCode(String.format("%03d", 1));
            return codeNumber;
        }
    }

    @Override
    public String getCodeByBusinessType(String businessType) throws Exception {
        if(StringUtils.isBlank(businessType)) {
            throw new BusinessException("业务类型不能为空");
        }
        if(CodeNumber.BusinessType.valueOf(businessType) == null) {
            throw new BusinessException("业务类型不正确");
        }
        Map<String, String> param = new HashMap<>();
        param.put("businessType", businessType);
        List<CodeNumber> codeNumbers = findAll(param);
        if(codeNumbers != null && !codeNumbers.isEmpty()) {
            return formatCode(codeNumbers.get(0));
        } else {
            CodeNumber codeNumber = generateNextCode(businessType);
            return formatCode(codeNumber);
        }
    }

    private String formatCode (CodeNumber codeNumber) {

        return String.format("%s-%s-%s",
                codeNumber.getBusinessType().name(), s.format(new Date()), codeNumber.getNextCode());
    }

    @Autowired
    public CodeNumberServiceImpl(CodeNumberRepository codeNumberRepository) {
        this.codeNumberRepository = codeNumberRepository;
    }
}
