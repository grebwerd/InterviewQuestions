package binaryTree;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		TreeNode level1Lefta = new TreeNode(20);
		TreeNode level1Righta = new TreeNode(60);
		TreeNode level2lefta = new TreeNode(10);
		TreeNode level2leftb = new TreeNode(30);
		TreeNode level2Righta = new TreeNode(50);
		TreeNode level2Rightb = new TreeNode(70);
		TreeNode level3Lefta = new TreeNode(5);
		TreeNode level3Rightb = new TreeNode(55);
		
		//Left Subtree
		root.left = level1Lefta;
		level1Lefta.left = level2lefta;
		level1Lefta.right = level2leftb;
		level2lefta.left = level3Lefta;
		
		//Right SubTree
		root.right = level1Righta;
		level1Righta.left = level2Righta;
		level1Righta.right = level2Rightb;
		level2Righta.right = level3Rightb;
		
		
		Traversal traversal = new Traversal();
		
	    
	  /*  System.out.println("Recursive");
	    traversal.postOrderRecursive(root);
	    
	    System.out.println(" Iterative ");
	    traversal.postOrderIterative(root);*/
		
		//traversal.preOrderIterativeTest(root);
		//traversal.inOrderIterativeTest(root);
		
	    //traversal.inOrderIterativeTestII(root);
		//traversal.postOrderIterativeTest(root);
		//List<Integer> path = new ArrayList<>();
		//traversal.printAllPaths(root, path, 0);
		
		//traversal.printAllLeafs(root);
		
		//List<Integer> path = new ArrayList<>();
		//traversal.sumEachPath(root, path, 0);
		
		//traversal.printAllPaths(traversal.invertTree(root), new ArrayList<Integer>(), 0);
		
		//traversal.levelTraversal(root);
		
		//traversal.serialize(root);
		//traversal.decomposeAndComposeTree(root);
		
		//traversal.maxDepthHelper(root, 0);
		
		//traversal.isTreeBalanced(root);
		
		//traversal.treeRightSide(root);
		
		//traversal.printZigZag(traversal.zigZag(root));
		
		//System.out.println("The LCA is " + root.val + ", " +level1Righta.leftNode.val + ", " + level2leftb.val + " is " + traversal.LCA(root,level1Righta.leftNode, level2leftb).val);
	
		System.out.println("The LCA is " + root.val + ", " +level1Righta.left.val + ", " + level2leftb.val + " is " + traversal.LowestCommonAncestorTest(root,level1Righta.left, level2leftb).val);
	}
}
