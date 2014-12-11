package chapter2;
import java.util.*;

public class EX_2_5 {

//Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
//DEFINITION
//Circular linked list: A (corrupt) linked list in which a node¡¯s next pointer points to an 
//earlier node, so as to make a loop in the linked list
//EXAMPLE
//input: A -> B -> C -> D -> E -> C [the same C as earlier]
//output: C
//time: loopBegin: O(k), loopBegin: O(n+k)
	
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
	
	public static Node loopBegin (Node head) {
		if (head == null)
			return null;
		Hashtable<Node, Boolean> h = new Hashtable<Node, Boolean> ();
		Node n = head;
		while (!h.containsKey(n)) {
			h.put(n, true);
			n = n.next;
		}
		return n;
	}
	
	public static Node loopBegin1 (Node head) {
		if (head == null)
			return null;
		Node fast = head;
		Node slow = head;
		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) 
				break;
		}
		if (fast.next == null)
			return null;
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static void main (String[] args) {
		Node head = new Node(5);
		int[] a = {6, 8, 7, 6, 9, 6, 7, 9};
		for (int i = 0; i < a.length; i++) {
			head.appendToTail(a[i]);
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		Node m = head;
		for (int i = 0; i < 4; i++) {
			m = m.next;
		}
		n.next = m;
		Node f = loopBegin1 (head);
		System.out.println(f.data);
	}
}
