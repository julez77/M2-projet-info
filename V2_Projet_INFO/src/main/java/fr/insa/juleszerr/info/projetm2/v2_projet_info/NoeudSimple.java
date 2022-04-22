/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author IEUser
 */
public class NoeudSimple extends Noeud {
    
    public static final double  TAILLE_POINT = 5;
     public NoeudSimple (double px , double py ){
        super(px,py);      
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
      return  "["+this.getPx()+","+this.getPy()+"] noeudsimple id " + this.getId();
  }

    @Override
    public double maxX() {
        return this.px;
            
    }

    @Override
    public Groupe dessine() {
        Ellipse res = new Ellipse (this.px, this.py ,TAILLE_POINT, TAILLE_POINT );
        res.setStroke(BLUE);
        res.setFill(BLUE);
        Groupe g = new Groupe;
        return g; 
        
    }
}
