/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.awt.Point;
import static java.lang.Math.sqrt;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Line;
import java.io.IOException;
import java.io.Writer;
/**
 *
 * @author IEUser
 */
public  class Barre extends Figure  {

    static Barre demandeBarre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Noeud noeud1 ;
    private Noeud noeud2 ;
    
private double prix ;
private double effort ;
private int id ;

    Barre(Point p1, Point p2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


public Vecteur2d vecteurBarre(){                                         //renvoie le vecteur associé à une barre (direction du vecteur : point de départ vers point d'arrivée)
    double px = this.getNoeud2().getPx() - this.getNoeud1().getPx() ;
    double py =  this.getNoeud2().getPy() - this.getNoeud1().getPy() ;
    Vecteur2d vecteur = new Vecteur2d (px, py) ;
    return vecteur ;
}

    /**
     * @return the noeud1
     */
    public Noeud getNoeud1() {
        return noeud1;
    }

    /**
     * @param noeud1 the noeud1 to set
     */
    public void setNoeud1(Noeud noeud1) {
        this.noeud1 = noeud1;
        noeud1.getBarredebut().add(this);
    }

    /**
     * @return the noeud2
     */
    public Noeud getNoeud2() {
        return noeud2;
        
    }

    /**
     * @param noeud2 the noeud2 to set
     */
    public void setNoeud2(Noeud noeud2) {
        this.noeud2 = noeud2;
        noeud2.getBarrefin().add(this);
    }
    
    public Barre ( Noeud noeud1 , Noeud noeud2 ){
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.effort= 0;
        this.id=0;
        this.prix = 0;
        
        noeud2.getBarrefin().add(this);
        noeud1.getBarredebut().add(this);
    }
    public Barre (Noeud noeud1,Noeud noeud2,double effort,double prix){
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.effort = effort;
        this.prix = prix;
        
        noeud2.getBarrefin().add(this);
        noeud1.getBarredebut().add(this);
        
        
    }
    
    /**
     *
     * @return
     */
    @Override
 public String toString() {
        return "barre :[" + this.noeud1.toString()+ "," + this.noeud2.toString() + "] id  :"+ id +" effort :"+getEffort()+" prix"+prix  ;   
 }
    
  public static  Barre créeBarre() {
        System.out.println(" noeud n1 : ");
        Noeud noeud1 = Noeud.entrenoeud();
        System.out.println("noeud  n2: ");
        Noeud noeud2 = Noeud.entrenoeud();
        return new Barre(noeud1, noeud2);   
    
  }

    public Noeud noeudOppose(Noeud  N){
    if (N==noeud2){
 return noeud1  ; }
        if (N == noeud1){
            return noeud2 ; }
        else{ return N;}
     
}
    public double angle(){
    double  magv1 = sqrt(Math.pow(noeud1.getPx() ,2)+  Math.pow(noeud2.getPy() ,2));
    double magv2 = sqrt(Math.pow(noeud2.getPx(),2) + Math.pow(noeud1.getPy(),2));

      double dot   =noeud1.getPx()*noeud2.getPx() +noeud2.getPy()*noeud1.getPy() ;
        
    double temp = (dot/(magv1*magv2));
    return Math.acos(temp);
    }
    
    public double longueurBarre(){
      
        return sqrt(Math.pow(noeud2.getPx() - noeud1.getPx(), 2) + Math.pow(noeud2.getPy() - noeud1.getPy(), 2)) ;
    }
    
    
    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double maxX() {
        return Math.max(this.noeud1.maxX(), this.noeud2.maxX());
    }

    @Override
    public double minX() {
        return Math.min(this.noeud1.minX(), this.noeud2.minX());
    }

    @Override
    public double maxY() {
        return Math.max(this.noeud1.maxY(), this.noeud2.maxY());
    }

    @Override
    public double minY() {
        return Math.min(this.noeud1.minY(), this.noeud2.minY());
    }

  @Override
    public double distanceNoeud(Noeud p) {
        double x1 = this.noeud1.getPx();
        double y1 = this.noeud1.getPy();
        double x2 = this.noeud2.getPx();
        double y2 = this.noeud2.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.noeud1.distanceNoeud(p);
        } else if (up > 1) {
            return this.noeud2.distanceNoeud(p);
        } else {
            NoeudSimple p4 = new NoeudSimple(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distanceNoeud(p);
        }
    }
    
    @Override
    public Group dessine() {
         Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
        res.setStroke(RED);
        res.setFill(RED);
        Group g = new Group( res);
        
       return g;
        
    }
    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int ind = num.creeID(this);
            this.noeud1.save(w, num);
            this.noeud2.save(w, num);
            w.append("Barre;" + ind + ";" +
                    num.getID(this.noeud1) + ";" + num.getID(this.noeud2) +
                    ";  \n");
        }
    }

    /**
     * @return the effort
     */
    public double getEffort() {
        return effort;
    }

    /**
     * @param effort the effort to set
     */
    public void setEffort(double effort) {
        this.effort = effort;
    }

    
    
    
}
