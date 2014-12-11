package chapter3;

public class EX_3_2 {
	
//How would you design a stack which, in addition to push and pop, also has a function 
//min which returns the minimum element? Push, pop and min should all operate in O(1) time
//


	public static class Node {
		Node next = null;
		int data;
		int premin;
		public Node (int d) {
			this.data = d;
			this.premin = d;
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
			if (top != null) {
				if (top.premin < n.data) {
					n.premin = top.premin;
				}
			}
			n.next = top;
			top = n;
		}
		
		public int min () {
			if (top != null) {
				return top.premin;
			}
			return Integer.MAX_VALUE;
		}
	}

	public static void main (String[] args) {
		Stack stack = new Stack ();
		int[] a = {4,6,3,3,5,7,2,4,1};
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		System.out.println(stack.min());
		}
	
/*
	public static class Node {
		Node next = null;
		int data;
		public Node (int d) {
			this.data = d;
		}
	}
	
	public static class Stack {
		static Stack s = new Stack ();
		Node top = null;
		public void push (int d) {
			if (d <= min()) {
				Node m = new Node (d);
				m.next = s.top;
				s.top = m;
			}
			Node n = new Node (d);
			n.next = top;
			top = n;
		}
		
		public Node pop () {
			if (top != null) {
				Node n = top;
				if (n.data == min()) {
					s.top = s.top.next;
				}
				top = top.next;
				return n;
			}
			return null;
		}
		
		public int min () {
			if (s.top != null) {
				return s.top.data;
			}
			else {
				return Integer.MAX_VALUE;
			}
		}
	}
	
	public static void main (String[] args) {
		Stack stack = new Stack ();
		int[] a = {4,6,3,3,5,7,2,4,1};
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		System.out.println(stack.min());
		Node n = stack.s.top;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
*/
	
}
