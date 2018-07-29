package com.oocl.Spring_flywaydb.entities.oneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oocl.Spring_flywaydb.entities.oneToOne.Klass;

import javax.persistence.*;

@Entity
public class Leader {
    @Id
    private Long id;
    private String name;

    public Leader(String name) {
        this.name = name;
    }
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klass_id")
    private Klass klass;
    public Leader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
