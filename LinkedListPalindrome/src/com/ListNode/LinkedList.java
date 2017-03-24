package com.ListNode;

public class LinkedList {
	
	ListNode head;
	int length;
	
	public void insertAtBegining(ListNode node){
		node.setNext(head);
		head = node;
		length++;
	}
	
	public void insertAtEnd(ListNode node){
		if(head==null){
			head = node;
		}
		else{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
				p.setNext(node);
			length++;
		}
	}
	
	public void display(ListNode head){
		
		ListNode current = head;
		while(current!=null){
			System.out.println(" "+current.data);
			current = current.next;
		}
	}
	
	public ListNode reverseList(ListNode currentnode){
		
		ListNode prev = null;
		ListNode nextNode;
		
		while(currentnode!=null){
			
			nextNode = currentnode.next;
			currentnode.next = prev;
			prev = currentnode;
			currentnode =nextNode;
		}
		return prev;
	}
	
	public boolean isListPalindrome(ListNode head){
		
		if(head == null){
			System.out.println("head is null");
			return true;
		}
		
		ListNode list = head;
		ListNode reverseList = new ListNode(head.getData());
		
		while(list.next!=null){
			ListNode temp = new ListNode(list.next.getData());
			temp.next = reverseList;
			reverseList = temp;
			list = list.next;
		}
		ListNode list1 = head;
		ListNode list2 = reverseList;
		 
		while(list1!= null){
			if(list1.getData() != list2.getData()){
				System.out.println("the list is not a palindrome");
				return false;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		System.out.println("the list is a palindrome");
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ListNode node = new ListNode("m");
       ListNode node1 = new ListNode("a");
       ListNode node2 = new ListNode("d");
       
       LinkedList list = new LinkedList();
       
       list.insertAtBegining(node);
       list.insertAtEnd(node1);
       list.insertAtEnd(node2);
       
       System.out.println("the current list is ");
       list.display(node);
       
       System.out.println(list.isListPalindrome(node));
       ListNode afterReversingList = list.reverseList(node);
       
       System.out.println("the reverse of the list is ");
       list.display(afterReversingList);
  
	}

}
