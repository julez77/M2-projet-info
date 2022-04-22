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
        System.out.println("lol");
      NoeudSimple pessi = new NoeudSimple(0,0);
      NoeudSimple benz;
        benz =  new NoeudSimple(1,1);
       System.out.println(pessi);
Barre penaldo = new Barre(pessi,benz);
System.out.println(penaldo);
System.out.println(penaldo.noeudOppose(benz));
double angl = penaldo.angle();
System.out.println(angl);
Groupe teste = new Groupe();
teste.ajouterBarre(penaldo);

teste.maxIDbarre();
System.out.println(teste.maxIDbarre());
System.out.println(teste.maxIDnoeud());
teste.menuTexte();
// TODO code application logic here
    }
    
}
