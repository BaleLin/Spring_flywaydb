package com.oocl.Spring_flywaydb.controller.dto;

import com.oocl.Spring_flywaydb.entities.Klass;

public class KlassDTO {
    private final Long id;
    private final String name;
    private final LeaderDTO leaderDTO;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LeaderDTO getLeaderDTO() {
        return leaderDTO;
    }

    public KlassDTO(Klass klass) {
        this.id = klass.getId();
        this.name = klass.getName();
        this.leaderDTO = new LeaderDTO(klass.getLeader());
    }
}
