package com.herton.module.attachment.web;

import com.herton.common.AbstractReadController;
import com.herton.common.CrudService;
import com.herton.common.utils.OSUtils;
import com.herton.module.attachment.domain.Attachment;
import com.herton.module.attachment.dto.AttachmentDTO;
import com.herton.module.attachment.service.AttachmentService;
import com.herton.module.attachment.service.AttachmentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Api(value = "游客附件接口，无权限过滤")
@RestController
@RequestMapping("/attachment")
public class GuestAttachmentController extends AbstractReadController<Attachment, AttachmentDTO> {
    private AttachmentService getService() {
        return (AttachmentService) crudService;
    }
    /**
     * 上传文件
     */
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ResponseEntity<List<AttachmentDTO>> upload(@RequestParam("attachments") MultipartFile[] attachments) throws Exception {
        List<AttachmentDTO> results = getService().save(Arrays.asList(attachments));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * 下载文件
     */
    @ApiOperation(value="下载文件")
    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@PathVariable String id) throws Exception {
        AttachmentDTO attachment = getService().findOne(id);
        String prefixPath = null;
        if(OSUtils.isWindows()) {
            prefixPath = AttachmentServiceImpl.prefixPath;
        }
        if(attachment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        File file=new File(prefixPath, attachment.getPath());
        HttpHeaders headers=new HttpHeaders();
        String downloadFileName=new String(attachment.getName().getBytes("UTF-8"),"ISO-8859-1");  //少了这句，可能导致下载中文文件名的文档，只有后缀名的情况
        headers.setContentDispositionFormData("attachment", downloadFileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}
