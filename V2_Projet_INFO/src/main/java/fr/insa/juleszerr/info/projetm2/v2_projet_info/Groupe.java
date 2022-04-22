/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud.entrenoeud;

import fr.insa.zerr.projetm2.Lire;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;


/**
 *
 * @author IEUser
 */
public class Groupe extends Figure{

   private List<Figure> contient  ;

    public List<Figure> getContient() {
        return contient;
    }   
   
    public Groupe(List<Figure> contient){
       this.contient = contient;
    }
    
    public Groupe(){
       this.contient = new ArrayList<>();
    }
    
    @Override
    public double  maxX(){
        if ( this.getContient().isEmpty()) {
            return 0;
        } else{
            double  max = this.contient.get(0).maxX();
            for (int  i = 1 ; i < this.contient.size(); i++){
                double cur = this.contient.get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;        
        }
    }

   @Override
    public double minX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }  
    
     @Override
    public double maxY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).maxY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
    
     @Override
    public double minY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }
    
    
     public void add(Figure f) {
        if (f.getGroupe() != this) {
            if (f.getGroupe() != null) {
                throw new Error("figure déja dans un autre groupe");
            }
            this.contient.add(f);
            f.setGroupe(this);
        }
    }
    
    public int size() {
        return (this.contient.size());
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
@Override 
  public String toString() {
        String res = "Groupe {\n";
        for (int i = 0; i < this.contient.size(); i++) {
            res = res + indente(this.contient.get(i).toString(), "  ") + "\n";
        }
        return res + "}";
    }

public void menuTexte(){
    
   System.out.println("1) afficher treillis");
   System.out.println("2) créer un nouveau noued");
   System.out.println("3) créer une nouvelle barre à partire de 2 Noeuds");
   System.out.println("4) supprimer une figure du groupe");
   System.out.println("autres: ne rien faire");
   int choice = Lire.i();
 while ((choice==1)||(choice==2)||(choice==3)||(choice==4)||(choice==5) ){
   if ( choice == 1){
       System.out.println(this.toString());
   } 
   if ( choice == 2){
     Noeud n =entrenoeud();
       this.add(n);
   }
    if ( choice == 3){
        
       this.add(new Barre(this.choisiNoeud(),this.choisiNoeud()));
   }
    if ( choice == 4){
       this.remove((Figure) this.choisiFigures());
        
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
    public Group dessine() {
        
        Group g = new Group();
        for(int i = 0 ; i < this.getContient().size() ; i ++) {
            g.getChildren().add(this.getContient().get(i).dessine());
        }
        return g;
    }
// TO DO : probléme gros, ptn j'comprends p'u rien gros 
    /*
    @Override
    public Groupe dessine(GraphicsContext context) {
        for (Figure f : this.contient) {
            f.dessine(context);
        }
       return null;
    }
*/
    
/*
public Noeud choisinoeud(){
    System.out.println("entrer l'id du  noeud");
        int id1 = Lire.i();
       int i = 0;
    while(id1 !=getListenoeud().get(i).getId()){
        i=i+1;
    }
    return getListenoeud().get(i); 
    
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
*/
    
    public void remove(Figure f) {
        if (f.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.contient.remove(f);
        f.setGroupe(null);
    }
    
    
    
public void remove(Barre b) {
        if (b.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.getContient().remove(b);
        b.setGroupe(null);
    }

public Noeud choisiNoeud() {
        List<Noeud> ln = new ArrayList<>();
        System.out.println("liste des points disponibles : ");
        int nbr = 0;
        for (int i = 0; i < this.contient.size(); i++) {
            Figure f = this.contient.get(i);
            if (f instanceof Noeud) {
                nbr++;
                ln.add((Noeud) f);
                System.out.println(nbr + ") " + f);
            }
        }
        if (nbr == 0) {
            System.out.println("Aucun point disponible");
            return null;
        } else {
            int rep = -1;
            while (rep < 0 || rep > nbr) {
                System.out.println("votre choix (0 pour annuler) : ");
                rep = Lire.i();
            }
            if (rep == 0) {
                return null;
            } else {
                return ln.get(rep - 1);
            }
        }
    }

    public List<Figure> choisiFigures() {
        List<Figure> res = new ArrayList<>();
        int rep = -1;
        while (rep != 0) {
            System.out.println("liste des figures disponibles : ");
            for (int i = 0; i < this.contient.size(); i++) {
                System.out.println((i + 1) + ") " + this.contient.get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.contient.size()) {
                Figure f = this.contient.get(rep - 1);
                if (res.contains(f)) {
                    System.out.println("déja selectionnée !!");
                } else {
                    res.add(f);
                }
                System.out.println(res.size() + " figure(s) séléctionnée(s)");
            }
        }
        return res;
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
        treillis1.add(s1);
        //treillis1.ajouterBarre(s2);
       // treillis1.ajouterBarre(s3);
        Groupe treillis2 = new Groupe();
        treillis2.add(p5);
        //treillis2.ajouterNoeud(p6);
        //treillis2.ajouterBarre(s4);
       
        for (int i = 0; i < 5; i++) {
            treillis2.add(new NoeudSimple(Math.random() * 500, Math.random() * 500 ));
        }
        for (int i = 0; i < 3; i++) {
            treillis2.add(new Barre(new NoeudSimple(Math.random() * 500, Math.random() * 500),
                    new NoeudSimple(Math.random() * 500, Math.random() * 500)));
        }
        return treillis2; 
}
}
