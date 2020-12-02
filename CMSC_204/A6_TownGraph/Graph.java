import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	// Town , <Town, weight>>
	private Map<Town, Map<Town, Integer>> adjMap=new LinkedHashMap<>(); //need to mentain the insertion order for testcases.
	// set for edges. will be easy to add and remove edges from the set
	private Set<Road> edgeSet=new LinkedHashSet<>();
	
	//use for Dijkastra algorithum, visited vertex
	private Map<Town, Boolean> visited=null;
	private Map<Town,FinalTable> dijKastraOutPut=new HashMap<>();
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		for(Road r: edgeSet) {
			if((r.getDestination().equals(destinationVertex)||r.getSource().equals(destinationVertex))
					&& (r.getDestination().equals(sourceVertex)||r.getSource().equals(sourceVertex))) {
				return r;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road downRoad=new Road(sourceVertex, destinationVertex, weight, description);
		edgeSet.add(downRoad);
		//if source vertex is already present
		if(adjMap.containsKey(sourceVertex)) {
			adjMap.get(sourceVertex).put(destinationVertex, weight);
		}else {   
			Map<Town, Integer> adMap=new HashMap<>();
			adMap.put(destinationVertex, weight);  // add into map list 
			adjMap.put(sourceVertex, adMap); // add source list in to map
		}
		// since this is a undirected graph, same code is repeated for destination source
		if(adjMap.containsKey(destinationVertex)) {
			adjMap.get(destinationVertex).put(sourceVertex, weight);
		}else {
			Map<Town, Integer> adMap=new HashMap<>();
			adMap.put(sourceVertex, weight);
			adjMap.put(destinationVertex, adMap);
		}
		return downRoad;
	}

	@Override
	public boolean addVertex(Town v) {
		adjMap.put(v, new HashMap<Town, Integer>());
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road r:edgeSet) {
			if((r.getSource().equals(sourceVertex)||r.getDestination().equals(sourceVertex)) 
					&& (r.getDestination().equals(destinationVertex)||r.getSource().equals(destinationVertex))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		return adjMap.containsKey(v);
	}

	@Override
	public Set<Road> edgeSet() {
		return edgeSet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> opSet=new HashSet<>();
		for(Road r: edgeSet) {
			if(r.getDestination().equals(vertex)||r.getSource().equals(vertex)) {
				opSet.add(r);
			}
		}
		return opSet;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Iterator<Road> it = edgeSet.iterator();
		Road r=null;
		while (it.hasNext()) {
			r = it.next();
			if ((r.getSource().equals(sourceVertex) || r.getDestination().equals(sourceVertex))
					&& (r.getDestination().equals(destinationVertex) || r.getSource().equals(destinationVertex))) {
				it.remove();
			}
		}
		Map<Town, Integer> adMap=null;
		if(adjMap.containsKey(sourceVertex)) {
			adjMap.get(sourceVertex).remove(destinationVertex);
		}
		if(adjMap.containsKey(destinationVertex)) {
			adjMap.get(destinationVertex).remove(sourceVertex);
		}
		return r;
	}

	@Override
	public boolean removeVertex(Town v) {
		if (adjMap.containsKey(v)) {
			Set<Town> neighbors = adjMap.keySet();
			adjMap.remove(v);
			for (Town t : neighbors) {
				adjMap.get(t).remove(v);
			}
			Iterator<Road> it=edgeSet.iterator();
			while(it.hasNext()) {
				Road r=it.next();
				if(r.getSource().equals(v) || r.getDestination().equals(v)){
					it.remove();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return adjMap.keySet();
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> path=new ArrayList<>();
		Town prevVertx=dijKastraOutPut.get(destinationVertex).getPrevTown();
		Town srcVertex=destinationVertex;
		while(prevVertx!=null) {
			Road currRoad=getEdge(srcVertex, prevVertx);
			//path.add(prevVertx.getName()+" via "+ currRoad.getName()+" to "+srcVertex.getName() +" "+ dijKastraOutPut.get(srcVertex).getWeight()+" mi ");
			path.add(prevVertx.getName()+" via "+ currRoad.getName()+" to "+srcVertex.getName() +" "+ adjMap.get(prevVertx).get(srcVertex)+" mi ");
			srcVertex=prevVertx;
			prevVertx=dijKastraOutPut.get(srcVertex).getPrevTown();
		}
		Collections.reverse(path);
		return path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		initializeBeforeDijkastraShortestPath(sourceVertex);
		Town smallestUndisclosedTown=sourceVertex;
		int sourceWeight=0;
		int count =0;
		while(count<adjMap.size()) {  // no.of vertex
			Set<Map.Entry<Town, Integer>> neighbors=adjMap.get(smallestUndisclosedTown).entrySet();
			for(Map.Entry<Town, Integer> e:neighbors) {
				int calcWeight=sourceWeight+e.getValue();
				if(calcWeight<dijKastraOutPut.get(e.getKey()).getWeight()) {
					dijKastraOutPut.get(e.getKey()).setWeight(calcWeight);
					dijKastraOutPut.get(e.getKey()).setPrevTown(smallestUndisclosedTown);
				}
			}
			visited.put(smallestUndisclosedTown, true);
			count++;
			//Find next smallest source town
			sourceWeight=Integer.MAX_VALUE;
			for(Map.Entry<Town, Boolean> t: visited.entrySet()) {
				if(!t.getValue() && dijKastraOutPut.get(t.getKey()).getWeight()<sourceWeight) {
					sourceWeight=dijKastraOutPut.get(t.getKey()).getWeight();
					smallestUndisclosedTown=t.getKey();
				}
			}
		}
		
	}
	
	private void initializeBeforeDijkastraShortestPath(Town sourceVertex) {
		//initialize visited Map
		visited=new HashMap<>();
		for(Town t: adjMap.keySet()) {
			visited.put(t, false);
		}
		//Initialize final data structure
		
		for(Town t:adjMap.keySet()) {
			FinalTable ft=new FinalTable();
			if(t.equals(sourceVertex)) {
				ft.setWeight(0);    // weight/distance of the source vertex is always zero.
				ft.setPrevTown(null);
			}else {
				ft.setWeight(Integer.MAX_VALUE); // distance of the other vertex from the source vertex set to infinity at starting.
				ft.setPrevTown(null);
			}
			dijKastraOutPut.put(t, ft);
		}
		
	}

	@Override
	public void populateTownGraph(File selectedFile) {
		String returnString = "";
		Scanner scan = null;
		try {
			scan = new Scanner(selectedFile);
			while (scan.hasNextLine()) {
				String route=scan.nextLine();
				String[] main=route.split(",");
				String[] sub=main[1].split(";");
				addEdge(new Town(sub[1]), new Town(sub[2]) , Integer.parseInt(sub[0]), main[0]);
			}
		}catch(FileNotFoundException exp ) {
			exp.printStackTrace();
		} finally {
			scan.close();
		}
		
	}

}
