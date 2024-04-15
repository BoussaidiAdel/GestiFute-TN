/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplicationproject;

import Company.Organisation;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import newpackage.Contrat;

/**
 *
 * @author bouss
 */
public class main {
    public static void main(String[] args) throws IOException {
         ArrayList<Contrat> contratList = Organisation.getContrats();
         Path filePath = Path.of("CONTRATS.txt");
        Organisation.getContratFile(contratList ,filePath);
        
        for ( Contrat cn : contratList)
        {
            System.out.println(cn);
        }
        

    }
    
    
}
