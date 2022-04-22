/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class OutilsTop extends HBox {
    private ColorPicker couleur;
    private Button zoomIn;
    private Button zoomOut;
    
    public OutilsTop() {
        this.couleur = new ColorPicker(Color.BLACK);
        this.zoomIn = new Button("Zoom *2");
        this.zoomOut = new Button("Zoom /2");
        
        this.getChildren().add(this.couleur);
        this.getChildren().add(this.zoomIn);
        this.getChildren().add(this.zoomOut);
        
    }
}
