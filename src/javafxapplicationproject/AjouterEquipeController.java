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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class AjouterEquipeController implements Initializable {

    @FXML
    private Button ValiderAjoutEquiper;
    @FXML
    private ChoiceBox<String> ChoiceLeague;
     private String[] Ligues={"Ligue 1 ","LaLiga", "BundesLiga","Premier Ligue","Serie A" };
    @FXML
    private Spinner<Integer> BudgetSpinner;
    @FXML
    private TextField nomfield;
    @FXML
    private DatePicker dfondationDATE;
    @FXML
    private Label Nom;
    @FXML
    private Label coach;
    @FXML
    private Text titre;
    @FXML
    private Label Lige;
    @FXML
    private Label propriétaire;
    @FXML
    private Label budget;
    @FXML
    private Text Dfondation;
    @FXML
    private TextArea Descriptionfield;
    @FXML
    private Label Description;
    @FXML
    private TextField propriétairefield;
    @FXML
    private TextField coachfield;
    
     ArrayList<Equipe> equipeList = Organisation.getEquipes();
     Path filePath = Path.of("EQUIPES.txt");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL arg0,ResourceBundle arg1)
    {
       
        ChoiceLeague.getItems().addAll(Ligues);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(100,1000);
        valueFactory.setValue(1);
        BudgetSpinner.setValueFactory(valueFactory);
        

    }

    @FXML
    private void addEquipe(ActionEvent event) throws InvalidDateException, InvalidIntException, IOException {
        if (validerLesFields())
        {
             LocalDate selectedDate = dfondationDATE.getValue();
            Equipe eqp = new Equipe(nomfield.getText(),ChoiceLeague.getValue(),BudgetSpinner.getValue(),selectedDate,coachfield.getText(),propriétairefield.getText(),Descriptionfield.getText());
            Organisation.getEquipeFile(equipeList ,filePath);
            equipeList.add(eqp);
            Organisation.<Equipe>EnregisterdansFICHIER(equipeList,filePath);
            switchToSecondInterface(event , "Equipe.FXML");

        }
        else 
            Alert("WARNING","TOUS LE CHAMPS SONT OBLIGATOIRE");
        
    }

     private boolean validerLesFields() {
        return isNotEmpty(nomfield.getText())
                && isNotEmpty(Descriptionfield.getText())
                && isNotEmpty(propriétairefield.getText())
                && isNotEmpty(coachfield.getText());
                
    }
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    private void Alert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
