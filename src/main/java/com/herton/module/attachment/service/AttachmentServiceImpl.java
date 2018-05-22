package com.herton.module.attachment.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.utils.OSUtils;
import com.herton.common.utils.StringUtils;
import com.herton.config.FrameworkProperties;
import com.herton.entity.BaseUser;
import com.herton.module.attachment.domain.Attachment;
import com.herton.module.attachment.domain.AttachmentRepository;
import com.herton.module.auth.UserThread;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class AttachmentServiceImpl extends AbstractCrudService<AttachmentRepository, Attachment> implements AttachmentService {
    public static final String prefixPath = "C:";

    @Override
    public Attachment save(MultipartFile multipartFile) throws Exception {
        if(multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }
        Attachment attachment = new Attachment();
        String path = "/nfs-client/%s/%s/%s/%s.%s";
        if(multipartFile.getOriginalFilename().lastIndexOf(".") >= 0) {
            String format = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            if(StringUtils.isNotBlank(format)) {
                format = format.substring(1);
            }
            attachment.setFormat(format);
        } else {
            attachment.setFormat("");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        attachment.setName(multipartFile.getOriginalFilename());
        BaseUser user = UserThread.getInstance().get();
        String loginName = "anonymous";
        if(user != null) {
            loginName = UserThread.getInstance().get().getLoginName();
        }
        String date = format.format(new Date());
        Long unixTimestamp = new Date().getTime();
        String attachmentFormat = attachment.getFormat();
        attachment.setPath(String.format(path, FrameworkProperties.getProjectName(), loginName, date, unixTimestamp, attachmentFormat));
        attachment.setSize(multipartFile.getSize());
        String prefixPath = null;
        if(OSUtils.isWindows()) {
            prefixPath = AttachmentServiceImpl.prefixPath;
        }
        File temp = new File(prefixPath, attachment.getPath());
        FileUtils.forceMkdir(temp.getParentFile());
        multipartFile.transferTo(temp);
        return super.save(attachment);
    }

    @Override
    public List<Attachment> save(List<MultipartFile> multipartFiles) throws Exception {
        List<Attachment> attachments = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            attachments.add(save(multipartFile));
        }
        return attachments;
    }
}
