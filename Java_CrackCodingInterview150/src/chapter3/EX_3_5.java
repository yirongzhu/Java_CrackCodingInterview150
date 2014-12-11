package chapter3;

public class EX_3_5 {

//Implement a MyQueue class which implements a queue using two stacks.
//time: put, peek(out != null), get(out != null): O(1); peek(out == null), get(out == null), size: O(n)
	
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
		
		public int size () {
			Node n = top;
			int count = 0;
			while (n != null) {
				count++;
				n = n.next;
			}
			return count;
		}
	}
	
	public static class MyQueue {
		public Stack in;
		public Stack out;
		public MyQueue () {
			this.in = new Stack ();
			this.out = new Stack ();
		}
		
		public void put (int d) {
			in.push(d);
		}
		
		public Node peek () {
			if (out.top != null) {
				return out.top;
			}
			Node n = in.top;
			if (in.top == null) {
				return null;
			}
			while (n.next != null) {
				n = n.next;
			}
			return n;
		}
		
		public Node get () {
			if (out.top == null) {
				if (in.top == null) {
					return null;
				}
				while (in.top != null) {
					out.push((in.pop().data));
				}
			}
			return out.pop();
		}
		
		public int size() {
			return in.size() + out.size();
		}
	}
	
	public static void main (String[] args) {
		MyQueue q = new MyQueue ();
		for (int i = 1; i <= 10; i++) {
			q.put(i);
		}
		Node n = q.in.top;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
		System.out.println(q.get().data);
		Node m = q.out.top;
		while (m != null) {
			System.out.print(m.data + " ");
			m = m.next;
		}
	}
}
