package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort 
{
	void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
	// Function to generate random data and write to file
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

  
    // Function to print an array
    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
    	final int NUM_DATASETS = 50;
        final int INITIAL_SIZE = 1000;
        final int INCREMENT = 1000;

        // Generate datasets and run Selection Sort for each dataset
        for (int i = 0; i < NUM_DATASETS; i++) {
            int datasetSize = INITIAL_SIZE + i * INCREMENT;
            String fileName = "SelectionDataSet_" + datasetSize + ".txt";

            try {
                generateAndWriteDataset(datasetSize, fileName);

                // Read dataset from file
                int[] data = readDataFromFile(fileName);
                new SelectionSort().sort(data);

                System.out.println("Selection Dataset Size: " + datasetSize);
                System.out.println("Number of Loop Cycles: " + (data.length - 1)); // Number of passes in Selection Sort
                System.out.println("--------------------------------------");
            } catch (IOException e) {
                System.err.println("Error generating or reading dataset: " + e.getMessage());
            }
        }
    }

    // Function to read integers from a file
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
}
