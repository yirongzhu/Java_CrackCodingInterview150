package chapter4;
import java.util.*;

public class EX_4_1 {

//Implement a function to check if a tree is balanced For the purposes of this question, 
//a balanced tree is defined to be a tree such that no two leaf nodes differ in distance 
//from the root by more than one
//time: O(n), space: O(n)
	
	public static class Node {
		ArrayList<Node> children = new ArrayList<Node> ();
	}
	
	public static class Tree {
		Node root;
		
		public int findHeight (Node v) {
			if (v.children.isEmpty()) {
				return 0;
			}
			else {
				int max = 0;
				for (Node n : v.children) {
					if (findHeight(n) > max) {
						max = findHeight(n);
					}
				}
				return max + 1;
			}
		}
		
		public boolean isBalance () {
			if (root.children.isEmpty()) {
				return true;
			}
			if (root.children.size() > 1) {
				int max = findHeight (root.children.get(0));
				int min = findHeight (root.children.get(0));
				for (Node v : root.children) {
					if (findHeight(v) > max) {
						max = findHeight(v);
					}
					if (findHeight(v) < min) {
						min = findHeight(v);
					}
				}
				return max - min <= 1;
			}
			else {
				return root.children.get(0).children.isEmpty();
			}
		}
		
		public static void main (String[] args) {
			Tree t = new Tree ();
			t.root = new Node ();
			Node b = new Node ();
			Node c = new Node ();
			Node d = new Node ();
			t.root.children.addAll(Arrays.asList(b, c, d));
			Node e = new Node ();
			b.children.add(e);
			Node f = new Node ();
			Node g = new Node ();
			c.children.addAll(Arrays.asList(f, g));
			Node h = new Node ();
			f.children.add(h);
			System.out.println(t.isBalance());
		}
	}
	
	
}
