/**
 * This Exception occurs when a top or pop method is called on an empty stack.
 * @author Trupti Thakur.
 *
 */
public class StackUnderflowException extends Exception {
	
	public StackUnderflowException() {
		super("Stack is empty. ");
	}

}
