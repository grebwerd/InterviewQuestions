package linkedListInsertionSort;



import isLinkedListPalidrome.ListNode;

public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(2);
		ListNode fourth = new ListNode(1);
		
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		
		System.out.println("The order of the list values before the sort: ");
		print(head);
		
		System.out.println("The order of the list values after the sort are: ");
		ListNode temp = insertionSortList(head);
        print(temp);
	}
	//Take from programming creek: http://www.programcreek.com/2012/11/leetcode-solution-sort-a-linked-list-using-insertion-sort-in-java/
	
	   public static ListNode insertionSortList(ListNode head) {
	    if (head == null || head.next == null)
				return head;
	 
			ListNode newHead = new ListNode(head.val);
			ListNode pointer = head.next;
	 
			// loop through each element in the list
			while (pointer != null) {
				// insert this element to the new list
	 
				ListNode innerPointer = newHead;
				ListNode next = pointer.next;
	 
				if (pointer.val <= newHead.val) {
					ListNode oldHead = newHead;
					newHead = pointer;
					newHead.next = oldHead;
				} else {
					while (innerPointer.next != null) {
	 
						if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
							ListNode oldNext = innerPointer.next;
							innerPointer.next = pointer;
							pointer.next = oldNext;
						}
	 
						innerPointer = innerPointer.next;
					}
	 
					if (innerPointer.next == null && pointer.val > innerPointer.val) {
						innerPointer.next = pointer;
						pointer.next = null;
					}
				}
	 
				// finally
				pointer = next;
			}
	 
			return newHead;
	}
	    
	public static void print(ListNode head){
		while(null != head){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
