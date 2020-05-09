 

import java.io.*;
import java.util.*;
/**
 * This class claculates tickets for Adults.
 * @author Trupti Thakur
 *
 */
public class Adult extends Ticket {
//private double adultMovieSale;
	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 * @param String type
	 * @param id
	 
	 */
	
	public Adult(String mName, String mRating, int mDay, int mTime, String format, String type, int id) {
		super(mName,mRating, mDay, mTime, format,type,id);
		
	}
	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 *
	 */
	public Adult(String mName, String mRating, int mDay, int mTime, String format) {
		super(mName,mRating, mDay, mTime, format);
		
	}
	/**
	 * Calculates ticket price for the adult .
	 * return ticketPrice.
	 */
	
		@Override
		public double calculateTicketPrice() {
			
			
			double ticketPrice=0.0;
			double price=0.0;
			// before 6pm			
				if(time<17) 
				{
					
					switch(format) 
					{
					case IMAX:price=(ADULT_BEFORE_6PM + ADULT_IMAX );
								ticketPrice=price+price*TAX;
								break;
					
					case THREE_D:price=(ADULT_BEFORE_6PM + ADULT_3D );
								ticketPrice=price+price*TAX;
								break;
					case NONE: 	price=ADULT_BEFORE_6PM ;
								ticketPrice=price+price*TAX;
								break;

					}
					// After 6 or 6pm.
				}else if(time>=17)
				{
					switch(format) 
					{
					case IMAX:	price=(ADULT_AFTER_6PM + ADULT_IMAX );
								ticketPrice=price+price*TAX;
								break;
		
					case THREE_D:price=(ADULT_AFTER_6PM+ ADULT_3D );
								ticketPrice=price+price*TAX;
								break;
					case NONE: 	price=ADULT_AFTER_6PM;
								ticketPrice=price+price*TAX;
								break;

					}
					
				}
				
			//adultMovieSale+=ticketPrice;
			
				
			return ticketPrice;
			
						
		}
		// Calculates no. of visits 
		@Override
		public void countVisits() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		/**
		 * @return int id.
		 */
	public int getId() {
		return id;
	}
//returns string.
	public String toString() {
		
		String str=null;
		str= " ADULT Movie: "+ movieName +" Rating:" + rating +" Day: "
		+ day + " Time: "+ time+" Price: " + (String.format("%.2f", calculateTicketPrice()));
		return str;
		
			
	}

}
