/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Materiau;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Vecteur2d;
import java.util.Optional;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author IEUser
 */
public class DialogParametreMateriaux extends Dialog<Materiau> {

    
    private ComboBox<String> cbbChoixMaterriau;
    private TextField tfResistanceMax;
    private Vecteur2d force;
    
    
    public DialogParametreMateriaux (){
        
        this.setTitle("Choix du materiau et des caractéristiques");
        this.setResizable(true);
        Label lMateriau = new Label("materiau :");
        Label lResistanceMax = new Label("resistance max :");
        
        
        
        this.cbbChoixMaterriau = new ComboBox<String>();
        cbbChoixMaterriau.getItems().addAll("ACIER","BOIS","BAMBOO","PLASTIQUE","ACIER A FAIBLE TENEUR EN CARBONNE (DOUX)","ACIER ELECTRIQUE","ACIER MARAGING",
            "FEUILLETAGE D'ACIER SANDVIK","ACIER DE CLAPET A BATTANT UDDEHOLMSTRIP","ACIER INOXIDABLE","AUTRE");
        cbbChoixMaterriau.setMinWidth(400);
        cbbChoixMaterriau.visibleRowCountProperty().set(4);
        cbbChoixMaterriau.setPromptText("Selectionnez un materiau");
        this.tfResistanceMax = new TextField("Indiquez sa resistance max");
        
        GridPane grid = new GridPane();
        //grid.add(lMateriau, 0, 0);
        grid.add(cbbChoixMaterriau, 0, 0);
        //grid.add(lResistanceMax, 0, 1);
        grid.add(this.tfResistanceMax, 0, 1);
        
        this.getDialogPane().setContent(grid);

        ButtonType bOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        //ButtonType bCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        this.getDialogPane().getButtonTypes().add(bOK);
        //this.getDialogPane().getButtonTypes().add(bCancel);

        this.setResultConverter((p) -> {
            if (p == bOK) {
                double effort;
                
                try {
                    effort = Double.parseDouble(this.tfResistanceMax.getText());
                   
                } catch (NumberFormatException ex) {
                    return null;
                }
                return new Materiau(cbbChoixMaterriau.getValue(), effort);
            } else {
                return null;
            }
        }
        );
    }
    static Optional<Materiau> demandeMateriau() {
        DialogParametreMateriaux dialog= new DialogParametreMateriaux();
        return dialog.showAndWait();
    }
    
}
