import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 6; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Rd_1");
		  graph.addEdge(town[1], town[3], 4, "Rd_2");
		  graph.addEdge(town[3], town[4], 3, "Rd_4");
		  graph.addEdge(town[2], town[4], 3, "Rd_3");
		  graph.addEdge(town[2], town[5], 4, "Rd_5");
		 

	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	

	@Test
	public void testContainsEdge() {
		assertEquals(false, graph.containsEdge(town[2], town[3]));
		assertEquals(false, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Rd_1", roadArrayList.get(0));
		assertEquals("Rd_2", roadArrayList.get(1));
		assertEquals("Rd_3", roadArrayList.get(2));
		assertEquals("Rd_4", roadArrayList.get(3));
		assertEquals("Rd_5", roadArrayList.get(4));
		
	}

	
	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[4]));
		assertEquals(true, roads.contains(town[5]));
	}

	 @Test
	  public void testTown_1ToTown_5() {
		  String beginTown = "Town_1", endTown = "Town_5";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Rd_1 to Town_2 2 mi",path.get(0).trim());
			  assertEquals("Town_2 via Rd_5 to Town_5 4 mi",path.get(1).trim());
			  
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	 
}
