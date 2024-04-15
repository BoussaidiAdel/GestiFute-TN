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
import java.time.Period;
import newpackage.Contrat;

public class ProfilSportif extends Profil {
    private String equipeActuelle;
    private String poste;
    private int numeroMaillot;
    private ArrayList<Contrat> contrats;
    private String nationalite;
    private ArrayList<String> tropheesGagnes;
    private String manager;

    public ProfilSportif(String nom, String prenom, int id, LocalDate dateNaissance,
                         String equipeActuelle, String poste, int numeroMaillot,
                         String nationalite, String manager) {
        super(nom, prenom, id, dateNaissance);
        this.equipeActuelle = equipeActuelle;
        this.poste = poste;
        this.numeroMaillot = numeroMaillot;
        this.contrats = new ArrayList<Contrat>();
        this.nationalite = nationalite;
        this.tropheesGagnes = new ArrayList<String>();
        this.manager = manager;
    }

    public String getEquipeActuelle() {
        return equipeActuelle;
    }

    public void setEquipeActuelle(String equipeActuelle) {
        this.equipeActuelle = equipeActuelle;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
    


    public int getNumeroMaillot() {
        return numeroMaillot;
    }

    public void setNumeroMaillot(int numeroMaillot) {
        this.numeroMaillot = numeroMaillot;
    }

    public ArrayList<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(ArrayList<Contrat> contrats) {
        this.contrats = contrats;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public ArrayList<String> getTropheesGagnes() {
        return tropheesGagnes;
    }

    public void setTropheesGagnes(ArrayList<String> tropheesGagnes) {
        this.tropheesGagnes = tropheesGagnes;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void afficherTropheesGagnes() {
        System.out.println("Trophées gagnés par " + getNom() + " " + getPrenom() + ":");
        for (String trophee : tropheesGagnes) {
            System.out.println("- " + trophee);
        }
    }
    public void ajouterTropheeGagne(String trophee) {
        tropheesGagnes.add(trophee);
    }
    public void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }
     public int calculerAge() {
        LocalDate dateNaissance = getDateNaissance();
        LocalDate aujourdHui = LocalDate.now();

        // Utilisez la classe Period pour calculer la différence entre les dates
        Period difference = Period.between(dateNaissance, aujourdHui);

        // Récupérez l'âge à partir de la période
        int age = difference.getYears();

        return age;
    }
     public boolean estLibre() {
    return equipeActuelle.equalsIgnoreCase("libre");}



    @Override
    public void afficherProfil() {
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("ID : " + getId());
        System.out.println("Date de naissance : " + getDateNaissance());
        System.out.println("Équipe actuelle : " + equipeActuelle);
        System.out.println("Poste : " + poste);
        System.out.println("Numéro de maillot : " + numeroMaillot);
        System.out.println("Nationalité : " + nationalite);
        System.out.println("Manager : " + manager);
    }
}



