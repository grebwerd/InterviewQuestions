package printBinaryTreePath;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1a = new TreeNode(2);
		TreeNode right1a = new TreeNode(3);
		root.left = left1a;
		root.right = right1a;

		Main main = new Main();
		main.binaryTreePaths(root);

	}

	public List<String> binaryTreePaths(TreeNode root) {

		String[] paths = traverseTree(root, "").split("x");
		List<String> retval = new ArrayList<String>();

		for (String s : paths) {
			System.out.println(s);
			retval.add(s);
		}
		return retval;
	}

	private String traverseTree(TreeNode root, String path) {

		if (null == root.left && null == root.right) {
			path = path.concat(String.valueOf(root.val) + "x");
			return path;
		}

		path = path.concat(String.valueOf(root.val) + "->");

		String pathLeft = traverseTree(root.left, path);
		String pathRight = traverseTree(root.right, path);
		path = pathLeft.concat(pathRight);
		return path;

	}

}
