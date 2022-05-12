/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class OutilsRight extends VBox {
    private Button zoomIn;
    private Button zoomOut;
    private Button bSelect;
    private Button bSuppr;
    private Button bAffiche;
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    
    public OutilsRight(MainPane main, Controleur contoleur ) {
        this.main = main;
        this.controleur= contoleur;
               
        this.zoomIn = new Button("Zoom *2");
        this.zoomOut = new Button("Zoom /2");
        this.bAffiche = new Button("Affiche");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        
        this.bSelect.setOnAction((ActionEvent t) -> {
            System.out.println("Select select");
            this.controleur.boutonSelect(t); 
             
        });
        
        
       /* 
        ToggleGroup gBouton = new ToggleGroup();
        this.couleur = new ColorPicker(Color.BLACK);
        this.bGrouper = new Button("Gouper");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        */
        
        this.getChildren().addAll( this.bAffiche,
                this.bSelect,this.bSuppr);
      
       
    }



    /**
     * @return the zoomIn
     */
    public Button getZoomIn() {
        return zoomIn;
    }

    /**
     * @return the zoomOut
     */
    public Button getZoomOut() {
        return zoomOut;
    }

    /**
     * @return the bSelect
     */
    public Button getbSelect() {
        return bSelect;
    }

    /**
     * @return the bSuppr
     */
    public Button getbSuppr() {
        return bSuppr;
    }

    

    /**
     * @return the bAffiche
     */
    public Button getbAffiche() {
        return bAffiche;
    }
    
    
    
}
