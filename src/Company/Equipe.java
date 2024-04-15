package Company;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import CustomException.InvalidDateException;
import CustomException.InvalidIntException;
import javafx.beans.property.StringProperty;
/**
 *
 * @author bouss
 */
public final  class Equipe extends Organisation {
    private String Ligue;
    private int budget ;
    private String coach;
    private String propriétaire ;
    private String Description;
    

     

    
    public Equipe ( String nom ,  String Ligue  , int budget, LocalDate dateFondation , String coach ,String prop,String D) throws InvalidDateException, InvalidIntException
    {
        super(nom,dateFondation);
        this.Ligue = Ligue ;
        setBudget(budget);
        this.Description=D;
        this.propriétaire=prop;
        this.coach=coach;
        setDateFondation(dateFondation);
        
    }


    public String getLigue() {
        return Ligue;
    }

    public void setLigue(String Ligue) {
        this.Ligue = Ligue;
    }

    public double getBudget() {
        return budget;
    }
   
    
    public void setBudget(int budget) throws InvalidIntException {
        if ( budget <0 )
                throw new InvalidIntException("le budget doit etre superieur a 0 ");
       else this.budget = budget;
    }


    public void modifierBudget(double montant) {
        budget += montant;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCoach() {
        return coach;
    }

    public String getPropriétaire() {
        return propriétaire;
    }
    public static Equipe convertir(String str) throws InvalidDateException, InvalidIntException {
    String[] fields = str.split(",");
    
    String nom = fields[0].substring(fields[0].indexOf('=') + 1).trim();
    LocalDate datefondation = LocalDate.parse(fields[1].substring(fields[1].indexOf('=') + 1).trim()); 
    String ligue = fields[2].substring(fields[2].indexOf('=') + 1).trim();
    int budget = Integer.parseInt(fields[3].substring(fields[3].indexOf('=') + 1).trim());
    String coach = fields[4].substring(fields[4].indexOf('=') + 1).trim();
    String proprietaire = fields[5].substring(fields[5].indexOf('=') + 1).trim();
    String description = fields[6].substring(fields[6].indexOf('=') + 1, fields[6].length() - 1).trim();

    return new Equipe(nom, ligue, budget, datefondation, coach, proprietaire, description);
}

     @Override
    public String toString() {
        return "Equipe{" +"nom=" + this.getNom() + ", datefondation=" + this.getDateFondation() + ", Ligue=" + Ligue + ", budget=" + budget + ", coach=" + coach + ", propri\u00e9taire=" + propriétaire + ", Description=" + Description + '}';
    }         

    

    
}
