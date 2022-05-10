/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiGlissant;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
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

   
    public enum Etat {DEBUT, SELECT , NOEUDSIMPLE , APPUIGLISSANT, APPUISIMPLE, 
    BARRE_N1, BARRE_N2,
    TERRAIN_N1, TERRAIN_N2, TERRAIN_N3}

    
    public Controleur(MainPane vue){
        this.vue = vue;
    }
    
    public void changeEtat(Etat nouveiEtat){
        System.out.println("changerEtat()");
        if (nouveiEtat == Etat.NOEUDSIMPLE){
            this.vue.getOutilsRight().getbGrouper().setDisable(true);
            //this.vue.getOutilsRight().getbCouleur
        }if (nouveiEtat == Etat.APPUIGLISSANT){
            
        }if (nouveiEtat == Etat.APPUISIMPLE){
            
        }if (nouveiEtat == Etat.BARRE_N1){
            
        }if (nouveiEtat == Etat.BARRE_N2){
            
        }if (nouveiEtat == Etat.TERRAIN_N1){
            
        }if (nouveiEtat == Etat.TERRAIN_N2){
            
        }if (nouveiEtat == Etat.TERRAIN_N3){
            
        }
        this.etat = nouveiEtat;
        
    }
    
    public void clicDansDessin(MouseEvent t) {

        if (this.etat == Etat.NOEUDSIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new NoeudSimple(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
            this.vue.redrawAll();
        }if (this.etat == Etat.APPUISIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new AppuiSimple(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
            this.vue.redrawAll();            
        }if (this.etat == Etat.APPUIGLISSANT) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            treillis.add(new AppuiGlissant(px , py));
            System.out.println("px = "+ px +"; py = "+ py);
            this.vue.redrawAll();            
        }if (this.etat == Etat.BARRE_N1) {
            this.pos1[0]=t.getX();
            this.pos1[1]=t.getY();
            this.changeEtat(Etat.BARRE_N2);           
        }if (this.etat == Etat.BARRE_N2) {
            double px = t.getX();
            double py = t.getY();
            this.vue.getTreillis().add(
            new Barre(new NoeudSimple(px, py), new NoeudSimple(pos1[0], pos1[1])));
            this.vue.redrawAll();
            this.changeEtat(Etat.BARRE_N1);
        }if (this.etat == Etat.TERRAIN_N1) {
            
        }if (this.etat == Etat.TERRAIN_N2) {
            
        }if (this.etat == Etat.TERRAIN_N3) {
            
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
    
}
