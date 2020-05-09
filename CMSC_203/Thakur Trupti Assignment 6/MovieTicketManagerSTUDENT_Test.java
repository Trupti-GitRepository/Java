

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//add adults
				ticketList.addTicket("DDLJ", "G", 4,19,"NONE","Adult",0);
				ticketList.addTicket("English Medium", "PG13", 2,12,"NONE","Adult",0);
				ticketList.addTicket("Life of Pi", "PG13", 3,14,"3D","Adult",0);
				
				//add children
				ticketList.addTicket("English Medium", "G", 5,19,"NONE","Child",0);
				ticketList.addTicket("FROZEN", "G", 2,12,"NONE","Child",0);
				ticketList.addTicket("Life of Pi", "PG", 2,14,"3D","Child",0);
				
				//add employees
				ticketList.addTicket("English Medium","NR", 5,19,"NONE","Employee",454545);
				ticketList.addTicket("FROZEN 2", "NR", 2,12,"NONE","Employee",545454);
				ticketList.addTicket("Life of Pi", "PG13", 1,13,"IMAX","Employee",111111);
				
				//add MoviePass members
				ticketList.addTicket("HUMTUM", "NR", 3,20,"NONE","MoviePass",788788);
				ticketList.addTicket("English Medium", "G", 2,13,"IMAX","MoviePass",588588);
				ticketList.addTicket("Life of Pi", "PG13", 3,12,"NONE","MoviePass",388388);

	}

	@After
	public void tearDown() throws Exception {
		//Student set ticketList to null;
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Employee
		assertEquals(1,ticketList.numVisits(454545));
		ticketList.addTicket("English Medium", "PG13",8,19,"NONE","Employee",454545);
		assertEquals(2,ticketList.numVisits(454545));
		ticketList.addTicket("FROZEN 2", "PG13", 10,19,"NONE","Employee",545454);
		assertEquals(2,ticketList.numVisits(545454));
		
	//MoviePass member
		assertEquals(1,ticketList.numVisits(788788));
		ticketList.addTicket("Life of PI", "NR", 5,13,"NONE","MoviePass",788788);
		assertEquals(2,ticketList.numVisits(788788));
		ticketList.addTicket("Life of Pi", "NR",7,13,"NONE","MoviePass",588588);
		assertEquals(2,ticketList.numVisits(588588));
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		
		//Employee
				assertEquals(1,ticketList.numThisMovie(454545,"English Medium"));
				ticketList.addTicket("Life of PI", "NR", 5,13,"NONE","Employee",454545);
				assertEquals(0,ticketList.numThisMovie(12345,"Solo"));
				ticketList.addTicket("Life of PI", "PG13", 9,19,"NONE","Employee",545454);
				assertEquals(1,ticketList.numThisMovie(545454,"Life of PI"));

				//MoviePass member
				assertEquals(0,ticketList.numThisMovie(788788,"Life of PI"));
				ticketList.addTicket("Life of PI", "NR", 4,12,"NONE","MoviePass",788788);
				assertEquals(1,ticketList.numThisMovie(788788,"Life of PI"));
				ticketList.addTicket("HUMTUM", "NR", 6,12,"NONE","MoviePass",588588);
				assertEquals(1,ticketList.numThisMovie(588588,"HUMTUM"));
		
	}

}
