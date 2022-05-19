/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.Group;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.PURPLE;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author IEUser
 */
public class AppuiGlissant extends NoeudAppui{

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    private Terrain terrain ;
    private Barre poseSur ;  //barre sur laquelle est posé l'appui glissant
    
     public AppuiGlissant(double px, double py){
      
      super(px,py);     
      
  }  
 
  
    @Override
 public String toString(){
      return  "["+this.getPx()+","+this.getPy()+"] appuiglissant posé sur barre "+ this.getPoseSur()+" force : "+this.getForce().toString();
  }
 
 @Override
 public String toString2(){
     return "["+this.getPx()+","+this.getPy()+"] appuiglissant" ;
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
       context.setFill(PURPLE);
       context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW); 
        return null;
    }
*/
    @Override
    public  Group dessine() {
        Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(PURPLE);
        res.setFill(PURPLE);
        Group g = new Group(res);  
        
        
        return g;              
    }
    
     @Override
    public Group dessineSelection() {
        Ellipse res = new Ellipse(this.px, this.py, RAYON_IN_DRAW, RAYON_IN_DRAW);
        //Segment s = new Segment(new Point(0, 0), new Point(5, 5));
        res.setStroke(NoeudSimple.COULEUR_SELECTION);
        res.setFill(NoeudSimple.COULEUR_SELECTION);
        Group g = new Group(res);
        return g;
    }
 
     @Override
    public void save(Writer w, Numeroteur<Figure> numn) throws IOException {
        if(! numn.objExist(this)) {
            int id = numn.creeID(this);
            w.append("AppuiGlissant;"+id+";"+this.px+";"+this.py+";"+numn.getID(this.poseSur)+
                      "\n");
        }
    }
 @Override
    public double distanceNoeud(Noeud p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);

    }
    
    public double angleForce(){          //renvoie l'angle formé avec l'horizontale par le vecteur "réaction normale du support" associé à l'appui 
        Barre barresupport = this.getPoseSur();
        double angle = barresupport.vecteurBarre().vecteurNormal().angleHorizontale() ;
        
        return angle ;
    }
    
    

    /**
     * @return the poseSur
     */
    public Barre getPoseSur() {
        return poseSur;
    }

    /**
     * @param poseSur the poseSur to set
     */
    public void setPoseSur(Barre poseSur) {
        this.poseSur = poseSur;
    }

   
 
}
