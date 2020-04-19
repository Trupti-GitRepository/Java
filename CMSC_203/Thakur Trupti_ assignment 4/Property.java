package cmsc.java.cmsc_203_assignment4;
/**
 * Property class is a Data Element Class named Property that has fields
 *  to hold the property name the city where the property is located,
 *  the rent amount, the owner's name, and the Plot to be occupied by the property.
 * 
 * @author Trupti Thakur
 *
 */
public class Property 
{
	private String city,owner,propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**No- arg constructor.
	  */
	public Property()
	{
		city="";
		owner="";
		propertyName="";
		rentAmount=0.0;
		this.plot= new Plot (0,0,1,1);
		
	}
	/**copy constructor, creates a new object using the information of the object passed to it.
	 * 
	 * @param p  object of Property class.
	 */
	public Property(Property p)
	{
		this.city=p.city;
		this.owner=p.owner;
		this.propertyName=p.propertyName;
		this.rentAmount=p.rentAmount;
		plot=p.plot;
		
	}
	/**
	 * parameterized constructor, no plot information provided.
	 * @param propertyName- name of the property
	 * @param city- name of the city
	 * @param rentAmount- rentAmount
	 * @param owner-name of the owner.
	 */
	 
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.city=city;
		this.owner=owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		
	}
	/**
	 * parameterized constructor, plot information provided.
	 * @param propertyName  name of the property
	 * @param city     name of the city
	 * @param rentAmount   rentAmount
	 * @param owner  name of the owner.
	 * @param x  the x-value of the property's plot
	 * @param y  the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth  the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		this.city=city;
		this.owner=owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.plot= new Plot(x, y, width, depth);
		
	}
	/**
	 * getCity method returns String city
	 * @return - name of the city.
	 */
	
	public String getCity()
	{
		
		return city;
		
	}
	/**
	 * getOwner method returns the name of the owner
	 * @return- name of the owner.
	 */
	public String getOwner() 
	{
		return owner;
	}
	/**
	 * getPropertyName method returns the name of the property.
	 * @return
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	/**
	 * getRentAmount method returns rentAmount.
	 * @return- rentAmount
	 */
	public double getRentAmount() 
	{
		return rentAmount;
	
	}
	/**
	 * This method set the plot values and return plot instance.
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width- the horizontal size of the property's plot
	 * @param depth- the vertical size of the property's plot
	 * @return the plot of the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		return plot;
		
	}
	/**
	 * getPlot returns the the plot.
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
		
	}
	/**
	 * setCity methods accepts the STring value and set the city.
	 * @param city
	 */
	public void setCity(String city) {
		this.city=city;
	}
	
	/**
	 * setOwner methods set the name of the owner.
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner=owner;
	}
	
	/**
	 * This method set the Property name.
	 * @param PropertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	
	/**
	 * setRentAmount method set the rent amount.
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
		
	}
	
	/**
	 * toSTring method return concatenated string.
	 */
	public String toString() {
		return  "Property Name:  " + propertyName  +"\n" +
				" Located in " + city + "\n" + " Belonging to: " + owner + "\n" + " Rent Amount: " + "  " + rentAmount;
	 
			
	}
}
