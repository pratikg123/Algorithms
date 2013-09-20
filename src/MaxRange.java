import java.util.HashMap;
import java.util.Map;

public class MaxRange {

	static void maxRange(int[] array) {
		Map<Integer, Integer> rangeMap = new HashMap<Integer, Integer>();

		int range = 1;
		rangeMap.put(array[0], array[0]);
		for (int i = 1; i < array.length; i++) {
			
			if (array[i] == array[i - 1] + 1) {
				rangeMap.put(array[i-range], array[i]);
				range++;
			} else {
				range = 1;
				rangeMap.put(array[i], array[i]);
			}
		}
		
		int maxRange = 1;
		int maxRangeStartElement = Integer.MAX_VALUE;
		for (int i : rangeMap.keySet()) {
			if (maxRange < rangeMap.get(i) - i) {
				maxRange = rangeMap.get(i) - i;
				maxRangeStartElement = i;
			}
		}
		System.out.println("Max Range: " + maxRangeStartElement + ":" + (maxRangeStartElement + maxRange));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,5,6,7,8,-2,-1,0,1,2,3, -100, -99, -98, -97, -96, -95};
		maxRange(array);

	}

}
