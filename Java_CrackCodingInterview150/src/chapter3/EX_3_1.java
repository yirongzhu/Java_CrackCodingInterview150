package chapter3;

public class EX_3_1 {

//Describe how you could use a single array to implement three stacks
//

/*
	public static class Node {
		Node next = null;
		int data;
		public Node (int d) {
			this.data = d;
		}
	}
	
	public static class Stack {
		Node top;
		public Node pop () {
			if (top != null) {
				Node t = top;
				top = top.next;
				return t;
			}
			return null;
		}
		public void push (int item) {
			Node t = new Node (item);
			t.next = top;
			top = t;
		}
	}
	
	public static class Queue {
		Node front;
		Node rear;
		public void put (int item) {
			Node t = new Node (item);
			if (front != null) {
				rear.next = t;
				rear = rear.next;
			}
			else {
				rear = t;
				front = rear;
			}
		}
		public Node get () {
			if (front != null) {
				Node t = front;
				front = front.next;
				return t;
			}
			return null;
		}
	}
*/
	
/*
	static int stackSize = 100;
	static int[] buffer = new int [stackSize * 3];
	static int[] startPointer = {-1, -1, -1};
	
	public static void push (int stackNum, int item) {
		int index = stackNum * stackSize + startPointer[stackNum] + 1;
		buffer[index] = item;
		startPointer[stackNum]++;
	}
	
	public static int put (int stackNum) {
		if (isEmpty (stackNum)) 
			return 0;
		int index = stackNum * stackSize + startPointer[stackNum];
		int result = buffer[index];
		buffer[index] = 0;
		startPointer[stackNum]--;
		return result;
	}
	
	public static int peak (int stackNum) {
		if (isEmpty (stackNum)) 
			return 0;
		int index = stackNum * stackSize + startPointer[stackNum];
		return buffer[index];
	}
	
	public static boolean isEmpty (int stackNum) {
		return startPointer[stackNum] == -1;
	}
*/

	public static class Node {
		int data;
		int preindex;
	}
	
	static int stackSize = 300;
	static Node[] buffer = new Node[stackSize];
	static int[] topPointer = {-1, -1, -1};
	
	public static void push (int stackNum, int item) {
		Node n = new Node();
		n.data = item;
		n.preindex = topPointer[stackNum];
		int f = topPointer[stackNum] + 1;
		while (buffer[f] != null){
			f++;
		}
		buffer[f] = n;
		topPointer[stackNum] = f;
	}
	
	public static int pop (int stackNum) {
		int f = topPointer[stackNum];
		int result = buffer[f].data;
		topPointer[stackNum] = buffer[f].preindex;
		buffer[f] = null;
		return result;
	}
	
	public static int peak (int stackNum) {
		int f = topPointer[stackNum];
		return buffer[f].data;
	}
	
	public static boolean isEmpty (int stackNum) {
		return topPointer[stackNum] == -1;
	}


	
	public static void main (String[] args) {
		push (0, 2);
		push (1, 3);
		push (2, 5);
		push (0, 1);
		push (1, 2);
		push (2, 1);
		push (0, 7);
		pop (2);
		pop (1);
		push (2, 4);
		push (1, 2);
		for (int i = 0; i < 3; i++) {
			System.out.print(topPointer[i] + " ");
		}
	}
}

	