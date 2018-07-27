package com.oocl.Spring_flywaydb.controller.dto.oneToOne;

import com.oocl.Spring_flywaydb.entities.oneToOne.Leader;

public class LeaderDTO {
    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    private final Long klassId;

    public Long getKlassId() {
        return klassId;
    }

    public LeaderDTO(Leader leader) {
        this.id = leader.getId();
        this.name = leader.getName();
        this.klassId = leader.getKlass().getId();
    }
}
