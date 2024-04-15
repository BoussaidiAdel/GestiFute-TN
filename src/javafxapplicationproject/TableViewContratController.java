/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplicationproject;

import Company.Equipe;
import Company.Organisation;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
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
import newpackage.Contrat;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class TableViewContratController implements Initializable {

    @FXML
    private TableColumn<Contrat, Integer> id;
    @FXML
    private TableColumn<Contrat, String> type;
    @FXML
    private TableColumn<Contrat, Integer> idparti1;
    @FXML
    private TableColumn<Contrat, Integer> idparti2;
    @FXML
    private TableColumn<Contrat, String> statut;
    @FXML
    private TableColumn<Contrat, Double> Montant;
    @FXML
    private TableColumn<Contrat, LocalDate> DateDebut;
    @FXML
    private TableColumn<Contrat, LocalDate> DateFin;
    @FXML
    private TableColumn<Contrat, String> Description;
    @FXML
    private Text Titre;
    @FXML
    private Button precedLM;
    
   ArrayList<Contrat> ContratList = Organisation.getContrats();
    Path filePath = Path.of("CONTRATS.txt");
    @FXML
    private TableView<Contrat> TableViewC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("numeroContrat"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        idparti1.setCellValueFactory(new PropertyValueFactory<>("idparti1"));
        idparti2.setCellValueFactory(new PropertyValueFactory<>("idparti2"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        Montant.setCellValueFactory(new PropertyValueFactory<>("montant "));
        DateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        DateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
        try {
            Organisation.getContratFile(ContratList ,filePath);
        } catch (IOException ex) {
            Logger.getLogger(TableViewContratController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ObservableList<Contrat> List = FXCollections.observableArrayList(ContratList);
        
        TableViewC.setItems(List);
        
    }    

    @FXML
    private void back(ActionEvent event ) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("contrat.FXML"));
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
