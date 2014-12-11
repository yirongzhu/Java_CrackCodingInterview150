package chapter2;

public class EX_2_4 {

//You have two numbers represented by a linked list, where each node contains a single digit The digits are stored in reverse order, such that the 1¡¯s digit is at the head of 
//the list Write a function that adds the two numbers and returns the sum as a linked 
//list
//EXAMPLE 
//Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
//Output: 8 -> 0 -> 8
//time: O(n), space: O(n), n = max (Nhead1, Nhead2)

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
	
	public static Node sumLinkedList (Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node head = new Node ((head1.data + head2.data) % 10);
		Node n = head;
		while (head1.next != null && head2.next != null) {
			int m = (head1.data + head2.data) / 10;
			head1 = head1.next;
			head2 = head2.next;
			n.appendToTail((head1.data + head2.data) % 10 + m);
			n = n.next;
		}
		int r = (head1.data + head2.data) / 10;
		if (r != 0 && head1.next == null && head2.next == null) {
			n.appendToTail(r);
			return head;
		}
		while (head1.next != null) {
			head1 = head1.next;
			n.appendToTail((head1.data + r) % 10);
			r = (head1.data + r) / 10;
		}
		while (head2.next != null) {
			head2 = head2.next;
			n.appendToTail((head2.data + r) % 10);
			r = (head2.data + r) / 10;
		}
		return head;
	}
	
	public static Node sumLinkedList1 (Node head1, Node head2, int remainder) {
		if (head1 == null && head2 == null && remainder == 0)
			return null;
		if (head1 == null && head2 == null && remainder == 1) 
			return new Node(remainder);
		Node head = new Node(remainder);
		int value = remainder;
		if (head1 != null) 
			value += head1.data;
		if (head2 != null)
			value += head2.data;
		head.data = value % 10;
		Node more = sumLinkedList1 (head1 == null ? null : head1.next, head2 == null ? null : head2.next, value >= 10 ? 1 : 0);
		head.next = more;
		return head;
	}
	
	public static void main (String[] args) {
		Node head1 = new Node(5);
		int[] a = {6, 8, 7, 6, 9, 6, 7, 9};
		for (int i = 0; i < a.length; i++) {
			head1.appendToTail(a[i]);
		}
		Node n = head1;
		while (n != null) {
			System.out.print(n.data);
			n = n.next;
		}
		System.out.println();
		
		Node head2 = new Node(7);
		int[] b = {9, 6, 7, 5, 8, 9, 7, 9};
		for (int i = 0; i < b.length; i++) {
			head2.appendToTail(b[i]);
		}
		Node m = head2;
		while (m != null) {
			System.out.print(m.data);
			m = m.next;
		}
		System.out.println();
		
		Node s = sumLinkedList (head1, head2);
		Node f = s;
		while (f != null) {
			System.out.print(f.data);
			f = f.next;
		}
		System.out.println();
	}
}
