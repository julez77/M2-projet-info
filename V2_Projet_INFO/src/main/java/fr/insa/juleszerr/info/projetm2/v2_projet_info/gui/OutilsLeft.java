/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;


import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;

/**
 *
 * @author IEUser
 */
public class OutilsLeft extends HBox {
    private RadioButton bNoeudSimple;
    private RadioButton bAppuiSimple;
    private RadioButton bAppuiGlissant;
    private RadioButton bTerrain;
    
    private RadioButton bBarreDepuisNoeud;
    private RadioButton bBarreLibre;
    private RadioButton bForce;
    
    
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    private ToolBar toolBar ;
    
public OutilsLeft(MainPane main, Controleur controleur) {
    this.main= main;
    this.controleur = controleur;
    this.setStyle("-fx-background-color: #8dbdf0; ");
    
    this.toolBar = new ToolBar();
    
    Label lNouvelleBarre = new Label("Nouvelle barre:");
    this.bBarreDepuisNoeud = new RadioButton("A partir de noeud");
    this.bBarreLibre = new RadioButton("Libre");
    //this.bBarrePara = new RadioButton ("Parallèle à une autre Barre");
    
    Label lNouveauNoeud = new Label("Nouveau noeud:");    
    this.bNoeudSimple = new RadioButton("Noeud Simple");
    this.bAppuiSimple = new RadioButton("Appui Simple");
    this.bAppuiGlissant = new RadioButton("Appui Glissant");
    
    Label lNouveauTerrain = new Label("Nouveau terrain:");
    this.bTerrain =new RadioButton("Terrain");
    
    Label lNouvelleForce = new Label("Nouvelle Force:");
    this.bForce = new RadioButton("Sur un noeud");
        
    Separator s1 = new Separator(Orientation.VERTICAL);
    Separator s2 = new Separator(Orientation.VERTICAL);
    Separator s3 = new Separator(Orientation.VERTICAL);
       
    
    
       
        toolBar.getItems().addAll(lNouveauNoeud, bNoeudSimple, bAppuiSimple,bAppuiGlissant,s1,
    lNouveauTerrain, bTerrain,s2,
    lNouvelleBarre,bBarreLibre,bBarreDepuisNoeud,s3, lNouvelleForce,bForce);
    toolBar.setOrientation(Orientation.VERTICAL);
    toolBar.setStyle("-fx-background-color: #8dbdf0; ");     
        
        ToggleGroup gBoutons = new ToggleGroup(); 
        
        
        this.bNoeudSimple.setToggleGroup(gBoutons);
        this.bAppuiSimple.setToggleGroup(gBoutons);
        this.bAppuiGlissant.setToggleGroup(gBoutons);
        this.bTerrain.setToggleGroup(gBoutons);
        this.bBarreDepuisNoeud.setToggleGroup(gBoutons);
        this.bBarreLibre.setToggleGroup(gBoutons);
        this.bForce.setToggleGroup(gBoutons);
        
        this.bBarreLibre.setOnAction((ActionEvent t) -> {
              System.out.println("Barre select");
            this.controleur.boutonBarreLibre(t);
        });
        
        this.bForce.setOnAction((ActionEvent t) -> {
              System.out.println("Barre select");
            this.controleur.boutonForce(t);
        });
        
        this.bBarreDepuisNoeud.setOnAction((ActionEvent t) -> {
              System.out.println("Barre select");
            this.controleur.boutonBarreDepuisNoeud(t);
        });
         
        this.bAppuiSimple.setOnAction((ActionEvent t) -> {
            System.out.println("Appuis simple select");
            this.controleur.boutonAppuiSimple(t);
             
        });
        
        this.bNoeudSimple.setOnAction((ActionEvent t)-> {
            System.out.println("Noeud Simple select");
            this.controleur.boutonNoeudSimple(t);

           
        });
        this.bAppuiGlissant.setOnAction((ActionEvent t) -> {
            System.out.println("Appui Glissant select");
            this.controleur.boutonAppuiGlissant(t);
  
             
        });
        this.bTerrain.setOnAction((ActionEvent t) -> {
            System.out.println("Terrain select");
            this.controleur.boutonTerrain(t);            
        });
        

        
        
        
        
        this.getChildren().addAll(this.bAppuiSimple,this.bAppuiGlissant,this.bNoeudSimple,
                this.bTerrain, this.toolBar, this.bBarreDepuisNoeud,this.bBarreLibre);
        //FxUtils.setSimpleBorder(this, Color.CYAN, 2);
        
    }

    /**
     * @return the bNoeudSimple
     */
    public RadioButton getbNoeudSimple() {
        return bNoeudSimple;
    }

    /**
     * @return the bAppuiSimple
     */
    public RadioButton getbAppuiSimple() {
        return bAppuiSimple;
    }

    /**
     * @return the bAppuiGlissant
     */
    public RadioButton getbAppuiGlissant() {
        return bAppuiGlissant;
    }



    /**
     * @return the bTerrain
     */
    public RadioButton getbTerrain() {
        return bTerrain;
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
     * @return the toolBar
     */
    public ToolBar getToolBar() {
        return toolBar;
    }


}
