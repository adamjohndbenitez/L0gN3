package citi.karat.Zsources;

import java.util.Arrays;
import java.util.Collections;

/**
 * Use this psvm main method driver to test edge cases.
 */
public class EdgeCasesInputsMain {
    public static void main(String[] args) {

        EdgeCasesInputsMain solution = new EdgeCasesInputsMain();
        int[][] inputs = {
                {77, 88}, // edge-case: what if we cannot find a sum?
                {1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}
        };

        int[] k = {99, 5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            // Display inputs:
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);


            // Invoke method:
//            int[] result = solution.twoSumUsingTwoPointers(inputs[i], k[i]);


            // Display outputs:
//            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
