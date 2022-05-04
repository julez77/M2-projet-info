/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;


import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class OutilsLeft extends VBox {
    private ToggleButton bSelect;
    private MenuItem bNoeudSimple;
        private MenuItem bAppuiSimple;
    private MenuItem bAppuiGlissant;

    private ToggleButton bBarre;
    private MenuButton bMenu; 
    
public OutilsLeft() {
        this.bMenu = new MenuButton("Nouveau Noeud");
        
        bMenu.getItems().addAll(this.bNoeudSimple = new MenuItem("Noeud Simple"),
            this.bAppuiGlissant = new MenuItem("Appuis Glissant"),
            this.bAppuiSimple = new MenuItem("Appuis Simple"),
            new MenuItem("Hot Dog")
        );
        
        this.bSelect = new ToggleButton("select");
        this.bBarre = new ToggleButton("Barre");
         this.bBarre.setOnAction(((ActionEvent t) -> {
            System.out.println("Barre clicked");
        }));
        
        ToggleGroup gBoutons = new ToggleGroup();
        this.bSelect.setToggleGroup(gBoutons);
        this.bBarre.setToggleGroup(gBoutons);
        
         this.bSelect.setOnAction((ActionEvent t) -> {
            System.out.println("select clicked ");
        });
        this.bAppuiGlissant.setOnAction((ActionEvent t) -> {
            System.out.println("Appuis Glissant clicked");
             
        });
        /*this.bNoeudSimple.setOnAction((MouseEvent t)-> {
            System.out.println("clic dans dessin");
            NoeudSimple n = new NoeudSimple(t.getX(), t.getY());
            n.dessine();
        });*/
        this.bNoeudSimple.setOnAction(((ActionEvent t) -> {
            System.out.println("Noeud Simple clicked");
  
             
        }));
        
        
        
        
        
        
        this.getChildren().addAll(this.bSelect,this.bMenu,this.bBarre);
        FxUtils.setSimpleBorder(this, Color.CYAN, 2);
        
    }   
}
