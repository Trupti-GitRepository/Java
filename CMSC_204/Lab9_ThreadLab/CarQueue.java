import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * A CarQueue class that maintains a queue of random directions that the car
 * should go.
 * 
 * @author Trupti Thakur
 *
 */
public class CarQueue {

	Queue<Integer> q;

	Random direction;

	/**
	 * Constructor
	 */
	public CarQueue() {
		q = new ArrayDeque<Integer>();
		direction = new Random();
		q.add(0);
		q.add(2);
		q.add(3);
		q.add(1);
		q.add(0);
		q.add(2);
		q.add(3);
		q.add(1);
		q.add(0);
		q.add(2);
		q.add(3);
		q.add(1);
		q.add(0);
		q.add(2);
		q.add(3);
		q.add(1);
		
	}

	/**
	 * addToQueue method that has a class that implements runnable,
	 */
	public void addToQueue() {

		class QueueRunnable implements Runnable {

			@Override
			public void run() {
				try {
					while (true) {
						q.add(direction.nextInt(4));
						Thread.sleep(200);
					}
				} catch (InterruptedException Exception) {

				} finally {

				}

				Runnable task = new QueueRunnable();
				Thread t = new Thread(task);
				t.start();
				
				/** Adds 0,1,2 or 3 to queue
			     *  0 = up
			     *  1 = down
			     *  2 = right
			     *  3 = left
			     */


			}

		}

	}

	public int deleteQueue() {

		return q.remove();
	}

}
