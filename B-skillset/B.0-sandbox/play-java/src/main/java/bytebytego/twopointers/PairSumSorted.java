package bytebytego.twopointers;

import java.util.ArrayList;

/**
 *
 * the core logic of the two-pointer approach for a sorted array, specifically how the pointers are moved to adjust the sum. Let's break it down using the example nums = [-5, -2, 3, 4, 6] and target = 7.
 *
 * Why this logic is crucial for the algorithm
 *
 * The two-pointer approach works precisely because of these properties of a sorted array. It allows us to make intelligent decisions about which pointer to move:
 *
 * If sum < target, we must try to increase the sum. The safest way to guarantee an increase (or at least not a decrease) is to move left to a larger value.
 * If sum > target, we must try to decrease the sum. The safest way to guarantee a decrease (or at least not an increase) is to move right to a smaller value.
 *
 */
public class PairSumSorted {

        public ArrayList<Integer> pair_sum_sorted_brute_force(ArrayList<Integer> nums, int target) {
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

    public static void main(String[] args) {
            // [-5, -2, 3, 4, 6]; target=7
            ArrayList<Integer> list = new ArrayList<>();
            list.add(-5);
            list.add(-2);
            list.add(3);
            list.add(4);
            list.add(6);
            int target = 7;
        System.out.println(new PairSumSorted().pair_sum_sorted_brute_force(list, target));
    }
}
