package com.oocl.Spring_flywaydb.repositories.manyToMany;

import com.oocl.Spring_flywaydb.entities.manyToMany.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersReository extends JpaRepository<Users,Long> {
}
