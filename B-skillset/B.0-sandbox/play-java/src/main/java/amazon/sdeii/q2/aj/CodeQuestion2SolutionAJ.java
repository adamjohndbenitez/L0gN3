package amazon.sdeii.q2.aj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// TODO: aj - bring all cases here and make a junit tests of it all.
// TODO: aj - Study more on  monotonic deque?  Sliding window + max tracking + binary search

public class CodeQuestion2SolutionAJ {
    /*
     * Complete the 'findMaximumSustainableClusterSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY processingPower
     *  2. INTEGER_ARRAY bootingPower
     *  3. LONG_INTEGER powerMax
     *
     * [1] fixed-size sliding window
     * [2] monotonic deque for window max
     * [3] binary search on answer
     * [4] long overflow safety
     * [5] at least one valid subarray
     *
     * Before the code, one very important reminder:
     *
     * i, left, right, mid = these are usually indices or sizes
     * processingPower.get(i) and bootingPower.get(i) = these are the actual values
     * the deque stores indices, not values
     *
     */
    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        // Write your code here
        /*
        processor has both bootingPower and processingPower.
        So both arrays are just two properties of the same processors.
        index   processor   bootingPower   processingPower
        0       P0          3              2
        1       P1          6              1
        2       P2          1              3
        3       P3          3              4
         */

        // n is the number of processors.
        int n = processingPower.size();

        // expect one booting power per processor, expect one processing power per processor
        if (processingPower.size() != n) {
            throw new IllegalArgumentException("Both arrays must have the same length.");
        }

        // [3] BINARY SEARCH ON ANSWER:
        // We are not binary-searching array values.
        // We are binary-searching the possible cluster size k.
        int left = 1;          // smallest cluster size we try
        int right = n;         // largest cluster size we try
        int answer = 0;        // if nothing works, answer stays 0

        // Normal binary search loop.
        while (left <= right) {

            // mid is the cluster size k we are testing now.
            int mid = left + (right - left) / 2;

            // [5] AT LEAST ONE VALID SUBARRAY:
            // We only ask:
            // "Is there at least one window of size mid that is sustainable?"
            if (canFormCluster(processingPower, bootingPower, powerMax, mid)) {
                // If yes, mid is possible.
                answer = mid;

                // Try a bigger cluster size.
                left = mid + 1;
            } else {
                // If no, mid is too big.
                // Try smaller sizes.
                right = mid - 1;
            }
        }

        // This is the biggest valid cluster size.
        return answer;
    }

    private static boolean canFormCluster(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax,
            int k
    ) {
        // [4] LONG OVERFLOW SAFETY:
        // sum can become large, so use long.
        long processingSum = 0L;

        // [2] MONOTONIC DEQUE FOR WINDOW MAX:
        // This deque stores INDICES, not bootingPower values.
        // The bootingPower values of these indices are kept in decreasing order.
        // So the front of the deque always points to the max bootingPower in the window.
        Deque<Integer> deque = new ArrayDeque<>();

        // i is the RIGHT index of the current window as we scan left to right.
        for (int i = 0; i < processingPower.size(); i++) {

            // Add the current processor's processing power into the running sum.
            // processingPower.get(i) is the VALUE at index i.
            processingSum += processingPower.get(i);

            // [2] MONOTONIC DEQUE FOR WINDOW MAX:
            // Remove smaller or equal bootingPower values from the back,
            // because they can never be the max while the current bigger value exists.
            while (!deque.isEmpty()
                    && bootingPower.get(deque.peekLast()) <= bootingPower.get(i)) {
                deque.pollLast();
            }

            // Add the current index i to the back of the deque.
            deque.offerLast(i);

            // [1] FIXED-SIZE SLIDING WINDOW:
            // Once the window grows bigger than size k,
            // remove the processor that falls out from the left side.
            if (i >= k) {

                // The index leaving the window is (i - k).
                // Remove its processingPower from the running sum.
                processingSum -= processingPower.get(i - k);

                // If that leaving index is currently sitting at the front of the deque,
                // remove it because it is no longer inside the window.
                if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                    deque.pollFirst();
                }
            }

            // [1] FIXED-SIZE SLIDING WINDOW:
            // A full window of size k exists when i >= k - 1.
            if (i >= k - 1) {

                // The left index of the current window is:
                // windowLeft = i - k + 1
                // The right index of the current window is:
                // windowRight = i
                //
                // Example:
                // if i = 2 and k = 3, then window is indices [0..2].

                // The front of the deque is the INDEX of the maximum bootingPower in this window.
                int maxBootIndex = deque.peekFirst();

                // This is the actual maximum bootingPower VALUE in the current window.
                long maxBootValue = bootingPower.get(maxBootIndex);

                // [4] LONG OVERFLOW SAFETY:
                // Use long math for total power calculation.
                // Formula:
                // max bootingPower in window + (sum of processingPower in window) * k
                long totalPower = maxBootValue + (processingSum * (long) k);

                // [5] AT LEAST ONE VALID SUBARRAY:
                // We only need ONE valid window of size k.
                // The moment we find one, we can return true.
                if (totalPower <= powerMax) {
                    return true;
                }
            }
        }

        // If no window of size k worked, return false.
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

// Below code is the original:
//    import java.io.*;
//    import java.util.*;
//    import java.util.stream.*;
//
//    class Result {
//
//        /*
//         * Complete the 'findMaximumSustainableClusterSize' function below.
//         *
//         * The function is expected to return an INTEGER.
//         * The function accepts following parameters:
//         *  1. INTEGER_ARRAY processingPower
//         *  2. INTEGER_ARRAY bootingPower
//         *  3. LONG_INTEGER powerMax
//         */
//        public static int findMaximumSustainableClusterSize(
//                List<Integer> processingPower,
//                List<Integer> bootingPower,
//                long powerMax
//        ) {
//            // Write your code here
//        }
//    }
//
//    public class Solution {
//        public static void main(String[] args) throws IOException {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            int processingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> processingPower = IntStream.range(0, processingPowerCount)
//                    .mapToObj(i -> {
//                        try {
//                            return bufferedReader.readLine().replaceAll("\\s+$", "");
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//
//            int bootingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> bootingPower = IntStream.range(0, bootingPowerCount)
//                    .mapToObj(i -> {
//                        try {
//                            return bufferedReader.readLine().replaceAll("\\s+$", "");
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//
//            long powerMax = Long.parseLong(bufferedReader.readLine().trim());
//
//            int result = Result.findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax);
//
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }
//    }
