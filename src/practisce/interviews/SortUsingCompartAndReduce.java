package practisce.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SortUsingCompartAndReduce {

	public static void main(String[] args) {
		
		// Q1. Sort Employee by its Age :
		// Get Employee having minimum age : 
		
		Employee e1 = new Employee("Dikesh", 39);
		Employee e2 = new Employee("Ram", 20);
		Employee e3 = new Employee("Santosh", 31);
		Employee e4 = new Employee("Alex", 50);
		
		List<Employee> empList = new ArrayList<>();
		
		empList.add(e1);
		empList.add(e2);
		empList.add(null);
		empList.add(e3);
		empList.add(e4);
		//empList = null;
		
		
		System.out.println("Before sorting : "+empList);
		
		List<Employee> sortedEmp = new ArrayList<>();
		
		/*
		 * solution 1
		 */
		Comparator<Employee> compEmp =  Comparator.nullsLast(Comparator.comparing(Employee::getAge));		
		empList.sort(compEmp);
		
		/*
		 * solution 2
		 */
//		Optional<List<Employee>> nullCheck = Optional.ofNullable(empList);
//		if(nullCheck.isPresent()) {
//			empList.stream().filter(emp ->emp !=null).sorted((d1,d2)->d1.getAge()-d2.getAge()).limit(1)
//			.forEach(e->System.out.println(e.getAge()));
//		}
		
		/*
		 * solution 3
		 */
		sortedEmp = empList.stream().filter(emp -> emp!=null).sorted(compEmp).limit(1).collect(Collectors.toList());
		
		/*
		 * solution 4
		 */
		Optional<Employee> minAgeEmployee = empList.stream()
				.filter(emp->emp!=null)
				.reduce((e11,e22) -> e11.getAge()<e22.getAge()?e11:e22);
		
		if(minAgeEmployee.isPresent())
			System.out.println("Employee with min age: "+minAgeEmployee.get());
		
		
		
		System.out.println("After sorting : "+empList);
		
		/*
		 * =================================================================================================================
		 */
		//Q2. Sort Map by its value : 
		
		Map<String, Integer> map = new HashMap();
		map.put("Dikesh", 250000);
		map.put("C", 25000);
		map.put("B", 25000);
		map.put("A", 45300);
		map.put("A", 45300);
		
//		Map<String,Integer> sortedByValue = map.entrySet().stream()
//				.filter(e -> e.getValue() != null)
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue), Collectors.minBy(Comparator.comparing(Map.Entry::getValue)));
		
	}

}
