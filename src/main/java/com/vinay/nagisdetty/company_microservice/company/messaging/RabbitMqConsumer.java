package com.vinay.nagisdetty.company_microservice.company.messaging;

import com.vinay.nagisdetty.company_microservice.company.CompanyService;
import com.vinay.nagisdetty.company_microservice.company.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqConsumer {

private CompanyService companyService;

    public RabbitMqConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "company-review-queue")
    public void consume(ReviewMessage reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }
}
