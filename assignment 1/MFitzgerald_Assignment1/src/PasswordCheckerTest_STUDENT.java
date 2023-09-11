
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Matthew Fitzgerald
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		passwords.add("validPas5word!");
		passwords.add("T1ny#");
		passwords.add("nouppercase6%");
		passwords.add("NOL0WERCASE!");
		passwords.add("Weak1@");
		passwords.add("Sequencepasssword#5");
		passwords.add("noNumber?");
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try{
			PasswordCheckerUtility.isValidPassword(passwords.get(1));
			assertTrue("Did not throw lengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Threw Length exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw other exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(2));
			assertTrue("Did not throw NoUpperAlpha exception", false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception", true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
			PasswordCheckerUtility.isValidPassword(passwords.get(3));
			assertTrue("Did not throw NoLowerApha exception", false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception", true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
		assertTrue(PasswordCheckerUtility.isWeakPassword(passwords.get(4)));
		assertTrue("Did not throw weakPassword exception", false);
		}
		catch(WeakPasswordException e) {
		assertTrue("Threw weakPassword exception", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(4)));
			PasswordCheckerUtility.isValidPassword(passwords.get(5));
			assertTrue("did not Throw InvalidSequence exception", false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequence exception", true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception", true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(6));
			assertTrue("did not throw HasDigit exception", false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoDigit exception", true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
			assertTrue("did not throw an exception", true);
		} catch (Exception e) {}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalid = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals("T1ny#: The password must be at least 6 characters long", invalid.get(0));
		assertEquals("nouppercase6%: The password must contain at least one uppercase alphabetic character", invalid.get(1));
		assertEquals("NOL0WERCASE!: The password must contain at least one lower case alphabetic character", invalid.get(2));
		assertEquals("Sequencepasssword#5: The password cannot contain more than two of the same character in sequence", invalid.get(3));
		assertEquals("noNumber?: The password must contain at least one digit", invalid.get(4));
	}
	
}
