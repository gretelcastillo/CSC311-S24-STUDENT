package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MergeSort 
{
	private int loopCycles = 0;

	 // Merges two subarrays of arr[].
	 // First subarray is arr[l..m]
	 // Second subarray is arr[m+1..r]
	 void merge(int arr[], int l, int m, int r)
	 {
	     // Find sizes of two subarrays to be merged
	     int n1 = m - l + 1;
	     int n2 = r - m;

	     // Create temp arrays
	     int L[] = new int[n1];
	     int R[] = new int[n2];

	     // Copy data to temp arrays
	     for (int i = 0; i < n1; ++i)
	         L[i] = arr[l + i];
	     for (int j = 0; j < n2; ++j)
	         R[j] = arr[m + 1 + j];

	     // Merge the temp arrays

	     // Initial indices of first and second subarrays
	     int i = 0, j = 0;

	     // Initial index of merged subarray array
	     int k = l;
	     while (i < n1 && j < n2) {
	         if (L[i] <= R[j]) {
	             arr[k] = L[i];
	             i++;
	         }
	         else {
	             arr[k] = R[j];
	             j++;
	         }
	         k++;
	         
	         //loopCycles++;
	     }

	     // Copy remaining elements of L[] if any
	     while (i < n1) {
	         arr[k] = L[i];
	         i++;
	         k++;
	         //loopCycles++;
	     }

	     // Copy remaining elements of R[] if any
	     while (j < n2) {
	         arr[k] = R[j];
	         j++;
	         k++;
	         //oopCycles++;
	     }
	     
	     loopCycles += n1 + n2;
	 }

	 // Main function that sorts arr[l..r] using
	 // merge()
	 void sort(int arr[], int l, int r)
	 {
	     if (l < r) {

	         // Find the middle point
	         int m = l + (r - l) / 2;

	         // Sort first and second halves
	         sort(arr, l, m);
	         sort(arr, m + 1, r);

	         // Merge the sorted halves
	         merge(arr, l, m, r);
	     }
	 }

	 // A utility function to print array of size n
	 //static void printArray(int arr[])
	 //{
	     //int n = arr.length;
	     //for (int i = 0; i < n; ++i)
	         //System.out.print(arr[i] + " ");
	     //System.out.println();
	 //}
	 
	//Function to generate random data and write to file
	 static void generateAndWriteDataset(int size, String fileName) throws IOException {
	     Random random = new Random();
	     FileWriter writer = new FileWriter(fileName);
	     for (int i = 0; i < size; i++) {
	         writer.write(Integer.toString(random.nextInt()));
	         if (i != size - 1) {
	             writer.write(" ");
	         }
	     }
	     writer.close();
	 }

	//Function to read integers from a file
	 static int[] readDataFromFile(String fileName) throws IOException {
		 Scanner scanner = new Scanner(new File(fileName));
	     StringBuilder dataString = new StringBuilder();
	     while (scanner.hasNext()) {
	         dataString.append(scanner.next()).append(" ");
	     }
	     scanner.close();
	     String[] dataArray = dataString.toString().split(" ");
	     int[] data = new int[dataArray.length];
	     for (int i = 0; i < dataArray.length; i++) {
	         data[i] = Integer.parseInt(dataArray[i]);
	     }
	     return data;
	 }
	 
	 // Driver code
	 public static void main(String args[])
	 {
		 final int NUM_DATASETS = 50;
	     final int INITIAL_SIZE = 1000;
	     final int INCREMENT = 1000;

	     // Generate datasets and run Merge Sort for each dataset
	     for (int i = 0; i < NUM_DATASETS; i++) {
	         int datasetSize = INITIAL_SIZE + i * INCREMENT;
	         String fileName = "MergeDataSet_" + datasetSize + ".txt";

	         try {
	             generateAndWriteDataset(datasetSize, fileName);

	             // Read dataset from file
	             int[] data = readDataFromFile(fileName);

	             // Measure sorting time
	             //long startTime = System.nanoTime();
	             MergeSort mergeSort = new MergeSort();
	             mergeSort.sort(data, 0, data.length - 1);
	             //long endTime = System.nanoTime();
	             //long elapsedTime = endTime - startTime;

	             System.out.println("Merge Dataset Size: " + datasetSize);
	             System.out.println("Number of Loop Cycles: " + mergeSort.loopCycles);
	             //System.out.println("Time taken (in nanoseconds): " + elapsedTime);
	             System.out.println("--------------------------------------");
	         } catch (IOException e) {
	             System.err.println("Error generating or reading dataset: " + e.getMessage());
	         }
	     }
	 }
	


}
