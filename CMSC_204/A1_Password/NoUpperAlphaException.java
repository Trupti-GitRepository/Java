
/**
 * This Exceptionclass throws the exception when password doesn't contain an
 * uppercase alpha character
 * 
 * @author Trupti Thakur.
 *
 */

public class NoUpperAlphaException extends Exception {

	/**
	 * Constructor
	 */

	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character"); // Message – The password must
																						// contain at least one
																						// uppercase alphabetic
																						// character

	}

}
