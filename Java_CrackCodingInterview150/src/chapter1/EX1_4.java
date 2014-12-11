package chapter1;
import java.util.*;

public class EX1_4 {

//Write a method to decide if two strings are anagrams or not.
//isanagrams: O(n) time, O(1) space
//isanagrams1: O(nlogn) time, O(n) space
	
	public static boolean isanagrams (String a, String b) {
		if (a == "" || b == "" || a.length() != b.length() || a.equals(b))
			return false;
		int[] check = new int[256];
		for (int i = 0; i < a.length(); i++) {
			int asca = (int) a.charAt(i);
			int ascb = (int) b.charAt(i);
			check[asca]++;
			check[ascb]--;
		}
		for (int i = 0; i < 256; i++) {
			if (check[i] != 0)
				return false;
		}
		return true;
	}
	
	public static boolean isanagrams1 (String a, String b) {
		if (a == "" || b == "" || a.length() != b.length() || a.equals(b))
			return false;
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();
		Arrays.sort(c);
		Arrays.sort(d);
		String e = new String(c);
		String f = new String(d);
		if (e.equals(f)) return true;
		else return false;
	}
	
	public static void main (String[] args) {
		String a = "qwertyuiop";
		String b = "poiuytrewq";
		System.out.print(isanagrams1 (a, b));
	}
}
