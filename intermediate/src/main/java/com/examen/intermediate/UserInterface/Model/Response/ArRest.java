package com.examen.intermediate.UserInterface.Model.Response;

import java.util.Date;

public class ArRest {

    private String articleId;
    private String auteurId;
    private String titre;
    private String texte;
    private Long categorieId;
    private Date date_creation = new Date();
    private int nmb_upvotes = 0;
    private int nmb_downvotes = 0;
    private int nmb_comm = 0;
    private int nmb_fav = 0;

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
