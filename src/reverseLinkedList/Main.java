package reverseLinkedList;

public class Main {

	public static void main(String[] args) {
	
		Main m = new Main();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		//m.print(m.reverseLinkedList(node1));
		
		m.print(m.reverse2(node1));
		
	}

	public Node reverseLinkedList(Node head){
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
	
	
	public Node reverse2(Node head){
		if(null == head){
			return head;
		}
		
		if(null == head.next){
			return head;
		}
		
		Node prevNode = null;
		Node curNode = head;
		
		while(null != curNode){
			Node nextNode = curNode.next;
		    curNode.next = prevNode;
		    prevNode = curNode;
			curNode = nextNode;
		}
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
