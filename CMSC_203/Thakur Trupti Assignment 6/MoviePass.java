
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

/**
 * This class calculates ticket price when hava a MoviePass.
 * @author Trupti Thakur
 *
 */
public class MoviePass extends Ticket {

//private final String TYPROFTICKET;
	
	private int id;
	private int numberOfVisits;
	protected double moviePassSale;
	

	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 * @param id
	 * @param numVisit
	 */
	public MoviePass(String mName, String mRating, int mDay,int mTime,String format,int id, int numVisit ){
		
		super(mName, mRating, mDay,mTime, format,id);
		this.id=id;
		this.numberOfVisits=numVisit;	
	}
	
	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 * @param String type
	 * @param id
	 * 
	 */
	public MoviePass(String mName, String mRating, int mDay,int mTime,String format,String type,int id){
		super(mName, mRating, mDay,mTime, format,type,id);
		this.id=id;
	}
	/**
	 * count no. of visits 
	 */
	public void countVisits( ) {
		int counter=0;
		if(ticketList!=null && ticketList.size()>0) {
			for(Ticket t:ticketList) {
				if(t instanceof MoviePass && t!=this && t.id==id) {
					counter++;
				}
			}
		}
		
		this.numberOfVisits=counter;
	}
	/**
	 * method returns true if patron watched the same movie again.
	 * @param id
	 * @param movie
	 * @return
	 */
	private boolean isMovieWatchedAgain(int id, String movie) {
		
		for(Ticket t:ticketList) {
			if(t instanceof MoviePass && t!=this && t.id==id && t.movieName.equalsIgnoreCase(movie)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns true if patron watched another movie on the same day.  
	 * @param id
	 * @param day
	 * @return
	 */
	private boolean isMoreMoviesWatchedInOneDay(int id, int day) {
		for(Ticket t:ticketList) {
			if(t instanceof MoviePass && t!=this && t.id==id && t.day==day) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Calculate ticket price for the moviePass type. 
	 */
	public double calculateTicketPrice()
	{
		double ticketPrice=0.0;
		double price=0.0;
	//	moviePassSale=0.0;
		
		
	if(format==Format.NONE && !isMoreMoviesWatchedInOneDay(id, this.day)&& !isMovieWatchedAgain(id, this.movieName) )
		{
			
			if(numberOfVisits<1)
			{
				ticketPrice=MOVIE_PASS;
				
			}else if(numberOfVisits>=1){			
			
			ticketPrice=0.0;
			}
			} else	{			
			if(time<17) {
				
				switch(format) 
				{
				case IMAX:price=(ADULT_BEFORE_6PM+ ADULT_IMAX );
							ticketPrice=price+price*TAX;
 							break;
				
				case THREE_D:price=(ADULT_BEFORE_6PM+ADULT_3D );
							ticketPrice=price+price*TAX;
							break;
				case NONE: 	price=ADULT_BEFORE_6PM;
							ticketPrice=price+price*TAX;
							break;

				}
				
				}else if(time>=17){
				
				switch(format) 
				{
				case IMAX:	price=(ADULT_AFTER_6PM+ ADULT_IMAX );
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
			
			
		}
		
		moviePassSale+=ticketPrice;
		//totalSales+=moviePassSale;
		return ticketPrice;
	}

	
	//returns id.
	public int getId() {
		return id;
	}
	
// returns string.
	public String toString() {
		String str=null;
		str= "MoviePass-"+ id +" " + format +" Movie: "+ movieName +" Rating: "
		+ rating +" Day: " + day + " Time: "+ time+" Price: " + (String.format("%.2f", calculateTicketPrice()));
		return str;
	}
	

}
