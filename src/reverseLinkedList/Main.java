package reverseLinkedList;

public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();
		final Node node1 = new Node(1);
		final Node node2 = new Node(2);
		final Node node3 = new Node(3);
		final Node node4 = new Node(4);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		main.print(main.reverseLinkedList(node1));
		
		//m.print(m.reverse2(node1));
		
	}

	public Node reverseLinkedList(final Node head){
		if(null == head){
			return head;
		}
		
		if(null == head.next){
			return head;
		}
		
		Node prevNode=head;
		
		Node currentNode=head.next;
		Node nextNode=head.next.next;
		prevNode.next = null;
		
		while(currentNode != null ){
              currentNode.next = prevNode;
              prevNode = currentNode;
              if(nextNode == null ){
            	  break;
              }
              currentNode = nextNode;
              nextNode = nextNode.next;
		}
		return currentNode;
	}
	
	
	public Node reverse2(final Node head){
		
		//If the head node is null return
		if(null == head){
			return head;
		}

		//if the head node next pointer is null, return
		if(null == head.next){
			return head;
		}
		
		//initialize previous node to null
		Node prevNode = null;
		
		//initialize curNode to the head node of the linked list
		Node curNode = head;
		
		
		//keep iterating while the current node isn't null
		while(null != curNode){
			
			//1. next node is equal to the curNode -> next value
			final Node nextNode = curNode.next;
		    
			//2. set curNode -> next node to the previous null
			curNode.next = prevNode;
		    
			//3. previous node is now point to the current node
			prevNode = curNode;
			
			//4. curNode is now pointing to the next node
			curNode = nextNode;
		}
		
		//return the curNode
		return prevNode;
	}
	
	
	public void print(Node head){
		if(null == head){
			System.out.print("The list was empty");
			return;
		}
		
		if(null == head.next){
			System.out.print(head.val +  ", ");
			return;
		}
		
		Node temp = head;
		
		while(temp != null){
			System.out.print(temp.val +  ", ");
			temp = temp.next;
		}
	}
}
