/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author IEUser
 */
public class OutilsTop extends HBox {

    
    private BoutonIcon bNouveu;
    private BoutonIcon bOuvrir;
    private BoutonIcon bSave;
    private BoutonIcon bSaveAs;
    private BoutonIcon bSelect;
    private BoutonIcon bSuppr;
    private BoutonIcon bTestIso;
    private BoutonIcon bResol;
    private BoutonIcon bAide;
    
    


    
    private ToolBar toolBar;
    
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    
    public OutilsTop(MainPane main, Controleur contoleur ) {
        this.setStyle("-fx-background-color: #8dbdf0; ");
        this.main = main;
        this.controleur= contoleur;
        
        this.toolBar = new ToolBar();
        
        this.bNouveu = new BoutonIcon("icones/bNouveau1.png", 32, 32);   
        this.bNouveu.setOnAction((t) -> {
            this.controleur.menuNouveau(t);
        });
        
        this.bOuvrir = new BoutonIcon("icones/bOuvrir.png", 32, 32);   
        this.bOuvrir.setOnAction((t) -> {
            this.controleur.menuOpen(t);
        });
        
        this.bSave = new BoutonIcon("icones/bSave.png", 32, 32);   
        this.bSave.setOnAction((t) -> {
            this.controleur.menuSave(t);
        });
        
        this.bSaveAs = new BoutonIcon("icones/bSaveAs.png", 32, 32);   
        this.bSaveAs.setOnAction((t) -> {
            this.controleur.menuSaveAs(t);
        });
        
        this.bSelect = new BoutonIcon("icones/bSelect.png", 32, 32);   
        this.bSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t);
        });
        
        this.bSuppr = new BoutonIcon("icones/bSuppr.png", 32, 32);   
        this.bSuppr.setOnAction((t) -> {
            this.controleur.boutonSuppr(t);
        });
        
        this.bTestIso = new BoutonIcon("icones/bTestIsos.png", 32, 32);
        this.bTestIso.setOnAction((t) -> {
            this.controleur.boutonTestIsostaticite();
        });
        
        this.bResol = new BoutonIcon("icones/bResol.png", 32, 32); 
        this.bResol.setDisable(true);
        this.bResol.setOnAction((t) -> {
            this.controleur.boutonResoudre(t);
        });
        
         this.bAide = new BoutonIcon("icones/bAide.png", 32, 32); 
         
        this.bAide.setOnAction((t) -> {
            this.controleur.boutonAide();
        });
        
        /*
        
        this.bSuppr.setOnAction((ActionEvent t) -> {
            
            this.controleur.boutonSuppr(t); 
             
        });
        
        this.bResoudre.setOnAction((ActionEvent t) -> {
            
            this.controleur.boutonResoudre(t); 
             
        });*/
        
    
        
        
       /* 
        ToggleGroup gBouton = new ToggleGroup();
        this.couleur = new ColorPicker(Color.BLACK);
        this.bGrouper = new Button("Gouper");
        this.bSelect = new Button("Selection");
        this.bSuppr = new Button("Supprimer");
        */
       
       
        toolBar.getItems().addAll(bNouveu,bOuvrir, bSave,bSaveAs,bSelect,bSuppr,bTestIso,
                bResol,bAide);
        toolBar.setOrientation(Orientation.HORIZONTAL);
        toolBar.setStyle("-fx-background-color: #8dbdf0; ");
        
        this.getChildren().addAll( toolBar,this.bResol,
                this.bSelect,this.bSuppr);
      
       
    }

   
  


    /**
     * @return the bNouveu
     */
    public BoutonIcon getbNouveu() {
        return bNouveu;
    }

    /**
     * @return the bOuvrir
     */
    public BoutonIcon getbOuvrir() {
        return bOuvrir;
    }

    /**
     * @return the bSave
     */
    public BoutonIcon getbSave() {
        return bSave;
    }

    /**
     * @return the bSaveAs
     */
    public BoutonIcon getbSaveAs() {
        return bSaveAs;
    }

    /**
     * @return the bTestIso
     */
    public BoutonIcon getbTestIso() {
        return bTestIso;
    }

    /**
     * @return the bResol
     */
    public BoutonIcon getbResol() {
        return bResol;
    }

    /**
     * @param bResol the bResol to set
     */
    public void setbResol(BoutonIcon bResol) {
        this.bResol = bResol;
    }

    /**
     * @return the bAide
     */
    public BoutonIcon getbAide() {
        return bAide;
    }

    /**
     * @return the toolBar
     */
    public ToolBar getToolBar() {
        return toolBar;
    }

    /**
     * @return the dessin
     */
    public DessinPane getDessin() {
        return dessin;
    }

    /**
     * @return the main
     */
    public MainPane getMain() {
        return main;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    

    
    
    
}
