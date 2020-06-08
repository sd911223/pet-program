package com.pet.service.impl;

import com.pet.common.RestResponse;
import com.pet.service.ImgUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class ImgUploadServiceImpl implements ImgUploadService {
    @Override
    public RestResponse upload(MultipartFile file) {
        return null;
    }
}
