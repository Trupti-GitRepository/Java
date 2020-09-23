
/**
 * This program sum the values in an array of integers.
 * @author trupt
 *
 */
public class ArraySum {

	public int sumOfArray (Integer[] a,int index) {
		
		if(index==0)  //base case
			return a[index];
		else
			//Recursive call
			// add value of that index + sum of previous indexes
			return a[index] + sumOfArray(a, index-1);  
		
		
		
	}

}
