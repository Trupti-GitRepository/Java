package com.java.cmsc_203_Lab4;
/** Purpose of this class is to model a Television.
 * @author Trupti Thakur.
 *Date : 27th FEb. 2020.
 */

public class Television {
	// Constant declaration.
	final String MANUFACTURER;  // //Hold the Manufacturere's Brand name.
	final int SCREEN_SIZE;	 //Hold the screenSize of the Television.
	
	boolean powerOn=false;      //Hold the status of the powerOn button of the television.
	int channel=2;				//hold the value of the station that the television is showing.
	int volume=20;				//hold a number value representing the loudness l.
	
	
	// Constructor, accepting two arguments, String MANUFACTURER's brand name , int SCREEN_SIZE
	public Television(String manufacturer, int screenSize) 
	{
		this.MANUFACTURER=manufacturer;
		this.SCREEN_SIZE=screenSize;
	}
	//The getVolume method will return the value stored in the volume field.
	public int getVolume(){
		return volume;
	}
	
	//The getChannel method will return the value stored in the channel field.
	public int getChannel(){
		return channel;
	}
	
	//The getManufacturer method will return the constant value stored in the MANUFACTURER field.
	public String getManufacturer(){
		return MANUFACTURER;
	}
	
	//The getScreenSize method will return the constant value stored in the SCREEN_SIZE field.
	public int getScreenSize(){
		return SCREEN_SIZE;
	}
	
	// The setChannel method will store the desired station in the channel field.
	public void setChannel (int station) {
		channel=station;
	}
	
	//The power method  changing the value stored in the powerOn field from true to false or from false to true.
	public void power() {
		if(!powerOn)
		{
			powerOn=true;
		}
		else
		{
			powerOn=false;
		}
		
	}
	// will increase the value stored in the volume field by 1.

	public void increaseVolume() {
		volume++;
	}
	// Will decrease the value stored in the volume field by 1.

	public void decreaseVolume() {
		volume--;
	}


}
	
