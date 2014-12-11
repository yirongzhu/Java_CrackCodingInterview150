package chapter4;
import java.util.*;

public class EX_4_2 {

//Given a directed graph, design an algorithm to find out whether there is a route between two nodes
//time: O(V + E), space: O(V + E)
	
	public static class Node {
		ArrayList<Node> adj = new ArrayList<Node> ();
	}
	
	public static class Graph {
		
		public boolean BFSFind (Node s, Node v) {
			HashMap<Node, Node> parent = new HashMap<Node, Node> ();
			parent.put(s, null);
			ArrayList<Node> frontier = new ArrayList<Node> (Arrays.asList(s));
			while (!frontier.isEmpty()) {
				ArrayList<Node> next = new ArrayList<Node> ();
				for (Node n : frontier) {
					for (Node m : n.adj) {
						if (!parent.containsKey(m)) {
							parent.put(m, n);
							next.add(m);
						}
					}
				}
				frontier = next;
			}
			return parent.containsKey(v);
		}
		
		public boolean DFSFind (Node s, Node v) {
			HashMap<Node, Node> parent = new HashMap<Node, Node> ();
			parent.put(s, null);
			DFSFindHelper (s, parent);
			return parent.containsKey(v);
		}
		
		public void DFSFindHelper (Node s, HashMap<Node, Node> parent) {
			for (Node n : s.adj) {
				if (!parent.containsKey(n)) {
					parent.put(n, s);
					DFSFindHelper (n, parent);
				}
			}
		}
	}
	
	public static void main (String[] args) {
		Graph graph = new Graph ();
		
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node();
		Node g = new Node();
		
		a.adj.addAll(Arrays.asList(b, g));
		b.adj.addAll(Arrays.asList(c));
		c.adj.addAll(Arrays.asList(a, d, f));
		d.adj.addAll(Arrays.asList(e, f));
		g.adj.addAll(Arrays.asList(c));
		
		System.out.println(graph.BFSFind(g, e));
		System.out.println(graph.DFSFind(g, e));
		System.out.println(graph.BFSFind(e, g));
		System.out.println(graph.DFSFind(e, g));
		System.out.println(graph.BFSFind(c, a));
		System.out.println(graph.DFSFind(c, a));
		System.out.println(graph.BFSFind(f, e));
		System.out.println(graph.DFSFind(f, e));
		
	}
}
