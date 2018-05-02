package com.herton.module.codenumber.service;

import com.herton.common.CrudService;
import com.herton.module.codenumber.domain.CodeNumber;

public interface CodeNumberService extends CrudService<CodeNumber> {
    /**
     * 生成下一个编号
     * @param businessType 业务类型
     * @return 编号类
     */
    CodeNumber generateNextCode(CodeNumber.BusinessType businessType) throws Exception;

    /**
     * 获取编号
     * @param businessType 业务类型
     * @return 编号
     */
    String getCodeByBusinessType(CodeNumber.BusinessType businessType) throws Exception;
}
