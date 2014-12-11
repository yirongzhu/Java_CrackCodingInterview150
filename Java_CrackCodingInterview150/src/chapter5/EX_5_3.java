package chapter5;

public class EX_5_3 {

//Given an integer, print the next smallest and next largest number that have the same 
//number of 1 bits in their binary representation
	
	public static int countOne (int mask, int n) {
		int count = 0;
		for ( ; mask >= 1; mask = mask >> 1) {
			if ((mask & n) != 0) {
				count++;
			}
		}
		return count;
	}
	
	public static void print (int n) {
		System.out.println("the next smallest: " + nextSmallest (n));
		System.out.println("the next largest: " + nextLargest (n));
	}
	
	public static String nextSmallest (int n) {
		int mask = 1;
		int i = 0;
		while ((i < 32) && (mask & n) != 0) {
			mask = mask << 1;
			i++;
		}
		while ((i < 32) && (mask & n) == 0) {
			mask = mask << 1;
			i++;
		}
		if (i == 32) {
			return "No next smalllest";
		}
		else {
			mask = mask >> 1;
			n = n - mask;
			int m = ~ (mask - 1);
			int count = countOne (mask >> 1, n);
			n = n & m;
			while (count > 0) {
				mask = mask >> 1;
				n = n + mask;
				count--;
			}
			return Integer.toString(n);
		}
	}

	public static String nextLargest (int n) {
		int mask = 1;
		int i = 0;
		while ((i < 32) && (mask & n) == 0) {
			mask = mask << 1;
			i++;
		}
		while ((i < 32) && (mask & n) != 0) {
			mask = mask << 1;
			i++;
		}
		if (i == 32) {
			return "No next largest";
		}
		else {
			int m = ~ (mask - 1);
			mask = mask >> 1;
			n = n + mask;
			int count = countOne (mask, n);
			n = n & m;
			int j = 1;
			while (count > 0) {
				n += j;
				j = j << 1;
				count--;
			}
			return Integer.toString(n);
		}
	}
	
	public static void main (String[] args) {
		int n = 177;
		print (n);
		System.out.println();
	}
}
