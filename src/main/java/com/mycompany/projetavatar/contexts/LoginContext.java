/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar.contexts;

import com.mycompany.projetavatar.models.Personnes;
import com.mycompany.projetavatar.Personne;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */
public class LoginContext {
    private Personnes personnes;
    private StringProperty loginUtilisateurConnecte;
    private StringProperty passwordUtilisateurConnecte;
    
    public LoginContext(Personnes personnes){
        this.personnes = personnes;
        this.loginUtilisateurConnecte = new SimpleStringProperty();
        this.passwordUtilisateurConnecte = new SimpleStringProperty();
    }
    
    public Personnes getPersonnes(){
        return this.personnes;
    }
    
    public StringProperty loginUtilisateurConnecteProperty(){
        return this.loginUtilisateurConnecte;
    }
    
    public String getLoginUtilisateurConnecte(){
        return this.loginUtilisateurConnecte.get();
    }
    
    public StringProperty passwordUtilisateurConnectProperty(){
        return this.passwordUtilisateurConnecte;
    }
    
    public String getPasswordUtilisateurConnect(){
        return this.passwordUtilisateurConnecte.get();
    }
    
    public Personne identification(){
        return personnes.identification(loginUtilisateurConnecte.get(), passwordUtilisateurConnecte.get());
    }
}
