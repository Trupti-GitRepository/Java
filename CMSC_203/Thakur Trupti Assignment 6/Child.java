

import java.io.*;
import java.util.*;

/**
 * This class extends Ticket to calculate movieTicket price for child.
 * @author Trupti Thakur
 *
 */
public class Child extends Ticket {
	
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
	public Child(String mName, String mRating, int mDay, int mTime, String format, String type, int id) {
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
	public Child(String mName, String mRating, int mDay, int mTime, String format) {
		super(mName,mRating, mDay, mTime, format);
		
	}
	@Override
	public double calculateTicketPrice() {
		
		double ticketPrice=0.0;
		double price=0.0;
		//childMovieSale=0.0;
		
			if(time<17) 
			{
				
				switch(format) 
				{
				case IMAX:price=(CHILD_BEFORE_6PM + CHILD_IMAX );
							ticketPrice=price+price*TAX;
							break;
				
				case THREE_D:price=(CHILD_BEFORE_6PM + CHILD_3D );
							ticketPrice=price+price*TAX;
							break;
				case NONE: 	price=CHILD_BEFORE_6PM ;
							ticketPrice=price+price*TAX;
							break;

				}
				
			}else if(time>=17)
			{
				switch(format) 
				{
				case IMAX:	price=(CHILD_AFTER_6PM + CHILD_IMAX );
							ticketPrice=price+price*TAX;
							break;
	
				case THREE_D:price=(CHILD_AFTER_6PM+ CHILD_3D );
							ticketPrice=price+price*TAX;
							break;
				case NONE: 	price=CHILD_AFTER_6PM;
							ticketPrice=price+price*TAX;
							break;

				}
				
			}
			//childMovieSale+=ticketPrice;
			//totalSales+=childMovieSale;	
		return ticketPrice;
		
		
		
	}
	@Override
	public void countVisits() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	public int getId() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public String toString() {
		String str=null;
		str= " CHILD Movie: "+ movieName +" Rating: " + rating +" Day: " + day
				+ " Time: "+ time+" Price: " + (String.format("%.2f", calculateTicketPrice()));
		return str;
	}

}
