import java.io.File;
import java.util.ArrayList;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph;

	public TownGraphManager() {
		graph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		return (graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null) ? true : false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		Set<Town> townSet = graph.vertexSet();
		Town tmpTown = new Town(name);
		for (Town t : townSet) {
			if (tmpTown.equals(t))
				return t;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> opList = new ArrayList<>();
		for (Road r : graph.edgeSet()) {
			opList.add(r.getName());
		}
		return opList;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return (graph.removeEdge(new Town(town1), new Town(town2), 0, road) != null) ? true : false;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		for (Town t : graph.vertexSet()) {
			towns.add(t.getName());
		}
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	@Override
	public void populateTownGraph(File selectedFile) {
		graph.populateTownGraph(selectedFile);
	}

}
