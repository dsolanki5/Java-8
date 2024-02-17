package com.learnJava;

import java.util.HashSet;
import java.util.Set;

class Parent {
	
	int x=10;
	String name = "Parent";
	int y = 30;
	
	public void m1() {
		System.out.println("Parent class - m1()");
	}
	
	public void m2() {
		System.out.println("Parent class - m2()");
	}
	
	public void doSomeThing(int x, int y) {
		System.out.println("doSomething: "+(x+y));
	}
}
//////
class Child1 extends Parent {
	int x = 20;
	String name = "Child1";
	int z = 40;
	
	public void m1() {
		System.out.println("Child1 class - m1()");
	}
	
	public void m3(int x) {
		System.out.println("Child1 class - m3()");
	}
	
	
	public void m5(Parent p) {
		System.out.println("printing parent: m5() "+p.x);
	}
	
	
	
}
////////
public class Main {

    public static void main(String[] args) {
    	
    	Set<String> GFG = new HashSet<String>();
    	  
        // Add elements into HashSet using add()
        GFG.add("Welcome");
        GFG.add("To");
        GFG.add("Geeks");
        GFG.add("For");
        GFG.add("Geek");
  
        // Displaying HashSet
        System.out.println("HashSet contains: " + GFG);
	
//    	System.out.println("Main class - main()");
//    	
//    	Parent parent = new Parent();
//    	parent.m1();
//    	parent.m2();
//    	System.out.println("1. "+parent.x);
//    	System.out.println("2. "+parent.name);
//    	
//    	System.out.println("*******************************************");
//    	Parent parChild = new Child1();
//    	parChild.m2();
////    	parChild.m3();
//    	parChild.m1();
//    	
//    	System.out.println("*******************************************");
//    	Child1 child1 = new Child1();
//    	child1.m2();
//    	child1.m1();
//    	child1.m3(5);
//    	//Child1 childPar = (Child1)new Parent();
    	
    	Parent p = new Parent();
//    	schild1.m5(p);
    	
    	p.doSomeThing(getX(), getY());
    	
    	
    }
    
    public static int getX() {
    	return 5;
    }
    
    public static int getY() {
    	return 4;
    }
}
