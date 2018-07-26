package com.oocl.Spring_flywaydb.repositories;

import com.oocl.Spring_flywaydb.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsReository extends JpaRepository<Groups,Long> {

}
