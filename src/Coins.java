import java.util.Arrays;

public class Coins {

	static int minimumCoins(int sum, int[] denominations) {

		Arrays.sort(denominations);
		
		int coins[] = new int[sum + 1];
		coins[0] = 0;

		for (int i = 1; i < sum + 1; i++) {

			int minimum = Integer.MAX_VALUE;

			for (int j = 0; j < denominations.length
					&& i - denominations[j] >= 0; j++) {

				if (coins[i - denominations[j]] != -1
						&& minimum > coins[i - denominations[j]] + 1) {
					minimum = coins[i - denominations[j]] + 1;
				}
			}

			if (minimum < Integer.MAX_VALUE) {
				coins[i] = minimum;
			} else {
				coins[i] = -1;
			}
		}

		for (int i : coins) {
			System.out.print(i + " ");
		}
		System.out.println();
		return coins[sum];
	}

	public static void main(String[] args) {

		System.out.println(minimumCoins(3, new int[] { 5, 2 }));		

	}

}
