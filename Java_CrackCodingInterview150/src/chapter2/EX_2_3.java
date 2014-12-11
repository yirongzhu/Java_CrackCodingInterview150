package chapter2;
import java.util.*;
public class EX_2_3 {

//Implement an algorithm to delete a node in the middle of a single linked list, given 
//only access to that node
//EXAMPLE
//Input: the node ¡®c¡¯ from the linked list a->b->c->d->e
//Result: nothing is returned, but the new linked list looks like a->b->d->e
//time: O(1)
	
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

	public static void deleteNode (Node n) {
		if (n.next == null || n == null) {
			return;
		}
		Node m = n.next;
		n.data = m.data;
		n.next = m.next;
	}
	
	public static void main (String[] args) {
		Node head = new Node(1);
		int[] a = {2, 3, 4, 1, 2, 1, 3, 4};
		for (int i = 0; i < a.length; i++) {
			head.appendToTail(a[i]);
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			n = n.next;
		}
		System.out.println();
		Node m = head;
		for (int i = 0; i < 3; i++) {
			m = m.next;
		}
		deleteNode (m);
		Node p = head;
		while (p != null) {
			System.out.print(p.data);
			p = p.next;
		}
	}
}
