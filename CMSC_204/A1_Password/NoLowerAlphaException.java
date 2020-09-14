
/**
 * This Exceptionclass throws the exception when password doesn't contain an
 * lowercase alpha character
 * 
 * @author Trupti Thakur.
 *
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * Constructor
	 */

	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");// Message – The password must
																						// contain at least one
																						// lowercase alphabetic
																						// character

	}

}
