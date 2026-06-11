package amazon.sdeii.q2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

// TODO: aj - bring all cases here and make a junit tests of it all.
// TODO: aj - Study more on  monotonic deque?  Sliding window + max tracking + binary search

public class CodeQuestion2Solution {
    /*
     * Complete the 'findMaximumSustainableClusterSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY processingPower
     *  2. INTEGER_ARRAY bootingPower
     *  3. LONG_INTEGER powerMax
     */
    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        // Write your code here
        int n = processingPower.size();
        int left = 1;
        int right = n;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

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
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < processingPower.size(); i++) {
            sum += processingPower.get(i);

            while (!deque.isEmpty() &&
                    bootingPower.get(deque.peekLast()) <= bootingPower.get(i)) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i >= k) {
                sum -= processingPower.get(i - k);

                if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                    deque.pollFirst();
                }
            }

            if (i >= k - 1) {
                long maxBoot = bootingPower.get(deque.peekFirst());
                long totalPower = maxBoot + sum * k;

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
