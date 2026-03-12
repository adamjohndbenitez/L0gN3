package scotiadigital.chatgpt.livecodility.Aarrayshashmap;

import java.util.*;

public class ATwoSum {

    public static void main(String[] args) {
//        int[] nums = {11,15,2,7}; // unsorted
        int[] nums = {2,7,11,15}; // sorted
        int target = 9;
        System.out.println("Input: nums = "+Arrays.toString(nums)+", target = "+target);
        ATwoSum atwoSum = new ATwoSum();
        System.out.println("Output: "+ Arrays.toString(atwoSum.usingHashMapComplementLookupTechniqueToSolvePairSum(nums, target)));
        System.out.println("Output: "+ Arrays.toString(atwoSum.usingInwardTraversalTechniqueToSolvePairSum(nums, target)));
    }

    //
    public int[] usingHashMapComplementLookupTechniqueToSolvePairSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // we subtract the element from the target to compute the complement
            // The problem asks us to find two numbers whose sum equals the target. If one of the numbers is nums[i], then the other number must be target - nums[i]. That value is what we call the complement.
            // The core equation of the problem is: a + b = target, a = nums[i] then b = target - a. Once you know one number (nums[i]), the other number becomes deterministic. Or predictable.


            if (seen.containsKey(complement)) { // Check: Have we already seen the complement?
                return new int[]{seen.get(complement), i}; // If yes → we found the pair.
                // But we return the indices.
                // `return new int[]{seen.get(complement)k:"complement"v:"index", <i>"index"};`
            }

            seen.put(nums[i], i); // Otherwise → store the current number in the map.
            // I store the current number as key and its index as value in the map.
            // `seen.put(<current_number>, <index>);`
        }

        return new int[]{};
    }

    // O(n) (linear time) - O(n) (constant space) - ⚠️ It only works if the array is sorted.
    public int[] usingInwardTraversalTechniqueToSolvePairSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }

            if (sum == target) {
                int[] result = new int[2];
                result[0] = left;
                result[1] = right;
                return result;
            }
        }
        return new int[] {};
    }
}
