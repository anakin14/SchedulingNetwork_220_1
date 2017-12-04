import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int graphSize = 9;
		Graph graph = new Graph(graphSize);
		Scanner input = new Scanner(System.in);
		System.out.println("Hello, Welcome to our Scheduling Network program.");
		boolean finishInitializing = false;
		int initialVertex = 0;
		int finalVertex = 0;
		int weight = 0;
		while(finishInitializing == false){
			System.out.println("Please enter the initial vertex, terminal vertex and weight of an edge");
			System.out.println("Or type \"999\" when you are finished with entering edges");
			initialVertex = Integer.parseInt(input.next());
			if(initialVertex == 999){
				finishInitializing = true;
				return;
			}
			finalVertex = Integer.parseInt(input.next());
			weight = Integer.parseInt(input.next());
			System.out.println(initialVertex + " " + finalVertex + " " + weight);
			if(initialVertex > 9 && initialVertex < 0){
				finishInitializing = true;
				return;
			}
			else{
				graph.add(initialVertex, finalVertex, weight);
			}
			initialVertex = 0;
			finalVertex = 0;
			weight = 0;
		}
		
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
