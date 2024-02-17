package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxvalue(List<Integer> integerList){

        return integerList.stream()
                //6 -> y
                //7 -> y
                //8-> y
                //9-> y
                //10-> y
                //x variable holds the max value for each element in the iteration
                .reduce(0,(x,y)-> x>y ? x : y);
    }
    
    // @solanki:
    public static int findMaxValueWithoutReduce(List<Integer> intgList ) {
    	return intgList.stream()
    			.max((x,y) -> x.compareTo(y))
    			.get();
    }

    public static Optional<Integer> findMinvalue(List<Integer> integerList){

        return integerList.stream()
                //6 -> y
                //7 -> y
                //8-> y
                //9-> y
                //10-> y
                //x variable holds the max value for each element in the iteration
                .reduce((x,y)-> x<y ? x : y);
    }

    public static Optional<Integer> findMaxvalueOptional(List<Integer> integerList){

        return integerList.stream()
                //6 -> y
                //7 -> y
                //8-> y
                //9-> y
                //10-> y
                //x variable holds the max value for each element in the iteration
                .reduce((x,y)-> x>y ? x : y);
    }
    
    public static int findMinValueWithoutReduce(List<Integer> intgList) {
    	if(null != intgList && !intgList.isEmpty()) {
//    		return intgList.stream()
//    				.min((x,y)->x.compareTo(y))
//    				.get();
    		return intgList.stream()
    				.min((x,y)->x.compareTo(y))
    				.orElseGet(() -> Integer.MAX_VALUE);
    	}
    	return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
//        List<Integer> integerList = new ArrayList<>();

        Optional<Integer> minValueOptional = findMinvalue(integerList);
        System.out.println("minValueOptional : " + minValueOptional);

        if(minValueOptional.isPresent()){
            System.out.println("The minimum value is : " + minValueOptional.get());
        }else{
            System.out.println("No Input is passed");
        }
        
        System.out.println("Min value without reduce() :: "+findMinValueWithoutReduce(integerList));

        int maxValue = findMaxvalue(integerList);
        System.out.println(" max value is :" + maxValue);

        Optional<Integer> maxValueOptional = findMaxvalueOptional(integerList);
//        System.out.println("Optional Max is : " + maxValueOptional);
        if(maxValueOptional.isPresent()){
            System.out.println("MaxValue using optional :" + maxValueOptional.get());
        }else{
            System.out.println("Input list is empty.");
        }
        
        int maxWithoutReduce = findMaxValueWithoutReduce(integerList);
        System.out.println("Max withouth reduce :: "+maxWithoutReduce);


    }
}
