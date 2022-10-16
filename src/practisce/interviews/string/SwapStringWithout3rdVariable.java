package practisce.interviews.string;

public class SwapStringWithout3rdVariable {
	
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "World";
		
		s2 = s2.concat(s1);
		s1 = s2.substring(0,s2.lastIndexOf(s1));
		s2 = s2.substring(s1.length());
		
		System.out.println(s1);
		System.out.println(s2);
//		s2=s2.substring(0)
	}

}
