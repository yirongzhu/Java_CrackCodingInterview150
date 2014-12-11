package chapter5;

public class EX_5_1 {

//You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a 
//method to set all bits between i and j in N equal to M (e g , M becomes a substring of 
//N located at i and starting at j) 
//EXAMPLE:
//Input: N = 10000000000, M = 10101, i = 2, j = 6
//Output: N = 10001010100
	
	public static int transferBit (int m, int n, int i, int j) {
		m = m << i;
		for (int k = j; k >= i; k--) {
			n = n & ( ~ (1 << k));
		}
		n = n | m;
		return n;
	}
	
	public static int transferBit1 (int m, int n, int i, int j) {
		int ret = (1 << i) - 1;
		ret = ret & n;
		return ((n >> (j + 1)) << (j + 1)) | ret | (m << i);
	}
	
	public static int transferBit2 (int m, int n, int i, int j) {
		int max = ~ 0;
		int left = max - ((1 << (j + 1)) - 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		return (mask & n) | (m << i);
	}
	
	public static void main (String[] args) {
		int n = 1024;
		int m = 21;
		int i = 2;
		int j = 6;
		System.out.println(transferBit (m, n, i, j));
		System.out.println(transferBit1 (m, n, i, j));
		System.out.println(transferBit2 (m, n, i, j));
	}
}
