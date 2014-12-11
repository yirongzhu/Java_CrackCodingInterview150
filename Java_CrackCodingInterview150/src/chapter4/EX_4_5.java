package chapter4;

public class EX_4_5 {

//Write an algorithm to find the ¡®next¡¯ node (i e , in-order successor) of a given node in 
//a binary search tree where each node has a link to its parent
//time: O(log(h)), space: in-place
	
	public static class Node {
		Node parent;
		Node lchild;
		Node rchild;
		int data;
		
		public Node (Node p, Node l, Node r, int d) {
			parent = p;
			lchild = l;
			rchild = r;
			data = d;
		}
	}
	
	public static class BST {
		Node root;
		
		public BST (int d) {
			root = new Node (null, null, null, d);
		}
		
		public void insert (int d) {
			root = insertHelper (root, null, d);
		}
		
		public Node insertHelper (Node v, Node p, int d) {
			if (v == null) {
				return new Node (p, null, null, d);
			}
			else if (d <= v.data) {
				v.lchild = insertHelper (v.lchild, v, d);
				return v;
			}
			else {
				v.rchild = insertHelper (v.rchild, v, d);
				return v;
			}
		}
		
		public Node min (Node v) {
			Node n = v;
			while (n.lchild != null) {
				n = n.lchild;
			}
			return n;
		}
		
		public Node successor (Node v) {
			if (v == null) {
				return null;
			}
			else if (v.rchild != null) {
				return min (v.rchild);
			}
			else if (v.parent.lchild == v) {
				return v.parent;
			}
			else {
				Node n = v;
				while (n.parent.rchild == n) {
					n = n.parent;
				}
				if (n.parent == null) {
					return null;
				}
				else {
					return n.parent;
				}
			}
		}
		
		public void inOrder (Node v) {
			if (v.lchild != null) {
				inOrder (v.lchild);
			}
			System.out.print(v.data + " ");
			if (v.rchild != null) {
				inOrder (v.rchild);
			}
		}
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
		Node v = t.root;
		v = v.lchild;
		System.out.println(t.successor(v).data);
	}
}
