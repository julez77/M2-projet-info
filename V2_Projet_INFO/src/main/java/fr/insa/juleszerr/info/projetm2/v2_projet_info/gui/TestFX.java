package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

// Program to create a menubutton and add menuitems to it
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
public class TestFX extends Application {
// labels
    Label l;
 
    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("creating MenuButton ");
 
        // create a tile pane
        TilePane r = new TilePane();
 
        // create a label
        Label l1 = new Label("This is a MenuButton example ");
 
        // create a menu
        MenuButton m = new MenuButton("MenuButton");
 
        // create menuitems
        MenuItem m1 = new MenuItem("menu item 1");
        MenuItem m2 = new MenuItem("menu item 2");
        MenuItem m3 = new MenuItem("menu item 3");
 
        // add menu items to menu
        m.getItems().add(m1);
        m.getItems().add(m2);
        m.getItems().add(m3);
 
        // label to display the selected menuitem
        Label l2 = new Label("default menuitem selected");
 
        // create action event
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l2.setText(((MenuItem)e.getSource()).getText() + " selected");
            }
        };
 
        // add action events to the menuitems
        m1.setOnAction(event1);
        m3.setOnAction(event1);
        m2.setOnAction(event1);
 
        // create a tilepane
        TilePane vb = new TilePane(l1);
 
        vb.getChildren().add(m);
        vb.getChildren().add(l2);
 
        // create a scene
        Scene sc = new Scene(vb, 200, 200);
 
        // set the scene
        s.setScene(sc);
 
        s.show();
    }
 
    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}