package com.pet.service.impl;

import com.pet.common.RestResponse;
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
        //处理图片
//        SecurityProperties.User currentUser = userService.getCurrentUser();
//        //获取路径
//        String return_path = ImageUtil.getFilePath(currentUser);
//        String filePath = location + return_path;
//        log.info("图片保存路径={}", filePath);
//        String file_name = null;
//        try {
//            file_name = saveImg(multipartFile, filePath);
//            ResultUtil markDVo = new ResultUtil();
//            ResultUtil.success()
//            markDVo.setSuccess(0);
//            if (StringUtils.isNotBlank(file_name)) {
//                markDVo.set(1);
//                markDVo.setMessage("上传成功");
//                markDVo.setUrl(return_path + File.separator + file_name);
//                markDVo.setCallback(callback);
//            }
//            logger.info("返回值：{}", markDVo);
//            return markDVo;
//        } catch (IOException e) {
//            throw new BusinessException("上传失败!");
//        }

        return null;
    }

    public String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID() + ".png";
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
