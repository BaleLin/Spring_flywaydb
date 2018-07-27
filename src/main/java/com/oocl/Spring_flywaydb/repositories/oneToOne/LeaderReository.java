package com.oocl.Spring_flywaydb.repositories.oneToOne;

import com.oocl.Spring_flywaydb.entities.oneToOne.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderReository extends JpaRepository<Leader,Long> {
}
