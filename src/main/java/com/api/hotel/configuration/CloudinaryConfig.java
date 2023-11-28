package com.api.hotel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dzsd5rmnx");
        config.put("api_key", "639248216746197");
        config.put("api_secret", "DZes4Bha1RRJhSLwvhpLsORqpBI");
        return new Cloudinary(config);
    }
}
