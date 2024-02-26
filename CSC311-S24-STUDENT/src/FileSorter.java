// Gretel Castillo (gcastillo46@toromail.csudh.edu)

import java.util.Scanner;
import java.io.IOException;

public class FileSorter 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		// Ask the user to provide name of a file.
		System.out.println("Please enter the name of the input file: ");
		String inputFileName  = keyboard.nextLine();
		
		System.out.println("Please enter the name of the output file");
		String outputFileName = keyboard.nextLine();
		
		// Read the file using your File Reader class
		NumberFileReader fileReader = new NumberFileReader(inputFileName);
		
		// Sort the content of your file using Bubble Sort class
		BubbleSort sort = null;
		
		// Write the results to output using your File Writer class
		NumberFileWriter fileWriter = new NumberFileWriter(outputFileName);
		
		try
		{
			int[] numbers = fileReader.read();
		
			sort = new BubbleSort(numbers);
			
			int[] sortedNumbers = sort.sortAsc();
			
			fileWriter.write(sortedNumbers);
			
			System.out.println("Sorted and Wrote to file.");
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			keyboard.close();
		}
	}
}
