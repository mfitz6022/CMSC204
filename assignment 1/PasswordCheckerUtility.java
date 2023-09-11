import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility() {}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!password.equals(passwordConfirm)) throw new UnmatchedException();
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm) ? true : false;
			
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for (String password : passwords)
			try {
				isValidPassword(password);
			} catch (Exception e) {
				String message = password;
				message += ": " + e.getMessage();
				invalidPasswords.add(message);
			}
		return invalidPasswords;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		return (password.length() >= 6 && password.length() <= 9) ? true : false;
	}
	
	public static boolean hasDigit(String password) throws NoDigitException {
		Pattern digitPattern = Pattern.compile("\\d+");
		Matcher matcher = digitPattern.matcher(password);
		if (matcher.find()) return true;

		throw new NoDigitException();
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern specialPattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = specialPattern.matcher(password);
		if (matcher.find()) return true;

		throw new NoSpecialCharacterException();
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern upperPattern = Pattern.compile("[A-Z]+");
		Matcher matcher = upperPattern.matcher(password);
		if (matcher.find()) return true;

		throw new NoUpperAlphaException();
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern specialPattern = Pattern.compile("[a-z]+");
		Matcher matcher = specialPattern.matcher(password);
		if (matcher.find()) return true;
	 
		throw new NoLowerAlphaException();
	}
	
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6) return true;
			
		throw new LengthException();
	}
	
	public static boolean isValidPassword(String password)throws 
	LengthException, 
	NoUpperAlphaException, 
	NoLowerAlphaException, 
	NoDigitException, 
	NoSpecialCharacterException, 
	InvalidSequenceException 
	{
		return (isValidLength(password) &&
				hasLowerAlpha(password) &&
				hasUpperAlpha(password) &&
				hasSpecialChar(password) &&
				NoSameCharInSequence(password)) ? true : false; 
	}

	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		else 
			return false;
	}
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for (int i = 0; i < password.length(); i++) {
			char currentChar = password.charAt(i);
			char nextChar = password.charAt(i+1);
			if (i + 1 != password.length())
				if (currentChar == nextChar) throw new InvalidSequenceException();
		}
		
		return true;
	}
}
