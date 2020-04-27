package com.java.cmsc_203_assignment5;
/**
 * Holiday bonus class calculates the bonuses for the stores in each category.
 * @author Trupti Thakur.
 *
 */
public class HolidayBonus {
	
	private static double [] sales;
	
	
	
	
	/**
	 * no-arg constructor
	 */	
	public HolidayBonus() {
		
	}
	/**
	 *The calculateHolidayBonus Calculate the holiday bonus for each store.
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[]calculateHolidayBonus(double [][] data, double high, double low, double other) 
	{	
		sales= new double[data.length];
		
		
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(data[i][j]>0) {
				if((data[i][j])==(TwoDimRaggedArrayUtility.getHighestInColumn(data, j))){
					sales[i]+=high;
				}else if((data[i][j])==(TwoDimRaggedArrayUtility.getLowestInColumn(data, j))){
					sales[i]+=low;
					
				}else if((data[i][j]<TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) && (data[i][j]>TwoDimRaggedArrayUtility.getLowestInColumn(data, j))) {
					sales[i]+=other;
				}
				}						
						
			}
			
		}
		return sales;
			
		}
			
	/**
	 * Calculates the total holiday bonuses.
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses.
	 * 
	 */
	public static double calculateTotalHolidayBonus(double [][] data, double high, double low, double other) 
	{
		double totalBonus=0.0;
		calculateHolidayBonus(data, high, low, other);
		
		for(int i=0;i<sales.length;i++) {
			totalBonus+=sales[i];
		}
		
		return totalBonus;
	}

}
