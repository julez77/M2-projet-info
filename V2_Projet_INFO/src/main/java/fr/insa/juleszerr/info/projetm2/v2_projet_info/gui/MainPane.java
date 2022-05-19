/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.gui.Controleur.Etat;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class MainPane extends BorderPane {
    
    public static String COLOR_MENU = "7e95d5"; 
    
    private Controleur controleur; 
    private Treillis treillis; 
    
    private OutilsTop outilsTop;
    private OutilsLeft outilsLeft;
    private DessinPane dessin;
    
    private MainMenu menu;
    private Stage inStage;
    private File curFile;
    
    private VBox top;
    public MainPane (){
        this.treillis = new Treillis();
    }
    
    public MainPane(Stage inStage) {
    this(inStage, new Treillis());
    }
    
    public MainPane(Stage inStage, Treillis treillis) {
        this(inStage, null, treillis);
    }
    
    public MainPane(Stage inStage, File fromFile, Treillis treillis){
        this.top = new VBox();
        this.inStage = inStage;
        this.curFile = fromFile;
        this.treillis = treillis;
        this.controleur = new Controleur(this); 
        this.outilsTop = new OutilsTop(this, this.controleur);
        this.outilsLeft = new OutilsLeft(this, this.controleur);
        
        ToggleGroup gBoutons = new ToggleGroup();
        this.outilsLeft.getbNoeudSimple().setToggleGroup(gBoutons);
        this.outilsLeft.getbAppuiSimple().setToggleGroup(gBoutons);
        this.outilsLeft.getbAppuiGlissant().setToggleGroup(gBoutons);
        this.outilsLeft.getbTerrainLibre().setToggleGroup(gBoutons);
        this.outilsLeft.getbTerrainHori().setToggleGroup(gBoutons);
        this.outilsLeft.getbBarreDepuisNoeud().setToggleGroup(gBoutons);
        this.outilsLeft.getbBarreLibre().setToggleGroup(gBoutons);
        this.outilsLeft.getbForce().setToggleGroup(gBoutons);
        
    
        
        
        this.dessin = new DessinPane(this);
        Label titre = new Label("Titre ");                
        titre.setStyle("-fx-font-weight: bold;");
        this.menu = new MainMenu(this);
        top.getChildren().addAll(this.menu,this.outilsTop);
        this.setLeft(this.outilsLeft);
        this.setCenter(this.dessin); 
        this.setTop(this.top);
        this.controleur.changeEtat(Etat.TERRAIN_N1);       
    }
    
    public void redrawAll(){
        this.dessin.redrawAll();
    }
    
   
     public Treillis getTreillis() {
        return treillis;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }
    
       /**
     * @return the outilsRight
     */
    public OutilsTop getOutilsRight() {
        return outilsTop;
    }

    /**
     * @return the outilsTop
     */
    public OutilsLeft getOutilsTop() {
        return outilsLeft;
    }

    /**
     * @return the dessin
     */
    public DessinPane getDessin() {
        return dessin;
    }

    /**
     * @return the inStage
     */
    public Stage getInStage() {
        return inStage;
    }

    /**
     * @return the curFile
     */
    public File getCurFile() {
        return curFile;
    }

    /**
     * @param curFile the curFile to set
     */
    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }

    
     
    
}
