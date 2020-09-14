
/** This class throws the exception when password doesn't contain a
 * numeric character
 * @author Trupti Thakur.
 */

public class NoDigitException extends Exception {

	/**
	 * constructor.
	 */

	public NoDigitException() {
		super("The password must contain at least one digit"); //// The password must contain at least one digit

	}

}
