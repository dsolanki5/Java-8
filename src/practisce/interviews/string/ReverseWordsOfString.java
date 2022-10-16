package practisce.interviews.string;

import java.util.Arrays;

public class ReverseWordsOfString {
	
	public static String reverseWords_1(String s) {
		StringBuilder sb = new StringBuilder("");
		int n = s.length();
		int j = 0, k = 0, i = 0;
		for (i = n - 1; i >= 0; i--) {

			// checked for word not start with ' '

			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			// stored end of word in (j variable)
			j = i;

			// again find start of word with this loop
			// and stored its value in (k variable)

			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			k = i + 1;

			// here we append the word one by one from K to J

			while (k <= j) {
				sb.append(s.charAt(k));
				k++;
			}

			// then again searched for any spaces' ' at end
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			if (i != -1)
				sb.append(' ');
			i += 1;
		}
		return sb.toString();
	}
	
	public static String reverseWords_2(String s) {
        if(s==null || s=="")
            return s;
        
        String[] sarr = s.trim().split(" ");
//        System.out.println(Arrays.toString(sarr));
        String rev="";
        for(int i=sarr.length-1; i>=0; i--) {
//        	System.out.println("- "+sarr[i]);
        	if(!("".equals(sarr[i]))) {
        		rev+=sarr[i].trim()+" ";
        	}
        }
        
        return rev.trim();
    }

	public static void main(String[] args) {
		System.out.println(reverseWords_1("a good   example")); //less time recommended approach
		System.out.println(reverseWords_2("a good   example"));

	}

}
