import java.util.ArrayList;
import java.util.List;

public class MergeLists {

	public static class Node implements Comparable<Node> {

		int data;
		Node next;

		Node(int data){
			this.data = data;
		}
		@Override
		public int compareTo(Node o) {
			if (this.data == o.data) {
				return 0;
			} else if (this.data < o.data) {
				return -1;
			}
			return 1;
		}
	}

	private Node resultList;
	private MinHeap<Node> minHeap;

	
	public MergeLists(List<Node> lists) {
		
		this.minHeap = new MinHeap<Node>(lists.size(), lists);
		this.minHeap.buildHeap();
	}

	public void merge() {

		Node tail = null;
		while (!minHeap.isEmpty()) {

			Node node = minHeap.deleteMin();
			
			if (resultList == null) {
				resultList = node;
				tail = node;
			} else {
				tail.next = node;
				tail = node;
			}
			if (node.next != null) {
				minHeap.insert(node.next);
			}
			node.next = null;
		}
	}

	public static void main(String[] args) {
		
		List<Node> list = new ArrayList<MergeLists.Node>();
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(5);
		n1.next.next.next.next = new Node(7);
		list.add(n1);
		
		Node n2 = new Node(4);
		n2.next = new Node(6);
		n2.next.next = new Node(8);
		n2.next.next.next = new Node(10);
		list.add(n2);

		Node n3 = new Node(9);
		n3.next = new Node(11);
		n3.next.next = new Node(12);
		n3.next.next.next = new Node(13);
		list.add(n3);

		Node n4 = new Node(-4);
		n4.next = new Node(-2);
		n4.next.next = new Node(-1);
		n4.next.next.next = new Node(14);
		list.add(n4);

		Node n5 = new Node(-3);
		list.add(n5);
		
		MergeLists ml = new MergeLists(list);
		ml.merge();
		ml.printList();
	}

	private void printList() {
		
		Node temp = resultList;
		while(temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}		
	}
}
