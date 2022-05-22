/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Matrice;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author IEUser
 */
public class GrilleAffichage extends GridPane{
    private MainPane main;
    private Text effort;
    private Text typeEffort;
    private Text type;
    private Text nbBarre;
    private Text nbNoeud;

    
    public GrilleAffichage(MainPane main){
        this.main = main;
        this.effort = new Text("Effort barre: ");
        this.typeEffort =  new Text("Type d'effort :");
        this.type = new Text ("aucun effort");
        this.nbBarre = new Text("Nbre de barre: ");
        this.nbNoeud = new Text("Nbre de noeud: ");
        this.add(effort, 0, 0);
        this.add(typeEffort, 0, 1);
        this.add(type, 0, 2);
        this.add(nbBarre, 0, 3);
        this.add(nbNoeud, 0, 4);
        
        
    }
    
    public void actualiseGrille(){
        this.getChildren().clear();
      
        
        if(main.getControleur().getBarreProche().getEffort() !=0){
            this.setEffort(new Text("Effort : "+ (int)Matrice.ArrondirDouble(main.getControleur().getBarreProche().getEffort())));
            if(main.getControleur().getBarreProche().getEffort()>0){
                this.setTypeEffort(new Text("Type d'effort :"));
                this.setType(new Text("traction"));
                this.add(getTypeEffort(), 0, 1);
                this.add(getType(), 0, 2);
            }else{
                this.setTypeEffort(new Text("Type d'effort :"));
                this.setType(new Text("compression"));
                this.add(getType(), 0, 2);
                this.add(getTypeEffort(), 0, 1);
            }            
            this.add(getEffort(),0,0);

        }else{
            this.setEffort(new Text("Effort barre: 0"));
            this.setTypeEffort(new Text("Type d'effort :"));
            this.setType(new Text("aucun effort"));
            this.add(getEffort(),0,0);
            this.add(getType(), 0, 2);
            this.add(getTypeEffort(), 0, 1);
        }
        
        if(main.getTreillis().barres3().size()>0){
            this.setNbBarre(new Text("Nbre de barre: "+main.getTreillis().barres3().size()));
            this.add(nbBarre, 0, 3);
        }if(main.getTreillis().noeuds3().size()>0){
            this.setNbNoeud(new Text("Nbre de noeud: "+main.getTreillis().noeuds3().size())); 
            this.add(nbNoeud, 0, 4);
        }   
        
    }

    /**
     * @param effort the effort to set
     */
    public void setEffort(Text effort) {
        this.effort = effort;
    }

    /**
     * @param nbBarre the nbBarre to set
     */
    public void setNbBarre(Text nbBarre) {
        this.nbBarre = nbBarre;
    }

    /**
     * @param nbNoeud the nbNoeud to set
     */
    public void setNbNoeud(Text nbNoeud) {
        this.nbNoeud = nbNoeud;
    }

    /**
     * @return the typeEffort
     */
    public Text getTypeEffort() {
        return typeEffort;
    }

    /**
     * @param typeEffort the typeEffort to set
     */
    public void setTypeEffort(Text typeEffort) {
        this.typeEffort = typeEffort;
    }

    /**
     * @return the type
     */
    public Text getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Text type) {
        this.type = type;
    }

    /**
     * @return the effort
     */
    public Text getEffort() {
        return effort;
    }
    
}
