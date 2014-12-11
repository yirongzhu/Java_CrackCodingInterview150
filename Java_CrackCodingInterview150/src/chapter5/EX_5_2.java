package chapter5;

public class EX_5_2 {

//Given a (decimal - e g 3 72) number that is passed in as a string, print the binary representation If the number can not be represented accurately in binary, print ¡°ERROR¡±
	
	public static String ignoreDecimal (String decimal) {
		if (decimal.indexOf(".") != -1) {
			int test = Integer.parseInt(decimal.substring(decimal.indexOf(".") + 1));
			if (test > 0) {
				return "ERROR";
			}
		}
		int d = Integer.parseInt(decimal);
		StringBuilder result = new StringBuilder ();
		while (d != 0) {
			result.append(d % 2);
			d /= 2;
		}
		return result.reverse().toString();
	}
	
	
	
	public static void main (String[] args) {
		String decimal = "1986";
		System.out.println(ignoreDecimal(decimal));
	}
}
