package chapter1;

public class EX1_2 {

// Write code to reverse a C-Style String (C-String means that ¡°abcd¡± is represented as five characters, including the null character )
// O(n) space, O(n) time
	
	public static char[] reverse (char[] c) {
		if (c == null)
			return new char[] {};
		for (int i = 0; i < c.length / 2; i++) {
			char tmp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = tmp;
		}
		return c;
	}
	
	public static char[] reverse1 (char[] c) {
		int start = 0;
		int end = c.length - 2;
		while (start < end) {
			char tmp = c[start];
			c[start] = c[end];
			c[end] = tmp;
			start++;
			end--;
		}
		return c;
	}
	
	public static void main (String[] args) {
		char[] c = {'o', 'm', 'g', '\0'};
		System.out.print(reverse1(c));
	}
}
