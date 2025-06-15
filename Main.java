
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        int initialSeed = 42;
        int minVal = -10;
        int maxVal = 10;
        
        long startTime = System.currentTimeMillis();
        double result = totalMaxSubarraySum(n, initialSeed, minVal, maxVal);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Total Maximum Subarray Sum (20 runs): " + result);
        System.out.println("Execution Time: " + ((endTime - startTime) / 1000.0) + " seconds");
    }
    
    public static double totalMaxSubarraySum(int n, int initialSeed, int minVal, int maxVal) {
        Random random = new Random(initialSeed);
        long[] randomNumbers = new long[n];
        
        for (int i = 0; i < n; i++) {
            randomNumbers[i] = random.nextInt(maxVal - minVal + 1) + minVal;
        }
        
        double totalSum = 0.0;
        int currentSum = 0;
        
        for (long number : randomNumbers) {
            currentSum += number;
            if (currentSum > totalSum) {
                totalSum = currentSum;
            }
        }
        
        return totalSum;
    }
}