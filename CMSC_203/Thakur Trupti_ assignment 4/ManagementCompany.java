package cmsc.java.cmsc_203_assignment4;

import java.util.List;
/**A property management company manages individual properties they will build to rent,
 *  and charges them a management fee as the percentages of the monthly rental amount. 
 * This class take input, operate on the data structure,
 *  and return values or set variables that may be accessed with getters.
 * @author Trupti Thakur
 *
 */

public class ManagementCompany
{

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private Property[] property = new Property[MAX_PROPERTY];
	private double mgmFeePer;
	String name, taxID;
	private Plot plot;
	private int arrayCounter = 0;

	/**
	 * No-Arg constructor that creates a Management company object using strings and
	 * default plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany() 
	{
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0.0;
		this.property = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);

	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * Mgmt Co plot is initialized to default Plot. "properties" array is
	 * initialized here as well.	
	 * @param name--management company name
	 * @param taxID--tax id
	 * @param mgmFeePer--management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.property = new Property[MAX_PROPERTY];

	}

	/**
	 * Constructor creates a Managementcompany Object using passed information. Mgmt
	 * Co plot is initialized to default plot. "proporties' array is initialized
	 * here as well.
	 * @param name      Management company's name
	 * @param taxID-    tax id
	 * @param mgmFeePer management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);

	}

	/**
	 * Copy constructor creates a Management Company object using other Mangement
	 * company object. "proporties' array is initialized here as well.
	* @param othercompany another management company.
	 */
	public ManagementCompany(ManagementCompany othercompany) {
		name = othercompany.name;
		taxID = othercompany.taxID;
		mgmFeePer = othercompany.mgmFeePer;
		this.plot = othercompany.plot;

	}

	/**
	 * The getMAX_PROPERTY return MAX_PROPERTY constant that represent the size of the "properties"
	 * array.
	 * @return MAX_PROPERTY. array length 
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}

	/**
	 * addProperty method adds the property object to the "properties" array.
	 * @param property
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property,
	 *  or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property)
	{
		if (arrayCounter > MAX_PROPERTY - 1)
			return -1;
		if (property == null)
			return -2;
		if (!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		if (arrayCounter > 0) {
			for (int i = 0; i < arrayCounter; i++) 
			{

				if (this.property[i].getPlot().overlaps(property.getPlot()))
				{

					return -4;
				}
			}
		}
		

		if (arrayCounter <= MAX_PROPERTY - 1) {
			this.property[arrayCounter] = property;
			arrayCounter++;
		}

		return arrayCounter-1;

	}
	/**
	 *This method Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name property name
	 * @param city property located
	 * @param rent rent amount
	 * @param owner name of the owner
	 * @return Returns either -1 if the array is full,
	 */
	 

	public int addProperty(String name, String city, double rent, String owner)
	{
		Property p = new Property(name, city, rent, owner);
		//Returns either -1 if the array is full, 
		if (arrayCounter > MAX_PROPERTY - 1)
			return -1;
		//-2 if property is null, 
		if (property == null)
			return -2;
		
		//-3 if the plot is not contained by the MgmtCo plot, 
		if (!plot.encompasses(p.getPlot()))
		{
			return -3;
		}
		//-4 of the plot overlaps any other property,
		 
		if(arrayCounter>0) 
		{
			for(int i=0;i<arrayCounter;i++)
			{
				if (this.property[i].getPlot().overlaps(p.getPlot()))
						{
						return -4;
						}
			}
		}
	
		// the index in the array where the property was added successfully.
		if (arrayCounter <= MAX_PROPERTY - 1) 
		{
			this.property[arrayCounter] = p;
			arrayCounter++;
		}
			

		return arrayCounter;
	}
	/**
	 * This method Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name property name
	 * @param city property located
	 * @param rent rent amount
	 * @param owner name of the owner
	 * @param x  x value of the plot
	 * @param y y vlaue of the plot
	 * @param width width of the plot 
	 * @param depth depth of the plot
	 * @return Returns either -1 if the array is full, 
		 */
	 

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		if (arrayCounter > MAX_PROPERTY - 1)
			return -1;
		if (property == null)
			return -2;
		if ((!plot.encompasses(p.getPlot())))
		{
			return -3;
		}
		if(arrayCounter>0) {
			for(int i=0;i<arrayCounter;i++) {
				if(this.property[i].getPlot().overlaps(p.getPlot())) 
				{
					return -4;
				}
				
			}
		}
		
