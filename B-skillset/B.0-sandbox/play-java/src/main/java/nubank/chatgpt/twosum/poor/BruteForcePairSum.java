package nubank.chatgpt.twosum.poor;

import java.util.ArrayList;
import java.util.List;

public class BruteForcePairSum {

    // The brute force solution to this problem involves checking all possible pairs. This is done using two nested loops: an outer loop that traverses the array for the first element of the pair, and an inner loop that traverses the rest of the array to find the second element.
    // O(n²) (quadratic time)
    public List<Integer> pairSumUsingBruteForce(List<Integer> nums, int target) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
}
