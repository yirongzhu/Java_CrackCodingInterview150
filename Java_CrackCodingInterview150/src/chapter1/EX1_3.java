package chapter1;

public class EX1_3 {

//Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer NOTE: One or two additional variables are fine 
//An extra copy of the array is not
//FOLLOW UP
//Write the test cases for this method
//removedupchar: O(n) time, O(1) space
//removedupchar1: O(n^2) time, inplace
	
	public static void removedupchar (char[] c) {
		if (c.length < 2) return;
		boolean[] check = new boolean[256];
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			int asc = (int) c[i];
			if (!check[asc]) {
				c[j++] = c[i];
				check[asc] = true;
			}
		}
		for (; j < c.length; j++)
			c[j] = '\0';
	}
	
	public static void removedupchar1 (char[] c) {
		if (c.length < 2) return;
		int p = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] != '\0') {
				c[p++] = c[i];
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] == c[j])
						c[j] = '\0';
				}
			}
		}
		for (; p < c.length; p++)
			c[p] = '\0';
	}
	
	public static void main (String[] args) {
		char[] c = {'o','o', 'm', 'm', 'g', 'g', 'a', 'b', 'o','o', 'm', 'm', 'c', 'g', 'a', 'b', 'o', 'i'};
		removedupchar1(c);
		System.out.print(c);
	}
}
