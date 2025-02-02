package com.vinay.nagisdetty.company_microservice.company.clients;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "REVIEW-MICROSERVICE")
public interface ReviewClients {

    @GetMapping("/reviews/averagerating")
    public Double getAverageRating(@RequestParam("companyId") Long companyId);
}
