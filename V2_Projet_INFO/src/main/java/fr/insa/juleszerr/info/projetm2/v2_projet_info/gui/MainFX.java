/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
        InputStream is = this.getClass().getResourceAsStream("icones/pont.png");
        primaryStage.getIcons().add( new Image(is,32,32,false,true));
        //Image image = new Image(this.getClass().getResourceAsStream("icones/OurseModel.png"));
        //Background bg = new Background(new BackgroundImage(image, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        //main.setBackground(bg);
        main.setStyle("-fx-background-color: #fdfbf3; ");
        primaryStage.setScene(s);
        primaryStage.show();
        this.main.getControleur().boutonAide(new ActionEvent());
        //this.main.getControleur().boutonDefTreillis(new ActionEvent());

        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}