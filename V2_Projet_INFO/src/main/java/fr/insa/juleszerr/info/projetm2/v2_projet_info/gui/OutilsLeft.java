/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.FxUtils;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class OutilsLeft extends VBox {
    private ToggleButton bSelect;
    private ToggleButton bPoint;
    private ToggleButton bSegment;
    
public OutilsLeft() {
        this.bSelect = new ToggleButton("select");
        this.bPoint = new ToggleButton("point");
        this.bSegment = new ToggleButton("segment");
        
        ToggleGroup gBoutons = new ToggleGroup();
        this.bSelect.setToggleGroup(gBoutons);
        this.bPoint.setToggleGroup(gBoutons);
        this.bSegment.setToggleGroup(gBoutons);
        
        this.getChildren().addAll(this.bSelect,this.bPoint,this.bSegment);
        FxUtils.setSimpleBorder(this, Color.CYAN, 2);
        
    }   
}
