
/**
 * This Exception class throws the exception when Password and re-typed Password
 * are identical .
 * 
 * @author Trupti Thakur.
 *
 */
public class UnmatchedException extends Exception {

	/**
	 * Constructor
	 */

	public UnmatchedException() {
		super("The passwords do not match"); // The passwords do not match

	}

}
