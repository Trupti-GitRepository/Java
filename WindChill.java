package com.java.mccollege.chap1;


import java.util.Scanner;


// This program will calculate the wind chill temperature in degrees Fahrenheit. 
/*
 * Wind Chill (oF) = 35.74 + 0.6215T - 35.75(V0.16) + 0.4275T(V0.16), where V is
 * the Wind Speed in MPH, and T is the temperature in degrees F.
 */

public class WindChill {

	public static void main(String[] args) { // main method.

		System.out.println("\t\tWind Chill Calculator.\n");
		
		//Variable Declaration.
		double fahTemp, windSpeed, windChill;
		
		//User Input
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the temperature in Fahrenheit (must be >= -45 and <= 40):");
		fahTemp = Double.parseDouble(userInput.nextLine());
		System.out.println("Enter the Wind Speed (must be >= 5 and <= 60):");
		windSpeed = Double.parseDouble(userInput.nextLine());
		
		//Calculate the Wind Chill.
		windChill = 35.74 + (0.6215 * fahTemp) - (35.75 * (Math.pow(windSpeed, 0.16)))
				+ (0.4275 * fahTemp * (Math.pow(windSpeed, 0.16)));
		
		//Display Wind Chill Temperature.
		System.out.println("Wind chill temperature:  " + windChill + " degrees Fahrenheit.");
		
		//Display Programer's name.
		String programerName = "Trupti Thakur.";
		System.out.print("\nProgramer : "+ programerName);
		System.exit(0);

	}

}
