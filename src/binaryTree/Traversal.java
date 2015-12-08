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
	
	
	public void inOrderRecursive(TreeNode root){
		
		if( null == root){
			return;
		}
		
		inOrderRecursive(root.leftNode);
		System.out.println(root.val);
		inOrderRecursive(root.rightNode);
		
	}
	
	public void inOrderIterative(TreeNode root){
		
		if( null == root ){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null){
			
			if( temp != null){
				stack.push(temp);
				temp = temp.leftNode;
			}else{
				TreeNode parent = stack.pop();
				System.out.println(parent.val);
				temp = parent.rightNode;
			}
		}
	}
	
	public void postOrderRecursive(TreeNode root){
		if( null == root){
			return;
		}
		
		postOrderRecursive(root.leftNode);
		postOrderRecursive(root.rightNode);
		
		System.out.println(root.val);
	}
	
	//This code came from: 
	//http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	public void postOrderIterative(TreeNode root){
		
		if( null == root){
			return;
		}
		
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		TreeNode prev = null;
		
		
		//prev is always the last node that curr was. 
		//curr is always the top value of the stack
		//prev and curr will be referencing the correct node at the start of the while loop
		//curr will be referencing the correct node at the start of the iteration when curr = stack.peek();
		//prev will be referencing the correct node for the next iteration when
		//prev = curr at the bottom of the while loop.
		
		while(!stack.empty()){
	    //This set curr to the to top of the stack
		TreeNode curr = stack.peek();
		
		//go down the tree
		//if prev is null, meaning you are starting at the root node
		//or if prev is a parent node of the curr node
		if( null == prev || prev.leftNode == curr || prev.rightNode == curr){
			//remember at the end of each iteration prev will equal curr node 
			//and curr will equal the top of the stack
			if( curr.leftNode != null){
				stack.push(curr.leftNode);
			}else if(curr.rightNode != null){
				stack.push(curr.rightNode);
			}else{
				stack.pop();
				System.out.println(curr.val + " ");
			}

			
			
		//if curr.leftNode == prev, this means you have gone down the left sub tree and now 
		//are going to go down the right sub tree.
		}else if( curr.leftNode == prev){
			if(curr.rightNode != null){
				stack.push(curr.rightNode);
			}else{
				stack.pop();
				System.out.println(curr.val + " ");
			}
			//if curr.rightNode == prev, then you have gone down the entire right subtree
			//and now curr is the parent node of the subtree
		}else if( curr.rightNode == prev){
			stack.pop();
			System.out.println(curr.val + " ");
		}
		
		prev = curr;
		}
		
	}
}
