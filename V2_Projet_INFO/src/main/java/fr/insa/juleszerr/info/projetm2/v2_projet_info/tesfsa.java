/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

/**
 *
 * @author corin
 */
public class tesfsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      NoeudSimple n1 = new NoeudSimple(4 ,2);
      NoeudSimple n2 = new NoeudSimple(7 ,3);  
       NoeudSimple n3 = new NoeudSimple(5 ,7);
Barre  b1 ;
Treillis tr = new Treillis();
tr.add(n1);
tr.add(n2);
System.out.println(tr.getElements());
System.out.println("lol");
System.out.println(tr.getNoeuds2());
b1=Barre.creeBarre();
tr.add(b1);
System.out.println("lol");
System.out.println(tr.getElements());
System.out.println("lol");
System.out.println(tr.getNoeuds2());
//System.out.println(tr.getBarres());



// TODO code application logic here
    }
    
}
