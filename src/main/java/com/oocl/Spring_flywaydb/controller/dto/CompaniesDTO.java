package com.oocl.Spring_flywaydb.controller.dto;

import com.oocl.Spring_flywaydb.entities.Companies;
import com.oocl.Spring_flywaydb.entities.Employees;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompaniesDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;
    private final List<EmployeesDTO> employees;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public List<EmployeesDTO> getEmployees() {
        return employees;
    }

    public CompaniesDTO(Companies companies) {
        this.id = companies.getId();
        this.name = companies.getName();
        this.createDate = companies.getCreatedDate();
        this.employees = companies.getEmployees().stream().map(employee -> new EmployeesDTO(employee)).collect(Collectors.toList());
    }
}
