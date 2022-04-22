/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.Groupe;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class MainFX extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception{
       Groupe test = Groupe.groupeTest();
       System.out.println("nb barre"+ test.getListebarre().size()+"nbnoeud"+test.getListenoeud().size());
       MainPanel main = new MainePanel(test);
    }
}
