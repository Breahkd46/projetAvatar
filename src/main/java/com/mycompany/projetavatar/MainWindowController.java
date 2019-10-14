package com.mycompany.projetavatar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class MainWindowController implements Initializable {

    AvatarContexte contexte;
    @FXML
    private ListView<String> ListViewHairColor;
    @FXML
    private Slider SliderHairLength;
    @FXML
    private ComboBox<String> ComboBoxFaceForm;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Canvas canvas;
    @FXML
    private BorderPane borderPaneCanvas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.canvas.scaleXProperty().bind(this.borderPaneCanvas.widthProperty().divide(this.canvas.getWidth()));
        this.canvas.scaleYProperty().bind(this.borderPaneCanvas.heightProperty().divide(this.canvas.getHeight()));
        ListProperty<String> listPropertyHairColor = new SimpleListProperty<>();
        this.ListViewHairColor.itemsProperty().bind(listPropertyHairColor);
        List<String> hairColorList = new ArrayList<>();
        hairColorList.add("Brun");
        hairColorList.add("Blond");
        hairColorList.add("Chatain");
        listPropertyHairColor.set(FXCollections.observableArrayList(hairColorList));
    }    
    
    public void setContexte(AvatarContexte contexte){
       this.contexte = contexte;
       this.contexte.personneConnectee.getHairLength().bindBidirectional(this.SliderHairLength.valueProperty());
       this.contexte.personneConnectee.getHairColor().bind(this.ListViewHairColor.getSelectionModel().selectedItemProperty());
       this.contexte.personneConnectee.getFaceForm().bindBidirectional(this.ComboBoxFaceForm.valueProperty());
       
       /*
       contexte.loginUtilisateurConnecteProperty().bind(this.username.textProperty());
       contexte.passwordUtilisateurConnectProperty().bind(this.password.textProperty());
       */
    }

    @FXML
    private void handleSave(ActionEvent event) {
        this.buttonSave.setText(this.contexte.personneConnectee.getHairLength().toString());
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }
    
}
