package trialjava;

import java.util.LinkedList;

public class myLinkedList {
	public static listNode head;
	public myLinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}
	public class listNode{
		int data;
		listNode next;
		
		public listNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.next = null;
		}
	}
	public void add(int data){
		if(head == null){
			head = new listNode(data);
			return;
		}
		listNode temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new listNode(data);;
	}
	public void printList(){
		int i = 0;
		listNode temp = head;
		while(temp != null && i<12){
			System.out.print(temp.data+" ");
			temp = temp.next;
			i++;
		}
		System.out.println();
	}
	public listNode findprev(int a){
		listNode prev = head;
		if(prev != null && prev.data == a){
			return null;
		}
		while(prev.next != null){
			if(prev.next.data == a){
				return prev;
			}
			prev = prev.next;
		}
		return null;
	}
	public void swapNodes(myLinkedList list ,int a, int b){
		listNode tempa = list.findprev(a);
		listNode tempb = list.findprev(b);
		if(tempa != null & tempb !=null){

		}
	}
	public void reverList(){
		listNode curr = head;
		listNode prev = null;
		while(head != null){
			head = head.next;
			curr.next = prev;
			prev = curr;
			if(head == null){
				head = curr;
				break;
			}
			curr = head;
		}
	}
	public Boolean detectAndRemoveLoop(){
		listNode slow = head;
		listNode fast = head;
		listNode prev = null;
		Boolean cycle = false;
		while(fast != null){
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				cycle = true;
				break;
		    }
		}
		if(cycle){
			slow = head;
			while(slow != null){
				if(slow == fast){
					prev.next = null;
					//System.out.println(prev.data);
					break;
				}
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}
		}
		return cycle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myLinkedList list = new myLinkedList();
		list.add(10);
		list.add(15);
		list.add(12);
		list.add(13);
		list.add(20);
		list.add(14);
		list.printList();
		listNode temp = list.findprev(14);
		temp.next.next = temp;
		list.printList();
		System.out.println(list.detectAndRemoveLoop());
		//list.reverList();
		list.printList();
		//list.swapNodes(list, 15, 13);
		//list.printList();
		
	}

}
