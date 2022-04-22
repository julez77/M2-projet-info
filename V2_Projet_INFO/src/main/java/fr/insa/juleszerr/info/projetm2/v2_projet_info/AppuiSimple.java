/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

/**
 *
 * @author IEUser
 */
public class AppuiSimple extends NoeudAppui {
    public AppuiSimple(double px, double py){
        super(px,py);
   

   
                }
    @Override
   public String toString(){
      return  "["+this.getPx()+","+this.getPy()+"]appuisimple id" +this.getId();
  } 
}
