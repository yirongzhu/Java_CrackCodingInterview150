package chapter3;

public class EX_3_6 {

//Write a program to sort a stack in ascending order You should not make any assumptions about how the stack is implemented The following are the only functions that 
//should be used to write this program: push | pop | peek | isEmpty
//recursion: time: O(2^n), space: in-place; sorted: time: O(n^2), space: O(n)
	
	public static class Node {
		Node next = null;
		int data;
		public Node (int d) {
			this.data = d;
		}
	}
	
	public static class Stack {
		Node top = null;
		
		public boolean isEmpty () {
			return top == null;
		}
		
		public void push (int d) {
			Node n = new Node (d);
			n.next = top;
			top = n;
		}
		
		public Node pop () {
			if (isEmpty()) {
				return null;
			}
			Node n = top;
			top = top.next;
			return n;
		}
		
		public Node peek () {
			return top;
		}
		
		public void sort (int n) {
			if (n < 2) {
				return;
			}
			else if (n == 2) {
				int a = pop().data;
				int b = pop().data;
				if (a > b) {
					push(a);
					push(b);
				}
				else {
					push(b);
					push(a);
				}
			}
			else {
				sort (n - 1);
				int c = pop().data;
				sort (n - 1);
				push (c);
				sort (2);
			}
		}
		
		public Stack sorted () {
			Stack r = new Stack();
			while (!isEmpty()) {
				int buffer = pop().data;
				while (!r.isEmpty() && r.peek().data < buffer) {
					push(r.pop().data);
				}
				r.push(buffer);
			}
			return r;
		}
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		for (int i = 1; i < 100; i++) {
			s.push(i);
		}
		Node n = s.top;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		Stack r = new Stack();
		r = s.sorted();
		System.out.println();
		Node m = r.top;
		while (m != null) {
			System.out.print(m.data + " ");
			m = m.next;
		}
	}
}
