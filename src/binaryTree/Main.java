package binaryTree;

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
		root.leftNode = level1Lefta;
		level1Lefta.leftNode = level2lefta;
		level1Lefta.rightNode = level2leftb;
		level2lefta.leftNode = level3Lefta;
		
		//Right SubTree
		root.rightNode = level1Righta;
		level1Righta.leftNode = level2Righta;
		level1Righta.rightNode = level2Rightb;
		level2Righta.rightNode = level3Rightb;
		
		
		Traversal traversal = new Traversal();
		traversal.preOrderIterative(root);
	}
	
	

}
