
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.scene.control.Alert;

/**The program PasswordCheckerUtility will validate password.
 * @author Trupti Thakur.
 */
public final class PasswordCheckerUtility extends java.lang.Object {

	private static ArrayList<String> passwords = new ArrayList<>();
	static boolean hasNum = false, hasUpr = false, hasLow = false, hasSplSym = false, hasInvalSeq = false;
	static char c;

	/**
	 * Constructor.
	 */
	public PasswordCheckerUtility() {

	}

	/**The isValidPassword method checks the parameter is a valid password string.
	 * 
	 * @param passwordString
	 * @return True if valid password, false if an invalid password.
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoSpecialSymbolException
	 * @throws InvalidSequenceException
	 * 
	 */
	
	public static boolean isValidPassword(java.lang.String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, NoSpecialSymbolException, InvalidSequenceException {

		if (passwordString.length() < 6) {
			throw new LengthException();
		} else if (hasUpr(passwordString) == false) {
			throw new NoUpperAlphaException();
		}else if (hasLow(passwordString) == false) {
			throw new NoLowerAlphaException();
		} else if (hasNum(passwordString) == false) {
			throw new NoDigitException();
		} else if (hasSplSym(passwordString) == false) {
			throw new NoSpecialSymbolException();
		} else if (hasInvalSeq(passwordString) == true) {
			throw new InvalidSequenceException();
		} else {
			return true;
		}

	}

	/**
	 * The method isWeakPassword checks the parameter String is >=6 and <=9.
	 * @param passwordString
	 * @return true if length of password is equal to 6 but less that or equal to 9.
	 * @throws WeakPasswordException
	 */
	
	public static boolean isWeakPassword(java.lang.String passwordString) throws WeakPasswordException {

		if ((passwordString.length() >= 6) && (passwordString.length() <= 9)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * The method invalidPasswords returns an arraylist of invalid passwords (weak passwords are not considered invalid)
	 * @param passwords
	 * @return an Arraylist of invalid passwords( Weak passwords are not consider as invalid.)
	 * @throws IOException
	 * @throws Exception
	 * @throws NoSpecialSymbolException
	 * @throws NoLowerAlphaException
	 * @throws NoUpperAlphaException
	 * @throws NoDigitException
	 * @throws LengthException
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) throws IOException, LengthException,
			NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialSymbolException, Exception {
		ArrayList<String> invalid = new ArrayList<String>();
		String pwd = null;
		for (int i = 0; i < passwords.size(); i++) {
			pwd = passwords.get(i);
			try {
				if (isValidPassword(pwd) == false) {

					// throw new InvalidSequenceException("The password cannot contain more than two
					// of the same character in sequence. ");
				}

			} catch (Exception e) {
				// String exception= e.getMessage();
				// System.out.println(pwd + " " + e.getStackTrace());

				// JOptionPane.showMessageDialog(null, (e.getMessage()));
				invalid.add(pwd + " --> " + e.getMessage());

			}
			// display result
			for (int j = 0; j < invalid.size(); j++) {
				System.out.println(invalid.get(j));
			}

		}

		return invalid;
	}

	// Checks passwords has At least 1 numeric character [\s0-9].
	private static boolean hasNum(String password) {
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if (Character.isDigit(c)) {
				hasNum = true;
				return true;
			}

		}

		return false;
	}

	//Checks password has At least 1 uppercase alphabetic character
	private static boolean hasUpr(String password) {
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				hasUpr = true;
				return true;
			}
		}

		return false;
	}

	//Checks password has At least 1 Lowercase alphabetic character
	private static boolean hasLow(String password) {
		for (int i = 0; i < password.length(); i++) {
			c = password.charAt(i);
			if (Character.isLowerCase(c)) {
				hasLow = true;
				return true;
			}

		}

		return false;
	}

	// check password has atleast 1 special character.
	private static boolean hasSplSym(String password) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			hasSplSym = true;
			return true;
		}

		return false;

	}
	
	/*
	 * The method checks No more than 2 of the same character in a sequence
	 * Hello@123 – OK AAAbb@123 – not OK Aaabb@123 – OK
	 */

	private static boolean hasInvalSeq(String password) {
		char prevchar = ' ';
		char prevchar1 = ' ';
		char current = ' ';

		for (int i = 0; i < password.length(); i++) {
			current = password.charAt(i);
			if (prevchar != current) {
				prevchar = current;
			} else if (prevchar1 != current) {
				prevchar1 = prevchar;
			} else if (((current == prevchar) && (prevchar == prevchar1))) {
				hasInvalSeq = true;
				return true;
			}

		}

		return false;
	}

}
