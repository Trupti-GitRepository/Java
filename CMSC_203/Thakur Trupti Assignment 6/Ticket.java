

import java.io.*;

import java.util.*;
/**
 * Ticket class stores information of Ticket.
 * @author Trupti Thakur.
 *
 */
public abstract class Ticket {
	
	// Field declarations.
	protected String movieName;   //to hold the name of the movie.
	protected String rating;    //G, PG, PG13, R, or NR
	protected int id;   // only neeed for employee and MoviePass members.
	protected int day;    // movie day
	protected int time;     // Movie time
	//protected int numVisit;    // to hold number of visits.
	protected Format format;
	protected static final double ADULT_BEFORE_6PM=10.50;
	protected static final double ADULT_AFTER_6PM=13.50	;
	protected static final double CHILD_BEFORE_6PM=5.75;
	protected static final double CHILD_AFTER_6PM=10.75;
	protected static final double ADULT_IMAX=3.00;
	protected static final double CHILD_IMAX=2.00;
	protected static final double ADULT_3D=2.50;
	protected static final double CHILD_3D=1.50;
	protected static final double TAX=0.096;
	protected static final double MOVIE_PASS=9.99;
	protected ArrayList<Ticket> ticketList;
	//protected double totalSales;
	/**
	 * no-arg constructor of class Ticket..
	 */
	public Ticket() {
		
	}
	
	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 * @param id
	 
	 */
public Ticket(String mName, String mRating, int mDay,int mTime,String format,int id) {
		this.movieName=mName;
		this.rating=mRating;
		this.day=mDay;
		this.time=mTime;
		this.id=id;
		//this.numVisit=numVisit;
		this.format=Format.getFormat(format);
		
	}

	/**
	 * Constructor
	 * @param mName
	 * @param mRating
	 * @param mDay
	 * @param mTime
	 * @param format
	 * @param type
	 * @param id
	 * 
	 */
	public Ticket(String mName, String mRating, int mDay, int mTime, String format, String type, int id ) {
		this.movieName=mName;
		this.rating=mRating;
		this.day=mDay;
		this.time=mTime;
		this.id=id;
		this.format=Format.getFormat(format);
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
	
	public Ticket(String mName, String mRating, int mDay, int mTime, String format ) {
		this.movieName=mName;
		this.rating=mRating;
		this.day=mDay;
		this.time=mTime;
		
		this.format=Format.getFormat(format);
	}
	
	/**
	 * countVisits method counts visit to the movie.
	 */
	
	public abstract void countVisits( );
	
	/**
	 * This methods calculates and returns ticketPrice.
	 * @return  ticketPrice.
	 */
	public abstract double calculateTicketPrice();
	
	/**
	 * getID method returns the ID.	
	 * @return Id
	 */
	public abstract int getId();

	
/**
 * toString method return string.
 * @return String 
 */
	public String toString() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	/**
	 * setter to set ticketList.
	 * @param ticketList
	 */
	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList=ticketList;
	}
	
	//enum inner class to hold ticket format.
		protected static enum Format{IMAX("IMAX"), THREE_D("3D"),NONE("NONE");
		
			private String formatName;
			Format(String formatName){
			this.formatName=formatName;
			}
			public String getName() {
				return this.formatName;
			}
			public static Format getFormat(String format) {
				EnumSet<Format> enumSet=EnumSet.allOf(Format.class);
				for(Format f: enumSet) {
					if(format.equalsIgnoreCase(f.getName())) {
						return f;
					}
				}
				return Format.NONE;
			}
		}
		
}
