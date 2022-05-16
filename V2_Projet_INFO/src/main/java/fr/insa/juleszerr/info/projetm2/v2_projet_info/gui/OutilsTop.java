/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 *
 * @author IEUser
 */
public class OutilsTop extends HBox {
    private Button bSelect;
    private Button bSuppr;
    private Button bResoudre;
    
    private ToolBar toolBar;
    
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    
    public OutilsTop(MainPane main, Controleur contoleur ) {
        this.main = main;
        this.controleur= contoleur;
        
        this.toolBar = new ToolBar();
        
        this.bResoudre = new Button("Resoudre");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        
        toolBar.getItems().addAll(bSelect,bSuppr,bResoudre);
        toolBar.setOrientation(Orientation.HORIZONTAL);
        toolBar.setStyle("-fx-background-color: #8dbdf0; ");
        this.bSelect.setOnAction((ActionEvent t) -> {
            this.controleur.boutonSelect(t); 
             
        });
        
        this.bSuppr.setOnAction((ActionEvent t) -> {
            
            this.controleur.boutonSuppr(t); 
             
        });
        
        this.bResoudre.setOnAction((ActionEvent t) -> {
            
            this.controleur.boutonResoudre(t); 
             
        });
        
        
       /* 
        ToggleGroup gBouton = new ToggleGroup();
        this.couleur = new ColorPicker(Color.BLACK);
        this.bGrouper = new Button("Gouper");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        */
        
        this.getChildren().addAll( toolBar,this.bResoudre,
                this.bSelect,this.bSuppr);
      
       
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
        return bResoudre;
    }
    
    
    
}
