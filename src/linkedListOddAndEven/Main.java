package linkedListOddAndEven;

import isLinkedListPalidrome.Node;

public class Main {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);
		Node eigth = new Node(8);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eigth;

		printList(linkedListOddAndEven(head));

	}

	public static Node linkedListOddAndEven(Node head) {

		if (null == head || null == head.next) {
			return head;
		}

		Node headPtr = head;
		Node oddPtr = head;
		Node evenPtr = head.next;
		Node evenPtrHead = head.next;
		boolean isOdd = true;

		while (null != headPtr) {
			System.out.println("headPtr.val is " + headPtr.val + " ");
			if (null != headPtr.next) {
				Node headPtrNext = headPtr.next;
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

	public static void printList(Node head) {

		while (null != head) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
