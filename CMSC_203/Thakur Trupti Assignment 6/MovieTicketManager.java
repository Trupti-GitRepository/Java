//

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

/**
 * MovieTicket Manager manages four types of tickets and prints reports.
 *implements MovieTicketInteface.
 * @author Trupti Thakur
 *
 */
public class MovieTicketManager implements MovieTicketManagerInterface {

	//private NumberFormat currencyFormat;
	private String currFormat="$%.2f";
	private ArrayList<Ticket> ticketList;
	private int numberOfVisits;

	/**
	 * No-arg constructor.
	 */
	public MovieTicketManager() {
		ticketList = new ArrayList<Ticket>();
	}
	
	/**
	 * Returns the number of times this patron has visited the theater this month
	 * @param id of the patron
	 * @return the number of times this patron has visited the theater this month
	 */
	public int numVisits(int id) {
		int counter=0;
		if(ticketList!=null && ticketList.size()>0) {
			for(Ticket t:ticketList) {
				if((t instanceof MoviePass || t instanceof Employee) && t.id==id) {
					counter++;
				}
			}
		}
		
		this.numberOfVisits=counter;
		
		return counter;
	}
	
	
	/**
	 * Checks to see if this patron already saw a movie today
	 * @param id id of patron
	 * @param date current date
	 * @return number of movies the patron has seen today
	 */	
	public int numMoviesToday(int id, int date) {
		int numMoviesToday=0;
		for(Ticket t:ticketList) {
			if((t instanceof MoviePass || t instanceof Employee) &&  t.id==id && t.day==date) {
				numMoviesToday++;
			}
		}
		
		return numMoviesToday;
				
	}
	/**
	 * Adds a patron to the list and returns the ticket price
	 * @param m movie to be watched
	 * @param rating movie rating
	 * @param d date
	 * @param t time
	 * @param f feature
	 * @param type type of patron
	 * @param id id of the patron
	 * @return the price of the ticket. Returns -1 if type is invalid
	 */
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
			
			
			Ticket t1=null;
			TicketType tt=TicketType.getTicktType(type);
			switch(tt) {
			case ADUlT:
				t1=new Adult( movieN,rating,d,t,f,type,id);
				break;
			case CHILD:
				t1=new Child( movieN,rating,d,t,f,type,id);
				break;
			case EMPLOYEE:
				t1=new Employee( movieN,rating,d,t,f,type,id);
				break;
			case MOVIEPASS:	
				t1=new MoviePass( movieN,rating,d,t,f,type,id);
			}
			ticketList.add(t1);
			t1.setTicketList(ticketList);
			if(t1 instanceof MoviePass || t1 instanceof Employee) {
				t1.countVisits();
			}
			return t1.calculateTicketPrice();                                                            
		
	}
	/**
	 * Returns total sales 
	 * @return total  sales .
	 */
	public double totalSalesMonth() {
		//Ticket t=new Ticket;
		
		double totalSale=0;
		
		for(Ticket t: ticketList) {
			
			totalSale+=t.calculateTicketPrice();
			//totalSale=t.totalSales;
		}
		//return Double.parseDouble(String.format("%.2f", totalSale));
	  return totalSale;
	}
	

	/**
	 * Returns the sales for the entire month
	 * @return the sales for the entire month
	 */
	public String monthlySalesReport() {
		StringBuilder opBuilder=new StringBuilder();
		opBuilder.append("\tMonthly Sales Report");
		opBuilder.append("\n\n");
		opBuilder.append("\t\t\tSales");
		opBuilder.append("\t");
		opBuilder.append("Numbers");
		opBuilder.append("\n");
		double adultSale=0,childSale=0,employeeSale=0,moviePSale=0;
		int adultc=0, childC=0, employeec=0, MoviePC=0;
		for(Ticket t: ticketList) {
			if(t instanceof Adult) {
				adultSale+=t.calculateTicketPrice();
				adultc++;
			}else if(t instanceof Child) {
				childSale+=t.calculateTicketPrice();
				childC++;
			}
			else if(t instanceof Employee) {
				employeeSale+=t.calculateTicketPrice();
				employeec++;
			}
			else {
				moviePSale+=t.calculateTicketPrice();
				MoviePC++;
			}
		}
		
		opBuilder.append("ADULT");
		opBuilder.append("\t\t");
		opBuilder.append(String.format(currFormat, adultSale));
		opBuilder.append("\t");
		opBuilder.append(adultc);
		opBuilder.append("\n");
		opBuilder.append("CHILD");
		opBuilder.append("\t\t");
		opBuilder.append(String.format(currFormat, childSale));
		opBuilder.append("\t");
		opBuilder.append(childC);
		opBuilder.append("\n");
		opBuilder.append("EMPLOYEE");
		opBuilder.append("\t");
		opBuilder.append(String.format(currFormat, employeeSale));
		opBuilder.append("\t");
		opBuilder.append(employeec);
		opBuilder.append("\n");
		opBuilder.append("MOVIEPASS");
		opBuilder.append("\t");
		opBuilder.append(String.format(currFormat, moviePSale));
		opBuilder.append("\t");
		opBuilder.append(MoviePC);
		opBuilder.append("\n\nTotal Monthly Sales: "+String.format(currFormat, (adultSale+childSale+employeeSale+moviePSale)));
		return opBuilder.toString();
	}
	
	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * use the toString of each Ticket in the ticketList
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	public ArrayList<String> getAllTickets() {
		Collections.sort(ticketList,new Comparator<Ticket>(){

			@Override
			public int compare(Ticket o1, Ticket o2) {
				int day1=o1.toString().indexOf("Day: ");
				int day2=o2.toString().indexOf("Day: ");
				
				String dString1=o1.toString().substring(day1, day1+6);
				String dString2=o2.toString().substring(day2, day2+6);
				return dString1.compareTo(dString2);
			}
			
		} 
		);
		ArrayList<String> opList=new ArrayList<>();
		for(Ticket t:ticketList) {
			opList.add(t.toString());
		}
		return opList;
		
	}
	
	/**
	 * Returns an arraylist of strings that represent 3D tickets sorted by day
	 * @return an arraylist of strings that represent 3D tickets sorted by day
	 */
	public ArrayList<String> get3DTickets() {
	
		ArrayList<String> ThreDTickets=new ArrayList<>();
		for(Ticket t:ticketList) {
			if(t.format==Ticket.Format.THREE_D) {
				ThreDTickets.add(t.toString());
			}
		}
		Collections.sort(ThreDTickets,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int day1=o1.indexOf("Day: ");
				int day2=o2.indexOf("Day: ");
				
				String dString1=o1.toString().substring(day1, day1+6);
				String dString2=o2.toString().substring(day2, day2+6);
				return dString1.compareTo(dString2);
			}}
		);
		                                                       
		return ThreDTickets;
	}
	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * use the toString of each Ticket in the ticketList
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	public ArrayList<String> getMoviePassTickets() {
		
		ArrayList<String> moviePassTickets=new ArrayList<>();
		for(Ticket t:ticketList) {
			if(t instanceof MoviePass) {
				moviePassTickets.add(t.toString());
			}
		}
		Collections.sort(moviePassTickets,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int mpass1=o1.indexOf(" ", 10);
				int mpass2=o2.indexOf(" ", 10);
				String dString1=o1.toString().substring(0, mpass1);
				String dString2=o2.toString().substring(0, mpass2);
				return dString1.compareTo(dString2);
			}}
		);
			
		return moviePassTickets;
	}
	
	/**
	 * Reads from a file and populates an arraylist of Ticket objects
	 * @param file file to be read from
	 * @throws FileNotFoundException when file is not found
	 */
	public void readFile(File file) throws FileNotFoundException {
		Scanner s = new Scanner(file);      //"src\\tickets.txt")
		
		while (s.hasNextLine()){
			String[] line=s.nextLine().split(":");
			Ticket t=null;
			TicketType tt=TicketType.getTicktType(line[5]);
			switch(tt) {
			case ADUlT:
				t=new Adult(line[0], line[1], Integer.valueOf(line[2]), Integer.valueOf(line[3]),line[4],line[5],Integer.valueOf(line[6]));
				
				break;
			case CHILD:
				t=new Child(line[0], line[1], Integer.valueOf(line[2]), Integer.valueOf(line[3]),line[4],line[5],Integer.valueOf(line[6]));
				break;
			case EMPLOYEE:
				t=new Employee(line[0], line[1], Integer.valueOf(line[2]), Integer.valueOf(line[3]),line[4],line[5],Integer.valueOf(line[6]));
				break;
			case MOVIEPASS:	
				t=new MoviePass(line[0], line[1], Integer.valueOf(line[2]), Integer.valueOf(line[3]),line[4],line[5],Integer.valueOf(line[6]));
				
			}
			ticketList.add(t);
			t.setTicketList(ticketList);
			 if(t instanceof MoviePass || t instanceof Employee) {
				t.countVisits();
			}
			
		}
		
		s.close();
	}
	
	/**
	 * sorting ticklist by Day.
	 */

	public void sortByDay() {
		Collections.sort(ticketList, (a1, a2)->a1.day-a2.day);	
		

	}
	/**
	 * returns string.
	 */

	public String toString() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	/**
	 * Returns the number of times the patron has seen this movie
	 * @param id the id of the patron
	 * @param movie name of the movie
	 */

	public int numThisMovie(int id, String movie) {
		int numThisMovie=0;
		for(Ticket t:ticketList) {
			if((t instanceof MoviePass || t instanceof Employee) &&  t.id==id && t.movieName==movie) {
				numThisMovie++;
			}
		}
		
		return numThisMovie;
	}

	/**
	 * Calculates ticket.
	 * @return
	 */
	public double calculateTicketPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @return id of the Ticket Type.
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
