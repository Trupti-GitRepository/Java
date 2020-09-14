

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;




public class PasswordMain extends BorderPane
{
	private Label passwordLabel, passwordALabel, instruction1Label, instruction2Label,instruction3Label,instruction4Label;
	private Label instruction5Label, instruction6Label,instruction7Label,instruction8Label;
	//private PasswordField passwordText, passwordAText ;
	private TextField passwordText, passwordAText ;
	private TextField passwordText0, passwordAText0 ;
	private ArrayList<String> illegalPasswords;
	private Button checkPwdButton, exitButton, checkPwdsInFileButton;
	DecimalFormat format = new DecimalFormat("#0.000");
	private Alert alert = new Alert(AlertType.INFORMATION);
	//PasswordCheckerUtility pwdChecker;
	
	public PasswordMain()
	{
		//pwdChecker = new PasswordCheckerUtility();
		illegalPasswords = new ArrayList<String>();
		
		VBox subpanel = new VBox();
		instruction1Label = new Label("Use the following rules when creating your passwords:");
		instruction2Label = new Label("\t1.  Length must be greater than 6; a strong password will contain at least 10 characters");
		instruction8Label = new Label("\t2.  Between 6 and 9 characters is a weak (but acceptable) password.");
		instruction3Label = new Label("\t3.  Must contain at least one upper case alpha character");
		instruction4Label = new Label("\t4.  Must contain at least one lower case alpha character");
		instruction5Label = new Label("\t5.  Must contain at least one numeric charcter");
		instruction7Label = new Label("\t6.  Must contain at least one special charcter");
		instruction6Label = new Label("\t7.  May not have more than 2 of the same character in sequence");
		VBox.setMargin(instruction1Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction2Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction8Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction3Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction4Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction5Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction7Label, new Insets(2,10,2,10));
		VBox.setMargin(instruction6Label, new Insets(2,10,2,10));

		subpanel.setAlignment(Pos.CENTER_LEFT);
		subpanel.getChildren().addAll(instruction1Label, instruction2Label,instruction8Label, instruction3Label,
				instruction4Label, instruction5Label,instruction7Label, instruction6Label);
		
		HBox subpanel1a = new HBox();
		passwordLabel = new Label ("Enter the Password");
		//passwordText = new PasswordField();
		passwordText = new TextField();
		passwordText0 = new TextField();
		HBox.setMargin(passwordLabel, new Insets(10,10,10,10));
		HBox.setMargin(passwordText, new Insets(10,10,10,10));
		subpanel1a.setAlignment(Pos.CENTER);
		subpanel1a.getChildren().addAll(passwordLabel, passwordText);
		
		HBox subpanel1b = new HBox();
		passwordALabel = new Label ("Re-type Password");
		//passwordAText = new PasswordField();
		passwordAText = new TextField();
		passwordAText0 = new TextField();
		HBox.setMargin(passwordALabel, new Insets(10,10,10,10));
		HBox.setMargin(passwordAText, new Insets(10,10,10,10));
		subpanel1b.setAlignment(Pos.CENTER);
		subpanel1b.getChildren().addAll(passwordALabel, passwordAText);
		
		VBox subpanel1 = new VBox();
		VBox.setMargin(subpanel1a, new Insets(10,10,10,10));
		VBox.setMargin(subpanel1b, new Insets(10,10,10,10));
		subpanel1.setAlignment(Pos.CENTER);
		subpanel1.getChildren().addAll(subpanel1a, subpanel1b);
				
		checkPwdsInFileButton = new Button("Check Passwords in _File");
		checkPwdsInFileButton.setMnemonicParsing(true); 
		checkPwdsInFileButton.setTooltip(new Tooltip("Select to read passwords from a file"));
		checkPwdsInFileButton.setOnAction(
        		event -> {
        			try {
						readFile();
					} catch (Exception e) {
						e.printStackTrace();
					}
        		});
		
		checkPwdButton = new Button ("Check _Password");
		checkPwdButton.setMnemonicParsing(true); 
		checkPwdButton.setTooltip(new Tooltip("Select to check a password."));
		checkPwdButton.setOnAction(
        		event -> {
        			addPassword();
        		});
		
		exitButton = new Button("E_xit");
		//_ in label specifies that the next character is the mnemonic, ie, type Alt-e as a shortcut
	    //this activates the mnemonic on exitButton when the Alt key is pressed
	    exitButton.setMnemonicParsing(true);  
	    exitButton.setTooltip(new Tooltip("Select to close the application"));
	    //use a lambda expression for the EventHandler class for exitButton
	    exitButton.setOnAction(
        		event -> {
	            	 Platform.exit();
	                 System.exit(0);
        		}
        	);
		 
	
		HBox buttonPanel = new HBox();
		HBox.setMargin(checkPwdButton, new Insets(10,10,10,10));
		HBox.setMargin(checkPwdsInFileButton, new Insets(10,10,10,10));
		HBox.setMargin(exitButton, new Insets(10,10,10,10));
		buttonPanel.setAlignment(Pos.CENTER);
		buttonPanel.getChildren().addAll(checkPwdButton, checkPwdsInFileButton, exitButton);

		//panelContainer = new 
		setTop(subpanel);
		setCenter(subpanel1);
		setBottom(buttonPanel);

	
	}

