package newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import CustomException.InvalidDateException;
import java.time.LocalDate ;
import CustomException.InvalidIntException;
import CustomException.InvalidDateException;
import java.util.StringTokenizer;
/**
 *
 * @author bouss
 */
public class Contrat {
    private int numeroContrat ;
    private  LocalDate dateDebut  ;
    private LocalDate dateFin ;
    private int montant ;
    private String statut ;
    private String type ;
    private String Description;
    private int idparti1 ;
    private int idparti2 ;

    
    
    public Contrat(int numeroContrat, LocalDate dateDebut, LocalDate dateFin, int montant, String type, String statut, String D, int id1, int id2) throws InvalidIntException, InvalidDateException {
        this.numeroContrat = numeroContrat;
        this.idparti1 = id1;
        this.idparti2 = id2;
        setmontant(montant);
        this.Description = D;
        this.statut = statut ;
        this.type = type ;
        setDateDebut(dateDebut) ;
        setDateFin(dateDebut,dateFin) ;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
       
    public int getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(int numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateDebut , LocalDate dateFin) throws InvalidDateException {
        if (dateFin.isBefore(LocalDate.now())) 
            {throw new InvalidDateException("la date de fin doit etre dans le futur .");}
        else if ( dateFin.isBefore(dateDebut) )
                {throw new InvalidDateException("la date de fin doit etre aprés la date de debut .");}
        else {
            this.dateFin = dateFin;
        
    }}
    public double getMontant() {
        return montant;
    }

    public void setmontant(int montant) throws InvalidIntException {
        if (montant <0 )
            throw new InvalidIntException("Le nombre doit etre positif") ;
        else 
        this.montant = montant ;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public int calculDuree() {
        return (int) dateDebut.until(dateFin).getDays();
    }
    
    public boolean EstEncore() {
        LocalDate currentDate = LocalDate.now();
        return (dateDebut.isBefore(currentDate) || dateDebut.isEqual(currentDate)) &&
               (dateFin.isAfter(currentDate) || dateFin.isEqual(currentDate));
    }

@Override
public String toString() {
    return "Contrat{" +
            "numeroContrat=" + numeroContrat +
            ", type=" + type +
             ", idparti1=" + idparti1 +
            ", idparti2=" + idparti2 +
            ", dateDebut=" + dateDebut +
            ", dateFin=" + dateFin +
            ", montant=" + montant +
            ", statut=" + statut +
            ", Description=" + Description +
            '}';
}

public static Contrat convertir(String str) throws InvalidIntException, InvalidDateException {
    String[] fields = str.split(",");

    int numeroContrat = Integer.parseInt(fields[0].substring(fields[0].indexOf('=') + 1).trim());
    String type = fields[1].substring(fields[1].indexOf('=') + 1).trim();
    int idparti1 = Integer.parseInt(fields[2].substring(fields[2].indexOf('=') + 1).trim());
    int idparti2 = Integer.parseInt(fields[3].substring(fields[3].indexOf('=') + 1).trim());
    LocalDate dateDebut = LocalDate.parse(fields[4].substring(fields[4].indexOf('=') + 1).trim());
    LocalDate dateFin = LocalDate.parse(fields[5].substring(fields[5].indexOf('=') + 1).trim());
    int montant = Integer.parseInt(fields[6].substring(fields[6].indexOf('=') + 1).trim());
    String statut = fields[7].substring(fields[7].indexOf('=') + 1).trim();    
    String description = fields[8].substring(fields[8].indexOf('=') + 1).trim();


    return new Contrat(numeroContrat, dateDebut, dateFin, montant, statut, type, description, idparti1, idparti2);
}
    
    
    
    
}
