public class Permutations {

	static void permutation(String str) {

		char[] chars = str.toCharArray();
		permutate(chars, 0, chars.length);

	}

	private static void permutate(char[] chars, int i, int length) {

		if (i == length-1) {
			System.out.println(String.valueOf(chars));
		} else {

			for (int j = i; j < length; j++) {
				swap(chars, i, j);
				permutate(chars, i + 1, length);
				swap(chars, i, j);
			}
		}

	}

	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation("abc");

	}

}
