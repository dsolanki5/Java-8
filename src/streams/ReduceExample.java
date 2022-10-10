package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDataBase;

public class ReduceExample {
	
	/*
	 * Reduce is another Terminal operator (collect was also a terminal operator)
	 * Reduce() method reduces stream of values to single desired value
	 * Below are examples
	 */

	public static int getMultiplicationOfNums(List<Integer> nums) {
		return nums.stream()
				.reduce(1, (a,b) -> a*b);  //here 1 is Identity i.e starting value or base value
										   // it will multiply two nos at a time : a,b
										   // at beginning 1* first value of list i.e, 1*1=1
								  // the result of above expression is multiplied with second value of list
									// i.e, 1*3=3 & then 3*5=15 & then 15*7=105 
								// i.e the list of nums is reduced to single desired value : 105 and returned

		// Here the starting value i.e identity i.e 1 can be removed  but then reduce will return 
			// "Optional" type of data . Refer below method :
	}
	
	public static Optional<Integer> getMultiplicationOfNumsReturningOptional(List<Integer> nums) {
		return nums.stream()
				.reduce((a,b) -> a*b);  //here Identity i.e starting value is removed and return type
										// is Optional<Integer> . This is for handling null value if any
		
	}
	
	public static Optional<Student> getHighestGpaStudent(List<Student> students) {
//		return students.stream()
//				.reduce((s1,s2) -> {
//					if(s1.getGpa() > s2.getGpa())
//						return s1;
//					else
//						return s2;
//				});
		
		return students.stream()
				.reduce((s1,s2)-> s1.getGpa()>s2.getGpa()?s1:s2);
	}
	
	public static Optional<Integer> getMaxValue(List<Integer> nums) {
		
		// below approach uses simple lambda expression to find max value
		// change return type of method to int
//		return nums.stream()
//				.reduce(Integer.MIN_VALUE,(a,b) -> a>b?a:b);
		
		/*
		 * It is always recommended to use Optional when calculating max / min / sum operation
		 */
//		return nums.stream()
//				.reduce((a,b)->a>b?a:b);
		
			//OR using Method reference : Integer:max
		return nums.stream()
				.reduce(Integer::max);
	}
	
	public static Optional<Integer> getMinValue(List<Integer> nums) {
		return nums.stream()
				.reduce(Integer::min);
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,3,5,7);
//		List<Integer> nums = new ArrayList<>();
		
		System.out.println("Multiplicatio of all value is : "+getMultiplicationOfNums(nums));
		
		Optional<Integer> result = getMultiplicationOfNumsReturningOptional(nums);
		System.out.println("if result has value or no : "+result.isPresent());
		
		if(!result.isEmpty())
			System.out.println("Multiplication returning Optional: "+result.get());
		
		Optional<Student> highestGpaStud = getHighestGpaStudent(StudentDataBase.getAllStudents());
		System.out.println("Highest GPA student is : "+highestGpaStud.get());
		
		Optional<Integer> maxVal = getMaxValue(nums);
		if(maxVal.isPresent())
			System.out.println("Max is "+maxVal.get());
		else
			System.out.println("Empty Input");
		
		Optional<Integer> minVal = getMinValue(nums);
		if(minVal.isPresent())
			System.out.println("Min is : "+minVal.get());
		else
			System.out.println("Empty list ");
		
	}
}
