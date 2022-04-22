/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

/**
 *
 * @author IEUser
 */
public abstract class Figure {
    private Groupe contenuDans ;
    
    
    public Figure (){
        this.contenuDans = null;
    }

    Groupe getContenuDAns() {
       return contenuDans;
    }

   void setContenuDans(Groupe contenuDans) {
       this.contenuDans= contenuDans ;
    }
   public abstract double maxX();
   public abstract Groupe dessine();
}
