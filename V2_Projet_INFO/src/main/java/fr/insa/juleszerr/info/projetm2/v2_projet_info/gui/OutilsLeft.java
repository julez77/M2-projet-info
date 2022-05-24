/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;


import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author IEUser
 */
public class OutilsLeft extends HBox {
    private ToggleButton bNoeudSimple;
    private ToggleButton bAppuiSimple;
    private ToggleButton bAppuiGlissant;
    private ToggleButton bTerrainLibre;
    private ToggleButton bTerrainHori;
    
    private ToggleButton bBarreDepuisNoeud;
    private ToggleButton bBarreLibre;
    private ToggleButton bForce;
    
    private Button bParaForce;
    private Button bChoixMateriau;
    private Button bAffTraxComp;
    
    private GrilleAffichage grill;
    
    private DessinPane dessin;
    private MainPane main;
    private Controleur controleur; 
    private ToolBar toolBar ;
    
public OutilsLeft(MainPane main, Controleur controleur) {
    this.setMinWidth(135);
    this.main= main;
    this.controleur = controleur;
    this.grill = new GrilleAffichage(main);
    this.setStyle("-fx-background-color: #8dbdf0; ");    
    this.toolBar = new ToolBar();
    
    Label lNouvelleBarre = new Label("Nouvelle barre:");
    this.bBarreDepuisNoeud = new ToggleButton("A partir de noeud");
    this.bBarreLibre = new ToggleButton("Libre");
    //this.bBarrePara = new RadioButton ("Parallèle à une autre Barre");
    
    Label lNouveauNoeud = new Label("Nouveau noeud:");    
    this.bNoeudSimple = new ToggleButton("Noeud Simple");
    this.bAppuiSimple = new ToggleButton("Appui Simple");
    this.bAppuiGlissant = new ToggleButton("Appui Glissant");
    
    Label lNouveauTerrain = new Label("Nouveau terrain:");
    this.bTerrainLibre =new ToggleButton("Terrain libre");
    this.bTerrainHori = new ToggleButton("Terrain plan");
    
    Label lNouvelleForce = new Label("Nouvelle Force:");
    this.bForce = new ToggleButton("Sur un noeud");
    
    this.bParaForce = new Button("Réglages force");
    
    Label lMateriau = new Label("Choix du materiau:");
    this.bChoixMateriau = new Button("Materiau");
    
    this.bAffTraxComp = new Button("Affiche trax/comp");
    
    
        
    Separator s1 = new Separator(Orientation.VERTICAL);
    Separator s2 = new Separator(Orientation.VERTICAL);
    Separator s3 = new Separator(Orientation.VERTICAL);
       
    
    
       
    toolBar.getItems().addAll(lNouveauNoeud, bNoeudSimple, bAppuiSimple,bAppuiGlissant,
    lNouveauTerrain, bTerrainLibre,bTerrainHori,
    lNouvelleBarre,bBarreLibre,bBarreDepuisNoeud, lNouvelleForce,bForce, bParaForce,lMateriau,bChoixMateriau,bAffTraxComp);
    toolBar.setOrientation(Orientation.VERTICAL);
    toolBar.setStyle("-fx-background-color: #8dbdf0; ");     
        
        ToggleGroup gBoutons = new ToggleGroup(); 
        
        /*
        this.bNoeudSimple.setToggleGroup(gBoutons);
        this.bAppuiSimple.setToggleGroup(gBoutons);
        this.bAppuiGlissant.setToggleGroup(gBoutons);
        this.bTerrainLibre.setToggleGroup(gBoutons);
        this.bTerrainHori.setToggleGroup(gBoutons);
        this.bBarreDepuisNoeud.setToggleGroup(gBoutons);
        this.bBarreLibre.setToggleGroup(gBoutons);
        this.bForce.setToggleGroup(gBoutons);
        */
        this.bBarreLibre.setOnAction((ActionEvent t) -> {
            this.controleur.boutonBarreLibre(t);
        });
        
        this.bForce.setOnAction((ActionEvent t) -> {
            this.controleur.boutonForce(t);
        });
        
        this.bBarreDepuisNoeud.setOnAction((ActionEvent t) -> {
            this.controleur.boutonBarreDepuisNoeud(t);
        });
         
        this.bAppuiSimple.setOnAction((ActionEvent t) -> {
            this.controleur.boutonAppuiSimple(t);
             
        });
        
        bNoeudSimple.setMinWidth(125);
        bAppuiGlissant.setMinWidth(125);
        bAppuiSimple.setMinWidth(125);
        bBarreDepuisNoeud.setMinWidth(125);
        bBarreLibre.setMinWidth(125);
        bForce.setMinWidth(125);
        bTerrainHori.setMinWidth(125);
        bTerrainLibre.setMinWidth(125);
        bParaForce.setMinWidth(125);
        bChoixMateriau.setMinWidth(125);
        bAffTraxComp.setMinWidth(125);
        this.bNoeudSimple.setOnAction((ActionEvent t)-> {
            this.controleur.boutonNoeudSimple(t);

           
        });
        this.bAppuiGlissant.setOnAction((ActionEvent t) -> {
            this.controleur.boutonAppuiGlissant(t);
  
             
        });
        this.bTerrainLibre.setOnAction((ActionEvent t) -> {
            this.controleur.boutonTerrainLibre(t);            
        });
        
        this.bTerrainHori.setOnAction((ActionEvent t) -> {
            this.controleur.boutonTerrainHori(t);            
        });
        
        this.bParaForce.setOnAction((t) -> {
            this.controleur.boutonParametreForce();
        });
        
        this.bChoixMateriau.setOnAction((t) -> {
            this.controleur.boutonParametreMateriau();
        });
        
         this.bAffTraxComp.setOnAction((t) -> {
            this.controleur.boutonAfficheTraxComp();
        });
        
        
        this.getChildren().addAll(this.bAppuiSimple,this.bAppuiGlissant,this.bNoeudSimple,
                this.bTerrainLibre,this.bTerrainHori, this.toolBar, this.bBarreDepuisNoeud,this.bBarreLibre);
        //FxUtils.setSimpleBorder(this, Color.CYAN, 2);
        
    }

    /**
     * @return the bNoeudSimple
     */
    public ToggleButton getbNoeudSimple() {
        return bNoeudSimple;
    }

    /**
     * @return the bAppuiSimple
     */
    public ToggleButton getbAppuiSimple() {
        return bAppuiSimple;
    }

    /**
     * @return the bAppuiGlissant
     */
    public ToggleButton getbAppuiGlissant() {
        return bAppuiGlissant;
    }



    /**
     * @return the bTerrain
     */
    public ToggleButton getbTerrain() {
        return getbTerrainLibre();
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

    /**
     * @return the bTerrainLibre
     */
    public ToggleButton getbTerrainLibre() {
        return bTerrainLibre;
    }

    /**
     * @return the bTerrainHori
     */
    public ToggleButton getbTerrainHori() {
        return bTerrainHori;
    }

    /**
     * @return the bBarreDepuisNoeud
     */
    public ToggleButton getbBarreDepuisNoeud() {
        return bBarreDepuisNoeud;
    }

    /**
     * @return the bBarreLibre
     */
    public ToggleButton getbBarreLibre() {
        return bBarreLibre;
    }

    /**
     * @return the bForce
     */
    public ToggleButton getbForce() {
        return bForce;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }


}
