/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import static fr.insa.juleszerr.info.projetm2.Lire.f;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud;
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
        
        clip.widthProperty().bind(this.widthProperty());
        
        this.setClip(clip);
        
        this.setOnMouseClicked((t)->{
          System.out.println("px2 = "+ t.getX() +"; py2 = "+ t.getY());
          this.main.getControleur().clicDansDessin(t);
          //this.redrawAll();
        });
        
        

        this.redrawAll();
    }
    
    public  void redrawAll() {
        this.getChildren().clear();
        this.getChildren().addAll(this.main.getTreillis().dessine());  
        List<Figure> select = this.main.getControleur().getSelection();
        List<Barre> barreContientForce = this.main.getTreillis().barres3();
        List<Noeud> noeudsContraint = this.main.getTreillis().noeuds3();
        
        if(! select.isEmpty()){
            if (this.main.getControleur().getEtat() == Etat.SELECT) {

                 for (Figure f : select){
                this.getChildren().addAll(f.dessineSelection());
            }
            }   
        }else if(this.main.getControleur().isResolu() == true) {
            System.out.println("Dessine couleur");
            List<Barre> barreForceCroissante1 = this.main.getTreillis().BarresTriees1();
            List<Barre> barreForceCroissante2 = this.main.getTreillis().BarresTriees2();
            int pasVert = this.main.getTreillis().QuantiteVert();
            int pasRouge = this.main.getTreillis().QuantiteRouge();
            int totVert = 255;
            int totRouge = 0;
            for (Barre b : barreForceCroissante1){
                this.getChildren().addAll(b.dessinForceCroissante(totVert, totRouge));
                totRouge+=pasRouge;
               
            }
            totVert = 255;
            totRouge = 255;
            for (Barre b : barreForceCroissante2){
                this.getChildren().addAll(b.dessinForceCroissante(totVert, totRouge));
                totVert-=pasVert;
               
            }
            /*
            for(Barre b : barreContientForce){
                this.getChildren().addAll(b.dessineForce());
            }*/
            for(Noeud n : noeudsContraint){
                this.getChildren().addAll(n.dessine());
            }
        
            
           
        }
    }

   
}
