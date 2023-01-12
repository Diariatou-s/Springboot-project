package com.examen.intermediate.InputOutputs.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="utilisateur")
public class UtEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, length=50)
    private String prenom;
    @Column(nullable = false, length=50)
    private String nom;
    @Column(nullable = false, length=120, unique=true)
    private String email;
    @Column(nullable = false)
    private String mdp;
    @Column(nullable = false)
    private String bio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
