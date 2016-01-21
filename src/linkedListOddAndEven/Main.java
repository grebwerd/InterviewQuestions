package linkedListOddAndEven;

import isLinkedListPalidrome.ListNode;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		ListNode seventh = new ListNode(7);
		ListNode eigth = new ListNode(8);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eigth;

		printList(linkedListOddAndEven(head));

	}

	public static ListNode linkedListOddAndEven(ListNode head) {

		if (null == head || null == head.next) {
			return head;
		}

		ListNode headPtr = head;
		ListNode oddPtr = head;
		ListNode evenPtr = head.next;
		ListNode evenPtrHead = head.next;
		boolean isOdd = true;

		while (null != headPtr) {
			System.out.println("headPtr.val is " + headPtr.val + " ");
			if (null != headPtr.next) {
				ListNode headPtrNext = headPtr.next;
				if (isOdd) {
					oddPtr.next = headPtr.next.next;
					if (oddPtr.next != null) {
						oddPtr = oddPtr.next;
					}
				} else {
					evenPtr.next = headPtr.next.next;
					evenPtr = evenPtr.next;
				}
				isOdd = !isOdd;
				headPtr = headPtrNext;
			} else {
				break;
			}
		}

		oddPtr.next = evenPtrHead;

		return head;
	}

	public static void printList(ListNode head) {

		while (null != head) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
