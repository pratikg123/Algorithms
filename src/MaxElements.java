public class MaxElements {

	static void maxElements(int a[]) {

		int max = a[a.length - 1];
		for (int i = a.length - 1; i >= 0; i--) {

			int prevMax = max;
			if (a[i] > max) {
				max = a[i];
			}
			if (i == a.length - 1) {
				a[i] = -1;

			} else {
				a[i] = prevMax;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 6, 1, 7, 8, 0, 1 };
		maxElements(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
	}

}
