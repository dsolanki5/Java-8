package streamsTerminal;

import java.util.stream.Collectors;

import data.StudentDataBase;

public class StreamsCountingExample {
	
	public static long getBasketBallPlayersCount() {
		
		return StudentDataBase.getAllStudents().stream()
				.filter(stud -> stud.getActivities().contains("basketball"))
				.collect(Collectors.counting());
	}
	
	public static void main(String[] args) {
		System.out.println("No of students playing BasketBall : "+getBasketBallPlayersCount());
	}

}
