/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.Group;

/**
 *
 * @author corin
 */
public class terrain3 extends Figure{
    //j'avais mis en attribut 3 noeud et 3 barre plus constructeur qui creer le terrain a partir de trois noeuds en parametre et ensuite les barre
private NoeudAppui[] noeuds;       
private Barre[] barres ;       
public terrain3(){
   this.noeuds = new NoeudAppui[4] ;
   this.barres = new Barre[4] ;
   for (int  i = 0 ; i<=2;i++){
       this.noeuds[i]= null;
       this.barres[i]=null;
   }
   
}

public void addbarre(Barre b)throws Exception{
  int  i=0;
  while ((this.getBarres()[i]!=null)&&(i<=2)){
      i=i+1;
  }
    if(i<3){
        this.getBarres()[i]=b; } else{throw new Exception("il y a deja 3 barres dans  le terrain");
  }
       
}
           
 public void addappui(NoeudAppui b) throws Exception{
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
       Barre b12 = new Barre(this.getNoeuds()[1],this.getNoeuds()[2]);
       Barre b10 = new Barre(this.getNoeuds()[1],this.getNoeuds()[0]);
       Barre b02 = new Barre(this.getNoeuds()[0],this.getNoeuds()[2]);
       this.addbarre(b02);
       this.addbarre(b10);
       this.addbarre(b12);
   }
 }   
    
   public static void main(String[] args) throws Exception {
      terrain3 t =new terrain3();
       AppuiSimple n1 = new AppuiSimple(1,2);
      AppuiSimple n2 = new AppuiSimple(1,6); 
       AppuiSimple n3 = new AppuiSimple(9,2);
       t.addappui(n3);
       t.addappui(n2);
      
      t.addappui(n1);
      t.relieappui();
      // AppuiSimple n4 = new AppuiSimple(1,3); 
     //  t.addappui(n4);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group dessine() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the noeuds
     */
    public NoeudAppui[] getNoeuds() {
        return noeuds;
    }

    /**
     * @param noeuds the noeuds to set
     */
    public void setNoeuds(NoeudAppui[] noeuds) {
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
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    