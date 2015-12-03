package binaryTree;

import java.util.Stack;

public class Traversal {

	
	public void preOrderRecursive(TreeNode root){
		
		//Base case
		if( null == root){
			return;
		}
	
		System.out.println(root.val);
		preOrderRecursive(root.leftNode);
		preOrderRecursive(root.rightNode);
	}
	
	public void preOrderIterative(TreeNode root){
		if( null == root){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.val);
			
			if( null != temp.rightNode){
				stack.add(temp.rightNode);
			}
			
			if( null != temp.leftNode){
				stack.add(temp.leftNode);
			}
		}
	}
}
