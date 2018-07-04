package com.herton.module.attachment.service;

import com.herton.common.CrudService;
import com.herton.module.attachment.domain.Attachment;
import com.herton.module.attachment.dto.AttachmentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService extends CrudService<Attachment, AttachmentDTO> {
    /**
     * 保存
     * @param multipartFile 待保存文件
     * @return 保存好的实体
     */
    AttachmentDTO save(MultipartFile multipartFile) throws Exception;

    /**
     * 批量保存
     * @param multipartFiles 待保存文件
     * @return 保存好的实体
     */
    List<AttachmentDTO> save(List<MultipartFile> multipartFiles) throws Exception;
}
