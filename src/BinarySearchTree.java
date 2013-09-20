import java.lang.ref.Reference;
import java.util.Stack;

public class BinarySearchTree extends Tree {

	public static Node makeNewRoot(Node root, int value) {

		boolean leftChild;
		Node result;

		if (root == null)
			return null;

		if (value < root.data) {
			leftChild = true;
			result = makeNewRoot(root.left, value);
		} else if (value > root.data) {
			leftChild = false;
			result = makeNewRoot(root.right, value);
		} else {
			return root;
		}

		if (result == null) {
			return null;
		}

		Node temp = result;
		if (leftChild) {
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = root;
			root.left = null;
		} else {
			while (temp.left != null) {
				temp = temp.left;
			}
			temp.left = root;
			root.right = null;
		}
		return result;
	}

	public static void findSum(Node n, int sum) {

		Stack<Node> leftStack = new Stack<Tree.Node>();
		Node left = n;

		Stack<Node> rightStack = new Stack<Tree.Node>();
		Node right = n;

		while (left.left != null) {
			leftStack.push(left);
			left = left.left;
		}

		while (right.right != null) {
			rightStack.push(right);
			right = right.right;
		}

		while (left.data < right.data) {
			if (left.data + right.data == sum) {
				System.out.println("Found: " + left.data + "," + right.data);
				if (left.right != null) {
					left = left.right;
					while (left.left != null) {
						leftStack.push(left);
						left = left.left;
					}
				} else {
					left = leftStack.pop();
				}
				if (right.left != null) {
					right = right.left;
					while (right.right != null) {
						rightStack.push(right);
						right = right.right;
					}
				} else {
					right = rightStack.pop();
				}

			} else if (left.data + right.data < sum) {
				if (left.right != null) {
					left = left.right;
					while (left.left != null) {
						leftStack.push(left);
						left = left.left;
					}
				} else {
					left = leftStack.pop();
				}

			} else {

				if (right.left != null) {
					right = right.left;
					while (right.right != null) {
						rightStack.push(right);
						right = right.right;
					}
				} else {
					right = rightStack.pop();
				}
			}
		}
	}

	public static void convertToDLL(Node root, Node[] head, Node[] tail) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			convertToDLL(root.left, head, tail);
		}

		root.left = tail[0];
		if (tail[0] != null) {
			tail[0].right = root;
		} else {
			head[0] = root;
		}

		tail[0] = root;

		if (root.right != null) {
			convertToDLL(root.right, head, tail);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.new Node(100, bst.new Node(50, bst.new Node(25,
				bst.new Node(0, null, bst.new Node(10, null, null)),
				bst.new Node(30, null, null)), bst.new Node(75, null, null)),
				bst.new Node(150, bst.new Node(125, null, null), bst.new Node(
						200, null, null)));
		System.out.println(bst);

		// bst.root = makeNewRoot(bst.root, 75);

		// System.out.println(bst);
		// findSum(bst.root, 210);

		Node[] head = new Node[1];
		Node[] tail = new Node[1];
		convertToDLL(bst.root, head, tail);

		Node temp = head[0];
		while (temp != null) {
			System.out.print(temp.data + "-");
			temp = temp.right;
		}
	}

}
