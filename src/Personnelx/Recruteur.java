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
import java.util.HashMap;
import java.util.Map;

public class Recruteur extends Profil {
    private String nomClub;
    private ArrayList<ProfilSportif> profilsSportifs;
    private String sport;
    private String email;
    private String adresse;

    public Recruteur(String nom, String prenom, int id,LocalDate dat, String nomClub, String sport, String email, String adresse) {
        super(nom, prenom, id, dat);
        this.nomClub = nomClub;
        this.sport = sport;
        this.email = email;
        this.adresse = adresse;
        this.profilsSportifs = new ArrayList<>();
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<ProfilSportif> getProfilsSportifs() {
        return profilsSportifs;
    }

    public void ajouterProfilSportif(ProfilSportif profilSportif) {
        profilsSportifs.add(profilSportif);
    }

    public void supprimerProfilSportif(ProfilSportif profilSportif) {
        profilsSportifs.remove(profilSportif);
    }
    
    public int nombreTotalProfilsSportifs() {
    return profilsSportifs.size();}
    
    public void afficherProfilsSportifs() {
    System.out.println("Profils sportifs associés au recruteur " + getNom() + " " + getPrenom() + ":");
    for (ProfilSportif profilSportif : profilsSportifs) {
        System.out.println(profilSportif.getNom() + " " + profilSportif.getPrenom());
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



    

    public double calculerMoyenneAgeProfilsSportifs() {
    if (profilsSportifs.isEmpty()) {
        return 0.0;
    }

    int totalAge = 0;

    for (ProfilSportif profilSportif : profilsSportifs) {
        totalAge += profilSportif.calculerAge();
    }

    return (double) totalAge / profilsSportifs.size();
}



    

    public Map<ProfilSportif, ArrayList<String>> groupTropheesParProfil() {
        Map<ProfilSportif, ArrayList<String>> trophesParProfil = new HashMap<>();

        for (ProfilSportif profilSportif : profilsSportifs) {
            trophesParProfil.put(profilSportif, profilSportif.getTropheesGagnes());
        }

        return trophesParProfil;
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
        System.out.println("Nom du club : " + nomClub);
        System.out.println("Sport : " + sport);
        System.out.println("Email : " + email);
        System.out.println("Adresse : " + adresse);
    }
}

