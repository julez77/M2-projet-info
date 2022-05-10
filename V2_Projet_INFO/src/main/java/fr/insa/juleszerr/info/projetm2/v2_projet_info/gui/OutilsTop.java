/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;


import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;

/**
 *
 * @author IEUser
 */
public class OutilsTop extends HBox {
    private RadioButton bNoeudSimple;
    private RadioButton bAppuiSimple;
    private RadioButton bAppuiGlissant;
    private RadioButton bBarre;
    private RadioButton bTerrain;
    
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    private ToolBar toolBar ;
    
public OutilsTop(MainPane main, Controleur controleur) {
    this.main= main;
    this.controleur = controleur;
        
        this.toolBar = new ToolBar();
        
        this.bNoeudSimple = new RadioButton("Noeud Simple");
        this.bAppuiSimple = new RadioButton("Appui Simple");
        this.bBarre = new RadioButton("Barre");
        this.bAppuiGlissant = new RadioButton("Appui Glissant");
        this.bTerrain =new RadioButton("Terrain");
        
        Label label = new Label("Créer :");
        toolBar.getItems().addAll(label, bNoeudSimple, bAppuiSimple, bBarre,bAppuiGlissant, bTerrain);
        toolBar.setOrientation(Orientation.HORIZONTAL);
        toolBar.setStyle("-fx-background-color: #8dbdf0; ");
        
      
        /*this.main.setOnMouseClicked((MouseEvent t2) -> {
                System.out.println("px = "+ t2.getX()+"; py ="+t2.getY());
            Controleur control = this.main.getControleur();
            control.clicDansDessin(t2);
        });*/
        //=> setOn... dans DessinPane
        
        ToggleGroup gBoutons = new ToggleGroup();
        
        this.bBarre.setToggleGroup(gBoutons);
        this.bNoeudSimple.setToggleGroup(gBoutons);
        this.bAppuiSimple.setToggleGroup(gBoutons);
        this.bAppuiGlissant.setToggleGroup(gBoutons);
        this.bTerrain.setToggleGroup(gBoutons);
        
        this.bBarre.setOnAction((ActionEvent t) -> {
              System.out.println("Barre select");
            this.controleur.boutonBarre(t);
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
                this.bTerrain,this.bBarre, this.toolBar);
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
     * @return the bBarre
     */
    public RadioButton getbBarre() {
        return bBarre;
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
