//Gretel Castillo (gcastillo46@toromail.csudh.edu)

import java.util.ArrayList;
import java.util.Arrays;

public class UnlimitedNumberArrayList 
{
	// Variables
	// private int size;
	private ArrayList<Integer> myList;
			
	// Constructor will NOT take size as a parameter
	public UnlimitedNumberArrayList()
	{
		//this.size = size;
				
		this.myList = new ArrayList<>();
	}
			
	// this method will return an index or location of the new entry
	public int add(int number)
	{
		// if(myList.size() < size)
		// {
			// myList.add(number);
					
			// return myList.size() - 1;
		// }
		// else
		// {
			// return -1;
		// }
				
		myList.add(number);
				
		return myList.size() - 1;
				
	}
			
	// will return number stored at the given location in the NumberArrayList
	public int get(int index)
	{
		if (index < 0 || index >= myList.size())
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
		UnlimitedNumberArrayList list = new UnlimitedNumberArrayList();
				
		// Add elements to array
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(12);
		list.add(14);
		list.add(16);
		list.add(18);
		list.add(20);
		list.add(22);
		list.add(24);
		list.add(26);
		list.add(28);
		list.add(30);
		list.add(32);
		list.add(34);
		list.add(36);
		list.add(38);
		list.add(40);
		list.add(42);
		list.add(44);
		list.add(46);
		
		// Print Out
		System.out.println("List: " + list);
		System.out.println("Size: " + list.size());
		System.out.println("Element at index 15: " + list.get(15));
		System.out.println("Indices of 4: " + Arrays.toString(list.find(4)));
		System.out.println("Largest element: " + list.getLargest());
		System.out.println("Smallest element: " + list.getSmallest());
		System.out.println("Average: " + list.getAverage());
		
	}
}
