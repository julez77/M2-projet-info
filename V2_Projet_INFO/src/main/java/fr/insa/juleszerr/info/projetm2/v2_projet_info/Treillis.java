/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IEUser
 */
public class Treillis extends Figure {
    private List<Figure> élements ;
    
    
    public Treillis(){
        this.élements = new ArrayList() ;
        
        
    }
    
    
    public Treillis(List<Noeud> élements){
    this.setÉlements(élements);
        
    
}
@Override
    public String toString(){
        String treillis = "[";
        for(int i=0 ; i<noeudsTreillis.size() ; i++){
            Noeud noeud = noeudsTreillis.get(i) ;
            treillis = treillis + noeud.toString()+", " ;
        }
       treillis = treillis +" / " ;
       
       for(int j=0 ; j<barresTreillis.size(); j++){
           Barre barre = barresTreillis.get(j) ;
           treillis = treillis + barre.toString()+", " ;
       }
       treillis = treillis + "]" ;
       
       return treillis ;
    }
    
            
            
    public int maxIdNoeud(){
        
        
        if (this.noeudsTreillis.isEmpty()) {
       return 0;
   }
        else{
            int max=0 ;
        
        for(int j=0 ; j<noeudsTreillis.size(); j++){
            Noeud noeud = noeudsTreillis.get(j) ;
            int id = noeud.getId() ;
            if(id>max){
                max=id;
            }
            
        }
                    
          return max ;         
            }
    }
    
    public int maxIdBarre(){
        int max=0 ;
        
        if (this.barresTreillis.isEmpty()) {
       return 0;
   }
        
        for(int j=0 ; j<barresTreillis.size() ; j++){
            Barre barre = barresTreillis.get(j) ;
            int id = barre.getId();
            if(id>max){
                max=id ;
            }
        }
        return max ;
    }
                
    public void ajouteNoeud(Noeud noeud){
        boolean noeudexiste = false ;
        if (this.noeudsTreillis.isEmpty()){
            noeudexiste = false ;
        }
        
        else{
            
       for(int i=0 ; i<noeudsTreillis.size() ; i++){
            if(noeud==noeudsTreillis.get(i)){
                noeudexiste = true ;
                
            }
       }
        }
            if(noeudexiste==false){
                noeud.setId((this.maxIdNoeud() + 1));
                noeudsTreillis.add(noeud) ;
            }
        
    
    }
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
    
    
    
    public void ajouteBarre(Barre barre){
        boolean barreexiste = false ;
        if(this.barresTreillis.isEmpty()){
            barreexiste = false ;
        }
        else{
        
       for(int i=0; i<barresTreillis.size() ; i++){
            if(barre==barresTreillis.get(i)){
                barreexiste = true ;
                
            }
       }
        }
            if(barreexiste == false){
            ajouteNoeud(barre.getNoeud1());
            ajouteNoeud(barre.getNoeud2());
            
                barre.setId((this.maxIdBarre() + 1));
                barresTreillis.add(barre) ;
            }
        
    
    }


    
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
    
    
    
    
}
