/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class OutilsRight extends HBox {
    private ColorPicker couleur;
    private Button zoomIn;
    private Button zoomOut;
    private Button bSelect;
    private Button bSuppr;
    private Button bGrouper;
    private Button bAffiche;
    
    public OutilsRight() {
               
        this.couleur = new ColorPicker(Color.BLACK);
        this.zoomIn = new Button("Zoom *2");
        this.zoomOut = new Button("Zoom /2");
        this.bAffiche = new Button("Affiche");
        this.bGrouper = new Button("Gouper");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        
        
        
        this.getChildren().addAll(this.couleur, this.bAffiche,this.bGrouper,
                this.bSelect,this.bSuppr);
      
       
    }

    /**
     * @return the couleur
     */
    public ColorPicker getCouleur() {
        return couleur;
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
     * @return the bGrouper
     */
    public Button getbGrouper() {
        return bGrouper;
    }

    /**
     * @return the bAffiche
     */
    public Button getbAffiche() {
        return bAffiche;
    }
    
    
    
}
