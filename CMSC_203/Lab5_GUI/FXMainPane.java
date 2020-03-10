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
import javafx.scene.input.MouseEvent;
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
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Button b6;
	
	 private Label label;
	
	private TextField textField; 
	//  declare two HBoxes
	public HBox hbox1;
	public HBox hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	public DataManager dataManager=new DataManager();
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		 
		//student Task #2:
		//  instantiate the buttons, label, and textfield
			this.b1=new Button("Hello");
		 	this.b2=new Button("Howdy");
		 	this.b3=new Button("Chinese");
		 	this.b6=new Button("Hindi");
			this.b4=new Button("Clear");
			this.b5=new Button("Exit");
		
			this.label=new Label("Feedback");
		
			this.textField = new TextField();
		
		
		//  instantiate the HBoxes
			this.hbox1=new HBox();
			this.hbox2=new HBox();
		
		
		
		//student Task #4:
		//  instantiate the DataManager instance
			this.dataManager=new DataManager();
		
		Insets inset=new Insets(20.4);
		
		//  set margins and set alignment of the components
		 HBox.setMargin(b1, inset); 
		 HBox.setMargin(b2, inset); 
		 HBox.setMargin(b3, inset); 
		HBox.setMargin(b4, inset); 
		 HBox.setMargin(b5, inset); 
		 HBox.setMargin(b6, inset); 
		 hbox1.setAlignment(Pos.CENTER);
		 hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		 
			hbox2.getChildren().addAll(label, textField);
			
		//  add the buttons to the other HBox
			hbox1.getChildren().addAll(b1,b2,b3,b6,b4,b5);
			
		//  add the HBoxes to this FXMainPanel (a VBox)
		//VBox vbox=new VBox(10, hbox1, hbox2);
			b1.setOnAction(new ButtonHandler());
			b2.setOnAction(new ButtonHandler());
			b3.setOnAction(new ButtonHandler()); 
			b4.setOnAction(new ButtonHandler());
			b5.setOnAction(new ButtonHandler()) ;
			b6.setOnAction(new ButtonHandler()) ;
			
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	 class ButtonHandler implements EventHandler<ActionEvent>{
		
		
		@Override
		public void handle(ActionEvent event ) {
			// TODO Auto-generated method stub
						
			if(event.getTarget()==b1) {
				textField.setText(dataManager.getHello());
			
				}else if(event.getTarget()==b2) {
					textField.setText(dataManager.getHowdy());
				}else if (event.getTarget()==b3) {
					textField.setText(dataManager.getChinese());
				}else if (event.getTarget()==b4) {
					textField.setText("");
				}else if (event.getTarget()==b6) {
						textField.setText(dataManager.getHindi());
				}else if (event.getTarget()==b5) {
					Platform.exit(); 
					System.exit(0); 

				}
			
		}
	}
}

	
