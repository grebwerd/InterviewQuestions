package linkedListReorder;

import isLinkedListPalidrome.ListNode;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;

		Main m = new Main();
		ListNode reorderList = m.reorderList(head);
		m.print(reorderList);
	}

	private ListNode reorderList(ListNode head) {
		
		if( null == head){
			return head;
		}
		
		int length = listLength(head);
		if(length <= 2){
			return head;
		}
		System.out.println("The value of length is " + length);
		int mid = getMid(length);
		System.out.println("The value of mid is " + mid);
		
		ListNode halfNode = seekNode(head, mid+1);
		System.out.println("The value of halfNode is " + halfNode.val);
		
		ListNode reverseList = reverse(halfNode);
		
		ListNode headPtr = head;
		System.out.println("The value of headPtr is " + headPtr.val);
		
		ListNode tailPtr = reverseList;
		System.out.println("The value of tailPtr is " + tailPtr.val);
		
		while(null != headPtr && null != tailPtr){
			
			ListNode headPtrNext = headPtr.next;
			ListNode tailPtrNext = tailPtr.next;
			
			headPtr.next = tailPtr;
			tailPtr.next = headPtrNext;
			
			headPtr = headPtrNext;
			tailPtr = tailPtrNext;
		}

		return head;
	}

	private int listLength(ListNode head) {
		int retval = 0;
		while(null != head){
			retval++;
			head = head.next;
		}
		return retval;
	}

	private int getMid(int length) {
		return (length/2);
	}

	private ListNode seekNode(ListNode head, int point) {
		
		int counter = 1;
		while( counter < point){
			
			System.out.println(head.val);
			head = head.next;
			counter++;
		}
		
		ListNode retval = head.next;
		
		head.next = null;
		return retval;

	}

	private ListNode reverse(ListNode head) {
		
		System.out.println("reverse");
		
		ListNode prev = null;
		while(null != head){
			System.out.println(head.val);
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;

	}

	private void print(ListNode head) {

		while (null != head) {
			System.out.println(head.val);
			head = head.next;
		}

	}
}
