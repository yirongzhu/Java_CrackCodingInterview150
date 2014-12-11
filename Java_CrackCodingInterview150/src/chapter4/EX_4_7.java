package chapter4;

public class EX_4_7 {

//You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes Create an algorithm to decide if T2 is a subtree of T1
//
	
	public static class Node {
		Node lchild;
		Node rchild;
		int data;
		
		public Node (int d) {
			lchild = null;
			rchild = null;
			data = d;
		}
	}
	
	public static class BinaryTree {
		private Node root;
		
		public BinaryTree (int d) {
			root = new Node (d);
		}
		
		public void linsert (Node s, Node v) {
			s.lchild = v;
		}
		
		public void rinsert (Node s, Node v) {
			s.rchild = v;
		}
		
		public String preOrder (Node v) {
			StringBuffer buf = new StringBuffer ();
			preOrderHelper (buf, v);
			return buf.toString();
		}
		
		public String inOrder (Node v) {
			StringBuffer buf = new StringBuffer ();
			inOrderHelper (buf, v);
			return buf.toString();
		}
		
		public void preOrderHelper (StringBuffer buf, Node v) {
			if (v == null) {
				return;
			}
			buf.append(((Integer) v.data).toString());
			preOrderHelper (buf, v.lchild);
			preOrderHelper (buf, v.rchild);
		}
		
		public void inOrderHelper (StringBuffer buf, Node v) {
			if (v == null) {
				return;
			}
			preOrderHelper (buf, v.lchild);
			buf.append(((Integer) v.data).toString());
			preOrderHelper (buf, v.rchild);
		}
		
		public boolean testSubtree (BinaryTree t) {
			if (t == null)
				return true;
			else {
				String pret1 = this.preOrder(root);
				String int1 = this.inOrder(root);
				String pret2 = t.preOrder(t.root);
				String int2 = this.inOrder(root);
				return pret1.contains(pret2) && int1.contains(int2);
			}
		}
	}
	
	public static void main (String[] args) {
		BinaryTree t = new BinaryTree (6);
		Node b = new Node (2);
		Node c = new Node (7);
		Node d = new Node (1);
		Node e = new Node (8);
		Node f = new Node (9);
		Node g = new Node (4);
		Node h = new Node (5);
		Node i = new Node (3);

		t.linsert (t.root, b);
		t.rinsert (t.root, c);
		t.rinsert (c, e);
		t.rinsert (e, f);
		t.linsert (b, d);
		t.rinsert (b, g);
		t.rinsert (g, h);
		t.linsert (g, i);
		
		System.out.println(t.preOrder (t.root));
		
		BinaryTree t1 = new BinaryTree (4);
		t1.linsert (t1.root, new Node (3));
		t1.rinsert (t1.root, new Node (5));
		
		System.out.println(t.preOrder (t1.root));
		
		System.out.println(t.testSubtree (t1));
	}
}
