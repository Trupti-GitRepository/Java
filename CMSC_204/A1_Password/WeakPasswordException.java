
/**
 * This Exception class throws the exception when Password is weak that is 6 to
 * 9 characters. .
 * 
 * @author Trupti Thakur.
 *
 */
public class WeakPasswordException extends Exception {

	/**
	 * Constructor
	 */

	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters."); // The password is OK but weak -
																						// it contains fewer than 10
																						// characters.
	}

}