	public void addPassword() {
		//Get information
		
		String passwordString = passwordText.getText();
		String passwordAString = passwordAText.getText();
		try
		{
			if (passwordString.compareTo(passwordAString)!=0)
				throw new UnmatchedException();
			if (PasswordCheckerUtility.isValidPassword(passwordString)) {
				if (PasswordCheckerUtility.isWeakPassword(passwordString)) {
					//alert.setContentText("Password is OK but weak");
					//alert.showAndWait();
					JOptionPane.showMessageDialog(null, "Password is OK but weak", "Password Status", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					//alert.setContentText("Password is valid");
					//alert.showAndWait();
					JOptionPane.showMessageDialog(null, "Password is valid", "Password Status", JOptionPane.PLAIN_MESSAGE);
				}	
			}
		}
		catch (UnmatchedException ex)
		{
			alert.setContentText(ex.getMessage());   //need to revert if require
			alert.setContentText("Both password doesn't match. Please re-enter the password.");
			alert.showAndWait();
			passwordText.clear();
			passwordAText.clear();
			//addPassword();
			//JOptionPane.showMessageDialog(null, ex.getMessage(), "Password Status", JOptionPane.PLAIN_MESSAGE);
		}
		catch (Exception ex)
		{
			//alert.setContentText(ex.getMessage());
			//alert.showAndWait();
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Password Error", JOptionPane.PLAIN_MESSAGE);
			passwordText.clear();
			passwordAText.clear();
		}			
	}


	//Listens for the Display Apps button to be pressed
	private class displayIllegalPasswords implements ActionListener
	{
		public void actionPerformed (ActionEvent theEvent)
		{
			String result = "";
			for(String temp:illegalPasswords)
				result += temp + "\n";
			//alert.setContentText("Illegal Passwords\n"+" " + result);
			
			//alert.showAndWait();
			JOptionPane.showMessageDialog(null, result, "Invalid Passwords", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void readFile() throws IOException, LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialSymbolException, Exception {
			FileChooser chooser = new FileChooser();
			Scanner input;
			File selectedFile = chooser.showOpenDialog(null);  // revert if need 
				if(selectedFile != null)
			   {
				ArrayList<String> passwords = new ArrayList<String>();
				String results = "";
				try{
				input = new Scanner(selectedFile);
				
				
				while(input.hasNext())
				{
					passwords.add(input.next());
				}
				illegalPasswords = PasswordCheckerUtility.invalidPasswords(passwords);
				for(String passwordString : illegalPasswords)
					results += passwordString +"\n";
				//alert.setContentText("Illegal Passwords\n"+results);
				//alert.showAndWait();
				
				
				JOptionPane.showMessageDialog(null, results, "Invalid Passwords", JOptionPane.PLAIN_MESSAGE);
			}// end of try
				catch(FileNotFoundException ex)
				{
					//alert.setContentText("File Error\n" + ex.toString());
				//	alert.showAndWait();
					JOptionPane.showMessageDialog(null, ex.toString(), "File Error", JOptionPane.PLAIN_MESSAGE);
					ex.printStackTrace();
				}
			}
		}
}