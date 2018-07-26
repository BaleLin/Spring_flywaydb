package com.oocl.Spring_flywaydb.controller;

import com.oocl.Spring_flywaydb.controller.dto.CompaniesDTO;
import com.oocl.Spring_flywaydb.entities.Companies;
import com.oocl.Spring_flywaydb.entities.Employees;
import com.oocl.Spring_flywaydb.repositories.CompaniesReository;
import com.oocl.Spring_flywaydb.repositories.EmployeesReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CompaniesController {
    private CompaniesReository companiesReository;

    @Autowired
    private EmployeesReository employeesReository;

    @Autowired
    public CompaniesController(CompaniesReository companiesReository){
        this.companiesReository = companiesReository;
    }

    @Transactional
    @GetMapping("/Companies")
    public List<Companies> getAllCompanies(){
        return companiesReository.findAll();
    }

    @Transactional
    @PostMapping("/Companies")
    public Companies addCompanies(@RequestBody Companies companies){
        companies.getEmployees().stream().forEach(employees -> {
            employees.setCompanies(companies);
        });
        return companiesReository.save(companies);
    }

    @Transactional
    @PutMapping("/Companies")
    public ResponseEntity<Object> updateCompanies(@RequestBody Companies companies){
        companies.getEmployees().stream().filter(employees -> employees.getCompanies()==null).forEach(employees -> {
            employees.setCompanies(companies);
        });
         companiesReository.save(companies);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @GetMapping("/Companies/{id}")
    public CompaniesDTO get(@PathVariable("id") Long id){
        Companies companies = companiesReository.findById(id).get();
        return new CompaniesDTO(companies);
    }

    @Transactional
    @DeleteMapping("/Companies/{id}")
    public Companies delete(@PathVariable("id")Long id){
        Companies one = companiesReository.findById(id).get();
        companiesReository.delete(one);
        return one;
    }

}
