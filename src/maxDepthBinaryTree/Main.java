package maxDepthBinaryTree;

public class Main {

	public static void main(String[] args){
		Main m = new Main();
		TreeNode root = null;
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		root = new TreeNode(1);
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		TreeNode leftNode1 = new TreeNode(2);
		root.left = leftNode1;
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		TreeNode rightNode1 = new TreeNode(3);
		root.right = rightNode1;
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		
		TreeNode leftNode2 = new TreeNode(4);
		leftNode1.left = leftNode2;
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		TreeNode leftNode3 = new TreeNode(6);
		leftNode2.left = leftNode3;
		System.out.println("The max depth of the tree is " + m.maxDepth(root));
		
		
		
		
		
	}
	
	public int maxDepth(TreeNode root){
		if(null == root){
			return 0;
		}
		int maxLeft = maxDepth(root.left);
		int maxRight = maxDepth(root.right);
		
		if( maxLeft > maxRight){
			return ++maxLeft;
		}
		return ++maxRight;
	}
}
