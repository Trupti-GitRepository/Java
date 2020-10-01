/**
 * The exception occurs when a dequeue method is called on an empty queue..
 * @author Trupti Thakur
 *
 */
public class QueueUnderflowException extends Exception{
	
	
	public QueueUnderflowException() {
		super("Empty queue.");
		
	}

}
