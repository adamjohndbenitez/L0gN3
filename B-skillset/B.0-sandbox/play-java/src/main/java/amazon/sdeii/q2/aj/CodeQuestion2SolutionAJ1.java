package amazon.sdeii.q2.aj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CodeQuestion2SolutionAJ1 {

    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        int numberOfProcessors = processingPower.size();

        // we are counting processors, each has 2 values stored in parallel arrays.
        // 2 arrays should have same match size
        if (numberOfProcessors != bootingPower.size()) {
            throw new IllegalArgumentException("Both arrays must have the same length.");
        }

        // BINARY SEARCH to test middle and cut half repeatedly.
        int left = 1/* smallest cluster size */, right = numberOfProcessors /* larges cluster size possible */, answer = 0 /* if nothing works, stays at 0 */;

        while (left <= right) { // binary search loop
            // mid is the cluster size k, safest way is to deduct left first on right and divide to avoid overflow of very large values.
            int mid = left + (right - left) / 2; // why divided by 2? to cut in half.

            if (canFormCluster(processingPower, bootingPower, powerMax, mid)) {
                answer = mid; // if it forms a group of cluster, answer is the mid.
                left = mid + 1; // ignore left half, advance the left pointer to the right side.
            } else {
                right = mid - 1; // ignore right half, advance the right pointer to the left side.
            }
        }

        return answer; // result biggest valid cluster size.
    }

    private static boolean canFormCluster(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax,
            int k
    ) {
        // constraints is saying 1 <= processingPower[i] <= 10^4 (100_000_000_000_000) (100 trillion). Java int only goes upto 2,147,483,647 (ie. two-point-one billion), while long goes extremely large (9,223,372,036,854,775,807) (ie. nine quintillion)
        long processingSum = 0L;

        // Monotonic Deque for window max, where the max value is always points at front.
        Deque<Integer> dequeIndices = new ArrayDeque<>();

        /*
        processor has both bootingPower and processingPower.
        So both arrays are just two properties of the same processors.
        k  index   processor   bootingPower   processingPower
        1  0       P0          3              2
        2  1       P1          6              1
        3  2       P2          1              3
        4  3       P3          3              4
        5  4       P4          4              5
        */
        for (int i = 0; i < processingPower.size(); i++) {
            // add the processing value into running sum.
            processingSum += processingPower.get(i);

            // Example to visualize: Let’s say, bootingPower = [3, 6, 1, 3]
            // Deque stores index:
            // At i = 0, skip the remove first because the Deque of indexes is empty.
            // At i = 1, [0] indices -> values [3] but [0] will be remove/pollLast because, gate acceptance condition: 6 >= 3 (current bootingPwr >= dequeIndex.peekLast bootingPwr)
            // At i = 2, [1, 2] indices -> values [6, 1], remove/pollLast because, gate acceptance condition: 1 >= 6 (current bootingPwr >= dequeIndex.peekLast bootingPwr)
            // At i = 3, discontinue, returns true at the bottom
            // Applying Monotonic Deque to remove smaller or equal bootingPower values from the back
            while (!dequeIndices.isEmpty() // double check deque prior to check the value by last index in deque against the value of the current index.
                    && bootingPower.get(dequeIndices.peekLast()) <= bootingPower.get(i)) {
                dequeIndices.pollLast(); // Remove the index value in deque from the back/last.
            } // Remove until the back/last part of deque is lesser than the current bootingPower, why the bootingPower because we want to find the max value of booting power (ie. max(bootingPower))
            dequeIndices.offerLast(i); // once all lesser values are wipe out, add the current index again at the back/last.

            // Fixed-size sliding window, moving i from left to right.
            /*
            Rundown 2 conditions `if(i >= k)` AND `if(i >= k - 1)`
            At i = 0, Window has 1 element [0], Not enough yet for size k=3, `if(i >= k)` → 0 >= 3 → false so do not remove anything, `if(i >= k - 1)` → 0 >= 2 → false so do not evaluate yet,
            At i = 1, Window has 2 element [0, 1], Not enough yet for size k=3, `if(i >= k)` → 1 >= 3 → false so do not remove anything, `if(i >= k - 1)` → 1 >= 2 → false so do not evaluate yet,
            At i = 2, Window has 3 element [0, 1, 2], window has 3 elements enough for size k=3, `if(i >= k)` → 2 >= 3 → false so no removal, because window is not too big, `if(i >= k - 1)` → 2 >= 2 → true so yes evaluate, because now size is exactly size k=3,
            At i = 3, Window has 4 element [0, 1, 2, 3], window has 4 elements too big for size k=3, `if(i >= k)` → 3 >= 3 → true start remove old left element in the window, deduct old left element to sum and remove deque indexes, updated Window has 3 element [1, 2, 3] after removal of index in deque and deduction on the sum value,   `if(i >= k - 1)` → 3 >= 2 → true so yes evaluate, evaluate this full window maxBootingPower + sumProcessingPower * k
            At i = 4, Window has 4 element [1, 2, 3, 4], window has 4 elements too big for size k=3, `if(i >= k)` → 3 >= 3 → true start remove old left element in the window, deduct old left element to sum and remove deque indexes, updated Window has 3 element [2, 3, 4] after removal of index in deque and deduction on the sum value,   `if(i >= k - 1)` → 4 >= 2 → true so yes evaluate, evaluate this full window maxBootingPower + sumProcessingPower * k
             */

            /*
            `if (i >= k)`
            the window has grown past size k, so remove the old left element
            Because when i == k, you have already seen k + 1 elements from index 0 to k.
            Example with k = 3:
                i = 0 → 1 element
                i = 1 → 2 elements
                i = 2 → 3 elements
                i = 3 → 4 elements
            So at i = 3, k = 3, i == k OR i >= k the window is too big and must drop the leftmost old element.
             */
            // this if block concern about the full size k=3 fixed sliding window that over boundary, because we will remove and deduct here.
            if (i >= k) { // k because we are dealing with indexes starting 0 to get the value for deduction,
                processingSum -= processingPower.get(i - k); // The index leaving the window is (i - k).
                if (!dequeIndices.isEmpty() && dequeIndices.peekFirst() == (i - k)) dequeIndices.pollFirst(); // is the first/front of deque index leaving the window (i - k), remove the first/front of deque index
            }

            /*
            `if (i >= k - 1)`
            This means:
            we now have a full window of size k, so we are allowed to calculate the answer for this window
            Example with k = 3:
                i = 0 → not enough yet
                i = 1 → not enough yet
                i = 2 → now we have 3 elements, window [0..2]
            So the first valid full window appears exactly when:
             */
            // this if block concern about cluster size k=3 itself of the index [0, 1, 2], because we will apply the formula here
            if (i >= (k - 1)) { // why k - 1, since k = 3, first full window ends at index 2. eg. [0, 1, 2] this condition give the sliding window the boundaries.
                int frontIndex = dequeIndices.peekFirst(); // the front/first will be the Max bootingPower in the deque of indexes after the while block above is performed (ie. removing the lesser value from the last/back of the deque)  in this current window. eg. [0, 1, 2]
                long maxBootingValue = bootingPower.get(frontIndex);
                long totalPower = maxBootingValue + (processingSum * (long) k);
                if (totalPower <= powerMax) {
                    return true;
                }
            }
        }
        // no window of size k worked.
        return false;
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
                        List.of(2, 1, 3, 4, 5) // processingPower
                ),
                new ArrayList<>(
                        List.of(3, 6, 1, 3, 4) // bootingPower
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

        /*
        processingPower = [10, 8, 7]
        bootingPower    = [11, 12, 19]
        powerMax        = 6
        answer          = 0
         */
        int output2 = findMaximumSustainableClusterSize(
                new ArrayList<>(
                        List.of(10, 8, 7) // arg1: processingPower
                ),
                new ArrayList<>(
                        List.of(11, 12, 19) // arg2: bootingPower
                ),
                6 // arg3: powerMax
        );
        System.out.println(output2);
    }
}