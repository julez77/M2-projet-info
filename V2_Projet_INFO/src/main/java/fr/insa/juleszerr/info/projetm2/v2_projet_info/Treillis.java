/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IEUser
 */
public class Treillis extends Groupe {
    private List<Noeud> noeudsTreillis ;
    private List<Barre> barresTreillis ;
    
    public Treillis(){
        this.noeudsTreillis = new ArrayList() ;
        this.barresTreillis = new ArrayList() ;
        
    }
    
    
    public Treillis(List<Noeud> noeudsTreillis , List<Barre> barresTreillis){
    this.setNoeudsTreillis(noeudsTreillis) ;
    this.setBarresTreillis(barresTreillis) ;    
    
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

    /**
     * @return the noeudsTreillis
     */
    public List<Noeud> getNoeudsTreillis() {
        return noeudsTreillis;
    }

    /**
     * @param noeudsTreillis the noeudsTreillis to set
     */
    public void setNoeudsTreillis(List<Noeud> noeudsTreillis) {
        this.noeudsTreillis = noeudsTreillis;
    }

    /**
     * @return the barresTreillis
     */
    public List<Barre> getBarresTreillis() {
        return barresTreillis;
    }

    /**
     * @param barresTreillis the barresTreillis to set
     */
    public void setBarresTreillis(List<Barre> barresTreillis) {
        this.barresTreillis = barresTreillis;
    }
}
