/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Vecteur2d;
import java.awt.Point;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author IEUser
 */
public class DialogParametreForce extends Dialog<Vecteur2d> {

    
    
    private TextField tfNormeForce;
    private TextField tfAngleForce;
    private Vecteur2d force;
    
    
    public DialogParametreForce (){
        this.force = new Vecteur2d(0, 0);
        this.setTitle("Parametrage de la force");
        this.setResizable(true);
        
        Label lNorme = new Label("                         Norme :     ");
        Label lAngle = new Label("                         Angle :     ");
        
        this.tfAngleForce = new TextField("0.0                        ");
        this.tfNormeForce = new TextField("0.0                        ");
        
        GridPane grid = new GridPane();
        grid.add(lNorme, 0, 0);
        grid.add(this.tfNormeForce, 1, 0);
        grid.add(lAngle, 0, 1);
        grid.add(this.tfAngleForce, 1, 1);
        
        this.getDialogPane().setContent(grid);
        

        ButtonType bOK = new ButtonType("OK", ButtonData.OK_DONE);
        ButtonType bCancel = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
        this.getDialogPane().getButtonTypes().add(bOK);
        this.getDialogPane().getButtonTypes().add(bCancel);

        this.setResultConverter((p) -> {
            if (p == bOK) {
                double norme;
                double angle;
                try {
                    norme = Double.parseDouble(this.tfNormeForce.getText());
                    angle = Double.parseDouble(this.tfAngleForce.getText());
                } catch (NumberFormatException ex) {
                    return null;
                }
                return force.ForceAvecAngleNorme(angle, norme);
            } else {

                return null;
            }
        }
        );
    }
    static Optional<Vecteur2d> demandeForce() {
        DialogParametreForce dialog= new DialogParametreForce();
        return dialog.showAndWait();
    }
    
}
