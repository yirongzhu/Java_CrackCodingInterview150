package chapter1;

public class EX1_1 {

//Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?	
//O(1) space, O(n) time;
	
	public static boolean checkUniqueChar (String s) {
		int[] check = new int[256];
		int asc;
		for (int i = 0; i < s.length(); i++) {
			asc = (int) s.charAt(i);
			check[asc]++;
		}
		for (int i = 0; i < check.length; i++) {
			if (check[i] > 1)
				return false;
		}
		return true;
	}
	
	public static boolean checkUniqueChar1 (String s) {
		boolean[] check = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int asc = s.charAt(i);
			if (check[asc])
				return false;
			check[asc] = true;
		}
		return true;
	}
	
	public static boolean checkUniqueChar2 (String s) {
		int[] check = new int[8];
		for (int i = 0; i < s.length(); i++) {
			int asc = s.charAt(i);
			int d = asc / 32;
			int m = asc % 32;
			if ((check[d] & (1 << m)) > 0)
				return false;
			check[d] |= (1 << m);
		}
		return true;
	}
	
	public static void main (String[] args) {
		String s = "asdfghjkl";
		System.out.print(checkUniqueChar2(s));
	}
}
