/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;


import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;

/**
 *
 * @author IEUser
 */
public class Terrain extends Treillis{
private List<NoeudAppui> Appuis ;
    private List<Barre> barres;
    private List<Figure> elements ;
   
            
            public Terrain(){
        this.Appuis = new ArrayList();
        this.barres = new ArrayList();
        this.elements = new ArrayList() ;
    }
    
    @Override
    public String toString() {
        String res = "Terrain {\n";
        for (int i = 0; i < this.getElements().size(); i++) {
            res = res + indente(this.getElements().get(i).toString(), "  ") + "\n";
        }
        return res + "}";
    
    } 
    
    
    public static String indente(String toIndente, String prefix) {
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }
     
    public void add(Figure f) {

      
            this.elements.add(f);

            f.setTerrain(this);

            if ((f instanceof NoeudAppui)== true ){
                this.getAppuis().add((NoeudAppui) f);
                
            }
            else if ((f instanceof Barre)== true ){
               this.barres.add((Barre) f);
            } 
    
    
    }
    public void Relieappuis(){
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    @Override
    public Group dessine() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            for (Figure f : this.getElements()) {
                f.save(w, num);
            }
            w.append("Terrain;" + id);
            for (Figure f : this.getElements()) {
                w.append(";" + num.getID(f));
            }
            w.append("\n");
        }
    }

    /**
     * @return the Appuis
     */
    public List<NoeudAppui> getAppuis() {
        return Appuis;
    }

    /**
     * @param Appuis the Appuis to set
     */
    public void setAppuis(List<NoeudAppui> Appuis) {
        this.Appuis = Appuis;
    }

    /**
     * @return the barres
     */
@Override
    public List<Barre> getBarres() {
        return barres;
    }

    /**
     * @param barres the barres to set
     */
@Override
    public void setBarres(List<Barre> barres) {
        this.barres = barres;
    }

    /**
     * @return the elements
     */
@Override
    public List<Figure> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
@Override
    public void setElements(List<Figure> elements) {
        this.elements = elements;
    }
    
   
    
    
}
