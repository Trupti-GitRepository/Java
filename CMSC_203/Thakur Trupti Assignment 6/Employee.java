

import java.io.*;
import java.util.*;
/**
 * This class calculates tickets for Employee.
 * @author Trupti Thakur.
 *
 */
public class Employee extends Ticket {

	//private final String TYPROFTICKET;
	//private int id;
	
	private int numberOfVisits;
	//private double employeeMovieSale;
	/**
	 * Constructor
	 * @param mName--name of the movie
	 * @param mRating---Ratings of the movie
	 * @param mDate---Movie date 
	 * @param mTime  ----time
	 * @param format  ---IMAX, D, NONE
	 * @param id-----id of the Employee
	 * @param numVisit ----No. of times watched movie.
	 */
	public Employee(String mName, String mRating, int mDay,int mTime,String format,int id, int numVisit ){
		
		super(mName, mRating, mDay,mTime, format,id);
		//this.id=id;
		this.numberOfVisits=numVisit;
	
	}
	/**
	 *  @param mName--name of the movie
	 * @param mRating---Ratings of the movie
	 * @param mDate---Movie date 
	 * @param mTime  ----time
	 * @param format  ---IMAX, D, NONE
	 * @param String type -----Employee.
	 * @param id-----id of the Employee
	
	 * 
	 */
	public Employee(String mName, String mRating, int mDay,int mTime,String format,String type,int id){
		
		super(mName, mRating, mDay,mTime, format,type,id);
		this.id=id;
		
	
	}
	/**
	 * No-arg constructor.
	 */
	public Employee() {
		
	}
	
	

public double calculateTicketPrice() {
		//employeeMovieSale=0.0;
		double ticketPrice=0.0;
		double price=0.0;
		
		if(numberOfVisits>2)
		{
			if(time<17) 
			{
				
				switch(format) 
				{
				case IMAX:price=(ADULT_BEFORE_6PM+ ADULT_IMAX )/2;
							ticketPrice=price+price*TAX;
							break;
				
				case THREE_D:price=(ADULT_BEFORE_6PM+ADULT_3D )/2;
							ticketPrice=price+price*TAX;
							break;
				case NONE: 	price=ADULT_BEFORE_6PM/2;
							ticketPrice=price+price*TAX;
							break;

				}
				
			}else if(time>=17)
			{
				switch(format) 
				{
				case IMAX:	price=(ADULT_AFTER_6PM+ ADULT_IMAX )/2;
							ticketPrice=price+price*TAX;
							break;
	
				case THREE_D:price=(ADULT_AFTER_6PM+ ADULT_3D )/2;
							ticketPrice=price+price*TAX;
							break;
				case NONE: 	price=ADULT_AFTER_6PM/2;
							ticketPrice=price+price*TAX;
							break;

				}
				
			}
			
			
		}
		else 
		{
			ticketPrice=0.0;
		}
		//employeeMovieSale+=ticketPrice;
		//totalSales+=employeeMovieSale;
		return ticketPrice;
	}
	
	/**
	 * @return int id--id of the Employee.
	 */

	public int getId() {
		return id;
	}
	/**
	 * @returns toString-- Employee Ticket details.
	 */

	public String toString() {
		String str=null;
		str= "EMPLOYEE-"+id+" " + format +" Movie: "+ movieName +" Rating:" + rating
				+" Day: " + day + " Time: "+ time+" Price: " +(String.format("%.2f", calculateTicketPrice()));
		return str;
	}

	@Override
	public void countVisits() {
		
		
			int counter=0;
			if(ticketList!=null && ticketList.size()>0) {
				for(Ticket t:ticketList) {
					if(t instanceof Employee && t.id==id) {
						counter++;
					}
				}
			}
			
			this.numberOfVisits=counter;
		
	}

}
