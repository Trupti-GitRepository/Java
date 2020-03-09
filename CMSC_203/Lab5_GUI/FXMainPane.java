package com.java.cmsc_203_Lab5;




import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button myButton1=new Button("Heelo");
	Button myButton2=new Button("Howdy");
	Button myButton3=new Button("Chinese");
	Button myButton4=new Button("Clear");
	Button myButton5=new Button("Exit");
	
	Label label=new Label("Feedback");
	
	TextField textField = new TextField();
	//  declare two HBoxes
	HBox hbox1=new HBox();
	HBox hbox2=new HBox();
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		
		//  instantiate the HBoxes
		hbox1.getChildren().addAll(myButton1,myButton2,myButton3,myButton3,myButton4,myButton5);
		hbox2.getChildren().addAll(label, textField);
		
		
		//student Task #4:
		//  instantiate the DataManager instance		
		DataManager dataManager=new DataManager();
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		VBox vbox=new VBox(10, hbox1, hbox2);
		vbox.setAlignment(Pos.CENTER);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	//myButton1.setOnAction(new ButtonClickHandler())
	//myButton2.setOnAction(new ButtonHandler())
	//myButton3.setOnAction(new ButtonHandler()) 
	//myButton4.setOnAction(new ButtonHandler())
	//myButton5.setOnAction(new ButtonHandler()) 
}
	
