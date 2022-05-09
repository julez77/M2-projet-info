/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.event.ActionEvent;

/**
 *
 * @author IEUser
 */
public class Controleur {
    
    public void clicDansDessin(ActionEvent t) {
        if (this.etat == Etat.NOEUDSIMPLE) {

        }
    }

    public enum Etat { SELECT , NOEUDSIMPLE , APPUIGLISSANT, APPUISIMPLE, BARREN1, BARREN2}

    private Etat etat;
    
    
}
