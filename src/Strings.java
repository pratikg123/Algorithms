public class Strings {

	public static String longestPalindrome(String input) {
		char[] inputArray = input.toCharArray();
		int maxLength = 0;
		String longestPalindrome = null;
		for (int i = 0; i<input.length(); i++) {
			String palindrome =  findLongestPalindrome(inputArray, i);
			if (maxLength < palindrome.length()) {
				maxLength = palindrome.length();
				longestPalindrome = palindrome;
			}
		}
		return longestPalindrome;
	}
	
	private static String findLongestPalindrome(char[] inputArray, int i) {
		String oddLengthPalindrome = findOddLengthLongestPalindrome(inputArray, i);
		String evenLengthPalindrome = findEvenLengthLongestPalindrome(inputArray, i);
		if (oddLengthPalindrome.length() > evenLengthPalindrome.length()) {
			return oddLengthPalindrome;
		} else {
			return evenLengthPalindrome;
		}
	
	}
	private static String findEvenLengthLongestPalindrome(char[] inputArray, int i) {
		int lower = i;
		int upper = i+1;
		String longestPalindrome = "";
		StringBuilder builder = new StringBuilder(longestPalindrome);
		while (lower >= 0 && upper < inputArray.length && inputArray[lower] == inputArray[upper] ) {
			builder = builder.insert(0, inputArray[lower]);
			builder = builder.append(inputArray[upper]);
			lower --;
			upper ++;			
		}
		
		return builder.toString();
	}

	private static String findOddLengthLongestPalindrome(char[] inputArray, int i) {
		int lower = i-1;
		int upper = i+1;
		String longestPalindrome = inputArray[i] + "";
		StringBuilder builder = new StringBuilder(longestPalindrome);
		while (lower >= 0 && upper < inputArray.length && inputArray[lower] == inputArray[upper] ) {
			builder = builder.insert(0, inputArray[lower]);
			builder = builder.append(inputArray[upper]);
			lower --;
			upper ++;			
		}
		
		return builder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPalindrome("baaaaaaaaabaaaaaaaaaaaaaab"));
	}

}
