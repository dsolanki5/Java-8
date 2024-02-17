package practisce.interviews.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * Immutable class Demo
 * @author deepak.solanki
 *
 */
final class A1{
	private final int empId;
	private final String empName;
	private final Map<String, Integer> subMarks;
	
	public A1(int empId, String empName, Map<String, Integer> subMarks) {
		this.empId = empId;
		this.empName = empName;
//		this.subMarks = subMarks;
		
		Map<String, Integer> tempSubMarks = new HashMap<>();
		
		for(Map.Entry<String,Integer> entry : subMarks.entrySet()) {
			tempSubMarks.put(entry.getKey(), entry.getValue());
		}
		
		this.subMarks = tempSubMarks;
	}
	
	public int getEmpId() {
		return this.empId;
	}
	
	public String getEmpName() {
		return this.empName;
	}
	
	public Map<String, Integer> getSubMarks() {
		Map<String, Integer> tempSubMarksMap = new HashMap<>();
		for(Map.Entry<String, Integer> temp : subMarks.entrySet()) {
			tempSubMarksMap.put(temp.getKey(), temp.getValue());
		}
		return tempSubMarksMap;
//		return this.subMarks;
	}

	@Override
	public String toString() {
		return "A1 [empId=" + empId + ", empName=" + empName + ", subMarks=" + subMarks + "]";
	}
	
	
}



public class Tester {

	public static void main(String[] args) {
		
		Map<String, Integer> stud1 = new HashMap<>();
		stud1.put("Deepak", 80);
		stud1.put("Manish", 90);
		
		Map<String, Integer> stud2 = new HashMap<>();
		stud2.put("Jeeni", 85);
		stud2.put("Arnik", 95);
		
		A1 a1 = new A1(101, "Deepak", stud1);
		A1 a2 = new A1(102, "Jeeni", stud2);
		
		System.out.println("a1:: "+a1);
		System.out.println("a2:: "+a2);
		
		stud1.put("Suraj", 70);
		System.out.println("a1:: "+a1);
		System.out.println(a1.getSubMarks());
	}

}
