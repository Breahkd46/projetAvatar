package com.mycompany.projetavatar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("login.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            
            LoginController controller = loader.getController();
            LoginContexte contexte = new LoginContexte(new Personnes());
            controller.setContexte (contexte); 
            
            this.scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.getIcons().add(new Image(App.class.getResourceAsStream("icon.png")));
            stage.setTitle("Avatar Maker");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}