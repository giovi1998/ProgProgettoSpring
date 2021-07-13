package com.example.progettospring.Es1.repositories;

import com.example.progettospring.Es1.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MyRepository {

    private List<Company> companies = new ArrayList<>();


    public List<Company> getAllCompanies(){
        return companies;
    }

    public Company getCompanyByID(UUID companyID){
        return companies.stream().filter(c -> c.getId().equals(companyID)).findFirst().orElse(null);
    }


    public Company createCompany(Company company){
        companies.add(company);

        return company;
    }




}
