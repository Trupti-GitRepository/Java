import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseDBStructure implements CourseDBStructureInterface {

	public LinkedList<CourseDBElement>[] hashTable;

	int hashTableSize;

	/**
	 * Constructor
	 * 
	 * @param i - size of the hashTable
	 */
	public CourseDBStructure(int i) {
		hashTableSize = i;
		hashTable = new LinkedList[i];

	}

	/**
	 * constructor using for testing
	 * 
	 * @param string
	 * @param size-size of the hashTable
	 */
	public CourseDBStructure(String string, int size) {
		hashTableSize = size;
		hashTable = new LinkedList[size];

	}

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable. If the CourseDatabaseElement does not exist in the hashtable, add
	 * it to the hashtable.
	 * 
	 * @param element the CDE to be added
	 */
	public void add(CourseDBElement element) {
		int index = element.hashCode() % hashTableSize;

		if (hashTable[index] != null) {
			hashTable[index].add(element);
		} else {
			LinkedList<CourseDBElement> ll = new LinkedList<>();
			ll.add(element);
			hashTable[index] = ll;
		}

	}

	public CourseDBElement get(int crn) throws IOException {

		int index = ("" + crn).hashCode() % hashTableSize;
		LinkedList<CourseDBElement> tmp = hashTable[index];
		for (CourseDBElement entry : tmp) {
			if (entry.getCRN() == crn) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * This method display all elements .
	 * @return list of all elements 
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> opList = new ArrayList<>();

		for (LinkedList<CourseDBElement> oe : hashTable) {
			if (oe != null) {
				for (CourseDBElement cde : oe) {
					opList.add("\n"+cde.toString());
				}
			}
		}
		return opList;
	}

	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return hashTableSize;
	}

}
