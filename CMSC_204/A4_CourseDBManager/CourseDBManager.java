import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Implements the CourseDBManagerInterface that is provided. The data manager
 * allows the user to read the courses from a file or to enter the data by hand,
 * and uses an Alert to print out the database elements. The input is read from
 * a file or read from the textfields and is added to the data structure through
 * the add method. The add method uses the CDS add method.
 * 
 * @author Trupti Thakur
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds = new CourseDBStructure(20);

	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement op = null;
		try {
			op = cds.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return op;
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cdb = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cdb);
	}

	/**
	 * read the courses from a file or to enter the data by hand, and uses an Alert
	 * to print out the database elements. The input is read from a file or read
	 * from the textfields and is added to the data structure through the add
	 * method. The add method uses the CDS add method.
	 * 
	 * @throws : IOException – created and thrown when user selects an input file
	 *           that cannot be read or attempting to retrieve a CDE that does not
	 *           exist in the DB.
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

		Scanner s = new Scanner(input);

		while (s.hasNext()) {

			String[] line = s.nextLine().split(" ");

			ArrayList<String> opList = new ArrayList<>(10);
			opList.add(line[0]);
			opList.add(line[1]);
			opList.add(line[2]);
			opList.add(line[3]);
			opList.add(line[4]);
			// CMSC100 21556 2 Distance-Learning Janet E. Joy
			// String courseId, int crn, int noOfCredits, String roomNumber, String
			// instructorName
			CourseDBElement tmp = new CourseDBElement(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
					line[3], line[4]);
			cds.add(tmp);
		}

		s.close();

	}

	@Override
	public ArrayList<String> showAll() {

		return cds.showAll();
	}

}
