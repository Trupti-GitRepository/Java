/**
 * The exception occurs when a enqueue method is called on a full queue.
 * @author Trupti Thakur
 *
 */

public class QueueOverflowException extends Exception {
	
	public QueueOverflowException () {
		super( "Queue is full." );
	}

}
