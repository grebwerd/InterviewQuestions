package mergeTwoLists;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		ListNode listNode1a = new ListNode(-9);
		ListNode listNode1b = new ListNode(-7);
		ListNode listNode1c = new ListNode(-3);
		ListNode listNode1d = new ListNode(-3);
		ListNode listNode1e = new ListNode(-1);
		ListNode listNode1f = new ListNode(2);
		ListNode listNode1g = new ListNode(3);
		
		listNode1a.next = listNode1b;
		listNode1b.next = listNode1c;
		listNode1c.next = listNode1d;
		listNode1d.next = listNode1e;
		listNode1e.next = listNode1f;
		listNode1f.next = listNode1g;
		
		
		ListNode listNode2a = new ListNode(-7);
		ListNode listNode2b = new ListNode(-7);
		ListNode listNode2c = new ListNode(-6);
		ListNode listNode2d = new ListNode(-6);
		ListNode listNode2e = new ListNode(-5);
		ListNode listNode2f = new ListNode(-3);
		ListNode listNode2g = new ListNode(2);
		ListNode listNode2h = new ListNode(4);
		
		listNode2a.next = listNode2b;
		listNode2b.next = listNode2c;
		listNode2c.next = listNode2d;
		listNode2d.next = listNode2e;
		listNode2e.next = listNode2f;
		listNode2f.next = listNode2g;
		listNode2g.next = listNode2h;
		
		
		
	
		
		
		main.printList(main.mergeTwoLists(listNode1a,listNode2a));
		
	}

	public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2){
		 
		
		 if( listNode1 == null ){
	            return listNode2;
	        }
	        
	        if( listNode2 == null ){
	            return listNode1;
	        }
	        
	        ListNode head = null;
	        ListNode temp1 = listNode1;
	        ListNode temp2 = listNode2;
	        if(listNode1.val < listNode2.val){
	        	head = listNode1;
	        	
	        }else{
	        	head = listNode2;
	        	
	        }
	      
	        while( null != listNode1 && null != listNode2){
	        	if(listNode1.val < listNode2.val){
	        		if(listNode1.next != null && listNode1.next.val < listNode2.val){
	        			listNode1 = listNode1.next;
	        			temp1 = listNode1;
	        		}else{
	        			listNode1 = listNode1.next;
	        			temp1.next = listNode2;
	        			temp1 = listNode1;
	        		}
	        	}else{
	        		//Why only the = sign for this if statement and not the other one? I feel like it has 
	        		//something do with how we are not check if listNode.val <= listNode2.val....
	        		if(listNode2.next != null && listNode2.next.val <= listNode1.val){
	        			listNode2 = listNode2.next;
	        			temp2 = listNode2;
	        		}else{
	        			listNode2 = listNode2.next;
	        			temp2.next = listNode1;
	        			temp2 = listNode2;
	        		}
	        	}
	        }
	       
	    
	       return head;
		
		
	}
	
	public void printList(ListNode listNode){
		if( listNode == null ){
			System.out.println("list was empty");
			return;
		}
		
		while( listNode != null ){
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}
	
}
