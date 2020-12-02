import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Town_STUDENT_Test {
	
	private String[] town;

	

	@Before
	public void setUp() throws Exception {
		 
		  town = new String[6];
		  
		  for (int i = 1; i < 6; i++) {
			  town[i] = "Town_" + i;
			  System.out.println("Town "+ i +"added");
		  }
		  
			 
	}

	@After
	public void tearDown() throws Exception {
		town = null;
	}

	@Test
	public void testEqualMethod() {
		
		assertEquals(false, town.equals("Town_2"));
	}

}
