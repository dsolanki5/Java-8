package com.learnJava;

import org.joda.time.DateTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class A {
	public static void m1() throws Exception {
			m2();
		
		System.out.println("In m1()");
	}
	
	public static void m2() throws Exception {
		try {
			m3();
		}
		catch(Exception ex) {
			System.out.println("exception catch at m2");
		}
		System.out.println("In m2()");
	}
	
	public static void m3() throws Exception {
		
		throw new Exception();
//		System.out.println("In m3()");
		
	}
	
	public static void main(String[] args) throws Exception {
		//m1();
//		System.out.println("Hello, World! : "+DateTime.now());
//		System.out.println("Hello, World! : "+Instant.now());
//        System.out.println("Hello, World! : "+ZonedDateTime.now());
//        System.out.println("Hello, World! : "+LocalDateTime.now());
//        
//        String s1 = "dabcabceabcfabch";
//        String s2 = "abc";
//        
//        System.out.println(countSubString(s1,s2));
		
		List<String> a1 = new ArrayList<>();
		a1.add("Arnik");
		a1.add("Jeeni");
		
		//a1 = Collections.unmodifiableList(a1);
		System.out.println(checkIsSynchronized(a1));
		System.out.println(a1);
	}

	private static boolean checkIsSynchronized(List<String> a1) {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Adding Deepak...");
				a1.add("Deepak");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("Adding Manish...");
				a1.add("Manish");
			}
		};
		t1.start();
		t2.start();
		return (a1.contains("Deepak") && a1.contains("Manish"));
	}
	
	public static int countSubString(String s1, String s2) {
        String[] s1Ar = s1.split("abc");
        System.out.println(Arrays.toString(s1Ar));
        int count=0;
        for(int i=0; i<s1Ar.length; i++) {
        	if(s1Ar[i].equals("") || s1Ar[i].equals(" ")) {
        		count++;
        	}
        }
        return (s1.length() - (s1Ar.length-count))/s2.length();
    }

}

