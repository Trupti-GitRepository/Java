/**
 * 
 * @author Trupti Thakur
 *
 */
public class Function1 extends Function {
	/**
	 * The method answerString returns a string.
	 * @return String 
	 */
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		//				return "Minimum cost is $" + optVal + " with height = " + y + " cm and radius = " + x + "cm";
				return String.format("Minimum cost is $%.2f with height = %.2f cm and radius = %.2f cm", optVal, y, x);
	}

	@Override
	public double fnValue(double x) {
		if (x==0.0)
			return Double.MAX_VALUE;
		else return (0.8*Math.PI * Math.pow(x,2)+800/x);
	}
	/**
	 * @return x - value of the radius.
	 */
	@Override
	public double getXVal(double x) {
		// TODO Auto-generated method stub
		return x;
	}
	/**
	 * @return height in terms of the radius.
	 */
	@Override
	public double getYVal(double x) {
		// TODO Auto-generated method stub
		return 2000/(Math.PI*Math.pow(x,2));
	}
	/**
	 *@return -1
	 */
	@Override
	public double getZVal(double x) {
		// TODO Auto-generated method stub
		return -1;
	}
	/**
	 * @return String.
	 */
	public String toString() {
		return "Minimize the cost of a can that will hold 2 liters of liquid";
	}
	

}
