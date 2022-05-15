/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
;import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class MainFX extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception{
      Treillis test;
        test = new Treillis();
            System.out.println("taille " + test.getElements().size());
        
        MainPane main = new MainPane(primaryStage,test);
        Scene s = new Scene(main,800,600);
        //primaryStage.setFullScreen(true);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}