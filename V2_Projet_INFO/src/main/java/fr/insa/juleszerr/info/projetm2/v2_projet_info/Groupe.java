/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud.entrenoeud;
import fr.insa.zerr.projetm2.Lire;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author IEUser
 */
public class Groupe extends Figure{

   private List<Barre> listebarre ;
   private List<Noeud> listenoeud ;
   private List<Figure> listelements ; 


    public List<Barre> getListebarre() {
        return listebarre;
    }

    public List<Noeud> getListenoeud() {
        return listenoeud;
    }
   
    public Groupe(List<Barre> listebarre,List<Noeud>listenoeud){
       this.listebarre = listebarre ;
        this.listenoeud = listenoeud ;
        
        
    }
    
   
    
    public Groupe(){
       this.listebarre = new ArrayList<>();
   this.listenoeud  = new ArrayList<>();  
        
    }
    
    public int maxIDnoeud(){
   if ( this.getListenoeud().isEmpty()) {
       return 0;
   }
  int  max = this.getListenoeud().get(0).getId();
   Noeud nmax = this.getListenoeud().get(0);
    for (int  i = 1 ; i < this.getListenoeud().size(); i++){
        if( max < this.getListenoeud().get(i).getId()){
           max =  this.getListenoeud().get(i).getId();
                   nmax = this.getListenoeud().get(i);
        }
        
    }
    return max ;
    
}

    public int maxIDbarre(){
   if ( this.getListebarre().isEmpty()) {
       return 0;
   }
  int  max = this.getListebarre().get(0).getId();
   Barre nmax = this.getListebarre().get(0);
    for (int  i = 1 ; i < this.getListebarre().size(); i++){
        if( max < this.getListebarre().get(i).getId()){
           max =  this.getListebarre().get(i).getId();
                   nmax = this.getListebarre().get(i);
        }
        
        
        
    }
    return max ;
    
}      
   
    public void ajouterNoeud(Noeud  n){
    if (getListenoeud().contains(n)== true){
        System.out.println(n.getId()+ "est deja dans  le groupe");
    }else {
       
       
       n.setId(this.maxIDnoeud()+1);
            getListenoeud().add(n);}
    
}
    
    public void ajouterBarre(Barre  b){
 
        boolean barreexiste = false ;
        if(this.getListebarre().isEmpty()){
            barreexiste = false ;
        }
        else{
        
       for(int i=0; i<getListebarre().size() ; i++){
            if(b==getListebarre().get(i)){
                barreexiste = true ;
                
            }
       }
        }
            if(barreexiste == false){
           ajouterNoeud(b.getNoeud1());
            ajouterNoeud(b.getNoeud2());
            
                b.setId((this.maxIDbarre() + 1));
                getListebarre().add(b) ;
            }
}    
        
       public int size() {
        return (this.getListebarre().size()+ this.getListenoeud().size());
    }
    
public static String indente(String toIndente, String prefix) {
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }
   
  /** public String toSting(){
     String res = "Treillis {\n";
     for (int i =0; i<this.size();i++){
         res =res + indente(this.listebarre.get(i).toString(),"")+ "\n";
    }
     return res + "}";
     
   }**/
   public String toString(){
    return "barres du groupe ( et leur noeuds) :" + getListebarre().toString()  +"noeuds du groupe" +getListenoeud().toString();                   
}

public void menuTexte(){
    
   System.out.println("1) afficher treillis");
   System.out.println("2) créer un nouveau noued");
   System.out.println("3) créer une nouvelle barre à partire de 2 Noeuds");
   System.out.println("4) supprimer une barre");
   System.out.println("5) supprimer un noeud");
   System.out.println("autres: ne rien faire");
   int choice = Lire.i();
 while ((choice==1)||(choice==2)||(choice==3)||(choice==4)||(choice==5) ){
   if ( choice == 1){
       System.out.println(this.toString());
   } 
   if ( choice == 2){
     Noeud n =entrenoeud();
       this.ajouterNoeud(n);
   }
    if ( choice == 3){
        
       this.ajouterBarre(new Barre(this.choisinoeud(),this.choisinoeud()));
   }
    if ( choice == 4){
       this.removebarre(this.choisibarre());
   }
   if ( choice == 5){
       
   }
   System.out.println("1) afficher treillis");
   System.out.println("2) créer un nouveau noued");
   System.out.println("3) créer une nouvelle barre à partire de 2 Noeuds");
   System.out.println("4) supprimer une barre");
   System.out.println("5) supprimer un noeud");
   System.out.println("autres: ne rien faire");
   choice = Lire.i();
   
   
   
 }  
    
    
    
    
}

 @Override
    public Groupe dessine() {
        
        Groupe g = new Groupe();
        for(int i = 0 ; i < this.getListebarre().size() ; i ++) {
            g.getChildren().add(this.getListebarre().get(i).dessine());
        }
        return g;
    }

public Noeud choisinoeud(){
    System.out.println("entrer l'id du  noeud");
        int id1 = Lire.i();
       int i = 0;
    while(id1 !=getListenoeud().get(i).getId()){
        i=i+1;
    }
    return getListenoeud().get(i); 
    
}
public void removebarre(Barre b) {
        if (b.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.getListebarre().remove(b);
        b.setGroupe(null);
    }
public Barre choisibarre(){
    System.out.println("entrer l'id de la barre");
        int id1 = Lire.i();
       int i = 0;
    while(id1 !=getListebarre().get(i).getId()){
        i=i+1;
    }
    return getListebarre().get(i);
}



    public static Groupe groupeTest() {
        NoeudSimple p1 = new NoeudSimple(10, 10);
        NoeudSimple p2 = new NoeudSimple(100, 10);
        //NoeudSimple p3 = new NoeudSimple(100, 100);
        //NoeudSimple p4 = new NoeudSimple(10, 100);
        AppuiGlissant p5 = new AppuiGlissant(50, 50);
        //AppuiGlissant p6 = new AppuiGlissant(500, 500);
        Barre s1 = new Barre(p1, p2);
        //Barre s2 = new Barre(p2, p3);
        //Barre s3 = new Barre(p3, p1);
        //Barre s4 = new Barre(p1, p4);
        Groupe treillis1 = new Groupe();
        treillis1.ajouterBarre(s1);
        //treillis1.ajouterBarre(s2);
       // treillis1.ajouterBarre(s3);
        Groupe treillis2 = new Groupe();
        treillis2.ajouterNoeud(p5);
        //treillis2.ajouterNoeud(p6);
        //treillis2.ajouterBarre(s4);
       
        for (int i = 0; i < 5; i++) {
            treillis2.ajouterNoeud(new NoeudSimple(Math.random() * 500, Math.random() * 500 ));
        }
        for (int i = 0; i < 3; i++) {
            treillis2.ajouterBarre(new Barre(new NoeudSimple(Math.random() * 500, Math.random() * 500),
                    new NoeudSimple(Math.random() * 500, Math.random() * 500)));
        }
        return treillis2; 
}
}
