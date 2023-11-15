package com.api.hotel.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    Map<String, Object> upload(MultipartFile multipartFile) throws IOException;

    Map<String, Object> delete(String id) throws IOException;
}
