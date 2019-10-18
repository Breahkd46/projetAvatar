package com.mycompany.projetavatar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.projetavatar.contexts.AvatarContext;
import com.mycompany.projetavatar.contexts.LoginContext;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author valo
 */
public class MainWindowController implements Initializable {

    LoginContext contexte;
    @FXML
    private TextField textUsername;

    @FXML
    private TableView<Personne> listViewPersonnes;
    @FXML
    private TableColumn<Personne,String> tableColumnLogin;
    @FXML
    private TableColumn<Personne,String> tableColumnNom;
    @FXML
    private TableColumn<Personne,String> tableColumnVille;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textVille;
    @FXML
    private Button boutonAjout;
    @FXML
    private Button buttonSupprimer;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
            
    public void setContexte(LoginContext contexte){
       this.contexte = new LoginContext(contexte);
       this.fillListView();
       
    }
    
    private void fillListView() {
        this.listViewPersonnes.setItems(this.contexte.getPersonnes().getListe());
        this.tableColumnLogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("username"));
        this.tableColumnNom.setCellValueFactory(new PropertyValueFactory<Personne, String>("name"));
        this.tableColumnVille.setCellValueFactory(new PropertyValueFactory<Personne, String>("city"));
        
    }
    
    public void lineSelected(Personne p) {
        
    }

    private void onOpenAvatarMaker(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("AvatarMaker.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            AvatarMakerController controller = loader.getController();
            AvatarContext avatarCont = new AvatarContext(this.contexte.identification());
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

    private void onOpenProfil(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Profil");
        alert.setHeaderText("This is your profil informations :");
        Personne user = this.contexte.identification();
        String profilShow = 
                " Login : "+ user.getUsername()+
                "\n Hair color : "+ user.getHairColor().get()+
                "\n Hair length : "+user.getHairLength().get()+
                "\n Face form : "+ user.getFaceForm().get();
        alert.setContentText(profilShow);
        alert.showAndWait();
    }

    @FXML
    private void onAjout(ActionEvent event) {
        if (!(this.textUsername.getText() == "" || this.textNom.getText() == "" ||
                this.textVille.getText() == "")) {
            Personne p = new Personne(
                            this.textUsername.getText(),
                            "titi",
                            "vert",
                            3.0,
                            "rond",
                            this.textNom.getText(),
                            this.textVille.getText()
                    );
            this.listViewPersonnes.getItems().add(p);
        }
    }

    @FXML
    private void onSuppression(ActionEvent event) {
        if (this.listViewPersonnes.selectionModelProperty().isNotNull().get()) {
            Personne p = this.listViewPersonnes.getSelectionModel().getSelectedItem();
            this.listViewPersonnes.getItems().remove(p);
        }
    }
    
}
