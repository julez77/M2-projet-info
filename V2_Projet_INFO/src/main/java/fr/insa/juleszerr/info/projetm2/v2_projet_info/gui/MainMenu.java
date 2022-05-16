/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;

/**
 *
 * @author IEUser
 */
public class MainMenu extends MenuBar{
    private MainPane main;
    
    public MainMenu (MainPane main){
        this.main = main;
        Menu file = new Menu("Fichier");
        
        MenuItem nouveau = new MenuItem("Nouveau");
        nouveau.setOnAction((t) -> {
            this.main.getControleur().menuNouveau(t);
        });
        Button save = new Button("Sauvegarder");
        save.setOnAction((t) -> {
            this.main.getControleur().menuSave(t);
        });
        MenuItem saveAs = new MenuItem("Sauvegarder sous...");
        saveAs.setOnAction((t) -> {
            this.main.getControleur().menuSaveAs(t);
        });
        MenuItem load = new MenuItem("Ouvrir");
        load.setOnAction((t) -> {
            this.main.getControleur().menuOpen(t);
        });        
        file.getItems().addAll(nouveau,saveAs,load);
        
        Menu help = new Menu("Aide");
        MenuItem racourci = new MenuItem("Racourci clavier");
        racourci.setOnAction((t) -> {
            this.main.getControleur().menuRacourci(t);
        });
        
        MenuItem apropos = new MenuItem("A propos");
        apropos.setOnAction((t) -> {
            this.main.getControleur().menuApropos(t);
        });
        
        help.getItems().addAll(racourci, apropos);
        
        Menu outils = new Menu("Outils");
        RadioMenuItem afficheBarOutils = new RadioMenuItem("Afficher la bar d'outils");
        afficheBarOutils.setOnAction((t) -> {
            this.main.getControleur().menuAfficherBarOutils(t);
        });         
        outils.getItems().addAll(afficheBarOutils);
        
        this.getMenus().addAll(file, help, outils);
    }
}
