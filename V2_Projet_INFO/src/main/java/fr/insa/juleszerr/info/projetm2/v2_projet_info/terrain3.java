/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 *
 * @author corin
 */
public class terrain3 extends Figure{
    private NoeudSimple noeud1;
    private Barre barre1;
    private NoeudSimple noeud2;
    private Barre barre2;
    private NoeudSimple noeud3;
    private Barre barre3;
    private Treillis treillis ;
    private Color color;
    private NoeudSimple[] noeuds;       
    private Barre[] barres ; 

public terrain3(NoeudSimple n1, NoeudSimple n2, NoeudSimple n3){
    this.color= Color.INDIANRED;
    this.noeuds = new NoeudSimple[4] ;
    this.barres = new Barre[4] ;
    this.noeud1 = n1;
    this.noeud2 = n2;
    this.noeud3 = n3;
    this.noeuds[0]=n1;
    this.noeuds[1]= n2;
    this.noeuds[2]=n3;       
    this.barre1 = new Barre(getNoeud1(), getNoeud2(), this.getColor());
    this.barre2 = new Barre(getNoeud2(), getNoeud3(),this.getColor());
    this.barre3 = new Barre(getNoeud1(), getNoeud3(),this.getColor());
    this.barres[0] = barre1;
    this.barres[1]= barre2;
    this.barres[2]= barre3 ;
    
    
}

public terrain3(){
   this.noeuds = new NoeudSimple[4] ;
   this.barres = new Barre[4] ;
   for (int  i = 0 ; i<=2;i++){
       this.noeuds[i]= null;
       this.barres[i]=null;
   }
   this.barre1 = null;
    this.barre2 = null;
    this.barre3 = null;
}

public void addbarre(Barre b)throws Exception{
  int  i=0;
  while ((this.getBarres()[i]!=null)&&(i<=2)){
      i=i+1;
  }
    if(i<3){
        this.getBarres()[i]=b; } else{throw new Exception("il y a deja 3 barres dans  le terrain");
  }
   this.barre1 =this.getBarres()[0];
   this.barre2 =this.getBarres()[1];
   this.barre3 =this.getBarres()[2];
}
           
 public void addNoeud(NoeudSimple b) throws Exception{
  int  i=0;
  while ((this.getNoeuds()[i]!=null)&&(i<=2)){
      i=i+1;
  }
  if(i<3){
      this.getNoeuds()[i]=b;  
  }else{
      throw new Exception("il y a deja 3 appui dans  le terrain");
  }
  
       
}   
 public void relieappui() throws Exception{
     int i;
     boolean p = true;
    for (i=0 ; i<= 2;i++) {
       if(  this.getNoeuds()[i]==null){
           p=false;
       } 
    }    
   if(p ==false){
       throw new Exception("pas assez d'appui dans le terrain");
   } else{
       this.barre1 = new Barre(this.getNoeuds()[1],this.getNoeuds()[2]);
       this.barre2 = new Barre(this.getNoeuds()[1],this.getNoeuds()[0]);
       this.barre3 = new Barre(this.getNoeuds()[0],this.getNoeuds()[2]);
       this.barres[0] = barre1;
    this.barres[1]= barre2;
    this.barres[2]= barre3 ;
       this.noeud1=(NoeudSimple) this.getNoeuds()[0];
        this.noeud2=(NoeudSimple) this.getNoeuds()[1];
                this.noeud3=(NoeudSimple) this.getNoeuds()[2];
   }
 }   
    
   public static void main(String[] args) throws Exception {
      terrain3 t =new terrain3();
       AppuiSimple n1 = new AppuiSimple(1,2);
      AppuiSimple n2 = new AppuiSimple(1,6); 
       AppuiSimple n3 = new AppuiSimple(9,2);
       /*t.addappui(n3);
       t.addappui(n2);
      
      t.addappui(n1);
      t.relieappui();
      // AppuiSimple n4 = new AppuiSimple(1,3); 
     //  t.addappui(n4);*/
   }

