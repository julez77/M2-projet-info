/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static java.lang.Math.acos;
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
   
   public double length(){
       return sqrt(Math.pow(this.getVx(), 2) + Math.pow(this.getVy(), 2)) ;
              
   }
   
   public static double angleVecteurs (Vecteur2d v1, Vecteur2d v2){
       double produitScalaire = v1.getVx() * v2.getVx() + v1.getVy() * v2.getVy() ;
       return acos(produitScalaire/(v1.length()* v2.length())) ;
       
   }
   
   public double angleHorizontale (){
       
       return acos(this.getVx()/this.length());
       
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
 public String toString() {
   return "(" + vx + "," + vy +")" ;
     
     
 }   
    
 public static void main(String[] args){
     Vecteur2d v1 = new Vecteur2d (0, 1);
     Vecteur2d v2 = new Vecteur2d (1, -1);
     System.out.println( angleVecteurs(v1, v2));
 }   
    
    
    
    
     
}
