/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */
public class Personne {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty hairColor = new SimpleStringProperty();
    private final IntegerProperty hairLength = new SimpleIntegerProperty();
    private final StringProperty faceForm = new SimpleStringProperty();
    
    public Personne(String username, String password, String hairColor, Integer hairLength, String faceForm) {
        this.username.set(username);
        this.password.set(password);
        this.hairColor.set(hairColor);
        this.hairLength.set(hairLength);
        this.faceForm.set(faceForm);
    }
    
    public String getUsername() {
        return this.username.get();
    }
    
    public void setUsername(String value){
        this.username.set(value);
    }
    
    public String getPassword() {
        return this.password.get();
    }
    
    public void setPassword(String value){
        this.password.set(value);
    }
    
    private StringProperty loginProperty(){
        return this.username;
    }
    
    public boolean checkPassword(String login, String password){
        return login.equals(this.getUsername()) && password.equals(this.getPassword());
    }
}
