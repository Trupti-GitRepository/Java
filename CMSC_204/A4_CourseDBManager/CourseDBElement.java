
/**
 * CourseDBElement implements Comparable, and consists of five attributes. The
 * CourseDBElement will be an object consisting of these five attributes, and is
 * referred to as a CDE.
 * 
 * @author Trupti Thakur
 *
 */

public class CourseDBElement implements Comparable {
	String courseId;
	int crn;
	int noOfCredits;
	String roomNumber;
	String instructorName;

	/**
	 * Constructor
	 * 
	 */

	public CourseDBElement(String courseId, int crn, int noOfCredits, String roomNumber, String instructorName) {
		super();
		this.courseId = courseId;
		this.crn = crn;
		this.noOfCredits = noOfCredits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}
	/*
	 * Constructor
	 */

	public CourseDBElement() {
		super();
	}

	/**
	 * This interface imposes a total ordering on the objects of each class that
	 * implements it. This ordering is referred to as the class's natural ordering,
	 * and the class's compareTo method is referred to as its natural comparison
	 * method.
	 * @param element a CourseDBElement
	 * @return a negative integer if x.compareTo(y) < 0, zero if x.compareTo(y) ==
	 * 0, and a positive integer if x.compareTo(y) > 0.
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return this.crn - element.crn;
	}
/**
 * This method return course CRN
 * @return crn- course CRN number
 */
	public int getCRN() {

		return this.crn;
	}
/**
 *  This method set course CRN
 * @param crn-course CRN number
 */
	public void setCRN(int crn) {
		this.crn = crn;

	}
/**
 *  This method return hashcode of CRN
 *  @return crn's hashcode
 */
	public int hashCode() {
		return ("" + crn).hashCode();
	}
	
	/**
	 * toString method 
	 * @return string
	 */

	public String toString() {

		return "Course:" + courseId + " " + "CRN:" + crn + " " + "Credits:" + noOfCredits + " " + "Instructor:"
				+ instructorName + " " + "Room:" + roomNumber;
	}
}
