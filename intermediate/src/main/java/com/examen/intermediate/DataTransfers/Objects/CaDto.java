package com.examen.intermediate.DataTransfers.Objects;

import java.io.Serializable;

public class CaDto implements Serializable {

    private Long id;
    private String intitule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
