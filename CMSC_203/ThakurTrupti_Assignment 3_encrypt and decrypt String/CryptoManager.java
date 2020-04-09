package com.java.cmsc_203_assignment3;

import java.util.Arrays;
import java.util.List;
/**
 * This class encrypt and decrypt a phrase using Caesar cipher and Bellaso method.
 * @author Trupti Thakur
 *
 */

public class CryptoManager {

	private static final char LOWER_BOUND = 32;
	private static final char UPPER_BOUND = 95;
	private static final char SPACE=' ';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *      bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		char[] val = plainText.toCharArray();
		for (int i = 0; i < val.length; i++) {
			if (!(val[i]==SPACE) &&!(val[i] >= LOWER_BOUND && val[i] <= UPPER_BOUND)) {
				return false;
			}
		}
		return true;
	}
	
	/*public static void main(String[] args) {
		//System.out.println(stringInBounds("THIS TEST SHOULD SUCCEED"));
		//System.out.println(encryptCaesar("TESTING ANOTHER STRING", 999));
	 //System.out.println(decryptCaesar(";,:;05.G(56;/,9G:;905.", 999));
			 
		//System.out.print(encryptBellaso("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
	System.out.println(decryptBellaso("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
	}*/

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// throw new RuntimeException("method not implemented");
		char[] ipArr = plainText.toCharArray();
		char[] opArr = new char[ipArr.length];
		int tmp = '0';
		while(key > RANGE)
		{
			key=key-RANGE;
		}			
		for (int i = 0; i < ipArr.length; i++) {
			
			tmp = (ipArr[i]+key);
			
				if(tmp>UPPER_BOUND) 
				{
					tmp=tmp-RANGE;
				//opArr[i]=(char)tmp;
				}
				if(tmp<LOWER_BOUND) 
				{
					tmp=tmp+RANGE;
				//opArr[i]=(char)tmp;
				}
				
			opArr[i]=(char)tmp;
			
			}
					
		return new String(opArr);
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		
			// copying plaintext into char array.
			char[] pTxtArray = plainText.toCharArray();
			char[] bTxtArray = bellasoStr.toCharArray();
			char[] refArray=new char[pTxtArray.length];
			char[] dcrptArray=new char[refArray.length];
			int counter=0;
			int offset=0;
			char temp=0;									
			
			//Copy complete array into reference array as many time as required
			//When plain String is greater than bellaso string.
			while((pTxtArray.length-counter)>=bTxtArray.length)
			{
				for(int i=counter,j=0;j<bTxtArray.length;j++,i++) {
				refArray[counter]=bTxtArray[j];
				counter++;
				}
			}
			
			 	//gathering phase		
			for(int i=counter,j=0;i<pTxtArray.length;i++,j++) 
			{
				refArray[i]=bTxtArray[j];
			}
			
						
				//Offset calculation.
			for(int i=0;i<refArray.length;i++) 
			{
				offset=refArray[i]+pTxtArray[i];
				if(offset<UPPER_BOUND) {
					temp=(char)offset;
				}else {
				temp=(char)(offset-RANGE);	
				if(temp>UPPER_BOUND)
				{
					temp=(char) (temp-RANGE);
				}
				}
				dcrptArray[i]=temp;
				
			}
							
		return new String(dcrptArray);
		}
	

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// copying plaintext into char array.
		char[] ipArr = encryptedText.toCharArray();
		char[] opArr = new char[ipArr.length];
		int tmp = '0';
		while(key > RANGE)
		{
			key=key-RANGE;
		}			
		for (int i = 0; i < ipArr.length; i++) {
			
				tmp = (ipArr[i]+RANGE)-key;	
								
			
				if(tmp>UPPER_BOUND) 
				{
					tmp=tmp-RANGE;
				
				}
				if(tmp<LOWER_BOUND) 
				{
					tmp=tmp+RANGE;
				
				}
				
			opArr[i]=(char)tmp;
			
			}
		
		
		
		return new String(opArr);
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		// coping encryptedText and bellasoStr into char array.
					char[] pTxtArray = encryptedText.toCharArray();
					char[] bTxtArray = bellasoStr.toCharArray();
					char[] refArray=new char[pTxtArray.length];
					char[] ecrptArray=new char[pTxtArray.length];
					int counter=0;
					int offset=0;
					char temp=0;
					
						//Copy complete array into reference array as many time as required
						//When plain String is greater than bellaso string.
						while((pTxtArray.length-counter)>=bTxtArray.length)
						{
							for(int i=counter,j=0;j<bTxtArray.length;j++,i++) {
							refArray[i]=bTxtArray[j];
							counter++;
							}
						}
						
						 	//gathering phase		
						for(int i=counter,j=0;i<pTxtArray.length;i++,j++) 
						{
							refArray[i]=bTxtArray[j];
						}
						
					// Offset calculation.
					for(int i=0;i<refArray.length;i++) 
					{
						offset=pTxtArray[i]+RANGE;
															
						temp=(char)(offset-refArray[i]);						
						
						if(temp>UPPER_BOUND) {
							temp=(char) (temp-RANGE);
						}else if (temp<LOWER_BOUND) {
							temp=(char) (temp+RANGE);
						}
						ecrptArray[i]=temp;
					}
									
				return new String(ecrptArray);
				}
		
}