
/**
 * This Exception class throws the exception when Password doesn’t contain a
 * special character .
 * 
 * @author Trupti Thakur.
 *
 */
public class NoSpecialSymbolException extends Exception {

	/**
	 * Constructor
	 */

	public NoSpecialSymbolException() {
		super("The password must contain at least one special character"); // The password must contain at least one
																			// special character
	}

}
