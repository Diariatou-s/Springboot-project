package com.examen.intermediate.InputOutputs.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="abonnement")
public class AbEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String suivantId;
    @Column(nullable = false)
    private String suiviId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuivantId() {
        return suivantId;
    }

    public void setSuivantId(String suivantId) {
        this.suivantId = suivantId;
    }

    public String getSuiviId() {
        return suiviId;
    }

    public void setSuiviId(String suiviId) {
        this.suiviId = suiviId;
    }
}
