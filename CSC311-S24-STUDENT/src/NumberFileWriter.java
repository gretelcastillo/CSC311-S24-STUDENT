// Gretel Castillo (gcastillo462toromail.csudh.edu)

import java.io.*;

public class NumberFileWriter 
{
	// Same Variables and Constructor as NumberFileReader
	
	// Variables
	private String fileName;
		
	// Constructor will take file name as argument
	public NumberFileWriter(String fileName)
	{
		this.fileName = fileName;
	}
	
	// will write content of the array to a file, one value per line
	public void write(int[] arrayOfNumbers)
	{
		FileWriter writer = null;
		
		try
		{
			writer = new FileWriter(fileName);
			
			for(int number : arrayOfNumbers)
			{
				writer.write(Integer.toString(number));
				writer.write('\n');
			}
			
			// Added a line of code to ensure the user knows whether writing file was successful
			System.out.println("File Writing was successful.");
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file: " + e.getMessage());
		}
		finally 
		{
			if(writer != null)
			{
				try 
				{
					writer.close();
				}
				catch(IOException e)
				{
					System.out.println("Error closing file writer: " + e.getMessage());
				}
				
				
			}
		}
	}
	
	//Experiment by creating main method
	public static void main(String[] args)
	{
		// Changed it by adding String variable that holds the file name
		// My code doesnt have to include the .txt to the end of file name but it still works
		String fileName = "numberFileOut";
		
		NumberFileWriter fw = new NumberFileWriter(fileName);
		
		int[] numbers = {10,20,30,40,50};
		
		fw.write(numbers);
	}
}
