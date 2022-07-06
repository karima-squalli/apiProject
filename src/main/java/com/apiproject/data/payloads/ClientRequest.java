package com.apiproject.data.payloads;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class ClientRequest {
    @NotBlank
    @NotNull
    private String nom;
    @NotBlank
    @NotNull
    private String prénom;
    @NotBlank
    @NotNull
    private String date;
    @NotBlank
    @NotNull
    private String produit;
    @NotBlank
    @NotNull
    private double montant;
    @NotBlank
    @NotNull
    private String statut;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrénom() {
        return prénom;
    }
    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getProduit() {
        return produit;
    }
    public void setProduit(String produit) {
        this.produit = produit;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }

}
