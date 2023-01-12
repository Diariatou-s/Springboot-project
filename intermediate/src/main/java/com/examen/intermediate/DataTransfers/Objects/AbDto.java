package com.examen.intermediate.DataTransfers.Objects;

import java.io.Serializable;

public class AbDto implements Serializable {

    private Long id;
    private String suivantId;
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
