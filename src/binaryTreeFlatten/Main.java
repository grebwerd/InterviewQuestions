package binaryTreeFlatten;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1l = new TreeNode(2);
		TreeNode left2l = new TreeNode(3);
		TreeNode left2r = new TreeNode(4);

		TreeNode right1r = new TreeNode(5);
		TreeNode right2r = new TreeNode(6);

		root.left = left1l;
		root.right = right1r;

		left1l.left = left2l;
		left1l.right = left2r;

		right1r.right = right2r;

		Main m = new Main();
		m.printList(m.flatten(root));
	}

	public TreeNode flatten(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode head = root;

		while (null != p || !stack.isEmpty()) {
			if (null != p.right) {
				stack.push(p.right);
			}

			if (null != p.left) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.isEmpty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}

		return head;
	}

	public void printList(TreeNode root) {

		System.out.print("The value of the linkedlist: ");

		while (null != root) {
			System.out.print(root.val + ", ");
			root = root.right;
		}
	}
}
