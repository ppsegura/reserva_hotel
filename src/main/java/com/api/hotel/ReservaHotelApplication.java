package com.api.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import com.cloudinary.Cloudinary;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ReservaHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaHotelApplication.class, args);
	}
	
	@Bean
    Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dzsd5rmnx");
        config.put("api_key", "639248216746197");
        config.put("api_secret", "DZes4Bha1RRJhSLwvhpLsORqpBI");
        return new Cloudinary(config);
    }

	@Bean
	OpenAPI personalizarApi() {
		
		return new OpenAPI()
				.info(new Info()
				.title("HotelAPI")
				.version("1")
				.description("Api de la empresa EasyStay ©")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("EasyStay 1.0").url("http://localhost:4200/listar")));
		
	}	
	
}
