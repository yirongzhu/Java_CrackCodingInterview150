package chapter5;

public class EX_5_6 {

//Write a program to swap odd and even bits in an integer with as few instructions as 
//possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
//swapBits1 and swapBits2 takes 5 instructions by using hexadecimal representation, if we cannot use hexadecimal, swapBits is the method but takes linear time.
	
	public static int swapBits (int a) {
		int even = 1;
		for (int i = 0; i < 32; i += 2) {
			even |= (1 << i);
		}
		int remainodd = even & a;
		even = even << 1;
		int remaineven = even & a;
		return (remainodd << 1) | (remaineven >> 1);
	}
	
	public static int swapBits1 (int a) {
		int mask = 0xaaaaaaaa;
		return ((a & mask) >> 1) | ((a << 1) & mask);
	}
	
	public static int swapBits2 (int a) {
		return ((a & 0xaaaaaaaa) >> 1) | ((a & 0x55555555) << 1);
	}
	
	public static void main (String[] args) {
		int a = 170;
		System.out.println(swapBits2 (a));
	}
}
