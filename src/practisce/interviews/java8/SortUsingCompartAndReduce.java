package practisce.interviews.java8;

import static java.util.stream.Collectors.collectingAndThen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SortUsingCompartAndReduce {

	public static void main(String[] args) {
		
		// Q1. Sort Employee by its Age :
		// Get Employee having minimum age : 
		
		Employee_ e1 = new Employee_("Dikesh", 39);
		Employee_ e2 = new Employee_("Ram", 20);
		Employee_ e3 = new Employee_("Santosh", 31);
		Employee_ e4 = new Employee_("Alex", 50);
		
		List<Employee_> empList = new ArrayList<>();
		
		empList.add(e1);
		empList.add(e2);
		empList.add(null);
		empList.add(e3);
		empList.add(e4);
		//empList = null;
		
		
		System.out.println("Before sorting : "+empList);
		
		List<Employee_> sortedEmpList = new ArrayList<>();
		
		/*
		 * solution 1.1
		 */
		Comparator<Employee_> compEmp =  Comparator.nullsLast(Comparator.comparing(Employee_::getAge));		
		empList.sort(compEmp);
		System.out.println("1.1 : After sorting : "+empList);
		
		/*
		 * solution 1.2
		 */
		Optional<List<Employee_>> nullCheck = Optional.ofNullable(empList);
		if(nullCheck.isPresent()) {
			System.out.println("Soln 1.2 : ");
			empList.stream().filter(emp ->emp !=null).sorted((d1,d2)->d1.getAge()-d2.getAge()).limit(1)
			.forEach(e->System.out.println(e.getAge()));
		}
		
		/*
		 * solution 1.3
		 */
		sortedEmpList = empList.stream().filter(emp -> emp!=null).sorted(compEmp).limit(1).collect(Collectors.toList());
		System.out.println("Soln 1.3 : "+sortedEmpList);
		
		Employee_ minEmp = empList.stream().filter(emp -> emp!=null).sorted(compEmp).limit(1).collect(Collectors.toList()).get(0);
		System.out.println("Sol.3: Fetch Emp obj: "+minEmp);
		
		/*
		 * solution 1.4
		 */
		Optional<Employee_> minAgeEmployee = empList.stream()
				.filter(emp->emp!=null)
				.reduce((e11,e22) -> e11.getAge()<e22.getAge()?e11:e22);
		
		if(minAgeEmployee.isPresent())
			System.out.println("Soln 1.4: Employee with min age: "+minAgeEmployee.get());
				
		
		/*
		 * =================================================================================================================
		 */
		//Q2. Sort Map by its value : 
		
		Map<String, Integer> map = new HashMap();
		map.put("Dikesh", 550000);
		map.put("C", 15000);
		map.put("B", 15000);
		map.put("A", 35300);
		map.put("A", 35300);
		
		/*
		 * Sol 2.1 : Using Streams
		 */
		Map<String,Integer> sortedByValue = map.entrySet().stream()
				.sorted((v1,v2) -> v1.getValue().compareTo(v2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e,s)-> e, LinkedHashMap::new));
		
		System.out.println("2.1: sorting map by values : "+sortedByValue);
		
		
		/*
		 * Sol 2.2 : Using Lambdas 
		 */
		
		List<Map.Entry<String,Integer>> alm = new LinkedList<>(map.entrySet());
		
		Collections.sort(alm, (v1,v2) -> v1.getValue().compareTo(v2.getValue()));
		
		Map<String, Integer> sortedMap2 = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> kv : alm) {
			sortedMap2.put(kv.getKey(), kv.getValue());
		}
		
		System.out.println("2.2 : sort map using Lambda : "+sortedMap2);
		
		/*
		 *  Q3. Find 2nd Highest salary using Map
		 */

		List<Emp2> list = new ArrayList<>();
				list.add(new Emp2("Dikesh", 250000));
				list.add(new Emp2("A", 25000));
				list.add(new Emp2("B", 2000));
				list.add(new Emp2("C", 45300));
				
		/*
		 * Solution 3.1
		 */
		Emp2 secondHighestEmp = list.stream()
				.sorted(Comparator.comparing(Emp2::getSalary).reversed())
				.collect(Collectors.toList())
				.get(1); //index based so 2nd highest is at index 1
		
		System.out.println("3.1 : Emp with 2nd highest salary : "+secondHighestEmp);
		
		/*
		 * SOlution 3.2
		 */
		
		Emp2 secondHighestEmp2 = list.stream()
				.sorted(Comparator.comparing(Emp2::getSalary).reversed())
				.limit(2)
				.skip(1)
				.collect(Collectors.toList())
				.get(0);
		
		System.out.println("3.2 : Emp with 2nd highest salary : "+secondHighestEmp2);
		
		/*
		 * 4. Convert List to Map 	
		 */

		List<Emp2> list2 = new ArrayList<>();
			list2.add(new Emp2("Dikesh", 250000));
			list2.add(new Emp2("A", 25000));
			list2.add(new Emp2("B", 2000));
			list2.add(new Emp2("C", 45300));
			
		Map<String, Integer> listToMap = list.stream()
				.collect(Collectors.toMap(Emp2::getName, Emp2::getSalary));
		
		listToMap.forEach((k,v) -> System.out.println(k+ " : "+v));
		
		System.out.println("List to Map : "+listToMap);
		
		/*
		 * 5. Get distinct value by key from map
		 */

		List<Emp2> list3 = new ArrayList<>();
			list3.add(new Emp2("Dikesh", 250000));
			list3.add(new Emp2("C", 25000));
			list3.add(new Emp2("B", 25000));
			list3.add(new Emp2("A", 45300));
			list3.add(new Emp2("A", 45300));
			
		/*
		 * Sol. 5.1 : Fetching Emp data as per distinct Salary
		 */
			
		List<Emp2> finalDistnictValueList = new ArrayList<>();
			
		list3.stream()
				.collect(Collectors.toMap(Emp2::getSalary, Emp2::getName, (e11,e22)->e11, LinkedHashMap::new))
				.entrySet()
				.forEach(e -> finalDistnictValueList.add(new Emp2(e.getValue(),e.getKey())));
		
//		distinctValueMap.entrySet().stream()
//		.forEach(e -> finalDistnictValueList.add(new Emp2(e.getValue(),e.getKey())));
		
		System.out.println("orig List : "+list3);
		System.out.println("finalDistnictValueList : "+finalDistnictValueList);
		
		List<Map.Entry<Integer, String>> distinctValueMapList = list3.stream()
				.collect(Collectors.toMap(Emp2::getSalary, Emp2::getName, (e11,e22)->e11, LinkedHashMap::new))
				.entrySet()
				.stream()
				.collect(Collectors.toList());
		
		System.out.println("distinctValueMapList : "+distinctValueMapList);
		
		
		/*
		 * Here in below code "(e11,e22)->e11" is a "merge function" which is used to handle collision in case of duplicate keys
		 * if there is duplicate keys then the above lambda expression or merge function tells how to handle the values for such keys
		 * in below code, in case of duplicate keys(e11,e22) take value from e11(-> e11)
		 */
		Map<Integer,String> distinctValueMap = list3.stream()
				.collect(Collectors.toMap(Emp2::getSalary, Emp2::getName, (e11,e22)->e11, LinkedHashMap::new));
		
		
		System.out.println(distinctValueMap);
		
		
		
	}

}
