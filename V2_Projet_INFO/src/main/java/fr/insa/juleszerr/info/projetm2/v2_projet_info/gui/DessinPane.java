/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
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
    }
}
