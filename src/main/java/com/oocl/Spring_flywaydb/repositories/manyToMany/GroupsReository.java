package com.oocl.Spring_flywaydb.repositories.manyToMany;

import com.oocl.Spring_flywaydb.entities.manyToMany.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsReository extends JpaRepository<Groups,Long> {

}
