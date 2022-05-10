/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;



/**
 *
 * @author IEUser
 */
public class Test {
     /**
     * @param args the command line arguments
     */
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
        
        NoeudSimple noeudterrain1 = new NoeudSimple(2,1) ;
        NoeudSimple noeudterrain2 = new NoeudSimple(1,2) ;
        NoeudSimple noeudterrain3 = new NoeudSimple(2,3) ;
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
       
        
        NoeudSimple noeudterrain4 = new NoeudSimple(2,5) ;
        NoeudSimple noeudterrain5 = new NoeudSimple(1,6) ;
        NoeudSimple noeudterrain6 = new NoeudSimple(2,7) ;
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
        
       
        terrain1.poserAppuiGlissant(barreterrain3, 1);
       
        terrain2.poserAppuiSimple(barreterrain6, 1);
        
        System.out.println(terrain1);
        System.out.println(terrain2);
        
        AppuiGlissant appuiglissant = ((AppuiGlissant) terrain1.getNoeuds().get(3)) ;
        //System.out.println(appuiglissant) ;
        
        //System.out.println(appuiglissant.getPoseSur().vecteurBarre().vecteurNormal()) ;
        
        AppuiSimple appuisimple = ((AppuiSimple) terrain2.getNoeuds().get(3)) ;
        
        NoeudSimple noeud = new NoeudSimple(4,4) ;
        
        Barre barre1 = new Barre(appuiglissant, noeud);
        Barre barre2 = new Barre(appuiglissant, appuisimple);
        Barre barre3 = new Barre(appuisimple, noeud);
        
        Treillis muda = new Treillis() ;
        muda.add(appuisimple);
        muda.add(appuiglissant);
        muda.add(noeud);
        muda.add(barre1);
        muda.add(barre2);
        muda.add(barre3);
        
        System.out.println(muda);
        
        Vecteur2d force = new Vecteur2d(0, -1000);
        noeud.setForce(force);
        System.out.println(noeud.getForce());
        System.out.println(appuisimple.getForce());
        System.out.println(appuiglissant.getForce());
        
       
        System.out.println(muda.Systeme());
        System.out.println(muda.Resolution());
        double[] solutions = new double[muda.NbInconnues()] ;
        solutions = muda.Resolution() ;
        
        for (int j=0 ; j<muda.NbInconnues() ; j++){
            System.out.print(solutions[j]+"  ");
        }
        
    }
    
    
    
}
