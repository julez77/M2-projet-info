/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author IEUser
 */
public class NoeudSimple extends Noeud {
    public static Color COULEUR_SELECTION; 
    public static  double  RAYON_IN_DRAW = 3;
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

@Override
    public double distanceNoeud(Noeud p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);

    }

  
    @Override
        public  Group dessine() {
        Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(BLUE);
        res.setFill(BLUE);
         Group g = new Group( res);       
        return g;              
    }
      @Override
    public Group dessineSelection() {
    Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(COULEUR_SELECTION);
        res.setFill(COULEUR_SELECTION);
         Group g = new Group( res);       
        return g;           
    }
    
        public  Group dessine(Color color) {
        Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(color);
        res.setFill(color);
         Group g = new Group( res);       
        return g;              
    }
        
    @Override
    public void save(Writer w, Numeroteur<Figure> numn) throws IOException {
        if(! numn.objExist(this)) {
            int id = numn.creeID(this);
            w.append("NoeudSimple;"+id+";"+this.px+";"+this.py+
                      "\n");
        }
    }

    
  
    
}
