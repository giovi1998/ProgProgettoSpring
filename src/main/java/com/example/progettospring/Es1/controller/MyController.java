package com.example.progettospring.Es1.controller;


import com.example.progettospring.Es1.services.MyService;
import com.example.progettospring.Es1.entities.Company;
import com.example.progettospring.Es1.entities.Parola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MyController {

    private MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<Company> getAllCompanies(
            @RequestParam(required = false) String startsWith
    ){
        return myService.getAllCompanies(startsWith);
    }

    @RequestMapping(value = "/randomNumber", method = RequestMethod.GET)
    public int getRandomNumber(){
        return myService.setNumRandom();
    }


    @RequestMapping(value = "/parola/{parola}", method = RequestMethod.GET)
    public ResponseEntity<Parola> createParola(
            @RequestBody String parola
    ){
        Parola c = myService.createParola(parola,parola.length());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(c);
    }

    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    public int getCount(){
        return myService.getCount();
    }

    @RequestMapping(value = "/incrementaCount", method = RequestMethod.POST)
    public void setCountInc(){
       myService.setCountInc();
    }

    @RequestMapping(value = "/decrementaCount", method = RequestMethod.POST)
    public void setCountDec(){
        myService.setCountDec();
    }



    @RequestMapping(value = "/company/{companyID}", method = RequestMethod.GET)
    public Company getCompanyByID(
            @PathVariable UUID companyID
    ){
        return myService.getCompanyByID(companyID);
    }




    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public ResponseEntity<Company> createCompany(
            @RequestBody Company company
    ){
        Company c = myService.createCompany(company);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(c);
    }



}
