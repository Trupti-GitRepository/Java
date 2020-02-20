package cmsc_203_Labs;

import java.util.Scanner;

// This class prints movie details.
public class MovieDriver {
	
	public static void main(String[]args)
	{
		String reply="yes";		
		do{
		//Scanner object that reads from the keyboard
		Scanner input=new Scanner(System.in);
		//object of the Movie class.
		Movie movie =new Movie();
		
		System.out.println("Enter the title of the movie."); // user input to enter the title of a movie. 
		String movieTitle=input.nextLine();
		movie.setTitle(movieTitle); // call method setTitle and pass the movieTitle as an argument..
		
		System.out.println("Please enter the movie rating."); // user input to enter the movie rating. 
	String movieRating=input.nextLine();
		movie.setRating(movieRating);// call method setRating and pass the movieRating as an argument.
		
		System.out.println("Enter the sold tickets."); // user input to enter the sold tickets. 
		int soldTickets=input.nextInt();
			movie.setSoldTickets(soldTickets);// call method setSoldTickets and pass the soldTickets as an argument.
						
			
		String message=movie.toString();//call method toString to print the movie information.		
		System.out.println(message);		
		System.out.println("Do you want to enter another movie.(yes or no)");
		input.nextLine();
		reply=input.nextLine();
		}while(reply.equalsIgnoreCase("yes"));		
				
		//Programmers information.
		System.out.println("\n\nProgrammer : Trupti Thakur");
		
		
		
		
	}
	
	

}
