/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

/**
 *
 * @author remyb
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NoeudSimple noeud1 = new NoeudSimple(0,3);
        NoeudSimple noeud2 = new NoeudSimple(3,0);
        Barre barre1 = new Barre(noeud1, noeud2);
        Treillis jojo= new Treillis() ;
        jojo.add(noeud1);
        jojo.add(noeud2);
        jojo.add(barre1);
        
        barre1.setEffort(24);
        
        Vecteur2d force = new Vecteur2d(5,6);
        noeud1.setForce(force);
        System.out.println(noeud1);
        
        System.out.println(jojo);
        jojo.poserAppuiSimple(barre1, 1);
        System.out.println(jojo);
    }
    
}
