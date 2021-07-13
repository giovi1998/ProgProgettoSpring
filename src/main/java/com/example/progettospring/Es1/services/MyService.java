package com.example.progettospring.Es1.services;

import com.example.progettospring.Es1.repositories.MyRepository;
import com.example.progettospring.Es1.entities.Company;
import com.example.progettospring.Es1.entities.Parola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MyService {

    private MyRepository myRepository;
    private Integer numRandom;
    private int count=0;


    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }


    public List<Company> getAllCompanies(String startsWith){
        return myRepository.getAllCompanies().stream().filter(c -> c.getName().startsWith(startsWith)).collect(Collectors.toList());
    }

    public Company getCompanyByID(UUID companyID){
        Company c = myRepository.getCompanyByID(companyID);

        if (c == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found for id " + companyID);

        return c;
    }

    public Integer getNumRandom() {
        return numRandom;
    }

    public int setNumRandom() {
        Random random = new Random();
        this.numRandom =  random.nextInt();
        return numRandom;
    }

    public Company createCompany(Company company){
       return myRepository.createCompany(company);
    }

    public Parola createParola(String parola, int length) {
        return new Parola (parola, length);
    }

    public int getCount() {
        return count;
    }

    public void setCountInc() {
       ++count;
    }
    public void setCountDec() {
        --count;
    }

}
