package com.vinay.nagisdetty.company_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompanyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyMicroserviceApplication.class, args);
	}

}
