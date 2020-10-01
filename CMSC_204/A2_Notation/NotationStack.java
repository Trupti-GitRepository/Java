import java.util.ArrayList;
import java.util.List;
/**
 * NotationStack will implement the Stack Interface 
 * @author Trupti Thakur
 *
 */
public class NotationStack<T> implements StackInterface<T> {

	private List<T> elements;
	private int top;
	private int size;
	
	

	public NotationStack(int size) {
		this.size=size;
		top=-1;
		elements=new ArrayList<>(size);
	}

	@Override
	public boolean isEmpty() {
		return top==-1;
	}

	@Override
	public boolean isFull() {
		return top==size-1;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(top==-1) {
			throw new StackUnderflowException();
		}
		T element=elements.remove(top--);
		return element;
	}

	@Override
	public T top() throws StackUnderflowException {
		if(top==-1) {
			throw new StackUnderflowException();
		}
		return elements.get(top);
	}

	@Override
	public int size() {
		return top+1;
	}

	
	@Override 
	public boolean push(T e) throws StackOverflowException {
	  if(top==size-1) { 
		  throw new StackOverflowException(); 
	  } 
	  elements.add(e);
	  ++top;
	  return true; 
	}
	 

	@Override
	public String toString(String delimiter) {
		StringBuilder sb=new StringBuilder();
		for(T e:elements) {
			sb.append(e).append(delimiter);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(T e:elements) {
			sb.append(e);
		}
		return sb.toString();
	}

	@Override
	public void fill(ArrayList<T> list) {
		top=-1;
		for(T e:list) {
			if(top<size) {
				top++;
				elements.add(e);
			}else {
				break;
			}
		}		
	}

	/*
	 * @Override public boolean push(Object e) throws StackOverflowException { //
	 * TODO Auto-generated method stub return false; }
	 */

}
