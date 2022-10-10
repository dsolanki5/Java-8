package functionalInterface;
import java.util.function.Predicate;

public class PredicateExample {
	
	static Predicate<Integer> p1 = num -> num%2==0;
	static Predicate<Integer> p2 = num -> num%5==0;
	
	public static void main(String[] args) {
		
		System.out.println(p1.test(4));
		
		System.out.println("p1AndP2 : "+p1.and(p2).test(10));
		System.out.println("p1OrP2 : "+p1.or(p2).test(25));
		System.out.println(p1.and(p2).test(9));
		System.out.println(p1.and(p2).test(15));
		System.out.println(p1.test(4) && p2.test(10));
		System.out.println("Negate : "+p1.negate().test(10)); // result will be revesed i.e ~
		
	}
	

}
