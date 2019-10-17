/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Etu
 */
public class AvatarContexte {
    public Personne personneConnectee;
    public final ObservableList<String> listHairColor;
    public final ObservableList<String> listFaceForm;    
    
    public AvatarContexte(Personne personneConnectee){
        this.personneConnectee = personneConnectee;
        
        //Populate the ObservableList for the listView to pick the hair color in the AvatarMaker.
        this.listHairColor = FXCollections.observableArrayList("vert","jaune","bleu");
        
        //Populate the ObersableList for the ComboBox to pick the shape of the face in the AvatarMaker.
        this.listFaceForm = FXCollections.observableArrayList("rond","oval","carre");

    }

}
