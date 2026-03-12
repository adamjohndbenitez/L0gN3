package nubank.chatgpt.Atwosum.good;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ByteByteGo > Coding Interview Patterns > 01 Two Pointers > Pair Sum - Sorted
 *
 */
public class InwardTraversalPairSum {
    // O(n) (linear time)
    public List<Integer> pairSumUsingInwardTraversal(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }

            if (sum == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(left);
                result.add(right);
                return result;
            }
        }
        return new ArrayList<>();
    }
}
