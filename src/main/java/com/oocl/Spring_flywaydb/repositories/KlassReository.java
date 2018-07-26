package com.oocl.Spring_flywaydb.repositories;

import com.oocl.Spring_flywaydb.entities.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassReository extends JpaRepository<Klass,Long> {
}
