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
Barre  b1 = new Barre(n1,n2);
Treillis tr = new Treillis();
tr.add(n1);
System.out.println(tr);
tr.add(n2);
System.out.println(tr);
tr.add(b1);
System.out.println(tr);
tr.remove(n1);
System.out.println(tr);
System.out.println(tr.getNoeuds());
System.out.println("lol");
tr.remove(b1);
System.out.println(tr);
System.out.println(tr.getBarres());



// TODO code application logic here
    }
    
}
