package amazon.sdeii.q2.aj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CodeQuestion2SolutionAJ0 {

    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        int n = processingPower.size();
        int left = 1;          // low
        int right = n;         // high
        int answer = 0;        //

        // (1) B I N A R Y   S E A R C H  ==>>  binary searching the possible cluster size k.
        while (left <= right) {
            int mid = left + (right - left) / 2; // aj: `left + (right - left) / 2` the reason is to be safer against Overflow math`(left + right) / 2`, like very large integers of left and right. (1) right - left stays much smaller, (2) then you divide by 2, (3) then add to left. In english, “Find the middle size between left and right.”
            if (canFormCluster(processingPower, bootingPower, powerMax, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean canFormCluster(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax,
            int k
    ) {
        long processingSum = 0L;

        Deque<Integer> dequeOfIndexes = new ArrayDeque<>();
        for (int i = 0; i < processingPower.size(); i++) {
            processingSum += processingPower.get(i);

            // (2) M O N O T O N I C   D E Q U E  ==>>  monotonic describes only one direction either non-increasing or non-decreasing, derived from the greek monos (single) and tonos (tone/pitch). in data structure, where elements are kept in order, sorted order. while using it for sliding window maximum, we keep it decreasing order from front to back SOOO the largest value is always at the front.
            while (!dequeOfIndexes.isEmpty()
                    && bootingPower.get(dequeOfIndexes.peekLast()) <= bootingPower.get(i)) { // cleanup smaller values from end/last, starting from end/last.
                dequeOfIndexes.pollLast(); // remove smaller values from the back/last
            }

            // Always move the sliding window to the right
            dequeOfIndexes.offerLast(i); // Add/Inserts the index at the end/back/last of this deque.


            // (3) F I X E D - S I Z E   S L I D I N G   W I N D O W  ==>> A monotonic deque helps you get the max fast while sliding.
            // note:
            // k is a cluster size from prior binary searching. i is index of processingPower.
            if (i >= k) { // remove old left element, moving the sliding window to the left.
                processingSum -= processingPower.get(i - k); // as we deduct the old left element removed from the processingSum.
                if (!dequeOfIndexes.isEmpty() && dequeOfIndexes.peekFirst() == i - k) { // as well as make sure that the front of deque is the index we use to remove the processing power.
                    dequeOfIndexes.pollFirst();
                }
            }

            // apply the formula on full window cluster size
            if (i >= k - 1) { // eg. [0...2] is full window of size k, so I can evaluate this cluster.
                int maxBootIndex = dequeOfIndexes.peekFirst();
                long maxBootValue = bootingPower.get(maxBootIndex);
                long totalPower = maxBootValue + (processingSum * (long) k);
                if (totalPower <= powerMax) {
                    return true;
                }
            }
        }

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
