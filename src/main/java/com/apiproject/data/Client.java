package com.apiproject.data;

import java.util.Date;
import javax.persistence.*;
import java.util.Objects;

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prénom;
    private Date date;
    private String produit;
    private double montant;
    private String statut;

    public Client() {}

    public Client(int id, String nom, String prénom, Date date, String produit, double montant, String statut) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.date = date;
        this.produit = produit;
        this.montant = montant;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prénom='" + prénom + '\'' +
                ", date='" + date + '\'' +
                ", produit='" + produit + '\'' +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.montant, montant) == 0 && Objects.equals(id, client.id) && Objects.equals(nom, client.nom) && Objects.equals(prénom, client.prénom) && Objects.equals(statut, client.statut) && Objects.equals(date, client.date) && Objects.equals(produit, client.produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prénom, nom, date, produit, montant, statut);
    }
}
