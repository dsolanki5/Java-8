package practisce.interviews.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicateCharInString {
	
	public static void printDuplicates_Suraj() {
        // count
	 String inputString ="Hellooeee";
        int count = 0;

        // a temp list of ch for which we have already printed the count
        ArrayList<Character> charList = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            // count the number of occurrences of the char ch in inputString
            for (int j = 0; j < inputString.length(); j++) {
                if (inputString.charAt(j) != ch) {
                    continue;
                }
                count++;
            }

            // check if we have already printed for ch
            if (!charList.contains(ch)) {
                // check if count is more than 1 i.e. duplicate and char should not be space
                if (count > 1 && ch != ' ') {

                    System.out.println("Char: " + ch + ", Count: " + count + " times.");
                    charList.add(ch);
                }
            }

            // set counter to zero for next ch
            count = 0;
        }
    }

	public static void main(String[] args) {
		/*
		 * Q1. Remove duplicate chars from String
		 */
		String s= "Hellooeee";
		String distinctStr = removeDuplicateChar(s);	//Approach 1	
		System.out.println("Distinct: "+distinctStr);
		
		printDuplicates_Suraj();// Dont use this approach O(n^2)
		
		
		/*
		 * Q2. Count frequency of char in string
		 */
		String str="Deepakad";
		System.out.println("2.1: Frequency of all chars of string : "+calFrequency(str));
		System.out.println("2.1: Frequency of only duplicate chars of string : "+calFrequencyOfDuplChars(str));
		
		/*
		 * Q3. Frequency of first element of String
		 */
		System.out.println("Q3. Frequency of first element of string : ");
		//Use LinkedHashMap solution from calFrequency() method
		System.out.println("First char => "+("stress").charAt(0)+" & its frequency => "+
						calFrequency("stress").get(("stress").charAt(0)));
		
	}
	
	private static Map<Character,Long> calFrequency(String s) {
		return s.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(c1->c1, Collectors.counting()));
		/*
		 * Or using LinkedHashMap for sequential order
		 */
//		return s.chars()
//				.mapToObj(c -> (char)c)
//				.collect(Collectors.groupingBy(c1->c1, LinkedHashMap::new, Collectors.counting()));
	}

	private static Map<Character,Long> calFrequencyOfDuplChars(String s) {
		
//		return s.chars()
//				.mapToObj(c -> (char)c)
//				.collect(Collectors.groupingBy(c1->c1,Collectors.counting()))
//				.entrySet()
//				.stream()
//				.filter(e -> e.getValue()>1)
//				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

		/*
		 * Or using LinkedHashMap for sequential order
		 */
		//Deepakad
		return s.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(c1->c1, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue()>1)
				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1,e2)->e1, LinkedHashMap::new));
	}

	private static String removeDuplicateChar(String s) {
		int[] countAr = new int[150];
		Arrays.fill(countAr, 0);
		
		String distinctStr = "";
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(countAr[ch] == 0) {
				distinctStr+=ch;
			}
			
			countAr[ch]++;
		}
		
		for(int i=0; i<countAr.length;i++) {
			if(countAr[i]>1) {
				System.out.println("Char "+((char)i)+" is repeated "+countAr[i]+" times");
			}
		}
		return distinctStr;
	}

}
