package linkedListMergeSort;

import isLinkedListPalidrome.ListNode;

public class Main {

	public static void main(String[] args) {
		ListNode root = new ListNode(5);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(2);
		root.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		
		
		
		Main m = new Main();
		m.sort(root);
	}
	
	public ListNode sort(ListNode head){
		if(null == head){
			return null;
		}
		
		return mergeSort(head);
	}
	
	
	private ListNode splitList(ListNode head){
		
		if( null == head){
			return head;
		}
		
		
		ListNode prev = null;
		ListNode midNode = head;
		ListNode endNode = head;
		
		while(null != endNode && null != endNode.next){
			prev = midNode;
			midNode = midNode.next;
			endNode = endNode.next.next;
		}
		
		return prev;
	}
	
	private ListNode mergeSort(ListNode head){
		System.out.println("\n\n!!!!MERGESORT!!!");
		
		if(null == head){
			System.out.println("head is null return");
			return head;
		}
		
		if(null == head.next){
			System.out.println("The head val is " + head.val);
			return null;
		}
		
		
		//end of the left linkedlist
		ListNode leftMidNode = splitList(head);
		ListNode rightMidNode = null;
		if(null != leftMidNode){
			System.out.println("leftMidNode val is " + leftMidNode.val);
			rightMidNode = leftMidNode.next;
			
			//set the end of the left linked list to null
			leftMidNode.next = null;
		}
		else{
			System.out.println("leftMidNode val is null");
		}
		
		//Start of the right linkedlist
		
		if(null != rightMidNode){
			System.out.println("rightMidNode val is " + rightMidNode.val);
		}
		else{
			System.out.println("rightMidNode val is " + null);
		}
		
		
		ListNode left = mergeSort(head);
		
		
		
		if(null == left){
			System.out.println("The value of the left Node is null");
		}else{
			System.out.println("The value of left node is " + left.val);
		}
		
		ListNode right = mergeSort(rightMidNode);
		if(null == right){
			System.out.println("The value of the right node is null");
		}else{
			System.out.println("The value of the right node is " + right.val);
		}
		
		return null;
	}

	
}
