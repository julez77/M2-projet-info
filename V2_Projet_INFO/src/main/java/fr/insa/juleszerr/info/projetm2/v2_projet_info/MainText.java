/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;
import fr.insa.juleszerr.info.projetm2.Lire;
/**
 *
 * @author IEUser
 */
public class MainText {
    public static void menuInitial(){
            int rep = -1;
            while(rep != 0){
                System.out.println("Initialisation du treillis");
                System.out.println("1) commencer avec un treillis vierge");
                System.out.println("2) commencer avec le treillis de test");
                System.out.println("0) quitter");
                rep = Lire.i();
                if(rep == 1){
                    Treillis treillis = new Treillis();
                    treillis.menuTexte();
                }

                        
                        
                        
                       
                
            }
        }
    
    
    public static void main(String[] args) {
        Noeud n1, n2, n3;
        n1= new NoeudSimple(2,3);
        n2 = new NoeudSimple (5,7);
        n3 = new NoeudSimple(1,3);
      
       Treillis G = new Treillis();
       //G.ajouterNoeud(n3);
      //G.ajouterNoeud(n2);
      // G.add(new Barre(n1,n2));
       
      // G.menuTexte();
       
       
       
        
    }
}
