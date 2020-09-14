
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of PasswordChecker
 * @author Trupti Thakur
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwordStr = new ArrayList<String>();
	String passwordStr1, passwordStr2;

	@Before
	public void setUp() throws Exception {
		String[] pass = { "889911EE", "Hello123@ok", "saumya2ZZZ", "4sal#", "prasad22#", "4wardMarch#", "august30",
				"pqrstuvw", "KavinWan#", "zz22b", "Germantown", "myHealth", "myHealth33" };
		passwordStr.addAll(Arrays.asList(pass)); // put strings into ArrayList.

	}

	@After
	public void tearDown() throws Exception {
		passwordStr = null;

	}

	/**
	 * Test if the password is less than 8 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("wErt#12#"));
			PasswordCheckerUtility.isValidPassword("we12%");
			assertTrue("Did not throw lengthException", false);

		} catch (LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some different exception other than length exception", false);
		}

	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("wert#12#"));
			assertTrue("Did not throw NoUpperAlphaException", false);
		} catch (NoUpperAlphaException e) {
			assertTrue("successfully threw NoUpperAlphaException exception ", true);
		} catch (Exception e) {
			assertTrue("Threw some different exception other than length exception", false);
		}

	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("WERT#12#"));
			assertTrue("Did not throw NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("successfully threw NoLowerAlphaException exception ", true);
		} catch (Exception e) {
			assertTrue("Threw some different exception other than length exception", false);
		}

	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("5678wwEEA#"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("5678wwEE");
			assertTrue(weakPwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("WeRtt#12##"));
			PasswordCheckerUtility.isValidPassword("WEEEEe#12#");
			assertTrue("Did not throw an InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("WErt#wryu"));
			assertTrue("Did not throw NoDigitException", false);
		} catch (NoDigitException e) {
			assertTrue("Successfully thrown NoDigitException ", true);

		} catch (Exception e) {
			assertTrue("Threw some other exception other than NoDigitException ", false);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("WEr1t#wr2yu"));
			assertTrue("This is a valid password", true);
		} catch (Exception e) {
			assertTrue("Invalid password", false);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 * 
	 * @throws Exception
	 * @throws NoSpecialSymbolException
	 * @throws NoLowerAlphaException
	 * @throws NoUpperAlphaException
	 * @throws NoDigitException
	 * @throws LengthException
	 * @throws IOException
	 */
	@Test
	public void testInvalidPasswords() throws IOException, LengthException, NoDigitException, NoUpperAlphaException,
			NoLowerAlphaException, NoSpecialSymbolException, Exception {
		ArrayList<String> output;
		output = PasswordCheckerUtility.invalidPasswords(passwordStr);
		Scanner scan = new Scanner(output.get(0)); //
		assertEquals(scan.next(), "889911EE");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		// assertEquals(scan.nextLine(), " The password must contain at least one
		// lowercase alphabetic character.");
		scan = new Scanner(output.get(1)); //
		assertEquals(scan.next(), "saumya2ZZZ");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));
		// assertEquals(scan.nextLine(), " The password cannot contain more than two of
		// the same character in sequence.");
		scan = new Scanner(output.get(3)); //
		assertEquals(scan.next(), "prasad22#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		// assertEquals(scan.nextLine(), " The password must contain at least one
		// uppercase alphabetic character.");
		scan = new Scanner(output.get(5)); //
		assertEquals(scan.next(), "pqrstuvw");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") || nextResults.contains("digit"));
		// assertEquals(scan.nextLine(), " The password must contain at least one
		// digit.");
		scan = new Scanner(output.get(6)); // a
		assertEquals(scan.next(), "KavinWan#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		// assertEquals(scan.nextLine(), " The password must contain at least one
		// digit.");
	}

}
