// Gretel Castillo (gcastillo46@toromail.csudh.edu)

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class NumberFileReader 
{
	// Variables
	private String fileName;
	
	// Constructor will take file name as argument
	public NumberFileReader(String fileName)
	{
		this.fileName = fileName;
	}
	
	// will return the array of numbers read from this file
	public int[] read() throws IOException
	{
		List<Integer> integerList = new ArrayList<>();
		
		StringBuilder number = new StringBuilder();
		
		try(FileReader fileReader = new FileReader(fileName))
		{
			int character;
			
			while ((character = fileReader.read()) != -1)
			{
				if(Character.isDigit((char) character) || character == '-')
				{
					number.append((char) character);
				}
				else
				{
					if (number.length() > 0)
					{
						try
						{
							int parsedNumber = Integer.parseInt(number.toString());
							
							integerList.add(parsedNumber);
						}
						catch (NumberFormatException e)
						{
							System.out.println("Skipping invalid integer: " + number);
						}
						
						number.setLength(0);
					}
				}
			}
			
			if (number.length() > 0)
			{
				try
				{
					int parsedNumber = Integer.parseInt(number.toString());
					
					integerList.add(parsedNumber);
				}
				catch (NumberFormatException e)
				{
					System.out.println("Skipping invalid integer: " + number);
				}
			}
		}
		
		int[] numbersArray = new int[integerList.size()];
		
		for (int i = 0; i < integerList.size(); i++)
		{
			numbersArray[i] = integerList.get(i);
		}
		
		return numbersArray;
		
	}
	
	// Experiment by creating a main method
	public static void main(String[] args)
	{
		// My code doesnt have to include the .txt to the end of file name but it still works
		String fileName = "numberFile";
		
		NumberFileReader reader = new NumberFileReader(fileName);
		
		try
		{
			int[] numbers = reader.read();
			
			for(int number : numbers)
			{
				System.out.println(number);
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
	}
}
