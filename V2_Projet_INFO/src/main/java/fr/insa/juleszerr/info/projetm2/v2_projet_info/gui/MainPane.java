/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.gui.Controleur.Etat;
import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class MainPane extends BorderPane {
    
    private Controleur controleur; 
    private Treillis treillis; 
    
    private OutilsTop outilsRight;
    private OutilsBot outilsTop;
    private DessinPane dessin;
    
    private MainMenu menu;
    private Stage inStage;
    private File curFile;
    
    private HBox top;
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
        this.top = new HBox();
        this.inStage = inStage;
        this.curFile = fromFile;
        this.treillis = treillis;
        this.controleur = new Controleur(this); 
        this.outilsRight = new OutilsTop(this, this.controleur);
        this.outilsTop = new OutilsBot(this, this.controleur);
        this.dessin = new DessinPane(this);
       
        this.menu = new MainMenu(this);
        top.getChildren().addAll(this.menu,this.outilsRight);
        //this.outilsRight.getChildren().addAll(this.menu, this.outilsTop.getToolBar());
        this.setBottom(this.outilsTop);
        this.setCenter(this.dessin);
        
        this.setTop(this.top);
                
        this.controleur.changeEtat(Etat.NOEUDSIMPLE);
       
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
        return outilsRight;
    }

    /**
     * @return the outilsTop
     */
    public OutilsBot getOutilsTop() {
        return outilsTop;
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
