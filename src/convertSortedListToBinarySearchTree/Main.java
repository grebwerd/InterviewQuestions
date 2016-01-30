package convertSortedListToBinarySearchTree;

import binaryTree.TreeNode;
import isLinkedListPalidrome.ListNode;

public class Main {

	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		Main main = new Main();
		TreeNode retval = main.sortedListToBST(head);
		
		main.printInOrder(retval);

	}
	
	/*1. If the LinkedList is null return
    2. Find the length of the LinkedList
    3. Find the Mid value of the LinkedList, (n/2) if the list is even else (n/2) + 1
    4. Find the mid Node of the linkedList
    5. insert the mid node into the BST
    6. recurse on the linked list 1..(mid-1) and (mid+1)..length of the linked list
    */
	
	
	public TreeNode sortedListToBST(ListNode head){
		TreeNode bstHead = null;
    	if(null == head ){
    		return null;
    	}
    	else if( null == head.next){
    		return bstHead = new TreeNode(head.val);
    	}
    	
    	int end = getListLength(head);
    	
    	bstHead = new TreeNode(-1);
    	constructBST(bstHead, head, 1, end);
    	
		return bstHead;
	}
	
	
	private int getListLength(ListNode head){
		int retval = 0;
		while(null != head){
			retval++;
			head = head.next;
		}
		System.out.println("The list length is " + retval);
		return retval;
	}
	
	private void constructBST(TreeNode bstHead, ListNode listHead, int startIndex, int endIndex){
		
		System.out.println("The value of start is " + startIndex + " and the value of end is " + endIndex);
		
		if( startIndex > endIndex){
			System.out.println("returning from construct BST");
			return;
		}
		
		int mid;
		if( startIndex == endIndex){
			mid = startIndex;
		}else{
		
		 mid = ((startIndex+endIndex)/2) %2 == 0?((startIndex+endIndex)/2):((startIndex+endIndex)/2)+1;
		System.out.println("The mid index of the linked list is " + mid);
		}
		int midNodeVal = getMidNode(listHead, mid);
		System.out.println("The value of the midNodeVal is " + midNodeVal);
		
		insert(bstHead, midNodeVal);
		
		constructBST(bstHead, listHead, 1, mid-1);
		constructBST(bstHead, listHead, mid+1, endIndex);
	}
	 
	  
	  public int getMidNode(ListNode head, int midPoint){
		  int counter = 1;
		  while( counter < midPoint){
			  System.out.println("The value of head is " + head.val);
			  head = head.next;
			  counter++;
		  }
		  return head.val;
	  }
	  
	  public void insert(TreeNode head, int val){
		  
		 
		  
		  if(null == head ){
			  return;
		  }
		  
		  if( head.val == -1){
			  head.val = val;
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
	  
	
	  
	  public void printInOrder(TreeNode treeHead){
		  
		  if(null == treeHead){
			  return;
		  }
		  printInOrder(treeHead.leftNode);
		  
		  System.out.println("The value of the node is " + treeHead.val );
		  
		  printInOrder(treeHead.rightNode);
	  }

}
