package practisce.interviews.string;

import java.time.Duration;
import java.time.Instant;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInString {
	
	// recommended approach :
	public static String reverseWords_1(String s) {
		Instant start = Instant.now();
		
        if(s==null || s==""){
            return s;
        }
        
        char[] sarr = s.toCharArray();
        
        int l=0, r=0, n=sarr.length;
        for(int i=0; i<n; i++) {
            
            if(sarr[i]==' ' || i==n-1) {
                
                r = i==n-1?i:i-1;
                
                while(l<r) {
                    char t = sarr[l];
                    sarr[l] = sarr[r];
                    sarr[r] = t;
                    l++;
                    r--;
                }
                
                l=i+1;
            }
        }
        System.out.println("Total time by Approach 1 : "+Duration.between(start, Instant.now()).toMillis());
        return String.valueOf(sarr);
    }
	
	public static String reverseWords_2 (String inputString) {
		Instant start = Instant.now();
		
		String revStr = "";
		String[] splitStrAr = inputString.split(" ");
		for(String splitStr : splitStrAr) {
			revStr += reverse(splitStr);
			revStr+=" ";
		}
		
		revStr = revStr.trim();
		
		System.out.println("Total time by Approach 2 : "+Duration.between(start, Instant.now()).toMillis());
		
		return revStr;		
	}
	
	public static String reverse(String str1) {
		char[] strAr = str1.toCharArray();
		for(int i=0,j=strAr.length-1; i<j; i++,j--) {
			char temp = strAr[j];
			strAr[j] = strAr[i];
			strAr[i] = temp;
		}
		
		return String.valueOf(strAr);		
	}
	
	public static void main(String[] args) {
		System.out.println("Reverse using approach 1 : "+reverseWords_1("Let's take LeetCode contest"));
		System.out.println("Reverse using approach 2 : "+reverseWords_2("Let's take LeetCode contest"));
		
		
		String t = "012345";
		System.out.println("t : "+t);
		String t2 = t.substring(0, 3);
		t=t.substring(3);
		System.out.println(t2);
		System.out.println(t);
		
	}
}
