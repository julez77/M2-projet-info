/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import javafx.scene.Group;
import java.io.IOException;
import java.io.Writer;
/**
 *
 * @author IEUser
 */
public abstract class Figure {
    private Groupe groupe ;
    
    
    public Figure (){
        this.groupe = null;
    }

    Groupe getGroupe() {
       return groupe;
    }

   void setGroupe(Groupe contenuDans) {
       this.groupe = contenuDans ;
    }
   public abstract double maxX();
   
   public abstract double minX();

   public abstract double maxY();

   public abstract double minY();
   
  // public abstract Groupe dessine(GraphicsContext context);
   
    public abstract Group dessine();
   
   
}
