import java.util.Arrays;

// Gretel Castillo (gcastillo46@toromail.csudh.edu)

public class BubbleSort 
{
	// Variables
	private int[] array;
	private int currentIndex;
	private int loopCount;
	
	// Constructor
	public BubbleSort(int[] inputValue)
	{
		array = new int[inputValue.length];
		
		for(int i = 0; i < inputValue.length; i++)
		{
			array[i] = inputValue[i];
		}
		
		currentIndex = inputValue.length;
				
	}
	
	// will return the array sorted in Ascending order
	public int[] sortAsc()
	{
		int temp = 0;
		loopCount = 0;
		
		for(int i = 0; i < currentIndex; i++)
		{
			for(int j = i + 1; j < currentIndex; j++)
			{
				if(array[j] < array[i])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				
				loopCount++;
			}
		}
		
		return array;
	}
	
	// will return the array sorted in Descending order
	public int[] sortDesc()
	{
		int temp = 0;
		loopCount = 0;
		
		for(int i = 0; i < currentIndex; i++)
		{
			for(int j = i + 1; j < currentIndex; j++)
			{
				if(array[j] > array[i])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				
				loopCount++;
			}
		}
		
		return array;
	}
	
	// How many loop cycles did it take to sort run the previous sort operation
	public int loopCycles()
	{
		return loopCount;
	}
	
	// Experiment with the class to see how the change in input size affects the number of operations
	public static void main(String[] args)
	{
		int[] inputArray = {24, 2, 18, 2019, 54, 17};
		
		BubbleSort bs = new BubbleSort(inputArray);
		
		int[] sortedAsc = bs.sortAsc();
		System.out.println("Sorted in ascending order: " + Arrays.toString(sortedAsc));
		System.out.println("Loop cycles for ascending sort: " + bs.loopCycles());
		
		int[] sortedDesc = bs.sortDesc();
		System.out.println("Sorted in descending order: " + Arrays.toString(sortedDesc));
		System.out.println("Loop cycles for descending sort: " + bs.loopCycles());
	}
}
