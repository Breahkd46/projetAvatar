/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */
public class Personne {
    public final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    public final StringProperty name = new SimpleStringProperty();
    public final StringProperty ville = new SimpleStringProperty();
    private final StringProperty hairColor = new SimpleStringProperty();
    private final DoubleProperty hairLength = new SimpleDoubleProperty();
    private final StringProperty faceForm = new SimpleStringProperty();
    
    public Personne(String username, String password, String hairColor, Double hairLength, String faceForm) {
        this.username.set(username);
        this.password.set(password);
        this.name.set("Christophe");
        this.ville.set("Cahors");
        this.hairColor.set(hairColor);
        this.hairLength.set(hairLength);
        this.faceForm.set(faceForm);
    }
    
    public Personne(){
        new Personne("Lorianne","justdance2","vert",7.0,"oval");
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
    
    public DoubleProperty getHairLength(){
        return this.hairLength;
    }

    public StringProperty getHairColor() {
        return this.hairColor;
    }

    public StringProperty getFaceForm() {
        return this.faceForm;
    }   

    public String getName() {
        return name.get();
    }

    public String getVille() {
        return ville.get();
    }
    
    

    @Override
    public String toString() {
        return "Personne{" + "username=" + username + ", hairColor=" + hairColor + ", hairLength=" + hairLength + ", faceForm=" + faceForm + '}';
    }
    
    
}
