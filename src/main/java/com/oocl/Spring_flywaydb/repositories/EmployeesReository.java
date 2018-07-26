package com.oocl.Spring_flywaydb.repositories;

import com.oocl.Spring_flywaydb.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesReository extends JpaRepository<Employees,Long> {
}
