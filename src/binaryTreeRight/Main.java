package binaryTreeRight;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1l = new TreeNode(2);
		TreeNode left2r = new TreeNode(5);
		TreeNode right1r = new TreeNode(3);
		TreeNode right2r = new TreeNode(4);
		
		root.left = left1l;
		root.right = right1r;
		left1l.right = left2r;
		right1r.right = right2r;
		
		Main m = new Main();
		
		System.out.println("The right side of the tree is " + m.rightSideView(root).toString());
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> path = new ArrayList<Integer>();
		return traverse(root, path);
	}

	public List<Integer> traverse(TreeNode root, List<Integer> path) {
		if (null == root) {
			return path;
		}
		path.add(root.val);
		traverse(root.right, path);
		return path;
	}

}
