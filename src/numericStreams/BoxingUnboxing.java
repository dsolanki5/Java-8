package numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxing {
	
	public static List<Integer> boxedIntgToInt() {
		return IntStream.range(1, 51)
				.boxed()
				.collect(Collectors.toList());
	}
	
	public static int unboxingIntToIntg(List<Integer> integerList) {
		return integerList.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Boxing: int to Integer : \n"+boxedIntgToInt());
		List<Integer> intgerList = boxedIntgToInt();
		System.out.println("Unboxing: Integer to int : \n"+unboxingIntToIntg(intgerList));
	}

}
