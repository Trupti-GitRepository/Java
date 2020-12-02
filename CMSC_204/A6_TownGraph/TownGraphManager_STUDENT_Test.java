


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[6];
		  
		  for (int i = 1; i < 6; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Rd_1");
		  graph.addRoad(town[1], town[3], 4, "Rd_2");
		  graph.addRoad(town[3], town[4], 3, "Rd_4");
		  graph.addRoad(town[2], town[4], 3, "Rd_3");
		  graph.addRoad(town[2], town[5], 4, "Rd_5");
		 
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}
	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Rd_1", roads.get(0));
		assertEquals("Rd_2", roads.get(1));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Rd_2", graph.getRoad(town[1], town[3]));
		
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		
	}

	
		
	
	
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[1],town[5]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Rd_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Rd_5 to Town_5 4 mi",path.get(1).trim());
		  

	}

}
