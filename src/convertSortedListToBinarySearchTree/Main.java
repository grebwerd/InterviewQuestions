package convertSortedListToBinarySearchTree;

import binaryTree.TreeNode;
import isLinkedListPalidrome.ListNode;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		//ListNode fifth = new ListNode(5);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		Main main = new Main();
		TreeNode retval = main.sortedListToBST(head);
		
		main.printInOrder(retval);

	}
	
	
	  public TreeNode sortedListToBST(ListNode head) {
	   
		  if(head == null || head.next == null){
			  return null;
		  }
		  
		  int mid = findMid(head);
		  System.out.println("The value of mid is " + mid);
		  if( mid < 2){
			  return null;
		  }
		  
		  System.out.println("the mid value is " + mid);
		  
		  ListNode midNode = getMidNode(head, mid);
		  System.out.println("The value of the midNode is " + midNode.val);
		  
		  
		  ListNode reverseNode = reverse(head, mid-1);
		  System.out.println("The value of reverseNode is " + reverseNode.val);
		  
		  
		  TreeNode treeHead = new TreeNode(midNode.val);
          System.out.println("The value of the root of the tree is " + treeHead.val);
		  
		  
		  constructBST(treeHead, reverseNode, midNode.next);

		  return treeHead;
	  }
	  
	  public int findMid(ListNode head){
		  
		  int retval = 0;
		  while(null != head){
			  retval++;
			  head = head.next;
		  }
		  
		  System.out.println("listsize is " + retval);
		  
		  if(retval % 2 == 0){
			  return retval/2;
		  }
		  else{
			  return ((retval/2)+1);
		  }
		  
	  }
	  
	  public ListNode getMidNode(ListNode head, int midPoint){
		  int counter = 1;
		  while( counter < midPoint){
			  System.out.println("The value of head is " + head.val);
			  head = head.next;
			  counter++;
		  }
		  return head;
	  }
	  
	  public void insert(TreeNode head, int val){
		  
		  if(null == head){
			  return;
		  }
		  
		  if(head.val > val){
			  if(head.leftNode == null){
				  head.leftNode = new TreeNode(val);
				  return;
			  }else{
				  insert(head.leftNode, val);
			  }
		  }
		  
		  if(head.val < val){
			  if( head.rightNode == null){
				  head.rightNode = new TreeNode(val);
				  return;
			  }else{
				  insert(head.rightNode, val);
			  }
		  }
		  
	  }
	  
	  public ListNode reverse(ListNode head, int endPoint){
		  int counter = 1;
		  ListNode prev = null;
		  
		  
		  
		  while(counter <= endPoint){
			  ListNode next = head.next;
			  head.next = prev;
			  prev = head;
			  head = next;
			  counter++;
		  }
		  return prev;
	  }
	  
	  public void constructBST(TreeNode treeHead, ListNode leftNode, ListNode rightNode){
		  boolean isLeft = false;
		  while(leftNode != null || rightNode != null){
			  if(isLeft && leftNode != null){
				  System.out.println("inserting the left val " + leftNode.val);
				  insert(treeHead, leftNode.val);
				  leftNode = leftNode.next;
				  isLeft = false;
			  }else if(!isLeft && rightNode != null){
				  System.out.println("inserting the right val " + rightNode.val);
				  insert(treeHead, rightNode.val);
				  rightNode = rightNode.next;
				  isLeft = true;
			  }
		  }
	  }
	  
	  
	  public void printInOrder(TreeNode treeHead){
		  
		  if(null == treeHead){
			  return;
		  }
		  printInOrder(treeHead.leftNode);
		  
		  System.out.println("The value of the node is " + treeHead.val );
		  
		  printInOrder(treeHead.rightNode);
	  }

}