		if (arrayCounter <= MAX_PROPERTY - 1)
		{
			this.property[arrayCounter] = p;
			arrayCounter++;
		}
			

		return arrayCounter;

	}

	/**
	 * The totalRent method accesses each "Property" object within the array "properties" and
	 * sums up the property rent and returns the total amount.
	 * @return total rent
	 */

	public double totalRent()
	{

		double totalRent = 0.0;
		for (int i = 0; i < arrayCounter; i++)
		{
			// Property p= new Property();
			totalRent += property[i].getRentAmount();

		}

		return totalRent;
	}

	/**
	 * The maxRentProp method finds the property with the maximum rent amount and returns its
	 * toString result.
	 * @return a String, the toString of the property with the maximum rent amount
	 */

	public String maxRentProp() 
	{
		Property maxRent = property[0];

		for (int i = 1; i < arrayCounter; i++) 
		{
			if (maxRent.getRentAmount() < property[i].getRentAmount()) 
			{
				maxRent = property[i];
				// return property[i].toString();
			}
		}
		return maxRent.toString();

	}

	/**
	 * The maxRentPropertyIndex method finds the index of the property with the maximum rent amount.
	 * @return int , the index of the property with the maximum rent amount
	 */
	public int maxRentPropertyIndex()
	{
		int maxRentIndex = 0;
		Property maxRent = property[0];
		int count = 1;
		while (count < arrayCounter)
		{
			if (maxRent.getRentAmount() < property[count].getRentAmount()) 
			{
				maxRent = property[count];
				maxRentIndex = count;
				
			}
			count++;
		}
		return maxRentIndex;
	}

	/**
	 * The displayPropertyAtIndex Displays the information of the property at index i.
	 * @param i-The index of the property within the array "properties"
	 * @return information of the property at index i
	 */
	public String displayPropertyAtIndex(int i)
	{
		return property[i].toString();
	}

	@Override
	/**
	 * The toString method prints out the name, city, owner and rent amount for a property
	 * @returns information of ALL the properties within this management company by accessing the "Properties" array.
	 */
	public String toString() {
		StringBuilder str1 = new StringBuilder();
		str1.append("List of the properties for " + name + ", taxID :" +taxID + "\n");
		str1.append("____________________________________________________________\n");
		for (int i = 0; i < property.length; i++) {
			str1.append("\t" + "property Name: " + property[i].getPropertyName() + "\n");
			str1.append("\t  " + "Located in " + property[i].getCity() + "\n");
			str1.append("\t  " + "Belonging to : " + property[i].getOwner() + "\n");
			str1.append("\t  " + "Rent Amount: " + property[i].getRentAmount() + "\n");
			//System.out.println("\n");

		}
		
		str1.append("____________________________________________________________\n");
		
		str1.append(" total management Fee: " + getTotalmgmFee());
		
		return str1.toString();

	}
	
	/**
	 * The getTotalmgmFee method calculates the total management fee.
	 * @return total management fee.
	 */
	
	public double getTotalmgmFee() 
	{
		double totalManagementFee=0;
		for(int i=0;i<arrayCounter;i++) 
		{
			double ManagementFee=(property[i].getRentAmount()*(mgmFeePer/100));
			totalManagementFee+=ManagementFee;
			
		}
		
		return totalManagementFee;
	}
	/**
	 * This method returns name of the property
	 * @return name of the property 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the plot of the property
	 * @return plot of the property 
	 */

	public Plot getPlot() {
		return plot;
	}

}
