public class SwapNodes {

	public static class Node {
		int data;
		Node next;
	}

	// 2-3-4-5-6
	// 3-2-4-5-6
	// 3-2-5-4-6
	public static Node swapAlternateNodes(Node n) {

		if (n == null || n.next == null) {
			return n;
		}

		Node temp = n;
		Node tempNext = n.next;
		Node prev = null;
		while (temp != null && temp.next != null) {
			Node temp1 = temp.next.next;
			temp.next.next = temp;
			if (prev != null) {
				prev.next = temp.next;
			}
			temp.next = temp1;
			prev = temp;
			temp = temp.next;
		}
		return tempNext;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node n = new Node();
		n.data = 0;
		Node cur = n;
		for (int i = 1; i < 4; i++) {
			Node temp = new Node();
			temp.data = i;
			cur.next = temp;
			cur = cur.next;
		}

		Node temp = n;
		while (temp != null) {
			System.out.print(temp.data + "-");
			temp = temp.next;
		}

		System.out.println();
		Node n2 = swapAlternateNodes(n);
		Node temp2 = n2;
		while (temp2 != null) {
			System.out.print(temp2.data + "-");
			temp2 = temp2.next;
		}

	}

}
