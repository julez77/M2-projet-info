/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;


import fr.insa.juleszerr.info.projetm2.Lire;
import static java.lang.Math.abs;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

@Override 
public String toString(){
   String res = "Matrice : \n" ;
   
   for (int i =0 ; i<this.NbrLigne ; i++){
       res = res + "\n" ;
      
       for (int j=0 ; j<this.NbrColonne ; j++){
        res = res + this.getCoeff(i, j)+ "   " ;
    }
   
   }
   return res ;
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
               
                this.Equilibrage();
                
                System.out.println(this);
            
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
           
          this.Equilibrage();
          
          
          System.out.println(this);
          
          System.out.println();
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
    
    double[]TabSol = new double[NbrLigne] ;
        
    for(int i=0 ; i<NbrLigne ; i++){
        
        double a = this.coeff[i][i] ;
        
        for(int j=i ; j<NbrColonne ; j++){
            
            double b = this.coeff[i][j] ;
            this.setCoeff(i, j, b/a);
            TabSol[i]= this.getCoeff(i, j);
        }
    }
    
    System.out.println(this);
    
    for(int t=0 ; t<NbrLigne ; t++){
        TabSol[t]= Matrice.ArrondirDouble(TabSol[t]);
    }
   
    return TabSol ; 
       
}

public static double ArrondirDouble(double db1){

    BigDecimal bd = new BigDecimal(db1).setScale(3, RoundingMode.HALF_UP);
    double db2 = bd.doubleValue() ;
    return db2 ;
}



public void ArrondirMatrice(){
    for (int i=0 ; i<NbrLigne ; i++){
        for (int j=0 ; j<NbrColonne ; j++){
            this.coeff[i][j] = Matrice.ArrondirDouble(this.coeff[i][j]);
        }
    }
}

public Matrice MultiplierMatrice(int facteur){
    
    for (int i=0 ; i<NbrLigne ; i++){
        for (int j=0 ; j<NbrColonne ; j++){
            this.coeff[i][j] = facteur*(this.coeff[i][j]);
        }
    }
    return this ;
}

public boolean MultiplierLigne1(int ligne){
    boolean multiplier = false ;
    int j=0 ;
    while ((multiplier == false) && (j<NbrLigne)){
        if ((abs(this.coeff[ligne][j]))>10){
            multiplier = true ;
        }
        
        j=j+1 ;
        
    }
    
    return multiplier ;
}

public void MultiplierLigne2(int ligne){
    for (int j=0 ; j<NbrColonne ; j++){
        double t=0.1*(this.coeff[ligne][j]);
        this.setCoeff(ligne, j, t);
    }
}

public void Equilibrage(){
    for(int i=0 ; i<NbrLigne ; i++){
        if ((this.MultiplierLigne1(i))==true){
            this.MultiplierLigne2(i);
        }
    }
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
        Matrice P = new Matrice(n, p, T) ;
        
        System.out.println(M);
        
        M.Equilibrage();
        
        System.out.println(M);
        
        
        
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
