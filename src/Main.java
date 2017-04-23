import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        System.out.println(generateRandomNumbersInRange(10, 20));

        int[] distribution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
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

        int i = 0;
        int targetNumber = 997940;

        long counter = 0;
        long startTime = System.currentTimeMillis();
        while(i < targetNumber) {
            int result = generateRandomNumbersInRange(1, 20);
            counter++;

            for(int k = 0; k < distribution.length; k++) {
                int[] distTracker = distributionContainer.get(result);
                if(distTracker[1] < distTracker[0]) {
                    distTracker[1]++;
                    i++;
                    break;
                }
                break;
            }
        }
        long endTime = System.currentTimeMillis();

        for(int n = 0; n < distribution.length; n++) {
            System.out.println( "Number: " + n + " : " + distributionContainer.get(distribution[n])[1]);
        }
        System.out.println( "Total generations ran: " + counter);
        System.out.println( "Time: " + (endTime - startTime));
    }

    private static int generateRandomNumbersInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
}
