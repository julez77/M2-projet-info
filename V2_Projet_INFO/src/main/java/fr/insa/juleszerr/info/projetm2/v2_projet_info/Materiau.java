/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

/**
 *
 * @author IEUser
 */
public class Materiau {
    private String typeMateriau;
    private double effortMax;
    
    public Materiau (String type, double effortMax){
        this.typeMateriau = type;
        this.effortMax = effortMax;
    }
    
    public Materiau (){
        this.effortMax = Double.MAX_VALUE;
        this.typeMateriau = "Acier";
        
    }
    
    @Override
    public String toString(){
        return "Materiau: "+this.getTypeMateriau()+", effort max: "+this.getEffortMax();
    }

    /**
     * @return the typeMateriau
     */
    public String getTypeMateriau() {
        return typeMateriau;
    }

    /**
     * @param typeMateriau the typeMateriau to set
     */
    public void setTypeMateriau(String typeMateriau) {
        this.typeMateriau = typeMateriau;
    }

    /**
     * @return the effortMax
     */
    public double getEffortMax() {
        return effortMax;
    }

    /**
     * @param effortMax the effortMax to set
     */
    public void setEffortMax(double effortMax) {
        this.effortMax = effortMax;
    }
}
