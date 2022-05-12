/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.gui.Controleur.Etat;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author IEUser
 */
public class DessinPane extends Pane{
    private MainPane main;
    private Rectangle clip;
  
    
    public DessinPane(MainPane main) {
        super();
      
        this.main=main;
        this.clip = new Rectangle();
        clip.heightProperty().bind(this.heightProperty());
        clip.heightProperty().addListener((cl)->{
            System.out.println("w="+ this.main.getWidth()+" ; h = "+ this.main.getHeight());
            this.redrawAll();
        });
        clip.widthProperty().bind(this.widthProperty());
        
        this.setClip(clip);
        
        this.setOnMouseClicked((t)->{
          System.out.println("px2 = "+ t.getX() +"; py2 = "+ t.getY());
          this.main.getControleur().clicDansDessin(t);
          this.redrawAll();
        });

        this.redrawAll();
    }
    
    public  void redrawAll() {
        
        this.getChildren().addAll(this.main.getTreillis().dessine());  
        List<Figure> select = this.main.getControleur().getSelection();
        if(! select.isEmpty()){
        if (this.main.getControleur().getEtat() == Etat.SELECT) {
            System.out.println("dessineSelectioin");
                 for (Figure f : select){
                this.getChildren().addAll(f.dessineSelection());
            }
            
        }else if(this.main.getControleur().getEtat() == Etat.NOEUDSIMPLE) {
            
        }else if (this.main.getControleur().getEtat() == Etat.APPUISIMPLE) {
                   
        }else if (this.main.getControleur().getEtat() == Etat.APPUIGLISSANT) {
                    
        }else if (this.main.getControleur().getEtat() == Etat.BARRE_N1_LIBRE) {
            
                     
        }else if (this.main.getControleur().getEtat() == Etat.BARRE_N2_LIBRE) {
           
         
        }else if (this.main.getControleur().getEtat() == Etat.TERRAIN_N1) {
            
        }else if (this.main.getControleur().getEtat() == Etat.TERRAIN_N2) {
            
        }else if (this.main.getControleur().getEtat() == Etat.TERRAIN_N3) {
}
            
           
        }
    }
}
