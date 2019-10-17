/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import com.mycompany.projetavatar.contexts.LoginContext;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Etu
 */
public class LoginController implements Initializable {


    @FXML
    private Button ButtonOk;
    @FXML
    private Button ButtonCancel;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    LoginContext contexte;
    
    @FXML
    private ProgressBar progressPassword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.username.setText("titi");
        this.password.setText("toto");
        
        this.password.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                progressPassword.setProgress(newValue.length()/8.0f);
            }
        });
    }

    public void setContexte(LoginContext contexte){
       this.contexte = contexte;
       contexte.loginUtilisateurConnecteProperty().bind(this.username.textProperty());
       contexte.passwordUtilisateurConnectProperty().bind(this.password.textProperty());
    }

    @FXML
    private void processOk(ActionEvent event) throws IOException {
        Personne personneConnectee = this.contexte.identification();
        if ( personneConnectee != null){
            try{
                Stage stage = (Stage) this.username.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(App.class.getResource("MainWindow.fxml"));
                BorderPane rootLayout = (BorderPane) loader.load();
                MainWindowController controller = loader.getController();
                LoginContext mainContexte = this.contexte;
                controller.setContexte(mainContexte);
                Scene scene = new Scene(rootLayout);
                
                this.contexte.loginUtilisateurConnecteProperty().unbind();
                this.contexte.passwordUtilisateurConnectProperty().unbind();
                
                stage.setScene(scene);
                stage.centerOnScreen();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void processCancel(ActionEvent event) {
        Stage stage = (Stage) this.ButtonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void mouseOutOk(MouseEvent event) {
        this.username.setStyle("-fx-control-inner-background : white");
    }

    @FXML
    private void mouseOnOk(MouseEvent event) {
        if (this.username.getText().isBlank()){
            this.username.setStyle("-fx-control-inner-background : #ff1c00");
        }else{
            this.username.setStyle("-fx-control-inner-background : #007aeb");
        }
    }    
}
