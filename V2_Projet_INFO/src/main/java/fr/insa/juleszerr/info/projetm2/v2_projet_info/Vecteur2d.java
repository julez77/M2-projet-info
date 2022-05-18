
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 *
 * @author IEUser
 */
public class Vecteur2d {
   private double vx ;
   private double  vy ;
   
   
   
   public Vecteur2d (double vx ,  double  vy){
       this.vx =vx ;
       this.vy = vy ;
       
   }
   
   public static Vecteur2d ForceAngleNorme(double angle , double norme){
       double vx = norme*cos(angle);
       double vy = norme*sin(angle);
       Vecteur2d force = new Vecteur2d(vx, vy);
       
       return force ;
       
   }
   
      
   
   public double length(){
       return sqrt(Math.pow(this.getVx(), 2) + Math.pow(this.getVy(), 2)) ;
           
   }
   
   public static double angleVecteurs (Vecteur2d v1, Vecteur2d v2){                //renvoie l'angle entre deux vecteurs mais c'est inutile
       double produitScalaire = v1.getVx() * v2.getVx() + v1.getVy() * v2.getVy() ;
       return acos(produitScalaire/(v1.length()* v2.length())) ;
       
   }
   
   public double angleHorizontale (){              //renvoie l'angle entre le vecteur et l'horizontale
       
      double angle = acos(this.getVx()/this.length()) ;
       
       if (vy>0){
           return -angle ;
           
       }else{
           return angle ;
           
       }    
   }
   
   public Vecteur2d vecteurNormal(){
       Vecteur2d vecteurnormal ;
       if((vy/vx)<=0){
           vecteurnormal = new Vecteur2d(-abs(vy), -abs(vx)) ;
            
       }
       else{
           vecteurnormal = new Vecteur2d(abs(vy), -abs(vx)) ;
           
       }
       return vecteurnormal ;
   }
   
   public Vecteur2d vecteurOppose(){
       Vecteur2d vecteuropp = new Vecteur2d(-vx, -vy) ;
       return vecteuropp ;
   }
   
   
    /**
     * @return the vx
     */
    public double getVx() {
        return vx;
    }

    /**
     * @param vx the vx to set
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * @return the vy
     */
    public double getVy() {
        return vy;
    }

    /**
     * @param vy the vy to set
     */
    public void setVy(double vy) {
        this.vy = vy;
    }
    
  @Override  
 public String toString() {
   return "(" + vx + "," + vy +")" ;
     
     
 }   
    
 public static void main(String[] args) {
     Vecteur2d vecteur1 = new Vecteur2d(2,2) ;
     Vecteur2d vecteur2 = new Vecteur2d(2,0) ;
     System.out.println(Vecteur2d.angleVecteurs(vecteur2, vecteur1));
             
 }
    
    
    
    
     
}
