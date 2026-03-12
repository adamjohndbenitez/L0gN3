package nubank.chatgpt.Atwosum;

import nubank.chatgpt.Atwosum.good.InwardTraversalPairSum;
import nubank.chatgpt.Atwosum.poor.BruteForcePairSum;

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
public class TwoPointerAlgorithm {

    public static void main(String[] args) {
        // [-5, -2, 3, 4, 6]; target=7
        List<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(-2);
        list.add(3);
        list.add(4);
        list.add(6);
        //java.util.Collections.sort(list); // Make sure the list is
        System.out.println("Input: " + list);
        int target = 7;
        System.out.println("Target: " + target);

        // Use to drive and inspect between the inward traversal and brute force.
        System.out.println("<<== [drive&inspect] two-pointer algorithm using inward traversal. ==>>");
        InwardTraversalPairSum inwardTraversalPairSum = new InwardTraversalPairSum();
        List<Integer> outputInwardTraversal = inwardTraversalPairSum.pairSumUsingInwardTraversal(list, target);
        System.out.println("Output: " + outputInwardTraversal);

        System.out.println("<<== [drive&inspect] two-pointer algorithm using brute force. ==>>");
        BruteForcePairSum bruteForcePairSum = new BruteForcePairSum();
        List<Integer> outputBruteForce = bruteForcePairSum.pairSumUsingBruteForce(list, target);
        System.out.println("Output: " + outputBruteForce);

    }
}
