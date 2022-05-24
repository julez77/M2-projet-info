/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.awt.Point;
import static java.lang.Math.sqrt;
import javafx.scene.Group;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Line;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author IEUser
 */
public  class Barre extends Figure  {

    static Barre demandeBarre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Noeud noeud1 ;
    private Noeud noeud2 ;
    private Color color;
    private Treillis treillis ;
    private double effort ;
    private int id ;

    Barre(Point p1, Point p2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


public Vecteur2d vecteurBarre(){            //renvoie le vecteur associé à une barre (sens du vecteur : point de départ vers point d'arrivée)
    double vx = this.getNoeud2().getPx() - this.getNoeud1().getPx() ;
    double vy =  this.getNoeud2().getPy() - this.getNoeud1().getPy() ;
    Vecteur2d vecteur = new Vecteur2d (vx, vy) ;
    return vecteur ;
}

    /**
     * @return the noeud1
     */
    public Noeud getNoeud1() {
        return noeud1;
    }

    /**
     * @param noeud1 the noeud1 to set
     */
    public void setNoeud1(Noeud noeud1) {
        this.noeud1 = noeud1;
        noeud1.getBarredebut().add(this);
    }

    /**
     * @return the noeud2
     */
    public Noeud getNoeud2() {
        return noeud2;
        
    }

    /**
     * @param noeud2 the noeud2 to set
     */
    public void setNoeud2(Noeud noeud2) {
        this.noeud2 = noeud2;
        noeud2.getBarrefin().add(this);
    }
    
    public Barre ( Noeud noeud1 , Noeud noeud2 ){
        this.color = Color.GREY;
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.effort = 0;
        
        
        noeud2.getBarrefin().add(this);
        noeud1.getBarredebut().add(this);
    }
    
     public Barre ( Noeud noeud1 , Noeud noeud2, Color color ){
        this.color = color;
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.effort= 0;
        this.id=0;
        
        noeud2.getBarrefin().add(this);
        noeud1.getBarredebut().add(this);
    }
    public Barre (Noeud noeud1,Noeud noeud2,double effort,double prix){
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.id = 0;
        this.effort = effort;
        
        noeud2.getBarrefin().add(this);
        noeud1.getBarredebut().add(this);
        
        
    }
    
    /**
     *
     * @return
     */
    @Override
 public String toString() {
        return "barre :[" + this.noeud1.toString()+ "," + this.noeud2.toString() + "] effort :"+getEffort() ;   
 }
    //nom explicite
  public static  Barre creeBarre() {
        System.out.println(" noeud n1 : ");
        Noeud noeud1 = Noeud.entrenoeud();
        System.out.println("noeud  n2: ");
        Noeud noeud2 = Noeud.entrenoeud();
        return new Barre(noeud1, noeud2);   
    
  }
//renvoie l'autre noeud de la barre ,lorsqu'on entre l'un
    public Noeud noeudOppose(Noeud  N){
    if (N==noeud2){
    return noeud1  ; }
        if (N == noeud1){
            return noeud2 ; }
        else{ return N;}
     
    }
    //nom explicite
    public double longueurBarre(){
      
        return sqrt(Math.pow(noeud2.getPx() - noeud1.getPx(), 2) + Math.pow(noeud2.getPy() - noeud1.getPy(), 2)) ;
    }
    
   
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
//nom explicite
  @Override
    public double distanceNoeud(Noeud p) {
        double x1 = this.noeud1.getPx();
        double y1 = this.noeud1.getPy();
        double x2 = this.noeud2.getPx();
        double y2 = this.noeud2.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.noeud1.distanceNoeud(p);
        } else if (up > 1) {
            return this.noeud2.distanceNoeud(p);
        } else {
            NoeudSimple p4 = new NoeudSimple(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distanceNoeud(p);
        }
    }
    
    @Override
        public Group dessine() {
        Materiau mat = Treillis.materiau;    
        if(this.getColor()==Color.BURLYWOOD){
            Line res1 = new Line();
            Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            res.setStroke(this.getColor());
            res.setFill(this.getColor());
            res.setStrokeWidth(7);        
            Group g = new Group( res);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }else{
        if(mat.getTypeMateriau() == "ACIER"){
            Line res1 = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            res.setStroke(Color.BLACK);
            res.setFill(Color.BLACK);
            res.setStrokeWidth(7);
            res1.setStroke(Color.DARKGRAY);
            res1.setFill(Color.DARKGRAY);
            res1.setStrokeWidth(3);
            Group g = new Group( res,res1);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }else if(mat.getTypeMateriau() == "BOIS" ||mat.getTypeMateriau()=="BAMBOO"){
            Line res1 = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            res.setStroke(Color.BROWN);
            res.setFill(Color.BROWN);
            res.setStrokeWidth(7);
            res1.setStroke(Color.BISQUE);
            res1.setFill(Color.BISQUE);
            res1.setStrokeWidth(3);
            Group g = new Group( res,res1);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }else if(mat.getTypeMateriau()=="PLASTIQUE"){
            Line res1 = new Line();
            Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            res.setStroke(Color.ORCHID);
            res.setFill(Color.ORCHID);
            res.setStrokeWidth(7);        
            Group g = new Group( res);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }else{
            Line res1 = new Line();
            Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            res.setStroke(this.getColor());
            res.setFill(this.getColor());
            res.setStrokeWidth(7);        
            Group g = new Group( res);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }
    }
        }

    
        @Override
    public Group dessineSelection() {
        
        Line res1 = new Line();
         Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
        res.setStroke(NoeudSimple.COULEUR_SELECTION);
        res.setFill(NoeudSimple.COULEUR_SELECTION);
        res.setStrokeWidth(7);
        Group g = new Group( res);
       return g;
    }

    public Group dessinForceCroissante(int Vert, int Rouge) {
        Line res1 = new Line();
        Line res = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
        res.setStroke(Color.rgb(Rouge, Vert, 0, 1));
        res.setFill(Color.rgb(Rouge, Vert, 0, 1));
        res.setStrokeWidth(7);
        Group g = new Group( res);
       return g;
    }
    
    public Group dessineForce() {
        Line bar = new Line();
        if(this.getEffort()>0){
            bar = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            bar.setStroke(RED);
            bar.setFill(RED);
            bar.setStrokeWidth(7);
            Group g = new Group(bar);
            return g;
        }else if (this.getEffort()<0) {
            bar = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            bar.setStroke(Color.BLUE);
            bar.setFill(Color.BLUE);
            bar.setStrokeWidth(7);
            Group g = new Group(bar);
            return g;
        }else{
            
            bar = new Line(this.getNoeud1().getPx(), this.getNoeud1().getPy(),
                this.getNoeud2().getPx(), this.getNoeud2().getPy());
            bar.setStroke(this.getColor());
            bar.setFill(this.getColor());
            bar.setStrokeWidth(5);
            Group g = new Group(bar);
            g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine());
            return g;
        }
        
    }
    //sauvegarde la barre
    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int ind = num.creeID(this);
            this.noeud1.save(w, num);
            this.noeud2.save(w, num);
            w.append("Barre;" + ind + ";" +
                    num.getID(this.noeud1) + ";" + num.getID(this.noeud2) +
                    ";  \n");
        }
    }
