package practisce.interviews.string;

public class ReverseStringUsingRecursion {
	
	public static void main(String[] args) {
		System.out.println(reverseRecursion("LeetCode"));
	}

	private static String reverseRecursion(String str) {
		if(str == null || str.length() <= 1) {
			return str;
		}
		
		return reverseRecursion(str.substring(1))+str.charAt(0);
	}

}
