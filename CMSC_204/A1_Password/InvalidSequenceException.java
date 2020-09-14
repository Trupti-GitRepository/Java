
/**
 * This Exceptionclass throws the exception when Password contains more than 2
 * of the same character in sequence .
 * 
 * @author Trupti Thakur.
 *
 */

public class InvalidSequenceException extends Exception {

	/**
	 * Constructor.
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence. "); 

	}

}
