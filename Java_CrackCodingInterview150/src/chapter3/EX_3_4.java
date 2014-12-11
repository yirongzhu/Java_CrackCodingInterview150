package chapter3;

public class EX_3_4 {

//In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different 
//sizes which can slide onto any tower The puzzle starts with disks sorted in ascending 
//order of size from top to bottom (e g , each disk sits on top of an even larger one) You 
//have the following constraints:
//(A) Only one disk can be moved at a time
//(B) A disk is slid off the top of one rod onto the next rod
//(C) A disk can only be placed on top of a larger disk
//Write a program to move the disks from the first rod to the last using Stacks

//time: O(2^n), space: O(n)
	
	public static class Node {
		Node next = null;
		int data;
		public Node (int d) {
			this.data = d;
		}
	}
	
	public static class Stack {
		Node top = null;
		public Node pop () {
			if (top != null) {
				Node n = top;
				top = top.next;
				return n;
			}
			return null;
		}
		public void push (int d) {
			Node n = new Node (d);
			n.next = top;
			top = n;
		}
	}

	public static class Tower {
		private Stack disk;
		public Tower () {
			disk = new Stack();
		}
		
		public void add (int d) {
			if (disk.top != null && d >= disk.top.data) {
				System.out.println("Error disk" + d);
			}
			else {
				disk.push (d);
			}
		}
		
		public void moveTopTo (Tower t) {
			int i = disk.pop ().data;
			t.add (i);
		}
		
		public void print () {
			Node n = disk.top;
			while (n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
		}
		
		public void Hanoi (int n, Tower destination, Tower buffer) {
			if (n > 0) {
				Hanoi (n - 1, buffer, destination);
				moveTopTo (destination);
				buffer.Hanoi (n - 1, destination, this);
			}
		}
	}
	
	public static void main (String[] args) {
		Tower first = new Tower();
		Tower buffer = new Tower();
		Tower destination = new Tower();
		int n = 5;
		for (int i = n; i > 0; i--) {
			first.add(i);
		}
		first.print();
		System.out.println();
		first.Hanoi (n, destination, buffer);
		destination.print();
	}
/*
	public static void Hanoi (int n, Stack first, Stack middle, Stack last) {
		if (n == 0)
			return;
		else if (n == 1) {
			last.push(first.pop().data);
		}
		else if (n == 2) {
			middle.push(first.pop().data);
			last.push(first.pop().data);
			last.push(middle.pop().data);
		}
		else {
			Hanoi (n - 1, first, last, middle);
			last.push(first.pop().data);
			Hanoi (n - 1, middle, first, last);
		}
	}
	
	public static void main (String[] args) {
		Stack first = new Stack();
		Stack middle = new Stack();
		Stack last = new Stack();
		int[] a = {1,2,3,4,5,6,7,8,9};
		for (int i = a.length - 1; i >= 0; i--) {
			first.push(a[i]);
		}
		int n = 9;
		Node m = first.top;
		while (m != null) {
			System.out.print(m.data + " ");
			m = m.next;
		}
		System.out.println();
		
		Hanoi (n, first, middle, last);

		Node p = last.top;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
		System.out.print(first.top.data);
	}
*/
}
