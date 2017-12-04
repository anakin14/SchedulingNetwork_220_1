import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(9);
		
		
		graph.add(5, 6, 9);
		graph.add(6, 7, 8);
		graph.add(0, 1, 1);
		graph.add(5, 5, 9);
		graph.add(2, 3, 9);
		graph.add(6, 7, 9);
		graph.add(8, 1, 9);
		
		
		
		
		
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
