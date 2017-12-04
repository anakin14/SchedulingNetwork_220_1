import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(9);
		
		/*
		graph.add(0, 1, 2);
		graph.add(0, 3, 3);
		graph.add(1, 2, 1);
		graph.add(2, 3, 3);
		graph.add(2, 5, 5);
		graph.add(2, 4, 2);
		graph.add(2, 6, 3);
	//	graph.add(5, 4, 4);
		graph.add(5, 6, 1);
		graph.add(5, 7, 1);
		graph.add(6, 7, 4);
		graph.add(4, 7, 3);
		*/
		
		graph.add(0, 8, 99);
		graph.add(8, 9, 100);
		graph.add(0, 2, 1000);
		graph.add(2, 9, 1);
		System.out.println(graph.EarliestArrival(2)+" " );//+ graph.LatestTime(5)+" " +graph.SlackTime(2)+ " " +graph .FloatTime(2, 4));
		System.out.println(graph.Maximum(0, 2));
		
	
		
		
		
		
		
		for(int x = 0; x < 10; x++)
		{
			for(int y = 0; y < 10; y++)
				if(graph.hasEdge(x, y))
				{
				System.out.println(x + "-> " + y + " weight: " + graph.print(x,y));
				}
		}
		boolean done = false;
		int entry;
		System.out.printf("Now that we have the values, enter 1 to calculate\n"
				+ "the earliest arrival time, 2 to calculate the latest time, 3\n"
				+ "to calculate slack time and 4 to calculate float time:"
				+ ".\n");
		Scanner input = new Scanner(System.in);
		while(!done){
			
		try{
			System.out.println("Entry: ");
		entry = input.nextInt();
		
		if (entry>=1 && entry<=4)
		{
			System.out.println("Complete");
			done = true;
		}
		else
			System.out.println("Invalid entry; we're only using integers 1-4");
		}
		catch(InputMismatchException e){
			System.out.println("Was not an integer, try again!");
			input.next();
		}
		

		}
	}

	
}
