package isLinkedListPalidrome;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		System.out.println("Is the linkedList a palindrome is " + m.isPalindrome(node1));

	}

	public boolean isPalindrome(Node head) {
		int[] midPoints = getMidPoints(getListLength(head));

		System.out.println("The value of the midpoints is " + midPoints[0] + " and " + midPoints[1]);

		Node second = secondHalf(head, midPoints[1]);
		Node first = reverseFirstHalf(head, midPoints[0]);
		return isSame(first, second);
	

	}

	public boolean isSame(Node firstHalf, Node secondHalf){
		Node firstPtr = firstHalf;
		Node secondPtr = secondHalf;
		
		while( null != firstPtr || null != secondPtr){
			if( null != firstPtr && null == secondPtr){
				return false;
			}
			
			if( null == firstPtr && null != secondPtr){
				return false;
			}
			
			if( firstPtr.val != secondPtr.val){
				System.out.println("The values differ at " + firstPtr.val + " and " + secondPtr.val);
				return false;
			}
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}
		
		return true;
	}
	
	public int getListLength(Node head) {

		if (null == head) {
			return 0;
		}

		if (null == head.next) {
			return 1;
		}

		int counter = 0;
		Node ptr = head;
		while (null != ptr) {
			counter++;
			ptr = ptr.next;
		}

		return counter;
	}

	public int[] getMidPoints(int val) {
		int[] retval = new int[2];

		System.out.println("The value of the length is " + val);
		if (val % 2 == 0) {
			retval[0] = val/2;
			retval[1] = (val/2) + 1;
		} else {
			retval[0] = (val/2)-1;
			retval[1] = ((val+1)/2);
		}
		return retval;
	}

	public Node secondHalf(Node head, int midPoint) {
		int counter = 0;
		Node ptr = head;

		while (counter <= midPoint-1) {
			counter++;
			ptr = ptr.next;
		}
		return ptr;
	}

	public Node reverseFirstHalf(Node head, int midPoint) {

		Node prevNode = null;
		Node curNode = head;

		if(0 == midPoint){
			return head;
		}
		
		int counter = 0;
		
		while (counter < midPoint) {
			Node nextNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
			counter++;
		}

		return prevNode;
	}

	public void print(Node head) {

		Node temp = head;
		while (null != temp) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
	}

}
