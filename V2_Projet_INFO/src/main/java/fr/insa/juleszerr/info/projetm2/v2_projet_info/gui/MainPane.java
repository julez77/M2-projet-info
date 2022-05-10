/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author IEUser
 */
public class MainPane extends BorderPane {


    
    private Controleur controleur; 
    private Treillis treillis; // =Private Groupe model; dans l'exemple du cours
    private OutilsRight outilsRight;
    private OutilsTop outilsTop;
    private DessinPane dessin;
    
    public MainPane (){
        this.treillis = new Treillis();
    }
    
    
    public MainPane(Treillis treillis){
       this.treillis = treillis;
       this.controleur = new Controleur(this); 
       this.outilsRight = new OutilsRight();
       this.outilsTop = new OutilsTop(this, this.controleur);
       this.dessin = new DessinPane(this);
       
       this.setBottom(this.outilsRight);
       this.setTop(this.outilsTop);
       this.setCenter(this.dessin);
       this.controleur.changeEtat(Controleur.Etat.NOEUDSIMPLE);
       
    }
    
    public void redrawAll(){
        this.getDessin().redrawAll();
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
    public OutilsRight getOutilsRight() {
        return outilsRight;
    }

    /**
     * @return the outilsTop
     */
    public OutilsTop getOutilsTop() {
        return outilsTop;
    }

    /**
     * @return the dessin
     */
    public DessinPane getDessin() {
        return dessin;
    }
     
    
}
