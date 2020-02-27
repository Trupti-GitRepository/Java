package com.java.cmsc203.assignment2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.JOptionPane;

//Driver class Birthday, using Toy class, helps to decided to purchase birthday gifts for the young children.
public class Birthday {

	public static void main(String[] args)
	{
		String name, card, toyChoice, ballon="", reply="";
		int age;
		double cost,totalCost=0;
		
		// Display welcome message.
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for your children");
		
		//User input name of the child and store it in variable "name".
		do {
		name = JOptionPane.showInputDialog("Enter the name of the child.");
		
		//User input age of the child and store it in "age" variable..
		age = Integer.parseInt(JOptionPane.showInputDialog("How old is the child.?"));
		
		//Take user input for the child toy choice and save in the variable "toyChoice".
		toyChoice = JOptionPane.showInputDialog("Choose a toy : a plushie, blocks, or a book.");
		
		// Call constructor of a Toy class and pass toyChoice, age as arguments. 
		Toy toy = new Toy(toyChoice, age);
		
		// Validate toy choice.
		while(!toy.ageOK()) 
			{
			JOptionPane.showMessageDialog(null, "The Toy is not age appropriate. ");
			// User input to modify order.
			reply=JOptionPane.showInputDialog("Do you want to select different Toy ? Yes or No");
			
			if(reply.equalsIgnoreCase("yes"))
				{
				toyChoice = JOptionPane.showInputDialog("Choose a toy : a plushie, blocks, or a book.");
				toy.setToy(toyChoice);
				if(!toy.ageOK())
					continue;
				}else break;
			
			}
		
		toy.setCost(toyChoice); // SetToy choice
		// Take a user Input if card should be added to the gift.
		//save the response in card variable.
		card = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
		// If yes then call addCost of the toy object
			if (card.equalsIgnoreCase("Yes")) 
				{
				toy.addCard(card);
			
				}
		
		//Take a user Input if balloon should be added to the gift.
		//Save the response in balloon variable.
		ballon=JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
			if (ballon.equalsIgnoreCase("Yes")) 
				{
				toy.addBalloon(ballon);
				}
			
		
		// Calculate the gift price. Display the child name, age and the total gift cost.
		
			cost=toy.getCost();
		// Total cost
			totalCost +=cost;
		
		NumberFormat dollar =NumberFormat.getCurrencyInstance();
		
		
		//
		System.out.println("The gift for " + name +" " + age + " " + "years old is " + dollar.format(cost));
		
		// User input foe another Toy.
		reply=JOptionPane.showInputDialog("Do you want to purchase another toy ?");
		}while(reply.equalsIgnoreCase("yes"));
		
		// Generating order number.
		int origin =10000;
		Random randomNumber=new Random();
		long orderNumber=randomNumber.nextInt(10000)+origin;
		
		//Format cost.
		NumberFormat dollar =NumberFormat.getCurrencyInstance();
		
		//Display Total order cost, order number .
		System.out.println("\nTotal cost of the purchase is "+ dollar.format(totalCost) + "\nOrder number is : "+ orderNumber + "\n\nProgrammer : Trupti Thakur.");
		

	}
	

}
