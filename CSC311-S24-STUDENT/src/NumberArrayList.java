// Gretel Castillo (gcastillo46@toromail.csudh.edu)

import java.util.ArrayList;
import java.util.Arrays;

public class NumberArrayList 
{
	// Variables
	private int size;
	private ArrayList<Integer> myList;
		
	// Constructor will take size as a parameter
	public NumberArrayList(int size)
	{
		this.size = size;
		
		this.myList = new ArrayList<>(size);
	}
	
	// this method will return an index or location of the new entry
	public int add(int number)
	{
		if(myList.size() < size)
		{
			myList.add(number);
				
			return myList.size() - 1;
		}
		else
		{
			return -1;
		}
			
	}
		
	// will return number stored at the given location in the NumberArrayList
	public int get(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
			
		return myList.get(index);
	}
		
	// return total number of elements currently in the list
	public int size()
	{
		return myList.size();
			
	}
		
	// will return an array of indices of matching numbers. Will return empty array if no numbers were found
	public int[] find(int number)
	{
		ArrayList<Integer> indices = new ArrayList<>();
			
		for(int i = 0; i < myList.size(); i++)
		{
			if(myList.get(i) == number)
			{
				indices.add(i);
			}
		}
			
		int[] result = new int[indices.size()];
			
		for(int i = 0; i < indices.size(); i++)
		{
			result[i] = indices.get(i);
		}
			
		return result;
	}
		
	// will return the largest number from array, return -1 if no number was found
	public int getLargest()
	{
		// return -1 if no number was found
		if(myList.size() == 0)
		{
			return -1;
		}
			
		int largestNum = myList.get(0);
			
		for(int i : myList)
		{
			if(largestNum < i)
			{
				largestNum = i;
				
			}
		}
			
		return largestNum;
	}
		
	// will return the smallest number from array, return -1 if no number was found
	public int getSmallest()
	{
		// return -1 if no number was found
		if(myList.size() == 0)
		{
			return -1;
		}
			
		int smallestNum = myList.get(0);
			
		for(int i : myList)
		{
			if(smallestNum > i)
			{
				smallestNum = i;
			}
		}
			
		return smallestNum;
	}
		
	// will return the average of all numbers stored in the array, return -1 if there are no numbers in the array
	public int getAverage()
	{
		// return -1 if there are no numbers in array
		if(myList.size() == 0)
		{
			return -1;
		}
			
		int total = 0;
			
		// Enhanced For Loop
		for(int num : myList)
		{
			total += num;
		}
			
		// Calculate Average by getting total and dividing by size in list
		return total / myList.size();
	}
		
	// Number ArrayList should be printable. 
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
			
		// When you print it will simply display a list
		for(int i = 0; i < myList.size(); i++)
		{
			sb.append(myList.get(i));
				
			if(i < myList.size() - 1)
			{
				// display a list of numbers separated by a comma
				sb.append(", ");
			}
		}
			
		return sb.toString();
	}
		
	// Test Code 
	public static void main (String[] args)
	{
		NumberArrayList list = new NumberArrayList(6);
			
		// Add 6 elements to array
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
			
		// Print out
		System.out.println("List: " + list);
		System.out.println("Size: " + list.size());
		System.out.println("Element at index 5: " + list.get(5));
		System.out.println("Indices of 4: " + Arrays.toString(list.find(4)));
		System.out.println("Largest element: " + list.getLargest());
		System.out.println("Smallest element: " + list.getSmallest());
		System.out.println("Average: " + list.getAverage());
	}
}
