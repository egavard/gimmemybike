package com.adeo.rfi.price.stations.model;

import java.util.List;

public class StationModel {
    private Long libelle;
    private String nom;
    private String adresse;
    private Geo geo;
    private String type;
    private Integer nbvelosdispo;
    private Integer nbplacesdispo;

    public StationModel() {
    }

    public Long getLibelle() {
        return libelle;
    }

    public void setLibelle(Long libelle) {
        this.libelle = libelle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNbvelosdispo() {
        return nbvelosdispo;
    }

    public void setNbvelosdispo(Integer nbvelosdispo) {
        this.nbvelosdispo = nbvelosdispo;
    }

    public Integer getNbplacesdispo() {
        return nbplacesdispo;
    }

    public void setNbplacesdispo(Integer nbplacesdispo) {
        this.nbplacesdispo = nbplacesdispo;
    }
}
