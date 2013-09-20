public class MergeSort {

	static int mergeSort(int a[], int t[], int start, int end) {

		if (start >= end)
			return 0;

		int mid = (start + end) / 2;

		int count = mergeSort(a, t, start, mid);
		count += mergeSort(a, t, mid + 1, end);
		count += merge(a, t, start, mid, end);
		return count;
	}

	private static int merge(int[] a, int[] t, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start;
		int count = 0;
		while (i <= mid && j <= end) {
			if (a[i] > a[j]) {
				t[k++] = a[j++];
				count += mid - i + 1;
			} else {
				t[k++] = a[i++];
			}
		}

		while (i <= mid) {
			t[k++] = a[i++];
		}
		while (j <= end) {
			t[k++] = a[j++];
		}

		while (start <= end) {
			a[start] = t[start];
			start++;
		}
		
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 3, 4, 2, 6, 3, 2,5,9,10 };
		int[] t = new int[a.length];

		int inversions = mergeSort(a, t, 0, a.length - 1);
		System.out.println("Inversions : " + inversions);
		for (int t1 : t) {
			System.out.print(t1 + ", ");
		}
	}
}