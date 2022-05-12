/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javafx.scene.Group;

/**
 *
 * @author IEUser
 */
public class Treillis extends Figure {
    private List<Figure> elements ;

    private List<Noeud> noeuds ;
    private List<Barre> barres;
    private List<Treillis> treillise ;
    private List<terrain3> terrain3;
    private List<Figure> elemterrain3;
  
    public Treillis(){
        this.elements = new ArrayList() ;
        this.barres = new ArrayList() ;
        this.noeuds = new ArrayList() ;
        this.treillise = new ArrayList();
        this.terrain3 = new ArrayList();
        this.elemterrain3 =new ArrayList(); 
    }
    
    
    public Treillis(List<Figure> elements){
    this.setElements(elements);
        
    
}
 @Override
    public String toString() {
        String res = "Groupe {\n";
        for (int i = 0; i < this.getElements().size(); i++) {
            res = res + indente(this.getElements().get(i).toString(), "  ") + "\n";
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

        //if (f.getTreillis() != this) {
            //if (f.getTreillis() != null) {
               // throw new Error("figure déja dans un autre treillis");
            //}
            //this.getElements().add(f);

       // if (f.getTreillis() != this) {
            //if (f.getTreillis() != null) {
               // throw new Error("figure déja dans un autre treillis");
           // }
            this.elements.add(f);

            f.setTreillis(this);

            if ((f instanceof Noeud)== true ){
                this.getNoeuds().add((Noeud) f);}
            else if ((f instanceof Barre)== true ){
               this.barres.add((Barre) f);
               
                          
            }else if ((f instanceof Treillis)== true ){
                this.addTreillis(this);

            } else{
                this.addterrain3((terrain3)f);
            }
    }
    public void addTreillis(Treillis T){
        this.elements.addAll(T.getElements());
        this.barres.addAll(T.getBarres());
        this.noeuds.addAll(T.getNoeuds());
        this.treillise.addAll(T.getTreillise());
        this.terrain3.addAll(T.getTerrain3());
        this.elements.add(T);
        this.treillise.add(T);
    }
    
    
    
    
          public void addterrain3(terrain3 t){
             this.elements.add(t);
              this.getTerrain3().add(t);
              this.elements.add(t.getNoeuds()[1]);
              this.elements.add(t.getNoeuds()[2]);
              this.elements.add(t.getNoeuds()[0]);
              this.elements.add(t.getBarres()[0]);
              this.elements.add(t.getBarres()[1]);
              this.elements.add(t.getBarres()[2]);
              this.noeuds.add(t.getNoeuds()[1]);
              this.noeuds.add(t.getNoeuds()[2]);
              this.noeuds.add(t.getNoeuds()[0]);
              this.barres.add(t.getBarres()[0]);
              this.barres.add(t.getBarres()[1]);
              this.barres.add(t.getBarres()[2]);
              this.elemterrain3.add(t.getNoeuds()[1]);
              this.elemterrain3.add(t.getNoeuds()[2]);
              this.elemterrain3.add(t.getNoeuds()[0]);
              this.elemterrain3.add(t.getBarres()[0]);
                            this.elemterrain3.add(t.getBarres()[1]);
                            this.elemterrain3.add(t.getBarres()[2]);
          }
        //}

        //}

    
    public void remove(Figure f) {                          // supprime une figure (barre, noeud, treillis)
        if (f.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.getElements().remove(f);
        f.setTreillis(null);
         if ((f instanceof Noeud)== true ){
                this.getNoeuds().remove((Noeud) f);}
         else if ((f instanceof Barre)== true ){
               this.barres.remove((Barre) f);}
         else  if ((f instanceof Treillis)== true ) {
             this.getTreillise().remove((Treillis)f);
             
            } else{
             
         }
        
        
    }

    public void removeAll(List<Figure> lf) {
        for (Figure f : lf) {
            this.remove(f);
        }
    }

    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.getElements());
        this.removeAll(toRemove);
    }

