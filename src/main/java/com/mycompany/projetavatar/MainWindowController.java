package com.mycompany.projetavatar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

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
    @FXML
    private BorderPane borderPaneCanvas;
    
    private StringProperty faceForm;
    private DoubleProperty length;
    private StringProperty color;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.canvas.scaleXProperty().bind(this.borderPaneCanvas.widthProperty().divide(this.canvas.getWidth()));
        this.canvas.scaleYProperty().bind(this.borderPaneCanvas.heightProperty().divide(this.canvas.getHeight()));
        this.faceForm.setValue("rond");
        this.length.setValue(0.0);
        this.color.setValue("jaune");
        this.drawAvatar();
    }
    
    public void drawAvatar() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.restore();
        this.drawFace(this.faceForm.getValue(), gc);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(75, 75, 10, 10);
        gc.strokeOval(115, 75, 10, 10);
        gc.strokeLine(85, 120, 115, 120);
        this.drawHair(this.length.getValue(),this.color.getValue(), gc);
    }
    
    public void drawFace(String form, GraphicsContext gc) {
        switch(form) {
            case "rond":
                gc.strokeOval(50, 50, 100, 100);
                break;
            case "ovale":
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
            case "green":
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
    
    public void setContexte(LoginContexte contexte){
       this.contexte = contexte;
       /*
       contexte.loginUtilisateurConnecteProperty().bind(this.username.textProperty());
       contexte.passwordUtilisateurConnectProperty().bind(this.password.textProperty());
       */
       ;
    }

    @FXML
    private void handleSave(ActionEvent event) {
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }
    
}
