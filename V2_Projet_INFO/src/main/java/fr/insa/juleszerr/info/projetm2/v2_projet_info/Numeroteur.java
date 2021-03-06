/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author eguy01
 */
public class Numeroteur<TO> {
  private TreeMap<Integer,TO> idVersObjet;
    private Map<TO,Integer> objetVersId;
    
    private int prochainID;
    
    public Numeroteur() {
        this(0);
    }
    
    private Numeroteur(int prochainID) {
        this.prochainID = prochainID;
        this.idVersObjet = new TreeMap<>();
        this.objetVersId = new HashMap<>();
    }
    //associe un id a  un objet
    public int creeID(TO obj) {
        
        if(this.objetVersId.containsKey(obj)) {
            throw new Error("objet " + obj + " déjà dans le numéroteur");
        }
        
        this.idVersObjet.put(this.prochainID, obj);
        this.objetVersId.put(obj, this.prochainID);
        this.prochainID ++;
        return this.prochainID - 1;
    }
    //renvoie si un objet existe  ou non
    public boolean objExist(TO obj) {
        return this.objetVersId.containsKey(obj);
    }
    
    public int getID(TO obj) {
        if (this.objExist(obj)) {
            return this.objetVersId.get(obj);
        } 
        else {
            throw new Error("Objet" + obj + " inconnu dans numéroteur");
        }
    }
//si l'objet a  un id  on le recup sinon on le crée et  on le recup
    public int getOuCreeID(TO obj) {
        if (this.objExist(obj)) {
            return this.objetVersId.get(obj);
        } 
        else {
            return this.creeID(obj);
        }
    }
    
    public TO getObj(int id) {
        if (! this.idExist(id)) {
            throw new Error("identificateur non existant");
        }
        return this.idVersObjet.get(id);
    }
    
    public boolean idExist(int id) {
        return this.idVersObjet.containsKey(id);
    }
    //nom explicite
    public void associe(int id,TO obj) {
        if (this.idExist(id)) {
            throw new Error("identificateur existant");
        }
        this.idVersObjet.put(id, obj);
        this.objetVersId.put(obj, id);
    }  
    
    
    
    
    
    
    
    
    
}