    public int size() {
        return this.getElements().size();
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
            for (Figure f : this.getElements()) {
                f.save(w, num);
            }
            w.append("Treillis;" + id);
            for (Figure f : this.getElements()) {
                w.append(";" + num.getID(f));
            }
            w.append("\n");
        }
    }

    /**
     * @return the élements
     */
    public List<Figure> getÉlements() {
        return getElements();
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
        @Override
    public Group dessineSelection() {
                
        Group g = new Group();
        for(int i = 0 ; i < this.getÉlements().size() ; i ++) {
            g.getChildren().add(this.getÉlements().get(i).dessineSelection());
        }
        return g;
    }
public static Treillis treillisTest() {
        NoeudSimple p1 = new  NoeudSimple(10, 10);
        NoeudSimple p2 = new  NoeudSimple(100, 10);
        NoeudSimple p3 = new  NoeudSimple(100, 100);
        NoeudSimple p4 = new  NoeudSimple(10, 100);
        NoeudSimple p5 = new  NoeudSimple(50, 50);
        NoeudSimple p6 = new  NoeudSimple(400, 500);
        NoeudSimple p7 = new  NoeudSimple(50, 100);
        NoeudSimple p8 = new  NoeudSimple(650, 350);
        NoeudSimple p9 = new  NoeudSimple(500, 500);
        Barre s1 = new Barre(p1, p2);
        Barre s2 = new Barre(p2, p3);
        Barre s3 = new Barre(p3, p1);
        Barre s4 = new Barre(p1, p4);
        terrain3 triangle = new terrain3(p7, p8, p9);

        Treillis res = new Treillis();
        res.add(p5);
        res.add(p6);
        res.add(s4);
       // res.add(triangle);
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
              if (this.getElements().isEmpty()) {
            return 0;
        } else {
            double max = this.getElements().get(0).maxX();
            for (int i = 1; i < this.getElements().size(); i++) {
                double cur = this.getElements().get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minX() {
         if (this.getElements().isEmpty()) {
            return 0;
        } else {
            double min = this.getElements().get(0).minX();
            for (int i = 1; i < this.getElements().size(); i++) {
                double cur = this.getElements().get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double maxY() {
       if (this.getElements().isEmpty()) {
            return 0;
        } else {
            double max = this.getElements().get(0).maxY();
            for (int i = 1; i < this.getElements().size(); i++) {
                double cur = this.getElements().get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }

    @Override
    public double minY() {
         if (this.getElements().isEmpty()) {
            return 0;
        } else {
            double min = this.getElements().get(0).minY();
            for (int i = 1; i < this.getElements().size(); i++) {
                double cur = this.getElements().get(i).minY();
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

            }System.out.println("lol");
        System.out.println(noeuds);
        }
       
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public double distanceNoeud(Noeud p) {
              if (this.getElements().isEmpty()) {
            return new NoeudSimple(0, 0).distanceNoeud(p);
        } else {
            double dist = this.getElements().get(0).distanceNoeud(p);
            for (int i = 1; i < this.getElements().size(); i++) {
                double cur = this.getElements().get(i).distanceNoeud(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }

    public Figure plusProche(Noeud p, double distMax) {
        if (this.elements.isEmpty()) {
            return null;
        } else {
            Figure fmin = this.elements.get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.elements.size(); i++) {
                Figure fcur = this.elements.get(i);
                double cur = fcur.distanceNoeud(p);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
    }
    
    
    private Noeud choisiNoeud() {
       List<Noeud> lp = new ArrayList<>();
        System.out.println("liste des points disponibles : ");
        int nbr = 0;
        for (int i = 0; i < this.getElements().size(); i++) {
            Figure f = this.getElements().get(i);
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
            for (int i = 0; i < this.getElements().size(); i++) {
                System.out.println((i + 1) + ") " + this.getElements().get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.getElements().size()) {
                Figure f = this.getElements().get(rep - 1);
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
            this.getElements().remove(f);
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
       

    public int NbInconnues(){
        int N=this.getBarres().size() ;
        for (int i=0 ; i<this.getNoeuds().size() ; i++){
            Noeud noeud = this.getNoeuds().get(i) ;
            if (noeud instanceof AppuiGlissant){
                N=N+1 ;
            }
            
            if (noeud instanceof AppuiSimple){
                N=N+2 ;
            }
            
        }
        return N ;
    }
    
    public double[][] Systeme(){
        int N = this.NbInconnues() ;
        double [][] S = new double[N][N+1];
        int i ; int j; 
        int X=this.getBarres().size() - 1 ; //représente l'avancement du remplissage des colonnes de la matrice
        int Z=0 ;        // représente l'avancement du remplissage des lignes de la matrice
        double angle ;
        double angle2 ;
        
        for (i=0 ; i<this.getNoeuds().size() ; i++){
            Z=2*i ;
            Noeud noeud = this.getNoeuds().get(i) ;
            
            for (j=0 ; j<this.getBarres().size() ; j++){        
                Barre barre = this.getBarres().get(j) ;
                
                if(noeud.barreincidente(barre)==true){
                    angle = noeud.angleBarreNoeud(barre) ;
                    S[Z][j]=cos(angle) ;
                    S[Z+1][j]=sin(angle) ;
                } 
                        
            }
            
            for(int t=j+1 ; t<X+1 ; t++){
                S[Z][t]=0 ;
                S[Z+1][t]=0 ;
            }
            
            if (noeud instanceof AppuiSimple){
                S[Z][X+1]=1 ;
                S[Z+1][X+1]=0 ;
                S[Z+1][X+2]=1 ;
                X=X+2 ;
            }
            
            if (noeud instanceof AppuiGlissant){
                Barre barresupport = ((AppuiGlissant) noeud).getPoseSur();
                angle2 = barresupport.vecteurBarre().vecteurNormal().angleHorizontale() ;
                S[Z][X+1]=cos(angle2);
                S[Z+1][X+1]=sin(angle2);
                X=X+1 ;
            }
            
            Vecteur2d force = noeud.getForce() ;
            
            if(force.getVx()==0 && force.getVy()==0){
             S[Z][N]=0 ;
             S[Z+1][N]=0 ;
            }
            
            else{
                
              double angleforce = force.angleHorizontale() ;
              double norme = force.length() ;
              S[Z][N]= - (cos(angleforce))*norme ;
              S[Z+1][N]= - (sin(angleforce))*norme ;
            }
          
        }
        
        for (int g=0 ; g<N ; g++){
            for (int h=0 ; h<N+1 ; h++){
                System.out.print(S[g][h]+"  ");
                
            }
            System.out.println();
        }
        
      return S ;  
    }
    
    public double[] Resolution(){
        
        int N = this.NbInconnues() ;
        Matrice resol = new Matrice(N, N+1, this.Systeme()) ;
        
        for (int g=0 ; g<N ; g++){
            for (int h=0 ; h<N+1 ; h++){
                System.out.print(resol.getCoeff(g, h));
                
            }
            
            System.out.println();
        }
        
        return resol.resolution() ;
    }
    
    
    

    /**
     * @return the elements
     */
    public List<Figure> getElements(){
        return elements;
    }

    /**
     * @return the noeuds
     */
    public List<Noeud> getNoeuds() {
        return noeuds;
    }

    /**
     * @param noeuds the noeuds to set
     */
    public void setNoeuds(List<Noeud> noeuds) {
        this.noeuds = noeuds;
    }

    /**
     * @return the barres
     */
    public List<Barre> getBarres() {
        return barres;
    }

    /**
     * @param barres the barres to set
     */
    public void setBarres(List<Barre> barres) {
        this.barres = barres;
    }

    /**
     * @return the treillise
     */
    public List<Treillis> getTreillise() {
        return treillise;
    }

    /**
     * @param treillise the treillise to set
     */
    public void setTreillise(List<Treillis> treillise) {
        this.treillise = treillise;
    }

    /**
     * @return the terrain3
     */
    public List<terrain3> getTerrain3() {
        return terrain3;
    }

    /**
     * @param terrain3 the terrain3 to set
     */
    public void setTerrain3(List<terrain3> terrain3) {
        this.terrain3 = terrain3;
    }

    /**
     * @return the elemterrain3
     */
    public List<Figure> getElemterrain3() {
        return elemterrain3;
    }

    /**
     * @param elemterrain3 the elemterrain3 to set
     */
    public void setElemterrain3(List<Figure> elemterrain3) {
        this.elemterrain3 = elemterrain3;
    }


    
}


