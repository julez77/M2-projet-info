/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;
import fr.insa.juleszerr.info.projetm2.Lire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author IEUser
 */
public abstract class Noeud extends Figure{

    static Noeud demandeNoeud() {
        
        return null;
        
    }
    public double px ;
    double  py ;
    private List<Barre> barredebut ;
    private List<Barre> barrefin ;
    private  int id ;
    private Vecteur2d force ;
    
   

    /**
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }
 
    @Override
  public String toString(){
      return  "["+px+","+py+"]" ;
  }
  
  public String toString2(){
      return "["+px+","+py+"]" ;
  }
  // permet de textuellement crée  un noeud
 public static  Noeud entrenoeud(){
   double  type ;
   System.out.println("entrer le type de  noeud: ");
   System.out.println("0) pour un NoeudSimple");
   System.out.println("1) pour un appuis simple");
   System.out.println("2) pour un appuis glissant");
   type = Lire.d();
   System.out.println("abs");
     double px = Lire.d();
     System.out.println("ord");
     double  py = Lire.d();

     
     if ( type == 0){
         return   new NoeudSimple (px,py);
         
     }
   if  (type == 1){
       return new AppuiSimple(px,py);
   }  
     if (type == 2){
         return new AppuiGlissant(px,py);
     } else {
        return null ; }
     
 }         
public Noeud (double px , double py){
    this.px = px;
    this.py = py; 
    this.force = new Vecteur2d(0,0) ;
    this.barredebut = new ArrayList<>(); //la liste des barres dont le noeud est le point de départ
    this.barrefin  = new ArrayList<>(); //la liste des barres dont le noeud est le point d'arrivée
    this.id=0;
}
    /**
     * @return the barredebut
     */

public List<Barre> getBarredebut() {
    return barredebut;
}

    /**
     * @return the barrefin
     */
    public List<Barre> getBarrefin() {
        return barrefin;
    }
  
public List<Barre> barresincidentes(){             //renvoie la liste des barres incidentes au noeud
     List<Barre> liste = new ArrayList<>(); 
     
     for(int  i = 0;  i < this.barredebut.size(); i++){
     liste.add(barredebut.get(i));
     
 }   
 for(int  i = 0;  i < this.barrefin.size(); i++){
     liste.add(barrefin.get(i));
     
 } 
 return liste ;  

 }

public boolean barreincidente(Barre b){           //vérifie si une barre est incidente au noeud
    boolean barreincidente=false ;
    for(int i=0 ; i<this.barresincidentes().size() ; i++){
        if (b==this.barresincidentes().get(i)){
            barreincidente=true ;
    }
}
    return barreincidente ;
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
    public double distanceNoeud(Noeud p) {          //distance entre deux noeuds
      double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);
    }
    //nom explicite
    public double angleBarreNoeud(Barre b){
        if (this==b.getNoeud2()){
            return b.vecteurBarre().vecteurOppose().angleHorizontale() ;
        
        }else{
            return b.vecteurBarre().angleHorizontale() ;
       }
        
    }

    /**
     * @return the force
     */
    public Vecteur2d getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(Vecteur2d force) {
        this.force = force;
    }
    
    
    }






