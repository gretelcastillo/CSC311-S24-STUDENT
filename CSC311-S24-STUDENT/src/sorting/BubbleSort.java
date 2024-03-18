package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort 
{
	// An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
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

    public static void main(String args[]) {
        final int NUM_DATASETS = 50;
        final int INITIAL_SIZE = 1000;
        final int INCREMENT = 1000;

        // Generate datasets and run Bubble Sort for each dataset
        for (int i = 0; i < NUM_DATASETS; i++) {
            int datasetSize = INITIAL_SIZE + i * INCREMENT;
            String fileName = "BubbleDataSet_" + datasetSize + ".txt";

            try {
                generateAndWriteDataset(datasetSize, fileName);

                // Read dataset from file
                int[] data = readDataFromFile(fileName);

                bubbleSort(data, data.length);

                System.out.println("Bubble Dataset Size: " + datasetSize);
                System.out.println("Number of Loop Cycles: " + (data.length - 1)); // Number of passes in Bubble Sort
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
