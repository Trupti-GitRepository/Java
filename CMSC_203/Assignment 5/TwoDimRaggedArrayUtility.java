package com.java.cmsc_203_assignment5;
//package cmsc.java.cmsc_203_assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.javafx.util.TempState;

/**
 * This utility class manipulates a two-dimensional ragged array of doubles 
 * which will be used to create a sales report.
 * @author Trupti Thakur
 */
public class TwoDimRaggedArrayUtility {
	
	/**No-arg constructor.
	 */	
	public TwoDimRaggedArrayUtility(){
		
	}
	/**
	 * The method getAvarage return the average of the elements in the two dimensional array.
	 * @param data-the two dimensional array.
	 * @return the average of the elements in the two dimensional array.
	 */
	
	public static double getAverage(double[][]data)
	{
	double average=0;
	int counter=0;   // count the total element in the array.
	double total=0;
	for(int i=0;i<data.length;i++) {
		for(int j=0;j<data[i].length;j++) {
			total+=data[i][j];
			counter++;
		}
	}
	average=(total/counter);
	return average;
	}
	/**
	 * The method getColumnTotal returns the total of the selected column in the array.
	 * @param data- the two dimensional array.
	 * @return the total of the selected column..
	 */
	public static double getColumnTotal(double[][] data,int col)
	{
		double columnTotal=0.0;;
		for(int row=0;row<data.length;row++) {
			 
				if(data[row].length>col) {
		
					columnTotal+=data[row][col];
				}
			}
		
		
		
	return columnTotal;
	
	}
	
