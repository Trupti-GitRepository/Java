package com.java.mccollege.chap1;

import java.util.Scanner;

/**Calculate the volume of Sphere.
 * 
 * @author trupti
 *
 */
public class SphereVolume {
	
	public static void main(String[] args)
	{
		//Variable declaration.
		double diam,radius,volume;
		
		System.out.println("Enter the diameter of a sphere. :");//prompt user to input sphere diameter.
		Scanner input = new Scanner(System.in);
		diam=input.nextDouble(); //Read diameter.
		
		//Calculate the radius.
		
		radius=diam/2;
		
		//Calculate the volume of the sphere.
		volume=(4/3.0)*(Math.PI)*Math.pow(radius, 3);
		System.out.println("Volume of the Sphere is "+ volume);
		String programerName = "Trupti Thakur.";
		System.out.print("\nProgramer : "+ programerName);
		System.exit(0);
						
	}

}