//nom explicite
    public Noeud noeudPlusProche(Noeud n){
        double dis1 = this.getNoeud1().distanceNoeud(n);
        double dis2 = this.getNoeud2().distanceNoeud(n);
        if(dis1>dis2){
            return this.getNoeud2();
        }else{
            return this.getNoeud1();
        }
    }
    //crée  une barre parallele a une autre ,(pas au point)
    public Barre barrepara(Barre b , Noeud n){
        // pour le  noeud1
    double    L = Math.sqrt((b.noeud1.px-b.noeud2.getPx())*((b.noeud1.px-b.noeud2.getPx())+(b.noeud1.py-b.noeud2.getPy()))*(b.noeud1.py-b.noeud2.getPy()));
        double n1px = b.noeud1.px + b.distanceNoeud(n) *((b.noeud1.py-b.noeud2.getPy())/L);
        double n2px =b.noeud2.px + b.distanceNoeud(n) *((b.noeud1.py-b.noeud2.getPy())/L);
        double n1py =b.noeud1.py + b.distanceNoeud(n) * ((b.noeud1.px-b.noeud2.getPx()) /L);
        double n2py = b.noeud2.py + b.distanceNoeud(n) * ((b.noeud1.px-b.noeud2.getPx())/L);
        if (b.noeud1.getClass()==NoeudSimple.class){
           NoeudSimple n1 = new NoeudSimple(n1px,n1py);
            NoeudSimple n2 =       new NoeudSimple(n2px,n2py);
            Barre B = new Barre(n1,n2);
        return B ;
    
        } else if (b.noeud1.getClass()==AppuiSimple.class){
            AppuiSimple n1 =new AppuiSimple(n1px,n1py);
            AppuiSimple n2 =new AppuiSimple(n2px,n2py);
            Barre B = new Barre(n1,n2);
        return B ;
    
        } else{
            AppuiGlissant n1 =new AppuiGlissant(n1px,n1py);
            AppuiGlissant n2 =new AppuiGlissant(n2px,n2py);
            Barre B = new Barre(n1,n2);
        return B ;
    }
        
        
    }
    
    
    
    
    
    
    /**
     * @return the effort
     */
    public double getEffort() {
        return effort;
    }

    /**
     * @param effort the effort to set
     */
    public void setEffort(double effort) {
        this.effort = effort;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the treillis
     */
    public Treillis getTreillis() {
        return treillis;
    }

    /**
     * @param treillis the treillis to set
     */
    public void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }

    

    




    
    
}
