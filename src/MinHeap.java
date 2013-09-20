import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap<E extends Comparable<E>> {

	private List<E> elements;
	private int k;

	public MinHeap(int k, List<E> elements) {
		this.k = k;
		this.elements = elements;
	}

	public boolean isEmpty() {
		return k <= 0;
	}

	public void buildHeap() {
		for (int i = k / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}

	public void heapify(int root) {

		int left = leftChild(root);
		int right = rightChild(root);
		int min = root;
		if (k > left && elements.get(root).compareTo(elements.get(left)) > 0) {
			min = left;
		}

		if (k > right && elements.get(min).compareTo(elements.get(right)) > 0) {
			min = right;
		}

		if (min != root) {
			swap(min, root);
			heapify(min);
		}

	}

	public void insert(E e) {
		elements.add(k++, e);
		int parent = parent(k - 1);
		int i = k - 1;
		while (parent >= 0
				&& elements.get(parent).compareTo(elements.get(i)) > 0) {
			swap(parent, i);
			i = parent;
			parent = parent(i);
		}
	}

	public E deleteMin() {
		swap(0, k - 1);
		k--;
		heapify(0);
		E e = elements.get(k);
		elements.remove(k);
		return e;
	}

	private void swap(int i, int j) {
		E temp = elements.get(i);
		elements.set(i, elements.get(j));
		elements.set(j, temp);
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return 2 * i + 1;
	}

	private int rightChild(int i) {
		return 2 * i + 2;
	}

	public static void main(String[] args) {
		Integer[] elements = { 3, 2, 1, 5, 4, 0, 1, -1, -9 };

		ArrayList<Integer> elementList = new ArrayList<Integer>(
				Arrays.asList(elements));
		int k = elements.length;
		MinHeap<Integer> heap = new MinHeap<Integer>(k, elementList);
		heap.buildHeap();
		for (int e : elementList) {
			System.out.print(e + ", ");
		}

		System.out.println();
		System.out.println(heap.deleteMin());
		for (int e : elementList) {
			System.out.print(e + ", ");
		}
	}
}
