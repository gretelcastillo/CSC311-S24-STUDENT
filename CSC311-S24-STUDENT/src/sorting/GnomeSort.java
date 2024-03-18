package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GnomeSort 
{
	static void gnomeSort(int arr[], int n) {
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

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

        for (int i = 0; i < NUM_DATASETS; i++) {
            int datasetSize = INITIAL_SIZE + i * INCREMENT;
            String fileName = "GnomeDataSet_" + datasetSize + ".txt";

            try {
                generateAndWriteDataset(datasetSize, fileName);

                int[] data = readDataFromFile(fileName);

                gnomeSort(data, data.length);

                System.out.println("Gnome Dataset Size: " + datasetSize);
                System.out.println("Number of Loop Cycles: " + (data.length - 1));
                System.out.println("--------------------------------------");
            } catch (IOException e) {
                System.err.println("Error generating or reading dataset: " + e.getMessage());
            }
        }
    }


}
