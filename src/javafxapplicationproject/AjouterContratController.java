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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import newpackage.Contrat;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class AjouterContratController implements Initializable {

    @FXML
    private DatePicker DDcontainer;
    @FXML
    private Spinner<Integer> MontantContainer;
    @FXML
    private DatePicker DFcontainer;
    @FXML
    private Button button;
    @FXML
    private ChoiceBox<String> TypechoiceBox;
    private String[] types= {"Entreprise-Manager","Entreprise-Psportif","Psportif-Equipe"};
    @FXML
    private TextField idparti1field;
    @FXML
    private TextField idfield;
    @FXML
    private TextField stautfield;
    @FXML
    private Label id;
    @FXML
    private Label statut;
    @FXML
    private Label DD;
    @FXML
    private Text title;
    @FXML
    private Label DF;
    @FXML
    private Label type;
    @FXML
    private Label montant;
    @FXML
    private Text idparti1;
    @FXML
    private TextArea descriptionfield;
    @FXML
    private Label description;
    @FXML
    private TextField idparti2field;
    @FXML
    private Label idparti2;
    ArrayList<Contrat> contratList = Organisation.getContrats();
    Path filePath = Path.of("CONTRATS.txt");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL arg0,ResourceBundle arg1)
    {   
         SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        TypechoiceBox.getItems().addAll(types);
        valueFactory.setValue(1);
        MontantContainer.setValueFactory(valueFactory);

    }

    @FXML
    private void addContrat(ActionEvent event) throws InvalidIntException, InvalidDateException, IOException {
          if (validerLesFields())
        {
             LocalDate selectedDD = DDcontainer.getValue();
             LocalDate selectedDF = DFcontainer.getValue();
             int montant = MontantContainer.getValue();
             int id =Integer.parseInt(idfield.getText());
             int id1 = Integer.parseInt(idparti1field.getText());
             int id2 = Integer.parseInt(idparti2field.getText());
            Contrat contrat = new Contrat(id,selectedDD, selectedDF , montant, TypechoiceBox.getValue(), stautfield.getText(), descriptionfield.getText(),id1,id2);
            Organisation.getContratFile(contratList ,filePath);
            contratList.add(contrat);
            Organisation.<Contrat>EnregisterdansFICHIER(contratList,filePath);
            switchToSecondInterface(event ,"contrat.FXML");

        }
        else 
            Alert("WARNING","TOUS LE CHAMPS SONT OBLIGATOIRE");
        
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

    
    
    
    
    private boolean validerLesFields() {
        return isNotEmpty(idfield.getText())
                && isNotEmpty(idparti1field.getText())
                && isNotEmpty(stautfield.getText())
                && isNotEmpty(descriptionfield.getText());
                
    }
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    private void Alert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
