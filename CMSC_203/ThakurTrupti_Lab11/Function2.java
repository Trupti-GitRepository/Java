
public class Function2 extends Function {
	/**
	 * This method returns a string that describes the result of the optimization.
	 * @return  "The time a dog must travel " + x 
	 * + "meters along the beach and then swim to fetch the ball is "+ optVal + " seconds";
	 */
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		
		return String.format("The minimum time a dog must travel %.2f meters along the beach and then swim to fetch the ball is %.2f seconds", x, optVal);
	}
/**
 *  @return the time in terms of x
 */
	@Override
	public double fnValue(double x) {
		
				if ((Math.pow(x,2)-8*x+25)<0)
					return Double.MAX_VALUE;
				else return ((x/3)+2*Math.sqrt(Math.pow(x,2)-8*x+25));
	}

	@Override
	public double getXVal(double x) {
		// returns the value of the distance x along the bank
		return x;
	}

	@Override
	public double getYVal(double x) {
		// dummy y value
		return -1;
	}

	@Override
	public double getZVal(double x) {
		// dummy z value
		return -1;
	
	}
	public String toString() {
		// This method returns a string that describes the problem.
		return "Minimize the time it takes a dog to run and swim to fetch a ball";
	}


}
