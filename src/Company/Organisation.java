/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Company;

import java.time.LocalDate;
import java.util.logging.Logger;
import CustomException.InvalidDateException;
import CustomException.InvalidIntException;
import Personnelx.Manager;
import Personnelx.Profil;
import Personnelx.ProfilSportif;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static javafx.scene.input.KeyCode.T;
import newpackage.Contrat;

/**
 *
 * @author bouss
 */
public sealed class Organisation permits Equipe {
    private String nom ;
    private  LocalDate dateFondation ;
    private final ArrayList<ProfilSportif> players;
    private final ArrayList<Manager> Managers;
    private static final ArrayList<Contrat> Contrats = new ArrayList<Contrat>();
    public static final ArrayList<Equipe> Equipes = new ArrayList<Equipe>();
    
    public static ArrayList<Equipe> getEquipes()
    {
        return Equipes;
    }

    public static ArrayList<Contrat> getContrats() {
        return Contrats;
    }

    
    @Override
    public String toString() {
        return "Organisation{" + "nom=" + nom + ", dateFondation=" + dateFondation + '}';
    }
    
            
   public Organisation () {
        this.players = new ArrayList<>();
        this.Managers = new ArrayList<>();
      

        
   } 
   public Organisation ( String nom , LocalDate dateFondation  ) throws CustomException.InvalidDateException
    {
        this.nom = nom ;
        setDateFondation(dateFondation);
        this.players = new ArrayList<>();
        this.Managers = new ArrayList<>();
        
    }
   
   
   public void setDateFondation(LocalDate dateFondation) throws CustomException.InvalidDateException {
        if (dateFondation.isAfter(LocalDate.now()))
        { throw new CustomException.InvalidDateException("La date de fondation doit etre dans le passé");}
        else
            this.dateFondation = dateFondation;
    }

    public String getNom() {
        return nom;
    }



    public LocalDate getDateFondation() {
        return dateFondation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }





    
 public static <T> void EnregisterdansFICHIER(List<T> list, Path filePath) {
        try {
            List<String> stringList = toStringList(list);
            System.out.println("Contents of stringList: " + stringList); 
            Files.write(filePath, stringList);
            System.out.println("Save successful! Data has been written to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            
        }}

    private static <T> List<String> toStringList(List<T> list) {
        List<String> stringList = new ArrayList<>(list.size());
        for (T item : list) {
            stringList.add(item.toString());
        }
        return stringList;
    }
    
  public static void getEquipeFile(ArrayList<Equipe> List ,Path filePath) throws IOException, InvalidDateException, InvalidIntException {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Equipe equipe = Equipe.convertir(line);
                    List.add(equipe);
                } catch (InvalidDateException | InvalidIntException e) {
                    // Handle or propagate InvalidDateException and InvalidIntException
                    e.printStackTrace(); // Or log the exception
                }
            }
        } catch (IOException e) {
            // Propagate IOException to the caller
            throw e;
        }
        
    }
  
  
  public static void getContratFile(ArrayList<Contrat> List ,Path filePath) throws IOException
  {
       try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Contrat contrat = Contrat.convertir(line);
                    List.add(contrat);
                } catch (InvalidDateException | InvalidIntException e) {
                    // Handle or propagate InvalidDateException and InvalidIntException
                    e.printStackTrace(); // Or log the exception
                }
            }
        } catch (IOException e) {
            // Propagate IOException to the caller
            throw e;
        }
      
  }
    
    public <T> void addElement ( ArrayList<T> List , T element ,String Path)
    {
        List.add(element);
        
        }
    public <T> void removeElement ( ArrayList<T> List , T element)
    {
        List.remove(element);}
    
    public <T> void showElements (ArrayList<T> List )
    {
        for (T curs : List )
        {
            System.out.println(curs);
        }}
    
    
    
    
  
    
    
 
    }

    
    
    

    





