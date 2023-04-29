package com.examen.intermediate.InputOutputs.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="article")
public class ArEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String articleId;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false, unique = true)
    private String texte;
    @Column(nullable = false)
    private String auteurId;
    @Column(nullable = false)
    private Date date_creation = new Date();
    @Column(nullable = false)
    private Long categorieId;
    @Column(nullable = false)
    private int nmb_upvotes;
    @Column(nullable = false)
    private int nmb_downvotes;
    @Column(nullable = false)
    private int nmb_comm;
    @Column(nullable = false)
    private int nmb_fav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(String auteurId) {
        this.auteurId = auteurId;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public int getNmb_upvotes() {
        return nmb_upvotes;
    }

    public void setNmb_upvotes(int nmb_upvotes) {
        this.nmb_upvotes = nmb_upvotes;
    }

    public int getNmb_downvotes() {
        return nmb_downvotes;
    }

    public void setNmb_downvotes(int nmb_downvotes) {
        this.nmb_downvotes = nmb_downvotes;
    }

    public int getNmb_comm() {
        return nmb_comm;
    }

    public void setNmb_comm(int nmb_comm) {
        this.nmb_comm = nmb_comm;
    }

    public int getNmb_fav() {
        return nmb_fav;
    }

    public void setNmb_fav(int nmb_fav) {
        this.nmb_fav = nmb_fav;
    }
}
