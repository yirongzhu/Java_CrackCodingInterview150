package chapter2;
import java.util.*;

public class EX_2_1 {

//Write code to remove duplicates from an unsorted linked list
//FOLLOW UP
//How would you solve this problem if a temporary buffer is not allowed?
//removeDupBuffer: time: O(n), space: O(n)
//removeNoDupBuffer: time: O(n^2), space: in-place
	
	public static class Node {
		
		Node next = null;
		int data;
		public Node (int d) {
			this.data = d;
		}
		public void appendToTail (int d) {
			Node n = this;
			Node end = new Node (d);
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}
	
	public static void removeDupBuffer (Node head) {
		if (head == null)
			return;
		Hashtable<Integer, Boolean> check = new Hashtable<Integer, Boolean>();
		Node n = head;
		Node previous = null;
		while (n != null) {
			if (!check.containsKey(n.data)) {
				check.put(n.data, true);
				previous = n;
			}
			else {
				previous.next = n.next;
			}
			n = n.next;
		}
	}
	
	public static void removeDupNoBuffer (Node head) {
		if (head == null) 
			return;
		Node previous = head;
		Node m = head;
		while (m != null) {
			previous = m;
			Node n = m.next;
			while (n != null) {
				if (m.data == n.data) {
					previous.next = n.next;
					n = previous.next;
				}
				else {
					previous = n;
					n = n.next;
				}
			}
			m = m.next;
		}
	}
	
	public static void main (String[] args) {
		Node head = new Node(1);
		int[] a = {2, 3, 4, 1, 2, 1, 3, 4};
		for (int i = 0; i < a.length; i++) {
			head.appendToTail(a[i]);
		}
		removeDupBuffer(head);
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
}
