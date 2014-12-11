package chapter1;

public class EX1_8 {

//Assume you have a method isSubstring which checks if one word is a substring of 
//another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
//only one call to isSubstring (i e , ¡°waterbottle¡± is a rotation of ¡°erbottlewat¡±)
//time: O(1), space: O(n)
	
	public static boolean isSubstring (String s1, String s2) {
		if (s1.contains(s2))
			return true;
		else
			return false;
	}
	
	public static boolean isRotation (String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0)
			return false;
		String news1 = s1 + s1;
		return isSubstring(news1, s2);
	}
	
	public static void main (String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(isRotation(s1, s2));
	}
}
