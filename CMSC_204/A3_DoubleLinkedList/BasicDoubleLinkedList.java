
import java.io.*;
import java.util.*;

/**
 * This is a generic double-linked list class.
 * 
 * @author Trupti Thakur
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {
	protected ListNode head;
	protected ListNode tail;
	protected int size;
	protected Comparator<T> comparator;

	/**
	 * Constructor - Creates a empty list.
	 */
	public BasicDoubleLinkedList() {
		this.size = 0;
	}

	/**
	 * This method just returns the value of the instance variable you use to keep
	 * track of size.
	 * 
	 * @return the size of the linked list.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds an element to the end of the list. Do not use iterators to implement
	 * this method.
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return - reference to the current object
	 */

	public BasicDoubleLinkedList<T> addToEnd(T data) {
		ListNode newNode = new ListNode(data);
		if (getSize() == 0) {
			head = newNode;
			tail = head;
			++size;
		} else {
			if (size == 1) {
				// IF there is only one node present
				head.next = newNode;
				head.next.last = head;
				tail = newNode;
				++size;
			} else {
				// If there are more than one node present
				tail.next = newNode;
				tail.next.last = tail;
				tail = newNode;
				++size;
			}
		}
		return this;
	}

	/**
	 * Adds element to the front of the list. Do not use iterators to implement this
	 * method.
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return - reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		ListNode newNode = new ListNode(data);
		if (getSize() == 0) {
			head = newNode;
			tail = head;
		} else {
			if (size == 1) {
				head.last = newNode;
				newNode.next = head;
				head = newNode;
				size++;
			} else {
				head.last = newNode;
				newNode.next = head;
				head = newNode;
				++size;

			}

		}

		return this;

	}

	/**
	 * This method Returns but does not remove the first element from the list. If
	 * there are no elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getFirst() {
		if (getSize() == 0)
			return null;
		else
			return head.data;
	}

	/**
	 * Returns but does not remove the last element from the list. If there are no
	 * elements the method returns null.
	 * 
	 * @return the data element or null
	 */
	public T getLast() {
		if (getSize() == 0)
			return null;
		else
			return tail.data;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		ListNode tmpNode = null;
		if (size == 0) {
			return null;
		} else if (size == 1) {
			tmpNode = head;
			head = null;
			tail = null;
			--size;
			return tmpNode.data;
		} else {
			tmpNode = head;
			head = tmpNode.next;
			--size;
			return tmpNode.data;
		}
	}

	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return data element or null
	 */

	public T retrieveLastElement() {
		ListNode tempNode = null;
		if (size == 0) {
			return null;
		} else if (size == 1) {
			tempNode = tail;
			head = null;
			tail = null;
			--size;
			return tempNode.data;

		} else {
			tempNode = tail;
			tail = tempNode.last;
			--size;
			return tempNode.data;
		}

	}

	/**
	 * This method removes the first instance of the targetData from the list.
	 * Remove the elements by performing a single traversal over the list.
	 * 
	 * @param targetData -the data element to be removed
	 * @param comparator -the comparator to determine equality of data elements
	 * @return data element or null
	 */

	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		this.comparator = comparator;
		ListNode tmp = null;
		if (size == 0) {
			return this;
		} else {
			tmp = head;
			while (tmp != null) {
				if (comparator.compare(tmp.data, targetData) == 0) {
					if (size == 1) {
						head = null;
						tail = null;
					} else {
						if (tmp == head) {
							head = tmp.next;
							tmp.next = null;
							head.last = null;
						} else if (tmp == tail) {
							tail = tmp.last;
							tmp.last = null;
							tail.next = null;
						} else {
							tmp.last.next = tmp.next;
							tmp.next.last = tmp.last;
							tmp.last = null;
							tmp.next = null;
						}
					}
					--size;
					break;
				} else {
					tmp = tmp.next;
				}
			}
		}

		return this;

	}

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return - an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> opList = new ArrayList<>(size);
		ListNode tmp = head;
		while (tmp.next != null) {
			opList.add(tmp.data);
			tmp = tmp.next;
		}
		opList.add(tmp.data);
		return opList;
	}

	// Inner class
	public class ListNode {
		private T data;
		private ListNode next;
		private ListNode last;

		public ListNode(T data) {
			this.data = data;

		}

		@Override
		public String toString() {
			return data.toString();
		}

		/**
		 * Get data of the node.
		 * 
		 * @return data of the element
		 */
		public T getData() {
			return data;
		}

		/**
		 * Get previous address of the node.
		 * 
		 * @return previous address of the node
		 */
		public ListNode getLast() {
			return last;
		}

		/**
		 * Get next address of the node.
		 * 
		 * @return next address of the node
		 */
		public ListNode getNext() {
			return next;
		}

		/**
		 * set previous address of the node.
		 * 
		 */
		public void setPrevious(ListNode n) {
			last = n;
		}

		/**
		 * set next address of the node.
		 * 
		 */
		public void setNext(ListNode n) {
			next = n;
		}

	} // end of inner class

	// Inner class implementating itarator
	private class DLLIterator<T> implements ListIterator<T> {
		private int counter = 0;
		private ListNode tmpPtr = null;

		@Override
		public boolean hasNext() {
			return counter < size;
		}

		@Override
		public T next() {
			if (counter < size) {
				if (tmpPtr == null) {
					tmpPtr = head;
				} else {
					tmpPtr = tmpPtr.next;
				}
				counter++;
				return (T) tmpPtr.data;
			}
			throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {

			return counter > 0;
		}

		@Override
		public T previous() {
			if (counter > 0) {
				T dt = (T) tmpPtr.data;
				tmpPtr = tmpPtr.last;
				counter--;
				return dt;
			}
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();

		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();

		}

	}

	/**
	 * This method must be implemented using an inner class that implements
	 * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and
	 * previous(). @ return reference
	 */
	public java.util.ListIterator<T> iterator() {
		return new DLLIterator<>();
	}
}
