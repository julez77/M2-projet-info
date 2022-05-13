/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

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
            this.controleur.boutonSelect(t); 
             
        });
        
        this.bSuppr.setOnAction((ActionEvent t) -> {
            NoeudSimple n1 = new NoeudSimple(200,200);
            NoeudSimple n2 = new NoeudSimple(300,300);
            NoeudSimple n3 = new NoeudSimple(400,300);
            Barre b = new Barre(n1, n2);
            Treillis treillis = this.main.getTreillis();
            treillis.add(b);
            treillis.add(n3);
            this.main.redrawAll();
            
            treillis.remove(b);
            this.main.redrawAll();
            //this.controleur.boutonSuppr(t); 
             
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
