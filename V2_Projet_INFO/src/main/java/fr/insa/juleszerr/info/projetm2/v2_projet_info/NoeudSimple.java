/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author IEUser
 */
public class NoeudSimple extends Noeud {
    
    public static  double  RAYON_IN_DRAW = 5;
     public NoeudSimple (double px , double py ){
        super(px,py);  
        
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
      return  "("+this.getPx()+","+this.getPy()+")";
  }

    
    @Override
    public double maxX() {
        return this.px;
            
    }
    
    @Override
    public double minX() {
        return this.px;
    }

    @Override
    public double maxY() {
      return this.py;
    }

    @Override
    public double minY() {
        return this.py;
    }

   /*
    @Override
    public Groupe dessine(GraphicsContext context) {
       context.setFill(BLUE);
       context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW); 
        return null;
    }
*/

  
    @Override
        public  Group dessine() {
        Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(BLUE);
        res.setFill(BLUE);
        Group g = new Group( res);       
        return g;              
    }

   
    
}
