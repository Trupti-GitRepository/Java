package cmsc.java.cmsc_203_assignment4;
/**
 * Plot that has fields specifying the X and Y location 
 * of the upper left corner of each Plot and a depth and width of each Plot. 
 * @author Trupti Thakur.
 */

public class Plot {
	private int x,y,width,depth;
	
	/**
	 * No-arg constructor creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	
	/**
	 * Copy constructor, creates a new object using the information of the object passed on it.
	 * @param p-   object of class Plot.
	 */
	public Plot(Plot p) {
		this.x=p.x;
		this.y=p.y;
		this.width=p.width;
		this.depth=p.depth;
	}
	
	/**
	 * Parameterized constructor. 
	 * @param x  --horizontal coordinate of upper left corner.
	 * @param y -- vertical coordinate of upper left corner.
	 * @param width --horizontal size
	 * @param depth--depth - vertical size
	 */
	
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
		
	}
	/**
	 * Overlaps method determines if this plot overlaps the parameter.
	 * @param plot object of class Plot.
	 * @return returns true of the two plots overlap, false otherwise. 
	 */
	public boolean overlaps(Plot plot) {
		if(plot.y<y+depth && plot.y+plot.depth>y && plot.x <x+width && plot.x+plot.width>x) {
			return true;
		}
		return false;
		
		
	}
	/**
	 * Encompasses method takes a Plot instance and determines if the current plot contains it. 
	 * @param plot object of class Plot.
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses( Plot plot) {
		if( plot.x+plot.width<=x+width && plot.y+ plot.depth<= y+ depth && plot.x >=x && plot.y>= y) {
			return true;
		}
		return false;
	
	}
	/**
	 * setX method sets the x value.
	 * @param x value
	 */
	public void setX(int x) {
		this.x=x;
	}
	
	/**
	 * setY method sets the y value.
	 * @param y value
	 */
	public void setY(int y) {
		this.y=y;
	}
	/**
	 * getX return the value of x.
	 * @return x value
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * getY return the value of y
	 * @return y value.
	 */
	public int getY() {
		return y;
	}
	/**
	 * setWidth method sets the width.
	 * @param width value
	 */
	
	public void setWidth(int width) {
		this.width=width;
	}
	
	/**
	 * getWidth return the value of width.
	 * @return width value
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * This method sets the depth of the plot.
	 * @param depth value
	 */
	public void setDepth(int depth) 
	{
		this.depth=depth;
	}
	/**
	 * getDepth return the value of depth.
	 * @return depth value
	 */
	public int getDepth() 
	{
		return depth;
	}
	
	/**
	 * toString prints out the name, city, owner and rent amount for a property
	 * @return  toString  String
	 */
	@Override
	public String toString()
	{
		return "Upper left: ("+ x +","+ y + "); Width: "+ width + " Depth: " + depth ;
	}
	
	
}