	/**
	 * The method Returns the largest element in the two dimensional array
	 * @param data-the two dimensional array.
	 * @return the Returns the largest element.
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highestInArray=data[0][0];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(highestInArray<data[i][j]) {
					highestInArray=data[i][j];
				}
								
			}
		}
	return highestInArray;
	}
	/**
	 * The method Returns the largest element of the selected column in the two dimensional array.
	 * @param data-the two dimentioanl array.
	 * @param col- the column index to find the largest element of (0 refers to the first column)
	 * @return the Returns the largest element of the column.
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highestInColumn=0;
		for(int i=0;i<data.length;i++)
		{
				if(data[i].length>col && highestInColumn<data[i][col]) 
				{
					highestInColumn=data[i][col];
				}
							
			
							
			}
		return highestInColumn;
		
		}
		
	
	
	
	/**
	 * The method Returns index of the largest element of the selected column
	 *  in the two dimensional array index 0 refers to the first column.
	 * @param data -the two dimentional array
	 * @param-The column index to find the largest element of (0 refers to the first column)
	 * @return the Returns the largest element of the column.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double max=0;
		int maxrow=0;
		for(int i=0; i<data.length; i++) {

			if(data[i].length>col && data[i][col]>max) {
				max=data[i][col];
				maxrow=i;
			}
		}
 		return maxrow;
	}
	
	

	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data--the two dimensional array.
	 * @param row--the row index to find the largest element of (0 refers to the first row)
	 * @return the Returns the largest element of the row.
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highestInRow=data[row][0];
		for(int i=row;i<data[row].length;i++)
		{
			for(int j=0;j<data[row].length;j++) 
			{
				if(highestInRow<data[row][j]) 
				{
					highestInRow=data[row][j];
				}
						
			
			}
		
					
			}
		return highestInRow;
		
		
	
	}
	/**
	 * The method Returns the largest element of the selected row
	 *  in the two dimensional array index 0 refers to the first row.
	 *
	 * @param data
	 * @param row
	 * @return the Returns the largest element of the column.
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double max=0;
		int maxcol=0;
		
			for(int j=0;j<data[row].length;j++) {
				if(data[j].length>=row && data[row][j]>max) {
					max=data[row][j];
					maxcol=j;
				
			
			
			}
		}
		return maxcol;
	}
	
	
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data--the two dimensional array.
	 * @return the Returns the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowestInArray=data[0][0];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				if(lowestInArray>data[i][j]) {
					lowestInArray=data[i][j];
				}
								
			}
		}
	return lowestInArray;
	
	}
	
	/**
	 * Returns the smallest element of the selected column in the
	 *  two dimensional array index 0 refers to the first column.
	 * @param data---the two dimensional array.
	 * @param col---the column index to find smallest element of.
	 * @return the Returns the smallest element in the two dimensional array
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowestInColumn=Double.MAX_VALUE;
		for(int i=0;i<data.length;i++)
		{
			
				if(data[i].length>col && lowestInColumn>data[i][col]) 
				{
					lowestInColumn=data[i][col];
				}
						
			
							
			}
		return lowestInColumn;
	
	}
	
	/**
	 * Returns the index of the smallest element of the selected column 
	 * in the two dimensional array index 0 refers to the first column.
	 * @param data
	 * @return the Returns the largest element of the column.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double low=99999999;
		int lowestRow=999999;
		for(int i=0; i<data.length; i++) {
			if(data[i].length>col && data[i][col]<low  ) {
				low=data[i][col];
				lowestRow=i;
			}
		}
		return lowestRow;
	}
	
	/**
	 * Returns the lowest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data- the two dimentional array
	 * @param row--the row index to search smallest element in that row index
	 * @return the Returns the lowest element of the row.
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowestInRow=data[row][0];
		
			for(int j=0;j<data[row].length;j++) 
			{
				if(lowestInRow>data[row][j]) 
				{
					lowestInRow=data[row][j];
				}
						
			
	
					
			}
		return lowestInRow;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row 
	 * in the two dimensional array index 0 refers to the first row.
	 * @param data-the two dimensional array.
	 * @param row- the row index to find the smallest element of 
	 * @return the Returns the smallest element of the row.
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double low=99999999;
		int lowestCol=9999999;
		
			for(int col=0;col<data[row].length;col++) {
				if(data[row].length>=row && data[row][col]<low) {
					low=data[row][col];
					lowestCol=col;
				}
			}
			
		
		return lowestCol;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data-the two dimensional array
	 * @param row-the row index to take the total of(0 refers to the first row.)
	 * @return the total of the row. 
	 */
	public static double getRowTotal(double[][] data, int row)
	{
	double rowTotal=0;
	
		
			for(int j=0;j<data[row].length;j++) {
				rowTotal+=data[row][j];
			}
			
	
		
	
	return rowTotal;
	
	}
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data
	 * @return the Returns the lowest element of the row.
	 */
	public static double getTotal(double[][] data)
	{
	double total=0;
	for(int i = 0; i<data.length; i++) 
	{
		for(int j = 0; j<data[i].length; j++) 
		{
			total+=data[i][j];
		}
		
	}
	return total;
	
	}
	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and 
	 * the maximum columns for each row is 10 Each row in the file is 
	 * separated by a new line Each element in the row is separated by a space Suggestion: 
	 * You need to know how many rows and how many columns there are for each row to create a ragged array.
	 * @param data
	 * @return the Returns the lowest element of the row.
	 */
	public static double[][] readFile(File file)throws FileNotFoundException
	{
	double [][] data= null;
	String [][] temp=new String[10][];
		Scanner inputFile=new Scanner(file);
	int i=0;
	while(inputFile.hasNext()&& i<temp.length) {
		String line=inputFile.nextLine();
		String[] lineArray=line.split(" ");
		temp[i]=lineArray;
		
		i++;
		
	}
	data=new double[i][];
	for(int j=0; j<i; j++) {
		String[] tmpStrig=temp[j];
		double[] tmpDouble=new double[tmpStrig.length];
		int counter=0;
		for(String s:tmpStrig) {
			tmpDouble[counter++]=Double.parseDouble(s);
		}
		data[j]=tmpDouble;
	}
	
	inputFile.close();
	return data;
	
	}
	
	/**
	 * Writes the ragged array of doubles into the file.
	 * @param data
	 * @param outputFile 
	 * @throws IOException 
	 */
	public static void writeToFile(double data[][], File outputFile) throws IOException {
		
		PrintWriter writeFile =new PrintWriter(outputFile);  //open file
		for(int i=0;i<data.length;i++) {
			for(int j=0; j<data[i].length; j++) {
				writeFile.print(data[i][j]+" ");            //Write data.	
			}
			writeFile.println();
		}
		
		writeFile.flush(); 
		writeFile.close();            //Close file
		
	}
	
}
