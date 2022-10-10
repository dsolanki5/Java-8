package functionalInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
	
	/**
	 * Like UnaryOperator, BinaryOperator also expects input and output parameter of same type
	 * But BinaryOperator accepts 2 input parameters and return output which is of same datatype
	 * as of input parameters
	 */
	
	static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

        System.out.println(binaryOperator.apply(3,4));

        //maxBy and minBy are methods provided by BinaryOperator to calculate max and min
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Result of MaxBy is : " + maxBy.apply(4,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Result of minBy is : " + minBy.apply(4,5));

    }

}

//Next is : SupplierExample
