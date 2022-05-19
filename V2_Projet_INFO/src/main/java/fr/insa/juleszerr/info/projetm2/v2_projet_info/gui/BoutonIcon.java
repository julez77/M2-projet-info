/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;


import java.io.InputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author IEUser
 */
public class BoutonIcon extends Button {
    public BoutonIcon(String relPathOfImageFile, double sizeX, double sizeY) {        
        InputStream is = this.getClass().getResourceAsStream(relPathOfImageFile);
        if (is == null) {
            this.setText("?? " + relPathOfImageFile);
        } else {
            Image img = new Image(is, sizeX, sizeY, false, true);
            this.setGraphic(new ImageView(img));
            this.setStyle("-fx-background-color: #fccf97; ");

        }

    }
    
}
