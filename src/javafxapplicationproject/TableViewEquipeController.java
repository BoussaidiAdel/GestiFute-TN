/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplicationproject;

import Company.Equipe;
import Company.Organisation;
import CustomException.InvalidDateException;
import CustomException.InvalidIntException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class TableViewEquipeController implements Initializable {

    @FXML
    private Button precedLM;
    @FXML
    private TableColumn<Equipe, String> nom;
    @FXML
    private TableColumn<Equipe, String> prop;
    @FXML
    private TableColumn<Equipe, String> entreneur;
    @FXML
    private TableColumn<Equipe, LocalDate> DateFondation;
    @FXML
    private TableColumn<Equipe, Double> Budget;
    @FXML
    private TableColumn<Equipe, String> Ligue;
    @FXML
    private TableColumn<Equipe, String> Description;
    @FXML
    private TableView<Equipe> tableviewEquipe;
    
    ArrayList<Equipe> equipeList = Organisation.getEquipes();
    Path filePath = Path.of("EQUIPES.txt");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateFondation.setCellValueFactory(new PropertyValueFactory<>("dateFondation"));
        Budget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        Ligue.setCellValueFactory(new PropertyValueFactory<>("Ligue"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        entreneur.setCellValueFactory(new PropertyValueFactory<>("coach"));
        prop.setCellValueFactory(new PropertyValueFactory<>("propriétaire "));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        
        try {
            Organisation.getEquipeFile(equipeList ,filePath);
        } catch (IOException ex) {
            Logger.getLogger(TableViewEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDateException ex) {
            Logger.getLogger(TableViewEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidIntException ex) {
            Logger.getLogger(TableViewEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Equipe> EquipeList = FXCollections.observableArrayList(equipeList);
        
        tableviewEquipe.setItems(EquipeList);


        
        
        

  
          
          
          
          
       
    }    

    @FXML
    private void back(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Equipe.FXML"));
            Parent secondInterface = loader.load();

      
            Stage secondStage = new Stage();

            Scene scene = new Scene(secondInterface);
            secondStage.setScene(scene);

            secondStage.show();


            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
    

}
