/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetavatar;

import com.mycompany.projetavatar.Personne;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Etu
 */
public class Personnes {
    private final ObservableList<Personne> liste;

    public Personnes( List<Personne> liste){
        this.liste = FXCollections.observableArrayList(liste);
    }

    public Personnes(){
        this.liste = FXCollections.observableArrayList();
        liste.add(new Personne("titi","toto","jaune",7.0,"rond"));
        liste.add(new Personne("Lorianne","justdance2","vert",7.0,"oval","Lorianne","Prémian"));
    }

    public ObservableList<Personne> getListe(){
        return this.liste;
    }

    public void addPersonne(Personne p) {
        this.liste.add(p);
    }

    public Personne identification(String login, String password){
        for (Personne p: liste){
            if (p.checkPassword(login, password)) return p;
        }
        return null;
    }
}
