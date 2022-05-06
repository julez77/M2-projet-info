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
Treillis teste = new Treillis();
//teste.add(penaldo);



teste.menuTexte();
// TODO code application logic here

NoeudSimple p1 = new NoeudSimple(2, 2);
NoeudSimple p2 = new NoeudSimple(5, 3);
Barre b = new Barre(p1, p2);
Treillis e = new Treillis();
//e.add(b);
//e.add(p2);
//e.add(p2);




    }
    
}
