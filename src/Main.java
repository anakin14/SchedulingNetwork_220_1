/**
 * Scheduling Network
 * @author Anakin  Kinsey, Ofo Croes, Jonathan Hubbard
 * 
 * 
 * References:
 * 	http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/11-Graph/weighted.html
 */
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	/**
	 * Main method, used to enter values to scheduling network and to
	 * show the menu of calculations
	 * @param args
	 */
	public static void main(String[] args) {
		boolean done = false, exit = false;
		int entry;
		int graphSize = 9;
		int numVertices = 0;
		Graph graph = new Graph(graphSize);
		Scanner input = new Scanner(System.in);
		//here's where menu acquires input to be sent to scheduling network
		System.out.println("Hello, Welcome to our Scheduling Network program.");
		boolean finishInitializing = false;
		int initialVertex = 0;
		int finalVertex = 0;
		int weight = 0;
		System.out.println("Please enter the initial vertex, terminal vertex and weight of an edge");
		System.out.println("Or type \"999\" when you are finished with entering edges");
		while(finishInitializing == false){
			
			initialVertex = Integer.parseInt(input.next());
			if(initialVertex == 999)
				finishInitializing = true;
			else
			{
			if(numVertices < 10)
			{
			finalVertex = Integer.parseInt(input.next());
			weight = Integer.parseInt(input.next());
			System.out.println(initialVertex + "-> " + finalVertex + " weight: " + weight);
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
			else
				finishInitializing = true;
			}
		}

		

		//test values

		//graph.add(0, 1, 25);
		//graph.add(0, 2, 50);
		//graph.add(0, 3, 20);
		//graph.add(1, 2, 25);
		//graph.add(1, 4, 20);
		//graph.add(1, 6, 55);
		//graph.add(2, 4, 10);
		//graph.add(2, 5, 15);
		//graph.add(2, 7, 30);
		//graph.add(3, 2, 35);
		//graph.add(3, 5, 20);
		//graph.add(3, 8, 50);
		//graph.add(4, 6, 30);
		//graph.add(4, 7, 35);
		//graph.add(5, 7, 40);
		//graph.add(5, 8, 20);
		//graph.add(6, 9, 25);
		//graph.add(7, 6, 25);
		//graph.add(7, 8, 35);
		//graph.add(7, 9, 45);
		//graph.add(8, 9, 10);
	
		
		while(!exit){
		done = false;
		//here's where the menu for calculations for the scheduling network can be found
		try{
			System.out.printf("Please enter 1 to calculate the earliest arrival time,\n"
					+ "2 to calculate the latest time, 3\n"
					+ "to calculate slack time and 4 to calculate float time:"
					+ ".\n");
			System.out.println("Entry: ");
		entry = input.nextInt();
		{
		if (entry>=1 && entry<=4)
		{
			System.out.println("For what Value?");
			while(!done)
			{
				System.out.println("Value: ");
				int value = input.nextInt(), value2 = 0;
				if(value > 9 || value < 0)
					System.out.println("Not valid value!");
				else
				{
					if(entry == 4)
					{
						System.out.println("Float time needs another value to calculate for!\n" +"Value: ");
					while(!done)
					{
						value2 = input.nextInt();
						if(value > 9 || value < 0)
							System.out.println("Not valid value!");
						else
							done = true;
					}
					}
					if(entry == 1)
						System.out.println("Earliest Arrival time(" + value+ ") = " + graph.EarliestArrival(value));
					if(entry == 2)
						System.out.println("Latest Time(" + value+ ") = " + graph.LatestTime(value));
					if(entry == 3)
						System.out.println("Slack Time(" + value+ ") = " + graph.SlackTime(value));
					if(entry == 4)
						if(graph.hasEdge(value, value2) == true)
						{
						System.out.println("Float Time(" + value+ ", " + value2 + ") = " + graph.FloatTime(value, value2));
						}
						else
							System.out.println("Can't compute a float of those 2 values");
					System.out.println("Compute another value, press y or n to exit");
					
					if(input.next().charAt(0) == 'n')
					{
						System.out.println("Thank you for using our program!");
						exit = true;
					}
			
				}
			done = true;

			
			}
			}
		
		else
			System.out.println("Invalid entry; we're only using integers 1-4");
		}
		}
		catch(InputMismatchException e){
			System.out.println("Was not an integer, try again!");
			input.next();
		}
		

		}
		
	}
}

	


