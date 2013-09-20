public class AncestorMatrix {

	static int[][] ancestorMatrix;

	static class Node {
		int value;
		Node left;
		Node right;
	}

	static void fillMatrix(Node n) {

		if (n.left != null) {
			ancestorMatrix[n.left.value][n.value] = 1;
			ancestorMatrix[n.value][n.left.value] = 0;

			for (int i = 0; i < ancestorMatrix[n.left.value].length; ++i) {
				if (i != n.value) {
					ancestorMatrix[n.left.value][i] = ancestorMatrix[n.value][i];
				}
			}

			fillMatrix(n.left);
		}

		if (n.right != null) {
			ancestorMatrix[n.right.value][n.value] = 1;
			ancestorMatrix[n.value][n.right.value] = 0;

			for (int i = 0; i < ancestorMatrix[n.right.value].length; ++i) {

				if (i != n.value) {
					ancestorMatrix[n.right.value][i] = ancestorMatrix[n.value][i];
				}
			}

			fillMatrix(n.right);
		}
	}

	public static void main(String[] args) {

		ancestorMatrix = new int[4][4];

		Node n0 = new Node();
		n0.value = 0;

		Node n1 = new Node();
		n1.value = 1;

		Node n2 = new Node();
		n2.value = 2;
		n2.left = n0;
		n2.right = n1;

		Node n3 = new Node();
		n3.value = 3;
		n3.left = n2;

		fillMatrix(n3);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(ancestorMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
