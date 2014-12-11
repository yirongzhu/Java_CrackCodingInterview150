package chapter4;
import java.util.*;

public class EX_4_6 {

//Design an algorithm and write code to find the first common ancestor of two nodes 
//in a binary tree Avoid storing additional nodes in a data structure NOTE: This is not 
//necessarily a binary search tree
//1: (time: O(h), space: in-place)
//2: (time: O(h), space: O(h))
//3: (time: O(h*n) (worst case), space: in-place)
	
	public static class Node {
		Node parent;
		Node lchild;
		Node rchild;
		
		public Node () {
			
		}
		
		public Node (Node p, Node l, Node r) {
			parent = p;
			lchild = l;
			rchild = r;
		}
	}
	
	public static class BinaryTree {
		private Node root;
		
		public BinaryTree () {
			root = new Node (null, null, null);
		}
		
		public int depth (Node v) {
			int count = 0;
			while (!v.equals(root)) {
				count++;
				v = v.parent;
			}
			return count;
		}
		
		public void linsert (Node s, Node v) {
			s.lchild = v;
			v.parent = s;
		}
		
		public void rinsert (Node s, Node v) {
			s.rchild = v;
			v.parent = s;
		}
		
		public void storeParent (HashMap<Node, Boolean> h, Node v) {
			while (v != null) {
				h.put(v, true);
				v = v.parent;
			}
		}
		
		public boolean isAncestor (Node s, Node v) {
			if (s == null || v == null) {
				return false;
			}
			if (s.equals(v)) {
				return true;
			}
			return isAncestor (s.lchild, v) || isAncestor (s.rchild, v);
		}
		
		public Node findCommonAncestor (Node s, Node v) {
			int ds = depth (s);
			int dv = depth (v);
			if (ds > dv) {
				while (ds != dv) {
					s = s.parent;
					ds--;
				}
			}
			else {
				while (ds != dv) {
					v = v.parent;
					dv--;
				}
			}
			if (s.equals(v)) {
				return s;
			}
			else {
				while (!s.equals(v)) {
					s = s.parent;
					v = v.parent;
				}
				return s;
			}
		}
		
		public Node findCommonAncestor1 (Node s, Node v) {
			if (s == null || v == null)
				return null;
			HashMap<Node, Boolean> h = new HashMap<Node, Boolean> ();
			storeParent (h, s);
			while (v != null && !h.containsKey(v)) {
				v = v.parent;
			}
			return v;
		}
		
		public Node findCommonAncestor2 (Node r, Node s, Node v) {
			if (isAncestor(r.lchild, s) && isAncestor(r.lchild, v)) {
				return findCommonAncestor2 (r.lchild, s, v);
			}
			if (isAncestor(r.rchild, s) && isAncestor(r.rchild, v)) {
				return findCommonAncestor2 (r.rchild, s, v);
			}
			return r;
		}
	}
	
	public static void main (String[] args) {
		BinaryTree t = new BinaryTree ();
		Node b = new Node ();
		Node c = new Node ();
		Node d = new Node ();
		Node e = new Node ();
		Node f = new Node ();
		Node g = new Node ();
		Node h = new Node ();
		Node i = new Node ();
		Node j = new Node ();
		Node k = new Node ();
		t.linsert (t.root, b);
		t.rinsert (t.root, c);
		t.rinsert (c, e);
		t.rinsert (e, f);
		t.rinsert (f, g);
		t.linsert (c, d);
		t.linsert (d, h);
		t.rinsert (d, i);
		t.linsert (i, j);
		t.rinsert (j, k);
		System.out.println(t.isAncestor(c, g));
		System.out.println(c.equals(t.findCommonAncestor2 (t.root, k, g)));
		System.out.println(d.equals(t.findCommonAncestor2 (t.root, h, k)));
		System.out.println(f.equals(t.findCommonAncestor2 (t.root, f, g)));
	}
}
