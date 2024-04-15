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
import java.util.ArrayList;
import newpackage.Contrat;

public class Manager extends Profil {
    private String email;
    private ArrayList<Contrat> contratsEnCours;
    private ArrayList<Contrat> contratsPasses;
    private ArrayList<ProfilSportif> profilsSportifs;

    public Manager(String nom, String prenom, int id,LocalDate dat, String email) {
        super(nom, prenom, id,dat);
        this.email = email;
        this.contratsEnCours = new ArrayList<>();
        this.contratsPasses = new ArrayList<>();
        this.profilsSportifs = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Contrat> getContratsEnCours() {
        return contratsEnCours;
    }

    public ArrayList<Contrat> getContratsPasses() {
        return contratsPasses;
    }

    public ArrayList<ProfilSportif> getProfilsSportifs() {
        return profilsSportifs;
    }

    public void ajouterContratEnCours(Contrat contrat) {
        contratsEnCours.add(contrat);
    }

    public void ajouterContratPasse(Contrat contrat) {
        contratsPasses.add(contrat);
    }

    public void ajouterProfilSportif(ProfilSportif profilSportif) {
        profilsSportifs.add(profilSportif);
    }

    public void supprimerProfilSportif(ProfilSportif profilSportif) {
        profilsSportifs.remove(profilSportif);
    }
    public void afficherProfilsSportifs() {
    System.out.println("Profils sportifs associés au recruteur " + getNom() + " " + getPrenom() + ":");
    for (ProfilSportif profilSportif : profilsSportifs) {
        System.out.println(profilSportif.getNom() + " " + profilSportif.getPrenom());
    }
    }


    public void afficherContratsEnCours() {
        System.out.println("Contrats en cours gérés par " + getNom() + " " + getPrenom() + ":");
        for (Contrat contrat : contratsEnCours) {
            System.out.println(contrat);
        }
    }

    public void afficherContratsPasses() {
        System.out.println("Contrats passés gérés par " + getNom() + " " + getPrenom() + ":");
        for (Contrat contrat : contratsPasses) {
            System.out.println(contrat);
        }
    }
    
    public ProfilSportif rechercherProfilSportif(String nom, String prenom) {
    for (ProfilSportif profilSportif : profilsSportifs) {
        if (profilSportif.getNom().equals(nom) && profilSportif.getPrenom().equals(prenom)) {
            return profilSportif;
        }
    }
    return null; // Retourne null si le profil sportif n'est pas trouvé
    }
    
    public int nombreTotalProfilsSportifs() {
    return profilsSportifs.size();
    }

    
    public ProfilSportif trouverProfilAvecPlusTrophees() {
    if (profilsSportifs.isEmpty()) {
        return null;
    }

    ProfilSportif profilAvecPlusTrophees = profilsSportifs.get(0);

    for (ProfilSportif profilSportif : profilsSportifs) {
        if (profilSportif.getTropheesGagnes().size() > profilAvecPlusTrophees.getTropheesGagnes().size()) {
            profilAvecPlusTrophees = profilSportif;
        }
    }

    return profilAvecPlusTrophees;
}

    



    @Override
    public void afficherProfil() {
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("ID : " + getId());
        System.out.println("Date de naissance : " + getDateNaissance());
        System.out.println("Email : " + email);
        System.out.println("Profils sportifs gérés :");
        for (ProfilSportif profilSportif : profilsSportifs) {
            System.out.println("- " + profilSportif.getNom() + " " + profilSportif.getPrenom());
        }
    }
}