import java.util.Random;

public class QuickSort {

	private static int[] arr = {2, 1}; //{ -3000, -100, -100, 330, 440, 440, 550, 650};//, 110, 101,
			//93, 85, 76, 18, 220 };

	public static int partition(int[] array, int low, int high) {

		if (low >= high || low < 0 || high >= array.length) {
			return -1;
		}

		int pivotIndex = new Random().nextInt(high - low + 1);
		pivotIndex = low + pivotIndex;
		int temp = array[low];
		array[low] = array[pivotIndex];
		array[pivotIndex] = temp;
		pivotIndex = low;
		
		low = low + 1;
		while (low < high) {

			while (low < high && array[low] < array[pivotIndex]) {
				low++;
			}

			while (high > pivotIndex && array[high] > array[pivotIndex]) {
				high--;
			}

			if (low < high) {
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}

		temp = array[high];
		array[high] = array[pivotIndex];
		array[pivotIndex] = temp;
		return high;
	}

	public static void quickSort(int[] array, int low, int high) {

		int partitionIndex = partition(array, low, high);

		if (partitionIndex != -1) {
			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	public static void main(String[] args) {

		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
}