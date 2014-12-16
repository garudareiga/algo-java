package math;

/**
 * 
 * @author raychen
 * 
 * Problem:
 * Divide number and return result in form of a string. e.g 100/3 result should
 * be 33.(3) Here 3 is in brackets because it gets repeated continuously and 
 * 5/10 should be 0.5.
 */

public class Division {
	public String divide(int dividend, int divisor) {
		StringBuilder sb = new StringBuilder();
		if (dividend > divisor) {
			sb.append(dividend / divisor);
			dividend %= divisor;
		} else 
			sb.append('0');
		if (dividend > 0) sb.append('.');
		int count = 0;
		while (dividend > 0) {
			int value = dividend*10 / divisor;
			if (dividend*10 % divisor == dividend) {
				sb.append("(" + value + ")"); break;
			} else {
				sb.append(value);
			}
			dividend = dividend*10 % divisor;
			if (++count >= 10) break;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Division d = new Division();
		System.out.println(d.divide(100, 3));
		System.out.println(d.divide(5, 10));
		System.out.println(d.divide(22, 7));
	}
}
