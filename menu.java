import java.util.InputMismatchException;
import java.util.Scanner;
public class menu {

	public static void main(String[] args) {
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
