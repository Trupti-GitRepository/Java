package cmsc.java.cmsc_203_assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 
	
	
	@Before
	public void setUp() throws Exception {
		//student create a management company		
	 m= new ManagementCompany("Tata Group","78787878",5);
		
		//student add three properties, with plots, to mgmt co
		
	 	p1 = new Property ("Caravan community", "German", 4844.00, "Sam Nene",2,1,2,2);
		p2 = new Property ("Kingsview", "Lakeforest", 1441, "Tie Tacoon",4,1,2,2);
		p3 = new Property ("Cedar Creek Lodge", "Gaithursburg", 9450, "Baban Belose",6,1,2,2);
		
		 
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		p4 = new Property ("Lullaby", "Germantown", 3126, "Luck Pery",2,5,2,2);
		p5 = new Property ("Cary Kelly", "Sakinaka", 7235, "Jay Remond",4,5,2,2);
		p6 = new Property ("VidyaBhavan", "Giant village", 2000, "Joy Ray",6,5,2,2);
		 
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);  //exceeds the size of the array and can not be added, add property should return -1	
	

		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		String maxRentString = m.maxRentProp().split("\n")[3];
		assertTrue(maxRentString.contains("9450.0"));
		
		
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),15735.0,0);
		
	}

 }