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

import java.io.*;
import java.util.UUID;

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
        String root_fileName = file.getOriginalFilename();
        log.info("上传图片:name={},type={}", root_fileName, contentType);
        log.info("图片保存路径={}", location);
        String file_name = null;
        try {
            file_name = saveImg(file, location);
            return ResultUtil.success(file_name);
        } catch (IOException e) {
            throw new BusinessException("上传失败!");
        }
    }

    public String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID().toString().replace("-", "") + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

}
