package nubank.chatgpt.twosum;

import nubank.chatgpt.twosum.good.InwardTraversalPairSum;
import nubank.chatgpt.twosum.poor.BruteForcePairSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 1️⃣ Arrays / HashMap Problems (Very Likely)
 * These appear in almost every CodeSignal test.
 * Example patterns:
 * Two Sum variation
 * ```
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * ```
 * Skills tested:
 *  - HashMap
 *  - O(n) optimization
 */
public class TestTimeSpaceComplexity {

    public static void main(String[] args) {

        // Measuring actual memory in JVM. It manages memory automatically via Garbage Collection (GC).

        // Smaller enough input size (n)
        // [-5, -2, 3, 4, 6]; target=7
        Runtime runtime = Runtime.getRuntime();

        // Optional: Run garbage collector for a cleaner starting point
        runtime.gc();

        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

        List<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(-2);
        list.add(3);
        list.add(4);
        list.add(6);
        //java.util.Collections.sort(list); // Make sure the list is
        System.out.println("Input: " + list);
        int target = 7; // using fixed variables, the space stays the same. O(1) Constant Space
        System.out.println("Target: " + target);

        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory: " + (afterMemory - beforeMemory) + " bytes  for smaller list input size(5)  with space complexity of O(n^2) Quadratic Space.");


        // Larger enough input size (n) to overcome the JVM's extreme speed:
        Runtime runtime0 = Runtime.getRuntime();
        // Optional: Run garbage collector for a cleaner starting point
        runtime0.gc();
        long beforeMemory0 = runtime0.totalMemory() - runtime0.freeMemory();
        // We need larger input size (n). Trying input size of n = 50,000. At this scale, the O(n^2) algorithm performs 2.5 billion operations, which will be clearly visible.
        int n = 50000;
        List<Integer> list0 = new ArrayList<>(); // For space complexity, This will grow as n grows
        for (int i = 0; i < n; i++) {
            list0.add(i); // Now you are using O(n) linear for space complexity
        }
        int target0 = n - 2;
        long afterMemory0 = runtime0.totalMemory() - runtime0.freeMemory();
        System.out.println("Used memory: " + (afterMemory0 - beforeMemory0) + " bytes  for larger list input size("+n+")  with space complexity of O(n^2) Quadratic Space.");

        // Use benchmark (measure performance by time) between the inward traversal and brute force. To see a measurable difference between O(n) and O(n^2), you need to use a high-resolution timer like System.nanoTime() and use a large enough input size (n) to overcome the JVM's extreme speed.
        System.out.println("<<== [benchmarking] two-pointer algorithm using inward traversal. ==>>");
        long startTime = System.nanoTime();
        InwardTraversalPairSum inwardTraversalPairSum = new InwardTraversalPairSum();
        List<Integer> outputInwardTraversal = inwardTraversalPairSum.pairSumUsingInwardTraversal(list0, target0);
        System.out.println("Output: " + outputInwardTraversal);
        long endTime = System.nanoTime();
        // Calculate elapsed time in milliseconds
        long durationInMilliseconds = (endTime - startTime) / 1_000_000;
        System.out.println("Elapsed time: " + durationInMilliseconds + " ms   with time complexity of O(n) Linear Time. [MOST NOTICEABLE PERFORMANCE]");

        System.out.println("<<== [benchmarking] two-pointer algorithm using brute force. ==>>");
        long startTime0 = System.nanoTime();
        BruteForcePairSum bruteForcePairSum0 = new BruteForcePairSum();
        List<Integer> outputBruteForce0 = bruteForcePairSum0.pairSumUsingBruteForce(list0, target0);
        System.out.println("Output: " + outputBruteForce0);
        long endTime0 = System.nanoTime();
        // Calculate elapsed time in milliseconds
        long durationInMilliseconds0 = (endTime0 - startTime0) / 1_000_000;
        System.out.println("Elapsed time: " + durationInMilliseconds0 + " ms   with time complexity of O(n^2) Quadratic Time.");
    }
}
