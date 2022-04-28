/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Groupe;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author IEUser
 */
public class MainPanel extends BorderPane {
    
     public Groupe getModel() {
        return model;
    }
    
    
    private Groupe model;
    private OutilsTop outilsTop;
    private OutilsLeft outilsLeft;
    private DessinPane dessin;
    
    
    public MainPanel (Groupe model){
       this.model = model;
       this.outilsTop = new OutilsTop();
       this.outilsLeft = new OutilsLeft();
       this.dessin = new DessinPane(this);
       
       this.setRight(this.outilsTop);
       this.setLeft(this.outilsLeft);
       this.setCenter(this.dessin);
       
    }
}
