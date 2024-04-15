/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplicationproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class ContratController implements Initializable {

    @FXML
    private Button Addbuttn;
    @FXML
    private Button viewbuttn;
    @FXML
    private Button Backbuttn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void addcontrat(ActionEvent event) {
         switchToSecondInterface(event ,"AjouterContrat.FXML");
    }

    private void viewcontrat(ActionEvent event) {
         switchToSecondInterface(event , "TableViewContrat.FXML");
    }
    

    @FXML
    private void back(ActionEvent event) {
    }
    
    private void switchToSecondInterface(ActionEvent event , String Path ) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(Path));
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
