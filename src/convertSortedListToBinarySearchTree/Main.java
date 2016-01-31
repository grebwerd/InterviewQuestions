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
		//TreeNode retval = main.sortedListToBSTII(head);
		int[] nums = {1, 2, 3, 4, 5};
		TreeNode retval = main.sortedArrayToBST(nums);
		
		main.printInOrder(retval);

	}
	 public TreeNode sortedArrayToBST(int[] nums) {
	        
	        if(nums == null){
	            return null;
	        }
	        
	        return convertArrayToBST(nums, 0, nums.length);
	    }
	    
	
	 private TreeNode convertArrayToBST(int[] nums, int start , int end){
         if(start == end){
             return null;
         }
         
         System.out.println("The start value is " + start + " and the end value is " + end);
         int mid = ((start+end)/2);
         
         System.out.println("The value of mid is " + mid + " and the value of nums[mid] is " + nums[mid]);
         
         TreeNode root = new TreeNode(nums[mid]);
         System.out.println("The value of the root is " + root.val);
         root.left = convertArrayToBST(nums, start, mid);
         if(null != root.left){
        	 System.out.println("The value of the root.left.val is " + root.left.val);
         }else{
        	 System.out.println("The value of the root.left.val is null");
         }
         root.right = convertArrayToBST(nums, mid+1, end);
         if(null != root.right){
        	 System.out.println("The value of the root.right.val is " + root.right.val);
         }else{
        	 System.out.println("The value of the root.right.val is null");
         }
         return root;
 }
     
	
	
	public TreeNode sortedListToBSTII(ListNode head){
    	if(null == head ){
    		return null;
    	}
    	
    	return constructBST(head, null);
    	
	}
	
	
	/*
	 * From the leetcode cracker android app
	 * 1. Base Case: If the start ListNode and the end ListNode are the same node, the return null because, you can not divided the list
	 * in half again...also, depending on the function call, the start or end listNode should already be in the BST
	 * 
	 * 2a. Next create ListNode MidNode which is equal to the beginning of the start of the section of the Sorted LinkedList
	 * 2b. Next create ListNode endNode which is equal to the beginning of the start of the section of the Sorted LinkedList
	 * 
	 * 3a. Find the mid node in the sorted linked list section, range, by using a while loop where 
	 * the midNode moves for 1 node every iteration and the endNode moves 2 nodes every iteration
	 * 
	 * 3b. The whil loop using the check condition, end != endNode && end != endNode.next.
	 * 3b1. The end != endNode is invalid when the end of th linked list section has been reached so exit the loop.
	 * 3b2. The end != endNOde.next is invalid if the endNode is the penultimate node in the sorted linked list range. If it went one more iteration, the mid node
	 * would be off by 1 node...?
	 * 
	 * 4. Creat a new TreeNode name root
	 * 
	 * 5a. Find and set the root's left node by passing in a sorted link list range that is from 1...midNode
	 * 5b. Find and set the root's right not by passing in a sorted link list range that is midNode.next, end
	 * 
	 * */
	
	
	private TreeNode constructBST(ListNode start, ListNode end){
		if( start == end ){
			return null;
		}
		
		ListNode midNode = start;
		ListNode endNode = start;
		while( end != endNode && end !=  endNode.next){
			midNode = midNode.next;
			endNode = endNode.next.next;
		}
		
		
		TreeNode root = new TreeNode(midNode.val);
		System.out.println("The val of mid is " + midNode.val);
		
		root.left = constructBST(start, midNode);
		if(root.left != null){
			System.out.println("The root val is " + root.val + " and the  value of root.leftNode is " + root.left.val);
			}else{
				System.out.println("The root val is " + root.val + " and the value of root.leftNode is null");
			}
		root.right = constructBST(midNode.next, end);
		if(root.right != null){
		System.out.println("The root val is " + root.val + " and the value of root.rightNode is " + root.right.val);
		}else{
			System.out.println("The root val is " + root.val + " and the value of root.rightNode is null");
		}
		return root;
		
	}
	
	
	
	
	/* DMG design...didn't work
	1. If the LinkedList is null return
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
			  if(head.left == null){
				  head.left = new TreeNode(val);
				  return;
			  }else{
				  insert(head.left, val);
			  }
		  }
		  
		  if(head.val < val){
			  if( head.right == null){
				  head.right = new TreeNode(val);
				  return;
			  }else{
				  insert(head.right, val);
			  }
		  }
		  
	  }
	  
	
	  
	  public void printInOrder(TreeNode treeHead){
		  
		  if(null == treeHead){
			  return;
		  }
		  printInOrder(treeHead.left);
		  
		  System.out.println("The value of the node is " + treeHead.val );
		  
		  printInOrder(treeHead.right);
	  }

}
