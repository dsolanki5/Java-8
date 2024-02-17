package streamsTerminal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import practisce.interviews.java8.Emp2;

/*
 * Refer : https://www.baeldung.com/java-collectors-tomap
 * Youtube explanation : https://www.youtube.com/watch?v=Gv4duTIb8j8
 * 
 */
public class StreamsCollectToMap {
	
	public static void main(String[] args) {
		List<Emp2> list2 = new ArrayList<>();
		list2.add(new Emp2("Dikesh", 250000));
		list2.add(new Emp2("A", 25000));
		list2.add(new Emp2("A", 35000));
		list2.add(new Emp2("B", 2000));
		list2.add(new Emp2("C", 45300));
		
//		Map<String, Integer> listToMap = list2.stream()
//				.collect(Collectors.toMap(Emp2::getName, Emp2::getSalary));
		
//		listToMap.forEach((k,v) -> System.out.println(k+ " : "+v));
		
		
		/*
		* There are other versions of toMap() which is used to convert to LinkedHashMap, ConcurrentHashMap, etc 
		* & to handle collisions(in case of duplicate keys)
		*/

		
		/*
		 * Here in below code "(e1,e2)->e1" is a "merge function" which is used to handle collision in case of duplicate keys
		 * if there is duplicate keys then the above lambda expression or merge function tells how to handle the values for such keys
		 * In below code, in case of duplicate keys(i.e, e1,e2) take value from e1(i.e, -> e1)
		 */
		Map<Integer,String> distinctValueMap = list2.stream()
				.collect(Collectors.toMap(Emp2::getSalary, Emp2::getName, (e1,e2)->e1, LinkedHashMap::new));
		System.out.println("ditinctValueMap :: "+distinctValueMap);
		
//		Map<String, Emp2> linkedHashMap = list2.stream()
//                .collect(Collectors.toMap(
//                        Emp2::getName, // keyMapper
//                        emp -> emp, // valueMapper
//                        (existing, replacement) -> {
//                            // Merge function: Sum up salaries for duplicate keys
//                            existing.setSalary(existing.getSalary()+replacement.getSalary());
//                            return existing;
//                        }, // merge function
//                        LinkedHashMap::new // mapSupplier
//                ));
//		System.out.println("linkedHashMap :: "+linkedHashMap);

		
		/*
		 * Duplicate keys in Map will throw IllegalStateException. To handle duplicate keys we use merge function parameter
		 * in toMap()
		 */
		Map<Integer, String> map = 
				Stream.of("cake", "biscuits", "tart")
				.collect(
						Collectors.toMap(s->s.length(), //1st parameter: key is Integer
								s -> s,					//2nd Paramter : value is String
								(s1,s2)->s1+"|"+s2		//3rd Paramter: Merge Function - what to do if duplicate keys -> concat values
							)
						);
		
		System.out.println("Map : "+map); //{4=cake tart, 8=biscuits}
		
		/*
		 * specify type of Map in 4th paramter
		 */
		Map<String, Integer> tmap = 
				Stream.of("cake", "biscuits", "apple tart", "cake")
				.collect(
						Collectors.toMap(s->s, 
								s->s.length(),					
								(len1,len2)->len1+len2,		
								TreeMap::new			// 4th Parameter : type of Map
							)
						);
		
		System.out.println("TreeMap : "+tmap); //{4=cake tart, 8=biscuits}
		
		
	}
}
