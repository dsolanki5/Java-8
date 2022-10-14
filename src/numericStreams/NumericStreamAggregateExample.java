package numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {
	
	public static void main(String[] args) {
		
		int sumInt = IntStream.range(0, 50).sum(); 
		System.out.println("Sum is : "+sumInt);
		
		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		System.out.println("total input : "+IntStream.rangeClosed(1, 50).count());
		System.out.println("Max is : ");
		System.out.print(max.isPresent()?max.getAsInt():Integer.MIN_VALUE);
		System.out.println();
		
		OptionalLong min = LongStream.range(0, 0).min();
		System.out.println("total count in input : "+LongStream.range(0, 0).count());
		System.out.println("Min is : ");
		System.out.print(min.isPresent()?min.getAsLong():Long.MAX_VALUE);
		
		OptionalDouble avg = IntStream.range(1, 51).average();
		System.out.println("Avg : ");
		System.out.println(avg.isPresent()?avg.getAsDouble():-1);
	}

}
