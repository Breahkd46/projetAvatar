/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */
public class Personne {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();

    public Personne(String username, String password) {
        this.username.set(username);
        this.password.set(password);
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
