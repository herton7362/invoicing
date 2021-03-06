package com.herton.module.attachment.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.attachment.domain.Attachment;
import com.herton.module.attachment.dto.AttachmentDTO;
import com.herton.module.attachment.service.AttachmentService;
import com.herton.module.attachment.service.AttachmentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Api(value = "附件管理")
@RestController
@RequestMapping("/api/attachment")
public class AttachmentController extends AbstractCrudController<Attachment, AttachmentDTO> {
    protected AttachmentService getService() {
        return (AttachmentService) crudService;
    }

    /**
     * 删除
     */
    @ApiOperation(value="删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
        ResponseEntity<?> responseEntity;
        AttachmentDTO attachment = getService().findOne(id);
        try {
            responseEntity = super.delete(id);
            File temp = new File(AttachmentServiceImpl.prefixPath, attachment.getPath());
            temp.delete();
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new InvalidParamException("当前附件已经被使用，需要先删除关联数据");
        }
        return responseEntity;
    }
}
