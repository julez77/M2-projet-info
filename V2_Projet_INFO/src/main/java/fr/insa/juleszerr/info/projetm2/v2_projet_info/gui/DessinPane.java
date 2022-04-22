/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.BLUE;

/**
 *
 * @author IEUser
 */
public class DessinPane extends Pane{
    private MainPanel main;
    
    public DessinPane(MainPanel main) {
        super();
        this.main = main;
        this.redrawAll();
    }
    
    public  void redrawAll() {
        this.getChildren().addAll(this.main.getModel().dessine());       
    }
}
