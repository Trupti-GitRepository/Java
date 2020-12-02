/**
 * Represents an town as a node of a graph. The Town class holds the name of the
 * town and a list of adjacent towns, and other fields as desired, and the
 * traditional methods (constructors, getters/setters, toString, etc.). It will
 * implement the Comparable interface These are the minimum methods that are
 * needed. Please feel free to add as many methods as you need.
 * 
 * @author Trupti Thakur
 *
 */
public class Town implements Comparable<Town> {

	private String townName;

	/**
	 * Constructor. Requires town's name.
	 * 
	 * @param name- twon's name
	 */
	public Town(String name) {
		townName = name;
	}

	/**
	 * copy constructor
	 * 
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		townName = templateTown.getName();
	}

	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the town's name
	 * 
	 * @returns town's name
	 */
	public String getName() {
		return townName;
	}

	/**
	 * To String method
	 * 
	 * @return the town name
	 */
	public String toString() {
		return townName;
	}

	/**
	 * This method returns hashcode of the town.
	 * 
	 * @returns hashCode for the name of the town.
	 */
	public int hashCode() {
		return townName.hashCode();

	}

	/**
	 * @returns true if the town names are equal, false if not
	 */

	public boolean equals(Object obj) {
		if (!(obj instanceof Town)) {
			return false;
		}
		Town td = (Town) obj;
		return this.townName.equalsIgnoreCase(td.townName);
	}

}
