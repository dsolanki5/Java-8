package numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxing {
	
	public static List<Integer> integerToInt() {
		return IntStream.range(1, 51)
				.boxed()
				.collect(Collectors.toList());
	}
	
	public static int intToInteger(List<Integer> integerList) {
		return integerList.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Boxing: int to Integer : \n"+integerToInt());
		List<Integer> intgerList = integerToInt();
		System.out.println("Unboxing: Integer to int : \n"+intToInteger(intgerList));
	}

}
