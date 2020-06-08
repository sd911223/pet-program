package com.pet.service;

import com.pet.common.RestResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImgUploadService {
    RestResponse upload(MultipartFile file);
}
