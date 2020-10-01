import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * NotationQueue will implement the QueueInterface .
 * 
 * @author Trupti Thakur
 *
 */
public class NotationQueue<T> implements QueueInterface<T> {

	private int size;
	private int first;
	private int last;
	private List<T> elements;

	public NotationQueue(int size) {
		elements = new LinkedList<>();
		this.size = size;
		first = -1;
		last = -1;
	}

	public boolean isEmpty() {
		return elements.size() == 0;
	}

	public boolean isFull() {
		return elements.size() == size;
	}

	public T dequeue() throws QueueUnderflowException {
		if (elements.size() == 0)
			throw new QueueUnderflowException();
		return elements.remove(first + 1);

	}

	public int size() {
		return elements.size();
	}

	public boolean enqueue(T e) throws QueueOverflowException {
		if (elements.size() >= size)
			throw new QueueOverflowException();
		elements.add(e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (T e : elements) {
			sb.append(e).append(delimiter);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T e : elements) {
			sb.append(e);
		}
		return sb.toString();
	}

	@Override
	public void fill(ArrayList<T> list) {
		elements = new LinkedList();
		for (T e : list) {
			elements.add(e);
		}
	}

}