    @Override
    public double maxX() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double minX() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double maxY() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double minY() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double distanceNoeud(Noeud p) {
        double dist = this.barres[0].distanceNoeud(p);
        if (dist < this.barres[1].distanceNoeud(p)){
            dist = this.barres[1].distanceNoeud(p);
        }
        else if  (dist < this.barres[2].distanceNoeud(p)){
            dist = this.barres[2].distanceNoeud(p);
        }
        return dist;
        
    }

    @Override
    public Group dessine() {
        Group g = new Group();
       
        g.getChildren().addAll(this.getBarre1().dessine(),this.getBarre2().dessine(),this.getBarre3().dessine());
        g.getChildren().addAll(this.getNoeud1().dessine(),this.getNoeud2().dessine(),this.getNoeud3().dessine());      
        return g;
    }

    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            Figure f ;
            for(int i = 0 ; i <= 2 ; i++){
                 f= this.noeuds[i];
                 f.save(w, num);
                f= this.barres[i];
                f.save(w, num);
            }
             w.append("terrain3;" + id);
           for(int i =0 ; i<=2 ; i++){
               w.append(";" + num.getID(this.noeuds[i]));
                w.append(";" + num.getID(this.barres[i]));
                
           } 
           
           w.append("\n");  
        }
            
            
            
    }

    /**
     * @return the noeuds
     */
    public Noeud[] getNoeuds() {
        return noeuds;
    }

    /**
     * @param noeuds the noeuds to set
     */
    public void setNoeuds(NoeudSimple[] noeuds) {
        this.noeuds = noeuds;
    }

    /**
     * @return the barres
     */
    public Barre[] getBarres() {
        return barres;
    }

    /**
     * @param barres the barres to set
     */
    public void setBarres(Barre[] barres) {
        this.barres = barres;
    }

    /**
     * @return the noeud1
     */
    public NoeudSimple getNoeud1() {
        return noeud1;
    }

    /**
     * @return the barre1
     */
    public Barre getBarre1() {
        return barre1;
    }

    /**
     * @return the noeud2
     */
    public NoeudSimple getNoeud2() {
        return noeud2;
    }

    /**
     * @return the barre2
     */
    public Barre getBarre2() {
        return barre2;
    }

    /**
     * @return the noeud3
     */
    public NoeudSimple getNoeud3() {
        return noeud3;
    }

    /**
     * @return the barre3
     */
    public Barre getBarre3() {
        return barre3;
    }
public Barre barreplusproche(Noeud p, double Distmax){
   boolean check ;
   check= false; 
   for(int i= 0 ; i <= 2; i++){
    if (this.barres[i]!= null){
        check = true ;
    }}
    if ( check == false){
        return null ;
    } else{
      Barre b  = this.barres[0];
        double min = b.distanceNoeud(p);
        
        for ( int i = 1; i<=2 ; i++) {
                Barre b2  = this.barres[i];
                double cur = b2.distanceNoeud(p);
                if (cur < min) {
                    min = cur;
                    b = b2;
                }
            }
        
        if (min <= Distmax) {
                return b;
            } else {
                return null;
            }
        
    }
}   

        
    @Override
    public Group dessineSelection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
   public void poserAppuiSimple(Barre b, double distance){
        
       
       
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiSimple noeud = new AppuiSimple(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        this.treillis.add(noeud);
       
    }
public void poserAppuiGlissant(Barre b, double distance){
        
        double T = b.getNoeud2().getPx() - b.getNoeud1().getPx() ;
        double C = b.getNoeud2().getPy() - b.getNoeud1().getPy() ;
        double D = b.longueurBarre() ;
        AppuiGlissant noeud = new AppuiGlissant(b.getNoeud1().getPx()+(distance*T)/D  ,  b.getNoeud1().getPy() + (distance*C)/D) ;
        this.treillis.add(noeud) ;
        
        noeud.setPoseSur(b) ;
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
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    