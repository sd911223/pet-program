package com.pet.service.impl;

import com.pet.common.RestResponse;
import com.pet.common.ResultUtil;
import com.pet.exception.BusinessException;
import com.pet.service.ImgUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class ImgUploadServiceImpl implements ImgUploadService {
    @Value("${img.location}")
    private String location;

    @Override
    public RestResponse upload(MultipartFile file) {
        if (file.isEmpty() || StringUtils.isBlank(file.getOriginalFilename())) {
            throw new BusinessException("图片不能空!");
        }
        String contentType = file.getContentType();
        if (!contentType.contains("")) {
            throw new BusinessException("图片格式错误!");
        }

        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;

        log.info("上传图片:name={},type={}", fileName, contentType);
        String file_name = null;
        try {
            file_name = saveImg(file, fileName);
            return ResultUtil.success(file_name);
        } catch (IOException e) {
            throw new BusinessException("上传失败!");
        }
    }

    public String saveImg(MultipartFile multipartFile, String filename) throws IOException {
        File file = new File(location);
        if (!file.exists()) {
            file.mkdirs();
        }

        File fileServer = new File(file, filename);
        log.info("file文件真实路径:{}", fileServer.getAbsolutePath());

        multipartFile.transferTo(fileServer);

        return location+filename;
    }

}
