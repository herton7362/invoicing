package com.herton.module.attachment.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.attachment.domain.Attachment;
import org.springframework.stereotype.Component;

@Component
public class AttachmentDTOConverter extends SimpleDTOConverter<AttachmentDTO, Attachment> {
}
