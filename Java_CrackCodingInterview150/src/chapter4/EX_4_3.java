package chapter4;

public class EX_4_3 {

//Given a sorted (increasing order) array, write an algorithm to create a binary tree with 
//minimal height
//time: O(n), space: O(n)
	
	public static class Node {
		Node lchild;
		Node rchild;
		int data;
		public Node (Node l, Node r, int d) {
			lchild = l;
			rchild = r;
			data = d;
		}
	}
	
	public static class BinaryTree {
		public Node root = null;
		public int[] a;
		
		public void creat () {
			root = creatHelper (0, a.length - 1);
		}
		
		public Node creatHelper (int s, int e) {
			if (s <= e){
				int d = (s + e) / 2;
				Node v = new Node (null, null, a[d]);
				v.lchild = creatHelper (s, d - 1);
				v.rchild = creatHelper (d + 1, e);
				return v;
			}
			return null;
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
		BinaryTree t = new BinaryTree ();
		t.a = new int[] {1,2,3,4,5,6,7,8,9};
		t.creat ();
		t.inOrder (t.root);
	}
}
