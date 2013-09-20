import java.util.EmptyStackException;
import java.util.Stack;

public class Tree {

	Node root;

	class Node {
		int data;
		Node left;
		Node right;
		boolean visited = false;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString(int depth) {
			StringBuilder tree = new StringBuilder();
			if (this.right != null) {
				tree.append(this.right.toString(depth + 1));
			}
			tree.append("\n" + appendSpace(depth) + this.data);
			if (this.left != null) {
				tree.append(this.left.toString(depth + 1));
			}
			return tree.toString();

		}

		private String appendSpace(int depth) {
			StringBuilder space = new StringBuilder();
			for (int i = 0; i < depth; i++) {
				space.append("   ");
			}
			return space.toString();
		}
	};

	public String toString() {
		return root.toString(0);

	}

	public void nonRecursiveInorder(Node root) {

		Node node = root;
		Stack<Node> stack = new Stack<Tree.Node>();

		while (true) {
			while (node.left != null && !node.left.visited) {
				stack.push(node);
				node = node.left;
			}

			if (!node.visited) {
				System.out.println(node.data);
				node.visited = true;
			}

			if (node.right != null && !node.right.visited) {
				stack.push(node.right);
			}

			try {
				node = stack.pop();
			} catch (EmptyStackException e) {
				break;
			}
		}
	}

	public void recursiveInorder(Node root) {
		if (root != null) {
			recursiveInorder(root.left);
			System.out.println(root.data);
			recursiveInorder(root.right);
		}
	}

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
	}

	static int preIndex = 0;

	public static TreeNode buildTree(int[] inorder, int[] preorder, int[] pre,
			int inOrderStart, int inorderEnd) {

		if (pre[0] >= preorder.length || inOrderStart > inorderEnd) {
			return null;
		}
		TreeNode n = new TreeNode();
		n.data = preorder[pre[0]++];

		if (inOrderStart == inorderEnd)
			return n;

		int inIndex = inOrderStart;
		for (int i = inOrderStart; i<=inorderEnd; i++) {
			if (inorder[i] == n.data) {
				inIndex = i;
				break;
			}
		}		

		n.left = buildTree(inorder, preorder, pre, inOrderStart, inIndex - 1);
		n.right = buildTree(inorder, preorder, pre, inIndex + 1, inorderEnd);
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Tree tree = new Tree(); tree.root = tree.new Node(10, tree.new
		 * Node(20, tree.new Node(40, null, tree.new Node(100, null, null)),
		 * tree.new Node(50, null, null)), tree.new Node(30, tree.new Node(60,
		 * null, null), tree.new Node( 80, null, null)));
		 */
		// tree.root = tree.new Node(10, null, tree.new Node(20,null,null));
		// tree.recursiveInorder(tree.root);
		// tree.nonRecursiveInorder(tree.root);
		// System.out.println(tree);

		int[] inorder = { 4, 2, 5, 1, 6, 3 };
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		TreeNode node = buildTree(inorder, preorder, new int[]{0}, 0, inorder.length - 1);
		inorder(node);
	}

	private static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + ", ");
			inorder(node.right);
		}

	}
}