package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

	List<List<Integer>> retval = new ArrayList<List<Integer>>();
	int maxDepth = 0;
	boolean isBalanced = true;

	public void preOrderRecursive(TreeNode root) {

		// Base case
		if (null == root) {
			return;
		}

		System.out.println(root.val);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	public void preOrderIterative(TreeNode root) {
		if (null == root) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.println(temp.val);

			if (null != temp.right) {
				stack.add(temp.right);
			}

			if (null != temp.left) {
				stack.add(temp.left);
			}
		}
	}

	public void inOrderRecursive(TreeNode root) {

		if (null == root) {
			return;
		}

		inOrderRecursive(root.left);
		System.out.println(root.val);
		inOrderRecursive(root.right);

	}

	public void inOrderIterative(TreeNode root) {

		if (null == root) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		TreeNode temp = root;

		while (!stack.isEmpty() || temp != null) {

			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				TreeNode parent = stack.pop();
				System.out.println(parent.val);
				temp = parent.right;
			}
		}
	}

	public void postOrderRecursive(TreeNode root) {
		if (null == root) {
			return;
		}

		postOrderRecursive(root.left);
		postOrderRecursive(root.right);

		System.out.println(root.val);
	}

	// This code came from:
	// http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	public void postOrderIterative(TreeNode root) {

		if (null == root) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode prev = null;

		// prev is always the last node that curr was.
		// curr is always the top value of the stack
		// prev and curr will be referencing the correct node at the start of
		// the while loop
		// curr will be referencing the correct node at the start of the
		// iteration when curr = stack.peek();
		// prev will be referencing the correct node for the next iteration when
		// prev = curr at the bottom of the while loop.

		while (!stack.empty()) {
			// This set curr to the to top of the stack
			TreeNode curr = stack.peek();

			// go down the tree
			// if prev is null, meaning you are starting at the root node
			// or if prev is a parent node of the curr node
			if (null == prev || prev.left == curr || prev.right == curr) {
				// remember at the end of each iteration prev will equal curr
				// node
				// and curr will equal the top of the stack
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.println(curr.val + " ");
				}

				// if curr.leftNode == prev, this means you have gone down the
				// left sub tree and now
				// are going to go down the right sub tree.
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.println(curr.val + " ");
				}
				// if curr.rightNode == prev, then you have gone down the entire
				// right subtree
				// and now curr is the parent node of the subtree
			} else if (curr.right == prev) {
				stack.pop();
				System.out.println(curr.val + " ");
			}

			prev = curr;
		}

	}

	public void preOrderIterativeTest(TreeNode root) {

		// If root is null, then the tree is empty and return
		if (null == root) {
			return;
		}

		// Since we are doing pre-order traversal, parent node, then left
		// subtree, then right subtree
		// We need to keep track of the subtrees we want to visit as we go down
		// the tree.
		// A Stack will allow us to visit the most recent child subtree that was
		// pushed onto the stack

		Stack<TreeNode> stack = new Stack<>();

		// Push the root onto the stack, this will help us set the boolean
		// condition for the while loop
		stack.push(root);

		// Keep going down the stack as long as the stack is not empty
		while (!stack.isEmpty()) {

			// First we print the root of the subtree
			TreeNode temp = stack.pop();
			System.out.println(temp.val);

			// Since we are using a stack and we want to visit the node's left
			// subtree
			// first and the node's right subtree second, then the right subtree
			// root
			// node needs to be pushed onto the stack first and the node's left
			// subtree
			// root onto the stack second

			// Next, push the root of the node's right subtree
			// onto the stack
			if (temp.right != null) {
				stack.push(temp.right);
			}

			// Next, push the root of the node's left subtree is pushed
			// onto the stack

			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	public void inOrderIterativeTest(TreeNode root) {

		// First we check to see if root is null
		if (null == root) {
			return;
		}

		// InOrder goes down the left subtree the evaluates the
		// The root of the subtree and then goes down the right subtree
		// Need to keep track of the most recent
		Stack<TreeNode> stack = new Stack<>();

		// we are setting the temp node to equal the root of the tree
		TreeNode temp = root;

		// We will keep exploring the tree until both the stack is empty,
		// meaning we have no more subtreees to explore and if temp equals null
		// meaning we have found the right most leaf of the tree.
		while (!stack.isEmpty() || null != temp) {

			// This will be printed out, when going back up to the subtree root
			// from the subtree root's left subtree
			if (null == temp) {
				temp = stack.pop();
				System.out.println(temp.val + "x");
				temp = temp.right;
			}

			else if (temp != null) {
				if (temp.left != null) {
					// Save the most recently visited node,
					// if it has a leftNode by adding it to the
					// stack. Then set the temp to that of the
					stack.push(temp);
					temp = temp.left;

					// Traverse Right Sub tree
				} else if (temp.right != null) {
					// This will be printed out if the subtree root has only
					// A right subtree
					System.out.println(temp.val);
					temp = temp.right;
				} else {
					// This will only print out leafs
					System.out.println(temp.val + "y");
					temp = temp.right;
				}

			}
		}

	}

	public void inOrderIterativeTestII(TreeNode root) {

		// If the root of the tree is null, then return from the function
		if (null == root) {
			return;
		}

		// Use a stack to keep of the root nodes of each subtree that you have
		// visited so far
		Stack<TreeNode> stack = new Stack<>();

		// Use a variable to iterate through the tree, set it to the root of the
		// tree
		TreeNode temp = root;

		while (!stack.isEmpty() || null != temp) {
			if (null != temp) {
				stack.push(temp);
				temp = temp.left;
			} else {
				TreeNode parentNode = stack.pop();
				System.out.println(parentNode.val);
				temp = parentNode.right;
			}
		}
	}

	public void postOrderIterativeTest(TreeNode root) {

		// If the root of the tree is null, the return from the function
		if (null == root) {
			return;
		}

		// Use a stack to keep trace nodes that has been visited
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				if (null != curr.left) {
					stack.push(curr.left);
				} else if (null != curr.right) {
					stack.push(curr.right);
				} else {
					// Hey you reached a leaf
					stack.pop();
					System.out.println(curr.val);

				}
			} else if (curr.left == prev) {
				if (null != curr.right) {
					stack.push(curr.right);
				} else {
					// There is no right subtree for the current node to
					// traverse
					// the curr node is equal to the top of the stack, the top
					// of the
					// stack node is the root node of the subtree that is being
					// traversed
					stack.pop();
					System.out.println(curr.val);
				}
			} else {
				stack.pop();
				System.out.println(curr.val);
			}

			prev = curr;
		}

	}

	public void printAllPaths(TreeNode root, List<Integer> path, int length) {
		if (null == root) {
			return;
		}

		path.add(length, root.val);

		length++;
		if (null == root.left && null == root.right) {
			System.out.println("\n    ");
			for (int i : path) {
				System.out.print(i + " ");
			}
		}

		printAllPaths(root.left, path, length);
		printAllPaths(root.right, path, length);

		path.remove(--length);
	}

	public void printAllLeafs(TreeNode root) {
		if (null == root) {
			return;
		}

		if (null == root.left && null == root.right) {
			System.out.print(root.val + " ");
		}

		printAllLeafs(root.left);
		printAllLeafs(root.right);
	}

	public void sumEachPath(TreeNode root, List<Integer> path, int length) {
		if (null == root) {
			return;
		}

		path.add(length, root.val);
		length++;

		if (null == root.left && null == root.right) {
			int sum = 0;
			for (int i : path) {
				sum += i;
				System.out.print(i + " ");
			}
			System.out.println("The sum of the path is " + sum);
		}

		sumEachPath(root.left, path, length);
		sumEachPath(root.right, path, length);

		path.remove(--length);
	}

	public TreeNode invertTree(TreeNode root) {

		if (null == root) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {

			TreeNode parentNode = stack.pop();
			TreeNode tempLeft = parentNode.left;

			parentNode.left = parentNode.right;
			parentNode.right = tempLeft;

			if (null != parentNode.right) {
				stack.push(parentNode.right);
			}

			if (null != parentNode.left) {
				stack.push(parentNode.left);
			}
		}

		return root;

	}

	public void levelTraversal(TreeNode root) {

		if (null == root) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode parentNode = queue.remove();
			System.out.print(parentNode.val + " ");

			if (null != parentNode.left) {
				queue.add(parentNode.left);
			}

			if (null != parentNode.right) {
				queue.add(parentNode.right);
			}
		}

	}

	public void decomposeAndComposeTree(TreeNode root) {
		deserialize(serialize(root));
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		ArrayList<String> lists = new ArrayList<>();
		serializeHelper(root, lists);
		String retval = lists.toString();
		retval = retval.replace("[", "");
		retval = retval.replace("]", "");
		retval = retval.replace(",", "");
		retval = retval.replace(" ", "");
		System.out.println(retval);

		return retval.toString();
	}

	private void serializeHelper(TreeNode root, ArrayList<String> path) {
		if (null == root) {
			return;
		}
		path.add(Integer.toString(root.val) + "->");
		serializeHelper(root.left, path);
		serializeHelper(root.right, path);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		/*
		 * if( data.equals("")){ return null; }
		 */
		String[] tree = data.split("->");
		for (String s : tree) {
			System.out.print(s + " ");
		}
		TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
		int i = 1;
		while (i < tree.length) {
			TreeNode temp = root;
			insertTreeNode(temp, Integer.parseInt(tree[i]));
			i++;
		}

		return root;
	}

	public void insertTreeNode(TreeNode root, int val) {
		if (root == null) {
			return;
		}

		if (root.val > val && root.left == null) {
			root.left = new TreeNode(val);
			/*
			 * System.out.println("The node " + root.val +
			 * " is inserting a node to its " + " left child with the value of "
			 * + val);
			 */
			return;
		}

		if (root.val > val) {
			insertTreeNode(root.left, val);
		}

		if (root.val < val && root.right == null) {
			root.right = new TreeNode(val);
			/*
			 * System.out.println("The node " + root.val +
			 * " is inserting a node to its " +
			 * " right child with the value of " + val);
			 */
			return;
		}

		if (root.val < val) {
			insertTreeNode(root.right, val);
		}
	}

	public int maxDepthHelper(TreeNode root, int depth) {

		if (null == root) {
			return depth;
		}

		depth += 1;
		System.out.println(root.val + " has the depth " + depth);

		int leftTreeDepth = maxDepthHelper(root.left, depth);
		int rightTreeDepth = maxDepthHelper(root.right, depth);

		System.out.println("leftTreeDepth is " + leftTreeDepth + " for root val " + root.val);
		System.out.println("rightTreeDepth is " + rightTreeDepth + " for root val " + root.val);
		int treeDepth = Math.max(leftTreeDepth, rightTreeDepth);

		maxDepth = Math.max(treeDepth, maxDepth);

		System.out.println("The new maxDepth is " + maxDepth + " for root val " + root.val);

		return maxDepth;

	}

	public boolean isTreeBalanced(TreeNode root) {

		treeDepth(root, 0);
		if (isBalanced) {
			System.out.println("The tree is balanced");
		} else {
			System.out.println("The tree is not balanced");
		}
		return isBalanced;

	}

	public int treeDepth(TreeNode root, int depth) {
		if (root == null) {
			return depth;
		}

		depth++;

		int leftDepth = treeDepth(root.left, depth);
		int rightDepth = treeDepth(root.right, depth);

		if (Math.abs(leftDepth - rightDepth) > 1) {
			isBalanced = false;

			System.out.println("The parent node with the value of " + root.val + " of the subtree is NOT balanced");
			System.out.println("The left Subtree depth is " + leftDepth);
			System.out.println("The right subtree depth is " + rightDepth);
		} else {
			System.out.println("The parent node with the value of " + root.val + " of the subtree is balanced");
			System.out.println("The left Subtree depth is " + leftDepth);
			System.out.println("The right subtree depth is " + rightDepth);
		}

		return Math.max(leftDepth, rightDepth);

	}

	public void treeRightSide(TreeNode root) {

		if (null == root) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			System.out.println("The size of the queue is " + size);
			// This loop goes
			// through 1 level of a binary tree at a time
			for (int i = 0; i < size; i++) {

				TreeNode temp = queue.remove();
				if (i == 0) {
					System.out.println("The right value is " + temp.val);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}

			}

		}

	}

	public List<List<Integer>> zigZag(TreeNode root) {

		if (null == root) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		boolean leftToRight = false;

		while (!queue.isEmpty()) {

			int size = queue.size();

			List<Integer> level = new ArrayList<>();

			System.out.println("The value of lefToRight is " + leftToRight);
			

			for (int i = 0; i < size; i++) {
				TreeNode parent = queue.remove();

				System.out.println("The value of the parent is " + parent.val);

				if(leftToRight){
					level.add(parent.val);
				}else{
					level.add(0, parent.val);
				}
				

				if (null != parent.left) {
					queue.add(parent.left);
				}
				if (null != parent.right) {
					queue.add(parent.right);
				}
			}
			
			list.add(level);
			if (leftToRight) {
				leftToRight = false;
			} else {
				leftToRight = true;
			}

		}
		return list;
	}
	
	public void printZigZag(List<List<Integer>> list){
		for(List<Integer> l1: list){
			System.out.print("printing level: ");
			for(Integer i: l1){
				System.out.print(i + " ");
			}
			System.out.println();
		}	
	}
	
	public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
		
		if( null == root){
			return null;
		}
		
		if( root == node1 || root == node2 ){
			return root;
		}
		
		TreeNode leftNode = LCA(root.left, node1, node2);
		TreeNode rightNode = LCA(root.right, node1, node2);
		
		if(null != leftNode && null != rightNode ){
			return root;
		}
		
		if(null != leftNode){
			return leftNode;
		}else{
			return rightNode;
		}
		
	}
	
	public TreeNode LowestCommonAncestorTest(TreeNode root, TreeNode left, TreeNode right){
		
		if( null == root){
			return null;
		}
		
		if(root == left || root == right ){
			return root;
		}
		
		left = LowestCommonAncestorTest(root.left, left, right);
		right = LowestCommonAncestorTest(root.right, left, right);
	
	    if(null != left && null != right){
	    	return root;
	    }
	    
	    if( null != left){
	    	return left;
	    }
	    else{
	    	return right;
	    }
	}
}
