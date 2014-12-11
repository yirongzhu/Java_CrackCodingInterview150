package chapter4;
import java.util.*;

public class EX_4_4 {

//Given a binary search tree, design an algorithm which creates a linked list of all the 
//nodes at each depth (i e , if you have a tree with depth D, you¡¯ll have D linked lists)
//time: O(n) space: O(n)
	
	public static class TNode {
		TNode lchild;
		TNode rchild;
		int data;
		public TNode (TNode l, TNode r, int d) {
			lchild = l;
			rchild = r;
			data = d;
		}
	}
	
	public static class BST {
		public TNode root;
		
		public BST (int d) {
			root = new TNode (null, null, d);
		}
		
		public void insert (int d) {
			root = insertHelper (root, d);
		}
		
		public TNode insertHelper (TNode v, int d) {
			if (v == null) {
				return new TNode (null, null, d);
			}
			else if (d <= v.data) {
				v.lchild = insertHelper (v.lchild, d);
				return v;
			}
			else {
				v.rchild = insertHelper (v.rchild, d);
				return v;
			}
		}
		
		public void inOrder (TNode v) {
			if (v.lchild != null) {
				inOrder (v.lchild);
			}
			System.out.print(v.data + " ");
			if (v.rchild != null) {
				inOrder (v.rchild);
			}
		}
		
		public Hashtable<Integer, LinkedList<TNode>> linkEachLevel () {
			int level = 0;
			Hashtable<Integer, LinkedList<TNode>> h = new Hashtable<Integer, LinkedList<TNode>> ();
			LinkedList<TNode> frontier = new LinkedList<TNode> ();
			frontier.add(root);
			while (!frontier.isEmpty()) {
				h.put(level, frontier);
				LinkedList<TNode> next = new LinkedList<TNode> ();
				for (TNode n : frontier) {
					if (n.lchild != null) {
						next.add(n.lchild);
					}
					if (n.rchild != null) {
						next.add(n.rchild);
					}
				}
				frontier = next;
				level++;
			}
			return h;
		}
		
		public static void main (String[] args) {
			BST t = new BST (6);
			System.out.println(t.root.data);
			int[] a = new int[] {2,1,4,3,5,7,8,9};
			for (int i = 0; i < a.length; i++) {
				t.insert (a[i]);
			}
			t.inOrder(t.root);
			System.out.println();
			Hashtable<Integer, LinkedList<TNode>> h;
			h = t.linkEachLevel();
			for (LinkedList<TNode> l : h.values()) {
				for (TNode n : l) {
					System.out.print(n.data + " ");
				}
				System.out.println();
			}
		}
	}
}
	
	
	

