/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;

/**
 *
 * @author IEUser
 */
public class Treillis extends Figure {
    private List<Figure> elements ;
    
    
    public Treillis(){
        this.elements = new ArrayList() ;
        
        
    }
    
    
    public Treillis(List<Figure> elements){
    this.setElements(elements);
        
    
}
 @Override
    public String toString() {
        String res = "Groupe {\n";
        for (int i = 0; i < this.elements.size(); i++) {
            res = res + indente(this.elements.get(i).toString(), "  ") + "\n";
        }
        return res + "}";
    
    }     
            
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
    
    
    // à faire : afficher un message d'erreur si la distance saisie est plus élevée que la longueur de la barre 
    public void poserAppuiSimple(Barre b, double distance){
        
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiSimple noeud = new AppuiSimple(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud) ;
       
    }
    
    public void poserAppuiGlissant(Barre b, double distance){
        
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiGlissant noeud = new AppuiGlissant(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud) ;
        
        noeud.setPoseSur(b) ;
    }
    
   public void poserNoeudSimple(Barre b, double distance){
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        NoeudSimple noeud = new NoeudSimple(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud) ;
        
        Barre newBarre1 = new Barre(b.getNoeud1(), noeud) ;
        Barre newBarre2 = new Barre(noeud, b.getNoeud2()) ;
        
        add(newBarre1) ;
        add(newBarre2) ;
        remove(b) ;
        
   }
        
    
    public void add(Figure f) {
        if (f.getTreillis() != this) {
            if (f.getTreillis() != null) {
                throw new Error("figure déja dans un autre treillis");
            }
            this.elements.add(f);
            f.setTreillis(this);
        }
    }
    public void remove(Figure f) {                          // supprime une figure (barre, noeud, treillis)
        if (f.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.elements.remove(f);
        f.setTreillis(null);
    }

    public void removeAll(List<Figure> lf) {
        for (Figure f : lf) {
            this.remove(f);
        }
    }

    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.elements);
        this.removeAll(toRemove);
    }

    public int size() {
        return this.elements.size();
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
            for (Figure f : this.elements) {
                f.save(w, num);
            }
            w.append("Treillis;" + id);
            for (Figure f : this.elements) {
                w.append(";" + num.getID(f));
            }
            w.append("\n");
        }
    }

    /**
     * @return the élements
     */
    public List<Figure> getÉlements() {
        return elements;
    }

    /**
     * @param élements the élements to set
     */
    public void setElements(List<Figure> élements) {
        this.elements = élements;
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
              if (this.elements.isEmpty()) {
            return 0;
        } else {
            double max = this.elements.get(0).maxX();
            for (int i = 1; i < this.elements.size(); i++) {
                double cur = this.elements.get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minX() {
         if (this.elements.isEmpty()) {
            return 0;
        } else {
            double min = this.elements.get(0).minX();
            for (int i = 1; i < this.elements.size(); i++) {
                double cur = this.elements.get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double maxY() {
       if (this.elements.isEmpty()) {
            return 0;
        } else {
            double max = this.elements.get(0).maxY();
            for (int i = 1; i < this.elements.size(); i++) {
                double cur = this.elements.get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minY() {
         if (this.elements.isEmpty()) {
            return 0;
        } else {
            double min = this.elements.get(0).minY();
            for (int i = 1; i < this.elements.size(); i++) {
                double cur = this.elements.get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }
public void menuTexte() {
        int rep = -1;
        while (rep != 0) {
            System.out.println("Gestion textuelle d'un groupe de figure");
            System.out.println("---------------------------------------");
            System.out.println("1) afficher le groupe");
            System.out.println("2) ajouter un noeud");
            System.out.println("3) ajouter une Barre avec deux nouveaux points");
            System.out.println("4) ajouter une Barre sur deux points existants");
            System.out.println("5) créer un sous-groupe");
            System.out.println("6) afficher le rectangle englobant");
            System.out.println("7) calculer la distance à un point");
            System.out.println("8) retirer des figures du groupe");
            System.out.println("9) sauvegarder le groupe dans un fichier");
            System.out.println("0) quitter");
            System.out.println("votre choix : ");
            rep = Lire.i();
            if (rep == 1) {
                System.out.println(this);
            } else if (rep == 2) {
                Noeud np = Noeud.entrenoeud();
                this.add(np);
            } else if (rep == 3) {
                Barre ns = Barre.créeBarre();
                this.add(ns);
                this.add(ns.getNoeud1());
                this.add(ns.getNoeud2());
            } else if (rep == 4) {
                System.out.println("choisissez le 1er noeud");
                Noeud deb = this.choisiNoeud();
                if (deb != null) {
                    System.out.println("choisissez le 2eme noeud");
                    Noeud fin = this.choisiNoeud();
                    Barre ns = new Barre(deb, fin);
                    this.add(ns);
                }
            } else if (rep == 5) {
                List<Figure> select = this.choisiFigures();
                this.sousTreillis(select);
            } else if (rep == 6) {
                System.out.println("maxX = " + this.maxX() + " ; "
                        + "minX = " + this.minX() + "\n"
                        + "maxY = " + this.maxY() + " ; "
                        + "minY = " + this.minY() + "\n");
            } else if (rep == 7) {
                System.out.println("entrez un point :");
                Noeud p = Noeud.entrenoeud();
                System.out.println("distance : " + this.distanceNoeud(p));
            } else if (rep == 8) {
                List<Figure> select = this.choisiFigures();
                this.removeAll(select);
            } else if (rep == 9) {
                System.out.println("répertoire courant : ");
                System.out.println(System.getProperty("user.dir"));
                System.out.println("entrez le chemin du fichier où sauvegarder le groupe de figure : ");
                String path = Lire.S();
                File fout = new File(path);
                try {
                    this.sauvegarde(fout);
                } catch (FileNotFoundException ex) {
                    System.out.println("fichier non trouvé : " + fout.getAbsolutePath());;
                } catch (IOException ex) {
                    System.out.println("problème de lecture : " + ex.getLocalizedMessage());;
                }

            }
        }
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public double distanceNoeud(Noeud p) {
              if (this.elements.isEmpty()) {
            return new NoeudSimple(0, 0).distanceNoeud(p);
        } else {
            double dist = this.elements.get(0).distanceNoeud(p);
            for (int i = 1; i < this.elements.size(); i++) {
                double cur = this.elements.get(i).distanceNoeud(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }

    private Noeud choisiNoeud() {
       List<Noeud> lp = new ArrayList<>();
        System.out.println("liste des points disponibles : ");
        int nbr = 0;
        for (int i = 0; i < this.elements.size(); i++) {
            Figure f = this.elements.get(i);
            if (f instanceof Noeud) {
                nbr++;
                lp.add((Noeud) f);
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
                return lp.get(rep - 1);
            }
        }
    }
    

    private List<Figure> choisiFigures() {
        List<Figure> res = new ArrayList<>();
        int rep = -1;
        while (rep != 0) {
            System.out.println("liste des figures disponibles : ");
            for (int i = 0; i < this.elements.size(); i++) {
                System.out.println((i + 1) + ") " + this.elements.get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.elements.size()) {
                Figure f = this.elements.get(rep - 1);
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

    

    private Treillis sousTreillis(List<Figure> lf) {
       for (int i = 0; i < lf.size(); i++) {
            Figure f = lf.get(i);
            if (f.getTreillis()!= this) {
                throw new Error(f + " n'appartient pas au groupe " + this);
            }
            this.elements.remove(f);
            f.setTreillis(null);
        }
        Treillis sg = new Treillis();
        for (int i = 0; i < lf.size(); i++) {
            sg.add(lf.get(i));
        }
        this.add(sg);
        return sg;
    }

    public static String indente(String toIndente, String prefix) {
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }
       public static void TLecture() {
        try {
            Figure lue = Figure.lecture(new File("sauv.txt"));
            System.out.println("fig lue : " + lue);
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }
       
    public List<Figure> NoeudsTreillis(){
       List<Figure> noeudstreillis = new ArrayList<>() ;
       for(int i=0 ; i<this.elements.size() ; i++){
           if (this.elements.get(i) instanceof Noeud){
               noeudstreillis.add(this.elements.get(i)) ;
           }
       }
      return noeudstreillis ; 
    }
    
    public static void main(String[] args) {
       
        NoeudSimple noeud1 = new NoeudSimple(1,1) ;
        NoeudSimple noeud2 = new NoeudSimple(4,3) ;
        Barre barre = new Barre(noeud1, noeud2) ;
        Treillis ora = new Treillis() ;
        ora.add(noeud1);
        ora.add(noeud2);
        ora.add(barre);
        System.out.println(ora);
        //ora.poserNoeudSimple(barre, 1);
        ora.poserAppuiGlissant(barre, 1);
        System.out.println(ora);
    }
    
    }
    
    
    
    

