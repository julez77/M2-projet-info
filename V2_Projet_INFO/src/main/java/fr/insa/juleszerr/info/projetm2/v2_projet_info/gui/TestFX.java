package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TestFX extends Application {
   @Override
   public void start(Stage stage) {
     //creating label email
      Text text1 = new Text("Email");

     //creating label password
      Text text2 = new Text("Password");

     //Creating Text Filed for email
      TextField textField1 = new TextField();

     //Creating Text Filed for password
      TextField textField2 = new TextField();

     //Creating Buttons
      Button button1 = new Button("Submit");
      Button button2 = new Button("Clear");

     //Creating a Grid Pane
      GridPane gridPane = new GridPane();

     //Setting size for the pane
      gridPane.setMinSize(400, 200);

     //Setting the padding
      gridPane.setPadding(new Insets(10, 10, 10, 10));

     //Setting the vertical and horizontal gaps between the columns
      gridPane.setVgap(5);
      gridPane.setHgap(5);

     //Setting the Grid alignment
      gridPane.setAlignment(Pos.CENTER);

     //Arranging all the nodes in the grid
      gridPane.add(text1, 0, 0);
      gridPane.add(textField1, 1, 0);
      gridPane.add(text2, 0, 1);
      gridPane.add(textField2, 1, 1);
      gridPane.add(button1, 0, 2);
      gridPane.add(button2, 1, 2);

     //Creating a scene object
      Scene scene = new Scene(gridPane);

     //Setting title to the Stage
      stage.setTitle("Grid Pane Example");

     //Adding scene to the stage
      stage.setScene(scene);

     //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}









/*// Program to create a menubutton and add menuitems to it
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
}*/