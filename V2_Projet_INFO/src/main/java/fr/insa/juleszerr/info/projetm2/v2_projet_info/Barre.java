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
    private Noeud noeud1 ;
    private Noeud noeud2 ;
private double prix ;
private double traction ;
private double compre;
private int id ;

    Barre(Point p1, Point p2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


public Vecteur2d vecteurBarre(){
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
        noeud1.addnoeud1(this);
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
        noeud2.addnoeud2(this);
    }
    
    public Barre ( Noeud noeud1 , Noeud noeud2 ){
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.traction= 0;
        this.compre = 0;
        this.id=0;
        this.prix = 0;
        
        noeud2.addnoeud2(this);
        noeud1.addnoeud1(this);
    }
    public Barre (Noeud noeud1,Noeud noeud2,double traction,double compre,double prix){
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.traction = traction;
        this.compre = compre;
        
        this.prix = prix;
        
        noeud2.addnoeud2(this);
        noeud1.addnoeud1(this);
        
        
    }
    
    /**
     *
     * @return
     */
    @Override
 public String toString() {
        return "barre :[" + this.noeud1.toString()+ "," + this.noeud2.toString() + "] id  :"+ id +" traction :"+traction +" compression :"+compre+" prix"+prix  ;   
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
     * @return the traction
     */
    public double getTraction() {
        return traction;
    }

    /**
     * @param traction the traction to set
     */
    public void setTraction(double traction) {
        this.traction = traction;
    }

    /**
     * @return the compre
     */
    public double getCompre() {
        return compre;
    }

    /**
     * @param compre the compre to set
     */
    public void setCompre(double compre) {
        this.compre = compre;
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

    /*
    @Override
    public Groupe dessine(GraphicsContext context) {
        context.setStroke(RED);
        context.strokeLine(this.noeud1.getPx(), this.noeud1.getPy(), this.noeud2.getPx(), this.noeud2.getPy());
        return null;
    }
*/
    
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
}
