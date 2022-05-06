/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class Treillis extends Figure {
    private List<Figure> élements ;
    
    
    public Treillis(){
        this.élements = new ArrayList() ;
        
        
    }
    
    
    public Treillis(List<Figure> élements){
    this.setÉlements(élements);
        
    
}
// @Override
   //  public String toString(){
    //     String treillis = "[";
    //     for(int i=0 ; i<noeudsTreillis.size() ; i++){
    //         Noeud noeud = noeudsTreillis.get(i) ;
         //    treillis = treillis + noeud.toString()+", " ;
    //     }
     //   treillis = treillis +" / " ;
       
     //   for(int j=0 ; j<barresTreillis.size(); j++){
     //       Barre barre = barresTreillis.get(j) ;
         //   treillis = treillis + barre.toString()+", " ;
     //   }
    //    treillis = treillis + "]" ;
       
   //     return treillis ;
//     }
    
            
            
 //    public int maxIdNoeud(){
        
        
 //        if (this.noeudsTreillis.isEmpty()) {
 //       return 0;
 //   }
 //        else{
 //            int max=0 ;
        
  //       for(int j=0 ; j<noeudsTreillis.size(); j++){
   //          Noeud noeud = noeudsTreillis.get(j) ;
        //     int id = noeud.getId() ;
     //        if(id>max){
   //              max=id;
       //      }
     //        
     //    }
     //                
     //      return max ;         
    //         }
  //   }
    
  //   public int maxIdBarre(){
   //      int max=0 ;
 //        
   //      if (this.barresTreillis.isEmpty()) {
     //   return 0;
  //  }
        
    //     for(int j=0 ; j<barresTreillis.size() ; j++){
   //          Barre barre = barresTreillis.get(j) ;
       //      int id = barre.getId();
    //         if(id>max){
       //          max=id ;
    //         }
     //    }
    //     return max ;
   //  }
                
 ////   public void ajouteNoeud(Noeud noeud){
   ///     boolean noeudexiste = false ;
  //     if (this.noeudsTreillis.isEmpty()){
  //           noeudexiste = false ;
    //    }
        
     //    else{
      //       
     //   for(int i=0 ; i<noeudsTreillis.size() ; i++){
    //         if(noeud==noeudsTreillis.get(i)){
      //           noeudexiste = true ;
                
    //         }
 //       }
    //     }
   //          if(noeudexiste==false){
          //       noeud.setId((this.maxIdNoeud() + 1));
     //            noeudsTreillis.add(noeud) ;
     //        }
        
    
//     }
    public void add(Figure f) {
        if (f.getTreillis() != this) {
            if (f.getTreillis() != null) {
                throw new Error("figure déja dans un autre treillis");
            }
            this.élements.add(f);
            f.setTreillis(this);
        }
    }
    public void remove(Figure f) {
        if (f.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.élements.remove(f);
        f.setTreillis(null);
    }

    public void removeAll(List<Figure> lf) {
        for (Figure f : lf) {
            this.remove(f);
        }
    }

    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.élements);
        this.removeAll(toRemove);
    }

    public int size() {
        return this.élements.size();
    }
    
    
    
  ///  public void ajouteBarre(Barre barre){
     //   boolean barreexiste = false ;
     //   if(this.barresTreillis.isEmpty()){
        //    barreexiste = false ;
  ///      }
  //      else{
        
 //      for(int i=0; i<barresTreillis.size() ; i++){
        //    if(barre==barresTreillis.get(i)){
             //   barreexiste = true ;
                
     //       }
   ///    }
    ///    }
        ///    if(barreexiste == false){
           // ajouteNoeud(barre.getNoeud1());
        //    ajouteNoeud(barre.getNoeud2());
            
           //     barre.setId((this.maxIdBarre() + 1));
            ///    barresTreillis.add(barre) ;
      //      }
        
    
    //}


    
    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            for (Figure f : this.élements) {
                f.save(w, num);
            }
            w.append("Treillis;" + id);
            for (Figure f : this.élements) {
                w.append(";" + num.getID(f));
            }
            w.append("\n");
        }
    }

    /**
     * @return the élements
     */
    public List<Figure> getÉlements() {
        return élements;
    }

    /**
     * @param élements the élements to set
     */
    public void setÉlements(List<Figure> élements) {
        this.élements = élements;
    }
    @Override
    public Group dessine() {
        
        Group g = new Group();
        for(int i = 0 ; i < this.getÉlements().size() ; i ++) {
            g.getChildren().add(this.getÉlements().get(i).dessine());
        }
        return g;
    }  
public static Treillis treillisTest() {
        NoeudSimple p1 = new  NoeudSimple(10, 10);
         NoeudSimple p2 = new  NoeudSimple(100, 10);
         NoeudSimple p3 = new  NoeudSimple(100, 100);
         NoeudSimple p4 = new  NoeudSimple(10, 100);
         NoeudSimple p5 = new  NoeudSimple(50, 50);
         NoeudSimple p6 = new  NoeudSimple(500, 500);
        Barre s1 = new Barre(p1, p2);
        Barre s2 = new Barre(p2, p3);
        Barre s3 = new Barre(p3, p1);
        Barre s4 = new Barre(p1, p4);
        Treillis triangle = new Treillis();
        triangle.add(s1);
        triangle.add(s2);
        triangle.add(s3);
        Treillis res = new Treillis();
        res.add(p5);
        res.add(p6);
        res.add(s4);
        res.add(triangle);
        for (int i = 0; i < 10; i++) {
            res.add(new NoeudSimple(Math.random() * 500, Math.random() * 500
                   ));
        }
        for (int i = 0; i < 5; i++) {
            res.add(new Barre(new NoeudSimple(Math.random() * 500, Math.random() * 500),
                    new NoeudSimple(Math.random() * 500, Math.random() * 500)
                    ));
        }
        return res;
    }
    @Override
    public double maxX() {
              if (this.élements.isEmpty()) {
            return 0;
        } else {
            double max = this.élements.get(0).maxX();
            for (int i = 1; i < this.élements.size(); i++) {
                double cur = this.élements.get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minX() {
         if (this.élements.isEmpty()) {
            return 0;
        } else {
            double min = this.élements.get(0).minX();
            for (int i = 1; i < this.élements.size(); i++) {
                double cur = this.élements.get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double maxY() {
       if (this.élements.isEmpty()) {
            return 0;
        } else {
            double max = this.élements.get(0).maxY();
            for (int i = 1; i < this.élements.size(); i++) {
                double cur = this.élements.get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minY() {
         if (this.élements.isEmpty()) {
            return 0;
        } else {
            double min = this.élements.get(0).minY();
            for (int i = 1; i < this.élements.size(); i++) {
                double cur = this.élements.get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    
    
    
    
}
