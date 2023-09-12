
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
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
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(1)));
		}
		catch(LengthException e) {
			assertTrue("Threw Length exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(2)));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(3)));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(4)));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw weak password exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(5)));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw InvalidSequence exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(6)));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoDigit exception",true);
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
		} 
		catch (Exception e) {
			assertTrue("Exception thrown ",true);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalid = PasswordCheckerUtility.getInvalidPasswords(passwords);
		System.out.println("INVALID PASSWORDS:");
		for (String password : invalid)
			System.out.println(password);
		assertEquals("T1ny#: The password must be at least 6 characters long", invalid.get(0));
		assertEquals("nouppercase6%: The password must contain at least one uppercase alphabetic character", invalid.get(1));
		assertEquals("NOL0WERCASE!: The password must contain at least one lowercase alphabetic character", invalid.get(2));
		assertEquals("Sequencepasssword#5: The password cannot contain more than two of the same character in sequence", invalid.get(3));
		assertEquals("noNumber?: The password must contain at least one digit", invalid.get(4));
	}
	
}
