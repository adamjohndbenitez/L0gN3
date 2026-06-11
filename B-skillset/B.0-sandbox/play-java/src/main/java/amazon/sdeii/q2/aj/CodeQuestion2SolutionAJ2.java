package amazon.sdeii.q2.aj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CodeQuestion2SolutionAJ2 {

    public static int findMaximumSustainableClusterSize(
            List<Integer> processingPower,
            List<Integer> bootingPower,
            long powerMax
    ) {
        // Binary Search
        int left = 1; // possible cluster size k= 1 to size of the list processors
        int right = processingPower.size();
        int answer = 0;

        // from left to right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (
                    canFormCluster(processingPower, bootingPower, powerMax, mid)
            ) {
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
        Deque<Integer> dequeIndices = new ArrayDeque<>();
        for (int i = 0; i < processingPower.size(); i++) {
            processingSum += processingPower.get(i);
            while (!dequeIndices.isEmpty() && bootingPower.get(i) >= bootingPower.get(dequeIndices.peekLast())) {
                dequeIndices.pollLast();
            }
            dequeIndices.offerLast(i);
            if (i >= k) {
                processingSum -= processingPower.get(i - k);
                if (!dequeIndices.isEmpty() && dequeIndices.peekFirst() == (i - k)) {
                    dequeIndices.pollFirst();
                }
            }
            if (i >= (k - 1)) {
                int maxBootingPowerIndex = dequeIndices.peekFirst();
                long maxBootingValue = bootingPower.get(maxBootingPowerIndex);
                long totalPower = maxBootingValue + (processingSum * (long) k);
                if (totalPower <= powerMax) {
                    return true;
                }
            }
        }

        return      false;
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