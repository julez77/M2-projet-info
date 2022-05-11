/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiGlissant;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author IEUser
 */
public class Controleur {
    private MainPane vue;
    private Etat etat;
    
    private double[] pos1 = new double[2];
    private double[] pos2 = new double[2];
    
    private List<Figure> selection;

   
    public enum Etat {DEBUT, SELECT , NOEUDSIMPLE , APPUIGLISSANT, APPUISIMPLE, 
    BARRE_N1, BARRE_N2,
    TERRAIN_N1, TERRAIN_N2, TERRAIN_N3}

    
    public Controleur(MainPane vue){
        this.vue = vue;
        this.selection = new ArrayList<>();
    }
    
    public void changeEtat(Etat nouvelEtat){
        System.out.println("changerEtat()");
        if (nouvelEtat == Etat.SELECT){
            this.getSelection().clear();
            this.vue.redrawAll();
        }
        else if (nouvelEtat == Etat.NOEUDSIMPLE){
            this.getSelection().clear();            
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            this.vue.redrawAll();
            //this.vue.getOutilsRight().getbCouleur
        }else if (nouvelEtat == Etat.APPUIGLISSANT){
            this.getSelection().clear();            
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.APPUISIMPLE){
            this.getSelection().clear();            
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.BARRE_N1){
            this.getSelection().clear();            
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            this.vue.redrawAll();

        }else if (nouvelEtat == Etat.BARRE_N2){

        }else if (nouvelEtat == Etat.TERRAIN_N1){
            this.getSelection().clear();            
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.TERRAIN_N2){
            
        }else if (nouvelEtat == Etat.TERRAIN_N3){
            
        }
        this.etat = nouvelEtat;
        
    }
    
    public void clicDansDessin(MouseEvent t) {

        if (this.etat == Etat.SELECT) {
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Figure proche = this.vue.getTreillis().plusProche(nclic, Double.MAX_VALUE);
            if (proche != null){
                if(t.isShiftDown()){
                    this.getSelection().add(proche);                                 
                }else if (t.isControlDown()){
                    if(this.getSelection().contains(proche)){
                        this.getSelection().remove(proche);
                    }else{
                        this.getSelection().add(proche);                               
                    }
                }else{
                    this.activeBoutonsSuivantSelection();
                    this.getSelection().add(proche);
                }
                this.getSelection().clear();
                this.vue.redrawAll();                
            }
        }else if(this.etat == Etat.NOEUDSIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new NoeudSimple(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
           
            this.vue.redrawAll();
        }else if (this.etat == Etat.APPUISIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new AppuiSimple(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
            this.vue.redrawAll();            
        }else if (this.etat == Etat.APPUIGLISSANT) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new AppuiGlissant(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
            this.vue.redrawAll();            
        }else if (this.etat == Etat.BARRE_N1) {
            this.pos1[0]=t.getX();
            this.pos1[1]=t.getY();
            this.changeEtat(Etat.BARRE_N2); 
             
            
                     
        }else if (this.etat == Etat.BARRE_N2) {
            System.out.println("px2 = "+ t.getX() +"; py2 = "+ t.getY());
            
            double px = t.getX();
            double py = t.getY();
            Treillis treillis =this.vue.getTreillis();
            System.out.println("coordonnees du noeud etat barre n1: px ="+ pos1[0]+" , py = "+pos1[1]);
            System.out.println("coordonnees du noeud etat barre n2: px ="+ px+" , py = "+py);            
            Barre b2 = new Barre(new NoeudSimple(px, py), new NoeudSimple(pos1[0], pos1[1]));
            this.vue.getTreillis().add(b2);
            System.out.println("Ajout d'une barre au treillis");
            Barre b =new Barre(new NoeudSimple(0, 0), new NoeudSimple(100, 100));
            treillis.add(b);
            this.vue.redrawAll();
            this.changeEtat(Etat.BARRE_N1);
             
         
        }else if (this.etat == Etat.TERRAIN_N1) {
            
        }else if (this.etat == Etat.TERRAIN_N2) {
            
        }else if (this.etat == Etat.TERRAIN_N3) {
            
        }
    }

   
     void boutonBarre(ActionEvent t) {
        this.changeEtat(Etat.BARRE_N1);
    }

    void boutonAppuiSimple(ActionEvent t) {
        this.changeEtat(Etat.APPUISIMPLE);
    }

    void boutonNoeudSimple(ActionEvent t) {
        this.changeEtat(Etat.NOEUDSIMPLE);
    }

    void boutonAppuiGlissant(ActionEvent t) {
        this.changeEtat(Etat.APPUIGLISSANT);
    }

    void boutonTerrain(ActionEvent t) {
        this.changeEtat(Etat.TERRAIN_N1);
    }
     private void activeBoutonsSuivantSelection() {
        this.vue.getOutilsRight().getbGrouper().setDisable(true);
        this.vue.getOutilsRight().getbSuppr().setDisable(true);
        if (this.etat == Etat.SELECT) {
            if (this.getSelection().size() > 0) {
                this.vue.getOutilsRight().getbSuppr().setDisable(false);
                if (this.getSelection().size() > 1) {
                    this.vue.getOutilsRight().getbGrouper().setDisable(false);
                }
            }
        }
    }

    /**
     * @return the selection
     */
    public List<Figure> getSelection() {
        return selection;
    }
}
