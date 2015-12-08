package binaryTree;

import java.util.ArrayList;
import java.util.List;
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
	
	//This code came frome: 
	//http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	public void postOrderIterative(TreeNode root){
		
		if( null == root){
			return;
		}
		
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		TreeNode prev = null;
		
		while(!stack.empty()){
		TreeNode curr = stack.peek();
		
		//go down the tree
		//check if current node is leaf, if so, process it and pop stack,
		//otherwise, keep going down 
		if( null == prev || prev.leftNode == curr || prev.rightNode == curr){
			//prev == null is the situation for a root node
			if( curr.leftNode != null){
				stack.push(curr.leftNode);
			}else if(curr.rightNode != null){
				stack.push(curr.rightNode);
			}else{
				stack.pop();
				System.out.println(curr.val + " ");
			}

			//go up the tree from the left node
			//need to check if there is a right child
			//if yes, push it to the stack
			//otherwise, process the parent and pop the stack
			
			
		}else if( curr.leftNode == prev){
			if(curr.rightNode != null){
				stack.push(curr.rightNode);
			}else{
				stack.pop();
				System.out.println(curr.val + " ");
			}
			//go up the tree from the right node
			//afte coming back from the right node, process the parent node and pop
			//the stack
		}else if( curr.rightNode == prev){
			stack.pop();
			System.out.println(curr.val + " ");
		}
		
		prev = curr;
		}
		
	}
}
