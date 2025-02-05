package com.vinay.nagisdetty.company_microservice.company.impl;



import com.vinay.nagisdetty.company_microservice.company.Company;
import com.vinay.nagisdetty.company_microservice.company.CompanyRepository;
import com.vinay.nagisdetty.company_microservice.company.CompanyService;
import com.vinay.nagisdetty.company_microservice.company.clients.ReviewClients;
import com.vinay.nagisdetty.company_microservice.company.dto.ReviewMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private ReviewClients reviewClients;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClients reviewClients) {
        this.companyRepository = companyRepository;
        this.reviewClients = reviewClients;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getTitle());
        Company company = companyRepository.findById(reviewMessage.getCompanyId()).orElse(null);
        Double averageRating = reviewClients.getAverageRating(reviewMessage.getCompanyId());

        if (company != null) {
            company.setRating(averageRating);
            companyRepository.save(company);
        }

    }

}
