package balancedBinaryTree;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		Node root = new Node(1);
		Node right1a = new Node(2);
		root.left = null;
		root.right = right1a;
		
		Node right2a = new Node(3);
		right1a.left = null;
		right1a.right = right2a;
		
		System.out.print("Is the tree balanced is " + m.isTreeBalanced(root));

	}
	
	//A binary tree is considered balanced if the tree or any of its subtree 
	//Do not differ in depth by more than 1
	
	public boolean isTreeBalanced(Node root){
		
		int hieghtDelta = treeHeight(root);
		System.out.println("The height difference in the tree is " + hieghtDelta);
		if( hieghtDelta == -1){

			return false;
		}
		return true;
	}
	
	private int treeHeight(Node root){
		if(null == root){
			return 0;
		}
		
	    int left = treeHeight(root.left);
		int right = treeHeight(root.right);
		
		System.out.println("The value of left is " + left);
		System.out.println("The value of right is " + right);
		
		if(left == -1 || right == -1){
			return -1;
		}
		
		if(Math.abs(left-right) > 1){
			return -1;
		}
		
		return Math.max(left, right) + 1;
		
	}
	

}
