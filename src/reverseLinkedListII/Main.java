package reverseLinkedListII;

public class Main {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		int m = 3;
		int n = 4;

		Main main = new Main();
		main.reverseList(node1, m, n);
	}

	public ListNode reverseList(ListNode head, int m, int n) {

		if (null == head) {
			return head;
		}

		if (null == head.next) {
			return head;
		}

		if (m >= n) {
			return head;
		}

		ListNode mNodePrev = null;
		ListNode mNode = null;
		ListNode nNode = null;
		ListNode nNodeNext = null;
		ListNode prevNode = null;
		ListNode currentNode = head;

		int counter = 1;

		while (counter <= n) {
			if (counter == m - 1) {
				mNodePrev = currentNode;
				currentNode = currentNode.next;
				counter++;
				continue;
			}

			if (counter == m) {
				mNode = currentNode;
			}

			if (counter == n) {
				nNode = currentNode;
				nNodeNext = currentNode.next;
			}
			if (counter >= m && counter <= n) {
				ListNode nextNode = currentNode.next;
				currentNode.next = prevNode;
				prevNode = currentNode;
				currentNode = nextNode;
				counter++;
				continue;
			}
			currentNode = currentNode.next;
			counter++;
		}

		if (null == mNodePrev) {
			mNode.next = nNodeNext;
			return nNode;
		} else {
			mNodePrev.next = nNode;
			mNode.next = nNodeNext;
		}

		return head;
	}

}
