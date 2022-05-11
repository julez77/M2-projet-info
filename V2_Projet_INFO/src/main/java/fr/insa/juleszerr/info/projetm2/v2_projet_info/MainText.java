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
    
    
    public static void main(String[] args){
    
  //  System.out.println("nb lignes");
    //      int n = Lire.i() ;
     //     int p = n + 1 ;
   //       
      //    double[][]T = new double[n][p] ;
     //     
      //    for(int i=0 ; i<n ; i++){
      //        for(int j=0; j<p ; j++){
    //              System.out.println("Entrer le coefficient "+ (i+1)+", "+(j+1));
     //             T[i][j]=Lire.d(); 
      //        }
      //    }
        
       //   Matrice M = new Matrice(n, p, T) ;
       
        
    //      for(int i=0 ; i<n ;i++){
    //      System.out.println() ;
      //    for(int j=0 ; j<p; j++){
      //        System.out.print("  "+M.getCoeff(i, j));
     //     }
  //    } 
       
    //      double[] TabSol = new double[n] ;
      //  
    //      TabSol=M.resolution();
     //     System.out.println();
    
     //     for(int i=0 ; i<n ; i++){
     //     System.out.print("  "+TabSol[i]);
    //  }
     //     
        //  double R = M.getCoeff(0, 2) ;
     //     System.out.println() ;
        //  System.out.println(R);
         // 
         Treillis treillis = new Treillis();
                    treillis.menuTexte();
       
    }
 }
    

    
