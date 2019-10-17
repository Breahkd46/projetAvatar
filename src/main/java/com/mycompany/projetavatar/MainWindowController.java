package com.mycompany.projetavatar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author valo
 */
public class MainWindowController implements Initializable {

    LoginContexte contexte;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setContexte(LoginContexte contexte){
       this.contexte = contexte;
    }

    @FXML
    private void onOpenAvatarMaker(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AvatarMaker.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            AvatarMakerController controller = loader.getController();
            AvatarContexte avatarCont = new AvatarContexte(this.contexte.identification());
            controller.setContexte(avatarCont);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.getIcons().add(new Image(App.class.getResourceAsStream("icon.png")));
            stage.setTitle("Avatar Maker");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void onClose(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit?");
        alert.setHeaderText("Do you confirm to quit the application?");
        //alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit(); 
            System.exit(0);
        } else {
        }
    }

    @FXML
    private void onOpenProfil(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Profil");
        alert.setHeaderText("This is your profil informations :");
        alert.setContentText(this.contexte.identification().toString());

        alert.showAndWait();
    }
    
}
