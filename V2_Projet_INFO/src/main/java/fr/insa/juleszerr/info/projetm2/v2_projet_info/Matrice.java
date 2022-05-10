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
public class Matrice {
    private int NbrColonne ;
    private int NbrLigne ;
    private double[][] coeff ;
    
public Matrice(int NbrLigne, int NbrColonne, double[][]coeff){
    this.NbrColonne = NbrColonne ;
    this.NbrLigne = NbrLigne ;
    this.coeff = coeff ;
            
        
    
}

//public String toString(){
    
//}



    
public void Matrice() {
    for(int i=0 ; i<NbrLigne ; i++){
        for (int j=0 ; j<NbrColonne ; j++) {
            this.coeff[i][j]=0 ;   
        }
            
        }
    }

public boolean Inversible(){
    boolean inversible=true ;
    
    int i = 0 ;
    
    while (inversible==true && i<NbrLigne){
        
        int j=0 ;
        boolean testligne = false ;
    
        while (testligne==false && j<NbrLigne){
            if((this.coeff[i][j])!=0){
                testligne = true ;
            }
            
            j=j+1 ;
            
        }
        
        inversible = testligne ;
        
       i=i+1 ; 
    }
    
    
    return inversible ;
}




//méthode qui permute deux lignes de la matrice

public void permutation(int lignePivot, int lignePermut){
    for(int i=0 ; i<NbrColonne ; i++){
        double T = this.coeff[lignePivot][i] ;
        this.setCoeff(lignePivot, i, this.coeff[lignePermut][i]) ;
        this.setCoeff(lignePermut, i, T) ;
    }
}

//méthode qui cherche la ligne contenant le plus grand pivot en valeur absolue
public int recherchePivot(int lignePivot){
    double max=0 ;
    double T=0 ;
    int lignePivotMax = lignePivot ;
    for(int i= lignePivot+1 ; i<NbrLigne ; i ++){
        T = this.getCoeff(i, lignePivot) ;
        if(T<0){
            T=-T ;   
        }
             
        if (T> max){
            max = T ;
            lignePivotMax = i ;
        }
        }
    return(lignePivotMax) ;
    
}

//méthode qui effectue la descente de Gauss
public void DescenteGauss(){
    for(int i=0 ; i<NbrLigne ; i++) {
        
        if(this.coeff[i][i]==0){
            int lignePermut = recherchePivot(i) ;
            permutation(i, lignePermut) ;
        }
        
        for(int j=i+1 ; j<NbrLigne ; j++){
                if (this.Inversible()==false){
                    throw new Error("La matrice n'est pas inversible");
                }
                else {
                transvection(i, j);
            
                }
        }
}  
}

public void RemonteeGauss(){
    for(int i=NbrLigne-1 ; i>=1 ; i=i-1){
        for(int j=i-1 ; j>=0 ; j=j-1){
            if (this.Inversible()==false){
                   throw new Error("La matrice n'est pas inversible");
                }
           else{
                transvection(i, j) ;
           }
            }
        }
    }
    



public void transvection(int lignePivot, int ligneTrans){
    double a = this.coeff[lignePivot][lignePivot] ;
    double b = this.coeff[ligneTrans][lignePivot] ;
    
    if(lignePivot>ligneTrans){
    
        for(int i=NbrColonne-1 ; i>=0 ; i=i-1){
        double c = this.coeff[ligneTrans][i] ;
        double d = this.coeff[lignePivot][i] ;
        double T = a*c - b*d ;
        this.setCoeff(ligneTrans, i, T) ; }
}else{
        
        for(int i=lignePivot ; i<NbrColonne ; i++){
        double c = this.coeff[ligneTrans][i] ;
        double d = this.coeff[lignePivot][i] ;
        double T = a*c - b*d ;
        this.setCoeff(ligneTrans, i, T) ; 
}
        
    }
}

public double[] resolution(){
    this.DescenteGauss();
    this.RemonteeGauss();
    
    for(int i=0 ; i<NbrLigne ;i++){
        System.out.println() ;
        for(int j=0 ; j<NbrColonne; j++){
            System.out.print("  "+this.getCoeff(i, j));
        }
    } 
    
    double[]TabSol = new double[NbrLigne] ;
    for(int i=0 ; i<NbrLigne ; i++){
        double a = this.coeff[i][i] ;
        for(int j=i ; j<NbrColonne ; j++){
            double b = this.coeff[i][j] ;
            this.setCoeff(i, j, b/a);
            TabSol[i]= this.getCoeff(i, j);
        }
    }
    
   
   return TabSol ; 
       
}

  

public static void main(String[] args){
    
    System.out.println("nb lignes");
        int n = Lire.i() ;
        int p = n + 1 ;
        
        double[][]T = new double[n][p] ;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0; j<p ; j++){
                System.out.println("Entrer le coefficient "+ (i+1)+", "+(j+1));
                T[i][j]=Lire.d(); 
            }
        }
        
        Matrice M = new Matrice(n, p, T) ;
       
        
        for(int i=0 ; i<n ;i++){
        System.out.println() ;
        for(int j=0 ; j<p; j++){
            System.out.print("  "+M.getCoeff(i, j));
        }
    } 
        
        if (M.Inversible()==true){
            System.out.println("Jotaro") ;
        }
       
        double[] TabSol = new double[n] ;
      
        TabSol=M.resolution();
        System.out.println();
    
        for(int i=0 ; i<n ; i++){
        System.out.print("  "+TabSol[i]);
    }
        
        double R = M.getCoeff(0, 2) ;
        System.out.println() ;
        System.out.println(R);
        
        
       
    }





public double getCoeff(int i, int j) {
    return coeff[i][j] ;
}

public void setCoeff(int i, int j, double x){
    this.coeff[i][j]=x ;
}
    
  
    /**
     * @return the NbrColonne
     */
    public int getNbrColonne() {
        return NbrColonne;
    }

    /**
     * @param NbrColonne the NbrColonne to set
     */
    public void setNbrColonne(int NbrColonne) {
        this.NbrColonne = NbrColonne;
    }

    /**
     * @return the NbrLigne
     */
    public int getNbrLigne() {
        return NbrLigne;
    }

    /**
     * @param NbrLigne the NbrLigne to set
     */
    public void setNbrLigne(int NbrLigne) {
        this.NbrLigne = NbrLigne;
    } 
}
