package chapter2;

public class EX_2_2 {

//Implement an algorithm to find the nth to last element of a singly linked list
//findNthEle, findNthEle1, findNthEle2: time: O(n), space: in-place

	
	
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
	
	public static Node findNthEle (Node head, int n) {
		if (head == null || n < 1)
			return null;
		int count = 0;
		Node m = head;
		while (m != null) {
			m = m.next;
			count++;
		}
		int f = count - n;
		if (f < 0)
			return null;
		m = head;
		while (f > 0) {
			m = m.next;
			f--;
		}
		return m;
	}
	
	public static Node findNthEle1 (Node head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		Node start = head;
		Node end = head;
		for (int i = 0; i < n - 1; i++) {
			if (end == null)
				return null;
			end = end.next;
		}
		while (end.next != null) {
			start = start.next;
			end = end.next;
		}
		return start;
	}
	
	static Node pp;
	static int nn;
	public static void findNthEle2 (Node head) {
		if (head == null)
			return;
		findNthEle2 (head.next);
		if (nn == 1) 
			pp = head;
		nn--;
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
		Node f = findNthEle1 (head, 3);
		System.out.println(f.data);
		
		nn = 3;
		findNthEle2(head);
		System.out.println(pp.data);
	}
}
