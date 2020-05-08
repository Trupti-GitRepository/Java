
public class Function3 extends Function {

	/**
	 * This method returns a string that describes the result of the optimization.
	 */
	@Override
	public String answerString(double optVal, double x, double y, double z) {
	
		return String.format("The minimum distance between the function f(x) = x^2 and the point (0, 1) is %.2f", optVal);

	}
	
	
	public String toString() {
		return "Find the minimum distance between the function f(x) = x^2 and the point (0, 1).\n" + 
				"This distance is described by the function d(x) = sqrt(x^4 - x^2 +1)";
	}
/**
 * @returns the x-coordinate of point a minimum distance from (0,1)
 */
	@Override
	public double fnValue(double x) {
		
		return Math.sqrt(Math.pow(x, 4)-Math.pow(x, 2)+1);
	}

	@Override
	public double getXVal(double x) {
	
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

}