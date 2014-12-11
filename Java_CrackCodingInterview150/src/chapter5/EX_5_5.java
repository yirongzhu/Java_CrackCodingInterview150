package chapter5;

public class EX_5_5 {

//Write a function to determine the number of bits required to convert integer A to 
//integer B
//Input: 31, 14
//Output: 2
//countBits: (time: O(n))
//countBits: (time: O(n) (Worst-case))

	public static int countBits (int a, int b) {
		int c = a ^ b;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((1 << i) & c) != 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int countBits1 (int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	public static void main (String[] args) {
		int a = 31;
		int b = 31;
		System.out.println(countBits1 (a, b));
	}
}
