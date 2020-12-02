/**
 * 
 * @author Trupti Thakur
 *
 */
public class Road implements Comparable<Road> {
	private Town sourceTown;
	private Town destinationTown;
	private int degrees;
	private String name;
	
	/**
	 * Constructor
	 * @param source -One town on the road
	 * @param destination -Another town on the road
	 * @param degrees Weight of the edge, i.e., distance from one town to the other
	 * @param name- Name of the road
	 */
	public Road(Town source,Town destination,
            int degrees,
            String name) {
		sourceTown=source;
		destinationTown=destination;
		this.name=name;
		this.degrees=degrees;
		
	}
	
	/**
	 * Constructor with weight preset at 1
	 * @param source One town on the road
	 * @param destination Another town on the road
	 * @param name Name of the road
	 */
	
	public Road(Town source,
            Town destination,
           String name) {
		sourceTown=source;
		destinationTown=destination;
		this.name=name;
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		
		return (this.sourceTown.equals(town)||this.destinationTown.equals(town));
	}
	
	/**
	 * To string method.
	 */
	public String toString() {
		
		return this.sourceTown.getName()+" ->"+this.destinationTown.getName();
	}
	
	
	/**
	 * Returns the road name
	 * @return The name of the road
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the second town on the road
	 * @return A town on the road
	 */
	public Town getDestination() {
		return destinationTown;
		
	}
	
	/**
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	public Town getSource() {
		return sourceTown;
		
	}

	//0 if the road names are the same,
	//a positive or negative number if the road names are not the same
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.name);
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return degrees;	
		
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road.
	 * Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r  road object to compare it to
	 */
	
	public boolean equals(Object r) {
		if(!(r instanceof Road)) {
			return false;
		}
		Road rd=(Road)r;
		if((rd.destinationTown.equals(this.destinationTown)||rd.destinationTown.equals(this.sourceTown)) &&
				(rd.sourceTown.equals(this.sourceTown)||rd.sourceTown.equals(this.destinationTown))) {
			return true;
		}
		return false;
	}

}
