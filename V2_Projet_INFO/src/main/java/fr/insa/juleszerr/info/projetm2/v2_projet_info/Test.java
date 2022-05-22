/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import static java.lang.Math.sqrt;
import java.util.List;



/**
 *
 * @author IEUser
 */
public class Test {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        NoeudSimple noeudterrain1 = new NoeudSimple(0,0) ;
        NoeudSimple noeudterrain2 = new NoeudSimple(3,0) ;
        NoeudSimple noeudterrain3 = new NoeudSimple(0,3) ;
        Barre barreterrain1 = new Barre(noeudterrain1, noeudterrain2);
        Barre barreterrain2 = new Barre(noeudterrain2, noeudterrain3);
        Barre barreterrain3 = new Barre(noeudterrain1, noeudterrain3);
        Treillis terrain1 = new Treillis() ;
        terrain1.add(noeudterrain1) ;
        terrain1.add(noeudterrain2) ;
        terrain1.add(noeudterrain3) ;
        terrain1.add(barreterrain1) ;
        terrain1.add(barreterrain2) ;
        terrain1.add(barreterrain3) ;
       
        
        NoeudSimple noeudterrain4 = new NoeudSimple(7,0) ;
        NoeudSimple noeudterrain5 = new NoeudSimple(10,0) ;
        NoeudSimple noeudterrain6 = new NoeudSimple(10,3) ;
        Barre barreterrain4 = new Barre(noeudterrain4, noeudterrain5);
        Barre barreterrain5 = new Barre(noeudterrain5, noeudterrain6);
        Barre barreterrain6 = new Barre(noeudterrain4, noeudterrain6);
        Treillis terrain2 = new Treillis() ;
        terrain2.add(noeudterrain4) ;
        terrain2.add(noeudterrain5) ;
        terrain2.add(noeudterrain6) ;
        terrain2.add(barreterrain4) ;
        terrain2.add(barreterrain5) ;
        terrain2.add(barreterrain6) ;
        
       
        terrain1.poserAppuiSimple(barreterrain2, 2*sqrt(2));
       
        terrain2.poserAppuiGlissant(barreterrain6, 2*sqrt(2));
        
        System.out.println(terrain1);
        System.out.println(terrain2);
        
        AppuiGlissant appuiglissant = ((AppuiGlissant) terrain2.getNoeuds().get(3)) ;
        
        AppuiSimple appuisimple = ((AppuiSimple) terrain1.getNoeuds().get(3)) ;
        
        NoeudSimple noeud1 = new NoeudSimple(5,2) ;
        NoeudSimple noeud2 = new NoeudSimple(3,4) ;
        NoeudSimple noeud3 = new NoeudSimple(7,4) ;
        NoeudSimple noeud4 = new NoeudSimple(5,6) ;
        
        Barre barre1 = new Barre(appuisimple, noeud1);
        Barre barre2 = new Barre(noeud1, appuiglissant);
        Barre barre3 = new Barre(appuisimple, noeud2);
        Barre barre4 = new Barre(noeud2, noeud1);
        Barre barre5 = new Barre(noeud3, noeud1);
        Barre barre6 = new Barre(appuiglissant, noeud3);
        Barre barre7 = new Barre(noeud2, noeud3);
        Barre barre8 = new Barre(noeud2, noeud4);
        Barre barre9 = new Barre(noeud3, noeud4);
        
        Vecteur2d force1 = new Vecteur2d(0, -500) ;
        Vecteur2d force2 = new Vecteur2d(0, -1000) ;
        
        noeud2.setForce(force1);
        noeud4.setForce(force2);
        
        Treillis muda = new Treillis() ;
        muda.add(appuisimple);
        muda.add(noeud1);
        muda.add(appuiglissant);
        muda.add(noeud2);
        muda.add(noeud3);
        muda.add(noeud4);
        
        muda.add(barre1);
        muda.add(barre2);
        muda.add(barre3);
        muda.add(barre4);
        muda.add(barre5);
        muda.add(barre6);
        muda.add(barre7);
        muda.add(barre8);
        muda.add(barre9);
        
       System.out.println(noeud1.angleBarreNoeud(barre1));
       System.out.println(noeud2.angleBarreNoeud(barre4));
       System.out.println(appuiglissant.getPoseSur().vecteurBarre().vecteurNormal());
       System.out.println(noeud3.angleBarreNoeud(barre5)); 
       System.out.println(muda);
        
        
       System.out.println(muda.Solutions());
 
       double[] solutions = new double[muda.NbInconnues()] ;
       solutions = muda.Solutions() ;
        
       System.out.println() ;
       System.out.println() ;
        
       for (int j=0 ; j<muda.NbInconnues() ; j++){
            
           System.out.print(solutions[j]+"  ");
       
       }
       
       muda.Resolution();
       System.out.println(muda);
       
       List<Barre> barrestriees = muda.BarresTriees() ;
       
       for (int i=0; i<barrestriees.size(); i++){
           System.out.print(barrestriees.get(i)+" / ");
       }
       System.out.println();
       System.out.println(muda.QuantiteVert());
       
        
    }
    
    
    
}
