
import java.io.*;
import java.util.*;

/**
 * Implements a generic sorted double list using a provided Comparator. It
 * extends BasicDoubleLinkedList class.
 * 
 * @author Trupti Thakur
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	/**
	 * Constructor- Creates an empty list that is associated with the specified
	 * comparator.
	 * 
	 * @param comparator2 - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		super();
		this.comparator = comparator2;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param data - the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		ListNode newNode = new ListNode(data);
		boolean nodeAdded = false;
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
			return this;
		}
		ListNode tmp = head;
		while (tmp != null) {
			if (comparator.compare(tmp.getData(), newNode.getData()) > 0) {
				if (tmp.getLast() == null) {
					newNode.setNext(tmp);
					tmp.setPrevious(newNode);
				} else {
					tmp.getLast().setNext(newNode);
					newNode.setNext(tmp);
					newNode.setPrevious(tmp.getLast());
					tmp.setPrevious(newNode);
				}
				if (tmp == head) {
					head = newNode;
				}
				size++;
				nodeAdded = true;
				break;
			} else {
				tmp = tmp.getNext();
			}
		}
		if (!nodeAdded) {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			size++;
		}
		return this;
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data -the data for the Node within the linked list
	 * @returns - reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	public BasicDoubleLinkedList<T> addToEnd(T Data) {

		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data -the data for the Node within the linked list
	 * @returns - reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	public SortedDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	/**
	 * Implements the iterator by calling the super class iterator method. an
	 * iterator positioned at the head of the list
	 */

	public java.util.ListIterator<T> iterator() {
		return super.iterator();
	}

	/**
	 * Implements the remove operation by calling the super class remove method.
	 * 
	 * @param data - the data element to be removed
	 * @Param the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public SortedDoubleLinkedList<T> remove(T data) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	
	 
	  public T getFirst() 
	  {
		  return super.getFirst(); }
	 
	public T getLast() {
		return super.getLast();
	}

	
	public int getSize() {
		return super.getSize();
	}

	
	public T retrieveFirstElement() {
		return super.retrieveFirstElement();
	}

	
	public T retrieveLastElement() {
		return super.retrieveLastElement();
	}


	 public ArrayList<T> toArrayList() { return super.toArrayList(); }
	 

}
