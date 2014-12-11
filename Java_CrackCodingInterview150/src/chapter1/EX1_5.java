package chapter1;

public class EX1_5 {

//Write a method to replace all spaces in a string with ¡®%20¡¯
//time: O(length), space: in-place
	
	public static void replacespace (char[] c, int length) {
		if (c == null || length == 0)
			return;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (c[i] == ' ')
				count++;
		}
		int newlength = length + count * 2;
		c[newlength] = '\0';
		for (int j = length - 1; j >= 0; j--) {
			if (c[j] == ' ') {
				c[newlength - 1] = '0';
				c[newlength - 2] = '2';
				c[newlength - 3] = '%';
				newlength -= 3;
			}
			else {
				c[newlength - 1] = c[j];
				newlength--;
			}
		}
	}
	
	public static String replacespace1 (String s) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(i, i + 1);
			if (sub.equals(" "))
				buf.append("%20");
			else
				buf.append(sub);
		}
		return buf.toString();
	}
	
	public static void main (String[] args) {
		char[] s = new char[15];
		int length = 5;
		for (int i = 0; i < 15; i++) {
			if (i % 2 == 0)
				s[i] = ' ';
			else
				s[i] = 's';
		}
		replacespace(s, length);
		System.out.print(s);
	}
}
