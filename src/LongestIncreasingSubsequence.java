import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LongestIncreasingSubsequence {

	List<Integer> findLIS(int[] sequence) {

		List<Pile<Integer>> piles = new ArrayList<Pile<Integer>>();

		for (int i = 1; i < sequence.length; i++) {

			Pile<Integer> newPile = new Pile<Integer>();
			newPile.push(sequence[i]);

			int index = Collections.binarySearch(piles, newPile);
			if (index < 0) {
				index = ~index;
			}
			if (index != piles.size()) {
				piles.get(index).push(sequence[i]);
			} else {
				piles.add(newPile);
			}
		}
		return null;
	}

	static int LIS(int a[]) {

		int[] lis = new int[a.length];
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		int max = 1;
		for (int a1 : lis) {
			if (a1 > max) {
				max = a1;
			}
		}
		return max;
	}

	static int longestAlternatingSequence (int a[]) {
		int[] incr = new int[a.length];
		int[] decr = new int[a.length];
		
		for (int i=0;i <a.length; i++) {
			incr[i] = 1;
			decr[i] = 1;
		}
		
		for (int i = 1; i<a.length; i++) {
			for (int j =0; j<i; j ++) {
				if (a[i] > a[j] && incr[i] < decr[j] + 1) {
					incr[i] = decr[j] + 1;
				}
				
				if (a[i] < a[j] && decr[i] < incr[j] + 1) {
					decr[i] = incr[j] + 1;
				}
			}
		}
		
		int max = 1;
		for (int i : incr) {
			if (i > max) {
				max = i;
			}
		}
		
		for (int i : decr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	static void printPairs(int a[]) {
		
		for (int i = 0; i<a.length; i++) {
			for (int j=1; j<i; j++) {
				if (a[i] > a[j]) {
					System.out.println("Pair : " + a[i] + ":" + a[j]);
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10, 22, 33, 11, 25, 21, 1, 55, 100};
		//System.out.println(LIS(a));
		System.out.println(longestAlternatingSequence(a));
		
		//printPairs(a);
	}

	private static class Pile<E extends Comparable<? super E>> extends Stack<E>
			implements Comparable<Pile<E>> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int compareTo(Pile<E> y) {
			return peek().compareTo(y.peek());
		}
	}
}
