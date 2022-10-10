package functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	/*
	 * UnaryOperator interface extends Function Interface
	 * It is used where the type of Input and Output is similar
	 * It has only 1 parameter 
	 */
	
	static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");

    public static void main(String[] args) {


        System.out.println(unaryOperator.apply("java8"));
    }
}
