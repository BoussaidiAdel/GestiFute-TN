/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnelx;

/**
 *
 * @author bouss
 */
import java.time.LocalDate;

public abstract class Profil  {
    private String nom;
    private String prenom;
    private int id;
    private LocalDate dateNaissance;

    // Constructeur
    public Profil(String nom, String prenom, int id, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.dateNaissance = dateNaissance;
    }

    // Méthodes getters et setters pour accéder aux attributs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Méthode abstraite pour afficher les détails du profil
    public abstract void afficherProfil();
}
