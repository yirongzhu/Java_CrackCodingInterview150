package chapter3;
import java.util.*;

public class EX_3_3 {

//Imagine a (literal) stack of plates If the stack gets too high, it might topple Therefore, in real life, we would likely start a new stack when the previous stack exceeds 
//some threshold Implement a data structure SetOfStacks that mimics this SetOfStacks should be composed of several stacks, and should create a new stack once 
//the previous one exceeds capacity SetOfStacks push() and SetOfStacks pop() should 
//behave identically to a single stack (that is, pop() should return the same values as it 
//would if there were just a single stack)
//FOLLOW UP
//Implement a function popAt(int index) which performs a pop operation on a specific 
//sub-stack
//time: for popAt, it is O(m*n), space: for popAt, it is O(n). If we want to improve time efficiency, there are two ways: first, change the Stack data structure to be deque; 
//second, waste space so that we ignore that some stack might not be full.
	
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
	
	public static class SetOfStacks {
		public int capacity;
		ArrayList<Stack> s = new ArrayList<Stack> ();
		public SetOfStacks (int c) {
			this.capacity = c;
		}
		
		public Stack getLastStack () {
			if (!s.isEmpty()) {
				return s.get(s.size() - 1);
			}
			else {
				return null;
			}
		}
		
		public int size (Stack w) {
			int count = 0;
			Node n = w.top;
			while (n != null) {
				count++;
				n = n.next;
			}
			return count;
		}
		
		public Node pop () {
			Stack last = getLastStack();
			if (last == null) {
				return null;
			}
			else if (last.top != null) {
				return last.pop();
			}
			else {
				s.remove(s.size() - 1);
				last = getLastStack ();
				return last.pop();
			}
		}
		
		public void push (int d) {
			Stack last = getLastStack ();
			if (last == null) {
				last = new Stack ();
				s.add(last);
				last.push(d);
			}
			else if (size(last) == capacity) {
				Stack w = new Stack ();
				s.add(w);
				w.push(d);
			}
			else {
				last.push(d);
			}
		}
		
		public Node rotate (Stack w) {
			Stack buffer = new Stack();
			Node n = w.top;
			while (n.next != null) {
				buffer.push(w.pop().data);
				n = n.next;
			}
			Node m = w.pop();
			Node b = buffer.top;
			while (b != null) {
				w.push(buffer.pop().data);
				b = b.next;
			}
			return m;
		}
		
		public Node popAt (int index) {
			Stack sp = s.get(index);
			Node result = sp.pop();
			int i = index + 1;
			while (i < s.size()){
				if (s.get(i).top == null) {
					s.remove(i);
				}
				else {
					s.get(i - 1).push(rotate(s.get(i)).data);
				}
				i++;
			}
			return result;
		}
	}
	
	public static void main (String[] args) {
		SetOfStacks sos = new SetOfStacks(10);
		for (int i = 1; i <= 100; i++) {
			sos.push(i);
		}
		System.out.println(sos.s.size());
		for (int i = 0; i < 10; i++) {
			Node t = sos.s.get(i).top;
			while (t != null) {
				System.out.print(t.data);
				t = t.next;
			}
			System.out.println();
		}
		sos.popAt(5);
		for (int i = 0; i < 10; i++) {
			Node t = sos.s.get(i).top;
			while (t != null) {
				System.out.print(t.data);
				t = t.next;
			}
			System.out.println();
		}
	}
}
