
/**
 * This Exception class throws the exception when the length of the password
 * doesn't match.
 * 
 * @author Trupti Thakur.
 *
 */

public class LengthException extends Exception {

	/**
	 * Constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long"); // The password must be at least 6 characters long
	}

}
