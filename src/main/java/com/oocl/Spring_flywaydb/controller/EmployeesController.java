package com.oocl.Spring_flywaydb.controller;

import com.oocl.Spring_flywaydb.entities.Employees;
import com.oocl.Spring_flywaydb.repositories.EmployeesReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployeesController {
    private EmployeesReository employeesReository;
    @Autowired
    public EmployeesController(EmployeesReository employeesReository){
        this.employeesReository =employeesReository;
    }
    @Transactional
    @GetMapping("/Employees")
    public List<Employees> getAllCompanies(){
        return employeesReository.findAll();
    }

    @Transactional
    @PostMapping("/Employees")
    public Employees saveCompanies(@RequestBody Employees employees){
        return employeesReository.save(employees);
    }
}
