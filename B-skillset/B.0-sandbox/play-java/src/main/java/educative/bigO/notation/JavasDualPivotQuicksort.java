package educative.bigO.notation;

import java.util.Random;
import java.util.Arrays;

public class JavasDualPivotQuicksort {

    static int SIZE = 5000;
    static Random random = new Random(System.currentTimeMillis());
    static int[] input = new int[SIZE];

    public static void main(String args[]) {
        createTestData();
        long start = System.currentTimeMillis();
        Arrays.sort(input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken = " + (end - start));
    }

    static void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }
}
