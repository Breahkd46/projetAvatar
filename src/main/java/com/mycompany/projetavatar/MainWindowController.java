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
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

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
    }

    public void setContexte(AvatarContexte contexte){
       this.contexte = contexte;
       this.drawAvatar();

       //set the values of the controls witht the initials value from the context.
       this.SliderHairLength.setValue(this.contexte.personneConnectee.getHairLength().get());
       this.ListViewHairColor.getSelectionModel().select(this.contexte.personneConnectee.getHairColor().get());
       this.ComboBoxFaceForm.setValue(this.contexte.personneConnectee.getFaceForm().get());

       //bind the listener between the Personne in the contexte and the 3 controls.
       this.contexte.personneConnectee.getHairLength().bindBidirectional(this.SliderHairLength.valueProperty());
       this.contexte.personneConnectee.getHairColor().bind(this.ListViewHairColor.getSelectionModel().selectedItemProperty());
       this.contexte.personneConnectee.getFaceForm().bindBidirectional(this.ComboBoxFaceForm.valueProperty());

       //Set the size of the canvas according to the size of the parent node.
       this.canvas.scaleXProperty().bind(this.borderPaneCanvas.widthProperty().divide(this.canvas.getWidth()));
       this.canvas.scaleYProperty().bind(this.borderPaneCanvas.heightProperty().divide(this.canvas.getHeight()));

       //Populate the listView and the ComboBox with the ObservableList of the context.
       this.ListViewHairColor.setItems(this.contexte.listHairColor);
       this.ComboBoxFaceForm.getItems().addAll(this.contexte.listFaceForm);
    }

    public void drawAvatar() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.restore();
        drawFace(this.contexte.personneConnectee.getFaceForm().get(), gc);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(75, 75, 10, 10);
        gc.strokeOval(115, 75, 10, 10);
        gc.strokeLine(85, 120, 115, 120);
        this.drawHair(14,this.contexte.personneConnectee.getHairColor().get(), gc);
    }

    public void drawFace(String form, GraphicsContext gc) {
        switch(form) {
            case "rond":
                gc.strokeOval(50, 50, 100, 100);
                break;
            case "oval":
                gc.strokeOval(50, 50, 100, 150);
                break;
            case "carre":
                gc.strokeOval(50, 50, 100, 100);
        }
    }

    public void drawHair(double length, String color, GraphicsContext gc) {
        switch(color) {
            case "jaune":
                gc.setStroke(Color.YELLOW);
                break;
            case "vert":
                gc.setStroke(Color.GREEN);
                break;
            case "bleu":
                gc.setStroke(Color.BLUE);
                break;
            default:
                gc.setStroke(Color.BLACK);
                break;
        }
        gc.strokeArc(60 - length, 40, 37 + length*1.2, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(55 - length, 45, 28 + length*1.2, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(50 - length, 50, 26 + length*1.2, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(50 - length, 55, 22 + length, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(50 - length, 60, 20 + length, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(50 - length, 65, 18 + length, 10, 150, 150, ArcType.OPEN);
        gc.strokeArc(50 - length, 70, 15 + length, 10, 150, 150, ArcType.OPEN);

        gc.strokeLine(115, 50, 130*(1+length/20), 130);
        gc.strokeLine(117, 50, 132*(1+length/20), 130);
        gc.strokeLine(119, 50, 134*(1+(length/20.0)), 130);
        gc.strokeLine(121, 50, 136*(1+length/20), 130);
        gc.strokeLine(123, 50, 138*(1+length/20), 130);
        gc.strokeLine(125, 50, 140*(1+length/20), 130);
        gc.strokeLine(127, 50, 142*(1+length/20), 130);
        gc.strokeLine(129, 50, 144*(1+length/20), 130);
    }

    @FXML
    private void handleSave(ActionEvent event) {
        //Print in the console the value of the Personne in the context.
        System.out.println(this.contexte.personneConnectee.getUsername() +
                " : Hair lenght = " + this.contexte.personneConnectee.getHairLength().get()+
                ", Hair color = "+ this.contexte.personneConnectee.getHairColor().get()+
                ", face form = " + this.contexte.personneConnectee.getFaceForm().get() +
        ".");
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        //Close the stage.
        Stage stage = (Stage) this.buttonCancel.getScene().getWindow();
        stage.close();
    }

}
