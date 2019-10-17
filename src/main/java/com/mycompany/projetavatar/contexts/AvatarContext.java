/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar.contexts;

import com.mycompany.projetavatar.Personne;
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
public class AvatarContext {
    public Personne personneConnectee;    
    
    public AvatarContext(Personne personneConnectee){
        this.personneConnectee = personneConnectee;
    }

}
