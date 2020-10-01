/**
 * The exception occurs when a push method is called on a full stack
 * @author Trupti Thakur
 *
 */
public class StackOverflowException  extends Exception {
	
/** Constructor */
	public StackOverflowException() {
		super("Stack is Full");
	}
	

}
