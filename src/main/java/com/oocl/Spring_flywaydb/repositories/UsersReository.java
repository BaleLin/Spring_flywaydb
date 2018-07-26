package com.oocl.Spring_flywaydb.repositories;

import com.oocl.Spring_flywaydb.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersReository extends JpaRepository<Users,Long> {
}
