package amazon.sdeii.q2.aj;

import java.util.ArrayList;
import java.util.List;

public class CodeQuestion2SolutionAJ3 {

    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        // (1) Binary Search
        // -DATA-
        // left = start at 1, right = size_Of_processing_Power, answer = 0 by default

        // -PSEUDOCODE-
        // loop from left to right:
            // find the mid = left + (right - left) / 2;
            // satisfy the condition: can we form a cluster given the arguments and the mid (ie. a check method).
                // once condition is satisfied, returning answer is the mid, replacing the 0 answer.
                // advancing left pointer by adding +1 to the mid as our left pointer.
            // condition is unsatisfy:
                // if not satisfied, deducting the right pointer by -1 to the mid.

         // return answer;

        return 0;
    }

    private static boolean canFormCluster(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax,
            int k
    ) {
        // what we need to solve is the calculation: max(bootingPower in the cluster) + (sum(processingPower in the cluster)) * k

        // -DATA-
        // processingSum must be long since the constraint is large 10^14 100trillion;
        // Monotonic Deque

        // (2) Monotonic Deque helps to get the max while sliding the window.
        // for-loop: iterate index from 0 to the size of processingPower by +1
            // [part 1] "The adding of processingSum"
            // we add processingSum for every current processingPower

            // [part 2] "Cleanup of the smaller values"
            // inner while-loop: guard defensive condition (deque of Indices should not be empty) AND gate acceptance condition (the current processor's booting power is greater than or equal to the booting power of the processor at the back of the deque)
                // remove that back processor from the deque.
            // inner while-loop ends

            // [part 3] "The current index in Deque"
            // adds the current index iteration in deque of indices

            // [part 4] "The Elimination of outbound processingPower"
            // the window has grown past size k, so remove the old left element
            // k is a sliding window size, when i is more that k that means i exceeds the k so mathematically speaking i - k means index is leaving the window so deduction to that value where it is at the leaving index i on size k where it is at the front of deque.
            // in this if block, we are concern about how much elements at index for the size of k. Eg. i=0 has 1 element, ... i=3 has 4 elements
            // front index is outside the window, pop it.
                // deduction of (i - k) "the value of the leaving index"
                // if deque first is Equal (i - k), pollarding the tree

            // [part 5] "The Elimination of outbound processingPower"
            // we now have a full window of size k, so we are allowed to calculate the answer for this window
                // get the front/first index of the Deque.
                // use that front/first index of the Deue to get the Max booting Power
                // Perform the formula: calculatedPower = max(bootingPower) + sum(processingSum) * k
                // if calculatedPower is less or more than powerMax return true

        // end of for-loop

        return false; // if everything fails on the process.
    }

    public static void main(String[] args) {
        /*
        bootingPower    = [3, 6, 1, 3, 4]
        processingPower = [2, 1, 3, 4, 5]
        powerMax        = 25
        answer          = 3
         */
        int output0 = findMaximumSustainableClusterSize(
                new ArrayList<>(
                        List.of(3, 6, 1, 3, 4) // processingPower
                ),
                new ArrayList<>(
                        List.of(2, 1, 3, 4, 5) // bootingPower
                ),
                25 // powerMax
        );
        System.out.println(output0);

        /*
        bootingPower    = [3, 6, 1, 3, 4]
        processingPower = [2, 1, 3, 4, 5]
        powerMax        = 25
        answer          = 2
         */
        int output1 = findMaximumSustainableClusterSize(
                new ArrayList<>(
                        List.of(4, 1, 4, 5, 3) // arg1: processingPower
                ),
                new ArrayList<>(
                        List.of(8, 8, 10, 9, 12) // arg2: bootingPower
                ),
                33 // arg3: powerMax
        );
        System.out.println(output1);
    }
}