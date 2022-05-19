/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class MainFX extends Application  {
    private MainPane main;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
      Treillis test;
        test = new Treillis();
            System.out.println("taille " + test.getElements().size());
        
        this.main = new MainPane(primaryStage,test);
        Scene s = new Scene(main,1500,900);
        primaryStage.resizableProperty();
        primaryStage.setTitle("super  projet d'info");
        primaryStage.getIcons().add( new Image("https://upload.wikimedia.org/wikipedia/fr/thumb/8/86/Paris_Saint-Germain_Logo.svg/800px-Paris_Saint-Germain_Logo.svg.png"));
        main.setStyle("-fx-background-color: #fdfbf3; ");
        primaryStage.setScene(s);
        primaryStage.show();
        this.main.getControleur().boutonAide(new ActionEvent());
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}