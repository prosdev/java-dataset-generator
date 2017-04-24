import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    /*
        1. Generate a randomized dataset of 997940 numbers (containing values between 1 to 20)
        2. Should contain the following distribution
            1-12    83,000
            13      1,000
            14      500
            15      250
            16      100
            17      50
            18      25
            19      10
            20      5
         3. No two consecutive numbers should be the same in the generated file
         4. Write generated dataset to a text file
         5. On the console, display all lines on which the value 20 appears
     */

    public static void main(String[] args) throws IOException {


        int minBound = 1;
        int maxBound = 20;

        //        int[] distribution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] distribution = generateDistributionArray(minBound, maxBound);

        HashMap<Integer, int[]> distributionContainer = new HashMap<>();

        distributionContainer.put(distribution[0], new int[] {83000, 0});
        distributionContainer.put(distribution[1], new int[] {83000, 0});
        distributionContainer.put(distribution[2], new int[] {83000, 0});
        distributionContainer.put(distribution[3], new int[] {83000, 0});
        distributionContainer.put(distribution[4], new int[] {83000, 0});
        distributionContainer.put(distribution[5], new int[] {83000, 0});
        distributionContainer.put(distribution[6], new int[] {83000, 0});
        distributionContainer.put(distribution[7], new int[] {83000, 0});
        distributionContainer.put(distribution[8], new int[] {83000, 0});
        distributionContainer.put(distribution[9], new int[] {83000, 0});
        distributionContainer.put(distribution[10], new int[] {83000, 0});
        distributionContainer.put(distribution[11], new int[] {83000, 0});
        distributionContainer.put(distribution[12], new int[] {1000, 0});
        distributionContainer.put(distribution[13], new int[] {500, 0});
        distributionContainer.put(distribution[14], new int[] {250, 0});
        distributionContainer.put(distribution[15], new int[] {100, 0});
        distributionContainer.put(distribution[16], new int[] {50, 0});
        distributionContainer.put(distribution[17], new int[] {25, 0});
        distributionContainer.put(distribution[18], new int[] {10, 0});
        distributionContainer.put(distribution[19], new int[] {5, 0});

        ArrayList<Integer> placeholder = generateDistributionValues(distribution, distributionContainer);

        writeValuesToFile(placeholder);

    }

    private static int[] generateDistributionArray(int minBound, int maxBound) {
        int[] distributionPlaceholder = new int[maxBound];
        for(int i = minBound-1; i < maxBound; i++) {
            distributionPlaceholder[i] = i+ 1;
        }
        System.out.println(distributionPlaceholder[0]);
        return distributionPlaceholder;
    }

    private static ArrayList<Integer> generateDistributionValues(int[] distribution, HashMap<Integer, int[]> distributionContainer) {
        ArrayList<Integer> placeholder = new ArrayList<>();

        int i = 0;
        int targetNumber = 997940;

        long counter = 0;
        long startTime = System.currentTimeMillis();
        int previousResult = 0;
        int consecutiveNumCount = 0;


        while(i < targetNumber) {
            counter++;

            int result = generateRandomNumbersInRange(1, 20);
            if(result == previousResult) {
                consecutiveNumCount++;
                continue; // skip to top of while loop
            } else {
                previousResult = result;
            }

            //Compare the current value held in distribution to desired distribution
            for(int k = 0; k < distribution.length; k++) {
                int[] distTracker = distributionContainer.get(result);
                if(distTracker[1] < distTracker[0]) {
                    distTracker[1]++;
                    placeholder.add(result);

                    //Print out the line in which 20 appears
                    if(result == 20) {
                        System.out.println("Line: " + i + " : " + result);
                    }
                    i++;
                }
                break;
            }
        }

        long endTime = System.currentTimeMillis();

        for(int n = 0; n < distribution.length; n++) {
            System.out.println( "Distribution at number " + (n+1) + " : " + distributionContainer.get(distribution[n])[1]);
        }

        System.out.println( "Total generations ran: " + counter);
        System.out.println( "Total consecutiveNumCount: " + consecutiveNumCount);
        System.out.println( "Time: " + (endTime - startTime));
        return placeholder;
    }

    private static void writeValuesToFile(ArrayList<Integer> placeholder) {
        final String FILENAME = "test.output.txt";

        //Can use BufferedWriter, PrintWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            System.out.println("Start writing...");

            for (int number: placeholder) {
                bw.write(String.valueOf(number));
                bw.newLine();
            }

            System.out.println("Done writing!");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static int generateRandomNumbersInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

}
