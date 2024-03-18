package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CocktailSort 
{
	private int loopCycles = 0;

    // Cocktail Sort implementation
    void cocktailSort(int a[]) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                loopCycles++;
            }

            if (!swapped)
                break;

            swapped = false;
            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                loopCycles++;
            }

            start = start + 1;
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
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Function to read integers from a file
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
    	


    public static void main(String args[]) {
        final int NUM_DATASETS = 50;
        final int INITIAL_SIZE = 1000;
        final int INCREMENT = 1000;

        // Generate datasets and run Cocktail Sort for each dataset
        for (int i = 0; i < NUM_DATASETS; i++) {
            int datasetSize = INITIAL_SIZE + i * INCREMENT;
            String fileName = "CocktailDataSet_" + datasetSize + ".txt";

            try {
                generateAndWriteDataset(datasetSize, fileName);

                // Read dataset from file
                int[] data = readDataFromFile(fileName);

                // Perform Cocktail Sort
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(data);

                System.out.println("Cocktail Dataset Size: " + datasetSize);
                System.out.println("Number of Loop Cycles: " + cocktailSort.loopCycles);
                System.out.println("--------------------------------------");
            } catch (IOException e) {
                System.err.println("Error generating or reading dataset: " + e.getMessage());
            }
        }
    }
}
