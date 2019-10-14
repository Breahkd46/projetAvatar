package com.mycompany.projetavatar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class MainWindowController implements Initializable {

    LoginContexte contexte;
    @FXML
    private ListView<?> ListViewHairColor;
    @FXML
    private Slider SliderHairLength;
    @FXML
    private ComboBox<?> ComboBoxFaceForm;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Canvas canvas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //this.canvas.setScaleX(this.canvas.parentProperty().get().;
    }    
    
    public void setContexte(LoginContexte contexte){
       this.contexte = contexte;
       /*
       contexte.loginUtilisateurConnecteProperty().bind(this.username.textProperty());
       contexte.passwordUtilisateurConnectProperty().bind(this.password.textProperty());
       */
    }

    @FXML
    private void handleSave(ActionEvent event) {
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }
    
}
