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
    private List<Barre> barres ;
    private List<Treillis> treillise ;
    private List<terrain3> terrain3;
    private List<Figure> elemterrain3;
    private List<NoeudAppui> bonuster3 ;
    private List<Noeud> noeuds2 ;
    private List<Barre> barres2 ;
    
  
  public Treillis(){
        this.elements = new ArrayList() ;
        this.barres = new ArrayList() ;
        this.noeuds = new ArrayList() ;
        this.treillise = new ArrayList();
        this.terrain3 = new ArrayList();
        this.elemterrain3 =new ArrayList(); 
        this.bonuster3 = new ArrayList();
        this.noeuds2 = new ArrayList();
        this.barres2 = new ArrayList();
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
            
 
    
    public void poserAppuiSimple(Barre b, double distance){  //pose un appui simple sur une barre à une distance sur la barre prise en compte à partir du noeud 1 de celle-ci
        
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiSimple noeud = new AppuiSimple(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud);
        this.elements.add(noeud) ;
        this.noeuds.add(noeud);
        noeud.setTreillis(this);
    }
    
    public void poserAppuiGlissant(Barre b, double distance){ //pareil que appui simple mais la barre sur laquelle a été posée l'appui glissant est récupérée
        
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiGlissant noeud = new AppuiGlissant(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud) ; 
        this.elements.add(noeud);
        this.noeuds.add(noeud);
        noeud.setPoseSur(b) ; 
        noeud.setTreillis(this);
        this.add(noeud);
    }
    
   public void poserNoeudSimple(Barre b, double distance){  //pareil que préccédemment, mais la barre est alors divisée en 2 nouvelles barres
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        NoeudSimple noeud = new NoeudSimple(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        add(noeud) ;
        
        Barre newBarre1 = new Barre(b.getNoeud1(), noeud) ;
        Barre newBarre2 = new Barre(noeud, b.getNoeud2()) ;
        this.add(newBarre1);
        this.add(newBarre2);
        this.remove(b);
        
   }
   
   public void ProjeterNoeud(Noeud noeud, Barre b){  //projete un noeud sur une barre : détermine notamment la distance requise par les méthodes "poser" 
       Barre barre = new Barre(b.getNoeud1(), noeud);
       Vecteur2d v1 = b.vecteurBarre();
       Vecteur2d v2 = barre.vecteurBarre();
       double angle = Vecteur2d.angleVecteurs(v1, v2);
       double d = noeud.distanceNoeud(b.getNoeud1());
       double distanceSurBarre = d*cos(angle);
       
       if ((noeud instanceof NoeudSimple)==true ){
           this.poserNoeudSimple(b, distanceSurBarre);
       }
       
        if ((noeud instanceof AppuiGlissant)==true){
            this.poserAppuiGlissant(b, distanceSurBarre);
        }
        
        if((noeud instanceof AppuiSimple)==true){
            this.poserAppuiSimple(b, distanceSurBarre);
        }
   } 
    
   public void add(Figure f) { //ajoute une figure au treillis

        
            if(this.elements.contains(f)==false){
            this.elements.add(f);}

            f.setTreillis(this);

            if ((f instanceof Noeud)== true ){
               f.setTreillis(this);
                if(this.noeuds.contains(f)==false){
                    this.getNoeuds().add((Noeud) f);
                    
                }
                
            }
            
            else if ((f instanceof Barre)== true ){
               this.addbarres((Barre) f);
               f.setTreillis(this);
               
            }
            
            else if ((f instanceof terrain3)== true ){
              f.setTreillis(this);
              
                this.addterrain3((terrain3)f);
            }
    
            
   }
   
   public List<Noeud> noeuds3(){     //renvoie la liste des noeuds utilisés pour la mise en équation
       List<Noeud> noeud3 = new ArrayList();
       for (int i=0 ; i<this.noeuds.size() ; i++){
           Noeud noeud = this.noeuds.get(i);
           if(this.elemterrain3.contains(noeud)==false){
               if(noeud3.contains(noeud)==false){
                    noeud3.add(noeud);
               }
             
               
           }
       }
       
       for(int j=0 ; j<noeud3.size();j++){
           Noeud noeud2 = noeud3.get(j) ;
           if(this.noeuds.contains(noeud2)==false){
               noeud3.remove(noeud2);
           }
       }
       
       return noeud3 ;
   }
   
   
   
   public List<Barre> barres3(){  //renvoie la liste des barres utilisés pour la mise en équation
       List<Barre> barre3 = new ArrayList();
       for (int i=0 ; i<this.barres.size() ; i++){
           Barre barre = this.barres.get(i);
           if(this.elemterrain3.contains(barre)==false){
               if(barre3.contains(barre)==false){
                    barre3.add(barre);
               }
           }
       }
       for(int j=0 ; j<barre3.size();j++){
           Barre barre2 = barre3.get(j) ;
           if(this.barres.contains(barre2)==false){
               barre3.remove(barre2);
           }
       }
       
       return barre3 ;
   }

    public void addbarres(Barre b){
      if (this.barres.contains(b)==false){
        this.barres.add(b);
   }
        if(this.noeuds.contains(b.getNoeud1())==false){
        this.noeuds.add(b.getNoeud1());
        b.getNoeud1().setTreillis(this);
        }
        if(this.noeuds.contains(b.getNoeud2())==false){
        this.noeuds.add(b.getNoeud2());
        b.getNoeud2().setTreillis(this);
        }
         if(this.elements.contains(b.getNoeud1())==false){
        this.elements.add(b.getNoeud1());}
          if(this.elements.contains(b.getNoeud2())==false){
        this.elements.add(b.getNoeud2());}
          
          
          
          
    }
    
    
    
    public void addterrain3(terrain3 t){
               
               if(this.elements.contains(t)==false){
                    this.elements.add(t);
               }
                    
               this.getTerrain3().add(t);
               t.setTreillis(this);
               for(int i=0 ; i<3 ; i++){
                   if(this.elemterrain3.contains(t.getNoeuds()[i])==false){
                    this.elemterrain3.add(t.getNoeuds()[i]);
                   }
                   
                   if(this.elemterrain3.contains(t.getBarres()[i])==false){
                    this.elemterrain3.add(t.getBarres()[i]); }
                   
                  
                   
                   
                   
                   if(this.elements.contains(t.getNoeuds()[i])==false){
                        this.elements.add(t.getNoeuds()[i]);
                        t.getNoeuds()[i].setTreillis(this);
                   }
                   
                   if(this.elements.contains(t.getBarres()[i])==false){
                        this.elements.add(t.getBarres()[i]);
                        t.getBarres()[i].setTreillis(this);
                   if(this.barres.contains(t.getBarres()[i])==false){
                        this.barres.add(t.getBarres()[i]);
                   }
                        if(this.noeuds.contains(t.getNoeuds()[i])==false){
                        this.noeuds.add(t.getNoeuds()[i]);
                        
                   } 
                   
                   
                   
                   }
                           
                   
                   
                   
                   
               }
               
               t.setTreillis(this);
            
          }
      

    
    public void remove(Figure f) {                          // supprime une figure (barre, noeud, treillis)
        if (f.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.getElements().remove(f);
        f.setTreillis(null);
         
        if ((f instanceof Noeud)== true ){
            this.getNoeuds().remove((Noeud) f);
            
        }
        else if ((f instanceof Barre)== true ){
            while(this.getBarres().contains(f)==true){
               this.getBarres().remove((Barre) f);
               
            }
        }
         
        else  if ((f instanceof Treillis)== true ) {
            this.getTreillise().remove((Treillis)f);
             
            } 
        else{
            this.removeterrain3((fr.insa.juleszerr.info.projetm2.v2_projet_info.terrain3) f);
         }  
             
        
    }
public void removeterrain3(terrain3 t){
              this.elements.remove(t);
              this.getTerrain3().remove(t);
              
              for (int i=0 ; i<3 ; i++){
                  this.elements.remove(t.getNoeuds()[i]);
                  this.elements.remove(t.getBarres()[i]);
                  this.elemterrain3.remove(t.getNoeuds()[i]);
                  this.elemterrain3.remove(t.getBarres()[i]);
                  this.noeuds.remove(t.getNoeuds()[i]);
                  this.barres.remove(t.getBarres()[i]);
                  t.getBarres()[i].setTreillis(null);
                  t.getNoeuds()[i].setTreillis(null);
              }
             
              t.setTreillis(null);
          }
    
    //public void removebarres(Barre b){
       // this.barres.remove(b);
        //this.elements.remove(b);
        
       // b.setTreillis(null);
   // }
    
    
    
    
    
    
    
    
    public void removeAll(List<Figure> lf) {
       for (Figure f : lf) {
           this.remove(f);
      }
   }

    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.getElements());
        this.removeAll(toRemove);
    }

    
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
    
        public Noeud NoeudPlusProche(Noeud p, double distMax) {
        if (this.noeuds.isEmpty()) {
            return null;
        } else {
            Noeud fmin = this.noeuds.get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.noeuds.size(); i++) {
                Noeud fcur = this.noeuds.get(i);
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
        
       public Barre barrePlusProche(Noeud p, double distMax) {
        if (this.barres.isEmpty()) {
            return null;
        } else {
            Barre bmin = this.barres.get(0);
            double min = bmin.distanceNoeud(p);
            for (int i = 1; i < this.barres.size(); i++) {
                Barre bcur = this.barres.get(i);
                double cur = bcur.distanceNoeud(p);
                if (cur < min) {
                    min = cur;
                    bmin = bcur;
                }
            }
            if (min <= distMax) {
                return bmin;
            } else {
                return null;
            }
        }
    }
    
    


    public static String indente(String toIndente, String prefix) {
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }
    
       public static void TLecture() throws Exception {
        try {
            Figure lue = Figure.lecture(new File("sauv.txt"));
            System.out.println("fig lue : " + lue);
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }
    
       public boolean Isostatique(){
           boolean isostatique ;
           int NbEquations = 2*(this.noeuds3().size());
           int NbInconnues = this.NbInconnues();
           
           if(NbEquations == NbInconnues){
               isostatique = true ;
           }
           else{
               isostatique = false ;
           }
           
           return isostatique ;
       }
       
    public int RoadToIsostatique(){
        int NbEquations = 2*(this.noeuds3().size());
        int NbInconnues = this.NbInconnues();
        
        return NbEquations - NbInconnues ;
        
    }   
    
    
       

    public int NbInconnues(){     
        int N=this.barres3().size() ;
        for (int i=0 ; i<this.noeuds3().size() ; i++){
            Noeud noeud = this.noeuds3().get(i) ;
            if ((noeud instanceof AppuiGlissant)==true){
                N=N+1 ;
            }
            
            if ((noeud instanceof AppuiSimple)==true){
                N=N+2 ;
            }
            
        }
        return N ;
    }
    
    public double[][] Systeme(){   //renvoie la matrice associée au treillis, dont la dernière colonne comporte les compsoantes des forces appliquées par l'utilisateur
        int N = this.NbInconnues() ;
        double [][] S = new double[N][N+1];
        int i ; int j; 
        int X=this.barres3().size() - 1 ; //représente l'avancement du remplissage des colonnes de la matrice
        int Z=0 ;        // représente l'avancement du remplissage des lignes de la matrice
        double angle ;
        double angle2 ;
        AppuiGlissant noeud2 ;
        
        for (i=0 ; i<this.noeuds3().size() ; i++){
            Z=2*i ;
            Noeud noeud = this.noeuds3().get(i) ;
            
            for (j=0 ; j<this.barres3().size() ; j++){        
                Barre barre = this.barres3().get(j) ;
                
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
                noeud2 = ((AppuiGlissant) noeud);
                angle2 = noeud2.angleForce();
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
    
    public double[] Solutions(){
        
        int N = this.NbInconnues() ;
        
        Matrice resol = new Matrice(N, N+1, this.Systeme()) ;
        
        System.out.println(resol);
        
        resol.ArrondirMatrice();
        
        System.out.println(resol);
        
        return resol.resolution() ;
    }
    
    
    public void Resolution(){
        
        int N = this.NbInconnues();
        int X = this.barres3().size()-1;
        double[] solutions = new double[N];
        solutions = this.Solutions() ;
        
        for(int i=0 ; i<X+1 ; i++){
            
            this.barres3().get(i).setEffort(solutions[i]);
            
        }
        
        for (int j=0 ; j<this.noeuds3().size() ; j++){
            Noeud noeud = this.noeuds3().get(j) ;
            
            if ((noeud instanceof AppuiSimple)==true){
                double vx = solutions[X+1] ;
                double vy = solutions[X+2] ;
                Vecteur2d forceAppuiSimple = new Vecteur2d(vx, vy);
                noeud.setForce(forceAppuiSimple);
                
                X=X+2 ;
            }
            
            if ((noeud instanceof AppuiGlissant)==true){
                double normeForceAppuiGlissant = solutions[X+1] ;
                AppuiGlissant noeudAppuiGlissant = ((AppuiGlissant) noeud);
                double angle = noeudAppuiGlissant.angleForce();
                
                noeud.setForce(Vecteur2d.ForceAngleNorme(angle, normeForceAppuiGlissant));
            }
        
    }
    
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

    /**
     * @return the noeuds2
     */
    public List<Noeud> getNoeuds2() {
        return noeuds2;
    }

    /**
     * @param noeuds2 the noeuds2 to set
     */
    public void setNoeuds2(List<Noeud> noeuds2) {
        this.noeuds2 = noeuds2;
    }

    /**
     * @return the barres2
     */
    public List<Barre> getBarres2() {
        return barres2;
    }

    /**
     * @param barres2 the barres2 to set
     */
    public void setBarres2(List<Barre> barres2) {
        this.barres2 = barres2;
    }


    
}


