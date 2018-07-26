package com.oocl.Spring_flywaydb.repositories;

import com.oocl.Spring_flywaydb.entities.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesReository extends JpaRepository<Companies,Long> {

}
