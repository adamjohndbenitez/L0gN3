package citi.karat.Aarrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * The interview prompt: identify two distinct numbers in an array that add up to a given target value.
 * Clarifying questions to ask: “Can the array contain negative numbers?”, “Is there exactly one solution or multiple?”, “Can elements be reused?”, “Should the output be indices or values?”, and “Is the array sorted?”
 * Brute-force idea: The brute force approach is to check every pair of numbers in the array to see if they sum to the target k. This involves nested loops: for each element, check all other elements to find a pair that adds up to k.
 * Optimal approach: The optimal approach uses a hash map to store numbers and their indices while iterating through the array. For each number, check if k minus that number exists in the map. This allows finding the pair in a single pass with O(n) time complexity.
 * Complete Java solution: Brute Force + Two-Pointers + Binary Search
 * Dry run with sample input: Create a package-private "no public class" to test solutions
 * Time & space complexity: See javadoc methods
 * Edge cases: if we cannot find a sum? it returns [0,0]
 * Common mistakes
 * Likely follow-up questions
 */
public class ATwoSum {

    /**
     * Brute Force Approach: O(n^2) Time & O(1) Space
     *  - The time complexity of this solution is O(n^2), where n is the length of the array. This is because there is a nested loop, each iterating over the entire array. As a result, the total number of iterations is proportional to the square of the length of the array.
     *  - The space complexity is O(1) because no extra space is used.
     *  0(n^2) quadratic time - because of nested loop inside the 1st loop, 0(1) constant space - fixed amount of memory
     * @param nums
     * @param target
     * @return return the indices of two numbers in nums whose sum equals target
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements.");
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // only return the (2) indexes
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution found.");
    }

    public int[] twoSumBruteForceNaive(int[] nums, int k) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the sum of current pair equals the target sum (k)
                if (nums[i] + nums[j] == k) {
                    // If found, push the pair to the result array and return
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }
        return new int[0];
    }

    /**
     * Using two pointers - To implement this approach, we first sort the given array in ascending order. Then, we initialize two pointers: one at the beginning of the array and the other at the end. These pointers will gradually move toward each other. At each step, we compute the sum of the values pointed to by these pointers. If the sum is smaller than the target we are looking for, we move the left pointer to the right. Conversely, if it’s larger, we move the right pointer to the left. We continue this process until we find a pair whose sum equals the target.
     * - The two-pointer algorithm itself runs in O(n) linear time because it scans the array once with two pointers (The two-pointer algorithm itself runs in O(n) time because it scans the array once with two pointers. However, before applying it, the array must be sorted, which takes O(n log n) time. Thus, the overall time complexity is dominated by the sorting step, resulting in O(n log n) linearithmic time). However, before applying it, the array must be sorted, which takes O(n log n) linearithmic time. Thus, the overall time complexity is dominated by the sorting step, resulting in O(n log n) linearithmic time.
     * - Sorting an array typically takes O(n log n) linearithmic time because efficient comparison-based sorting algorithms like mergesort or quicksort divide the array into smaller parts (log n divisions) and process all n elements during merging or partitioning, resulting in linearithmic O(n log n) overall complexity.  They divide the array into smaller parts (log n divisions) means. In sorting algorithms like mergesort, the array is repeatedly divided into halves until each part has one element.
     * - In Java, Arrays.sort(nums); uses a Dual-Pivot Quicksort algorithm for primitive types like int arrays, which on average runs in O(n log n) linearithmic time.
     * - The space complexity is O(1) constant space because no extra space is used.
     * @param nums array of numbers
     * @param k target
     * @return  Return the result array containing elements that sum up to k.
     */
    public int[] twoSumUsingTwoPointers(int[] nums, int k) {
        int[] result = new int[2]; //[0, 0]

        // 1. Sort the input array in nondecreasing order.
        Arrays.sort(nums);

        // 2. Initialize two pointers, the left pointing to the beginning of the array and the right pointing to the end of the array.
        int left = 0;
        int right = nums.length - 1;

        // Iterate until the pointers meet
        while (left < right) { // 3. While left is less than right:
            // I. Calculate the sum of the current pair
            int sumVal = nums[left] + nums[right];

            // II. If the sum is less than the target sum (k), move the left pointer to the right (increment the left pointer).
            if (sumVal < k) {
                left++;
            }
            // III. If the sum is greater than the target sum (k), move the right pointer to the left (decrement the right pointer).
            else if (sumVal > k) {
                right--;
            }
            // IV. If the sum equals the target sum (k), add the pair to the result array and break the loop (exit the loop).
            else {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }

        // 4. Return the result array containing elements that sum up to k.
        return result;
    }

    /**
     * Using binary search
     * First, the array is sorted to arrange the elements in ascending order, enabling efficient searching. Then, for each element in the sorted array, we compute the difference between the target sum (k) and the current element (a). This difference represents the value we need to find in the array to achieve the target sum. By utilizing binary search, we attempt to locate this difference within the sorted array. This process is repeated for each element in the array until a pair that sums up to the target is found.
     * @param nums
     * @param k
     * @return
     */
    public int[] twoSumUsingBinarySearch(int[] nums, int k) {
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            // Find the index of the complement to the current element using binary search

            int complement = k - nums[j]; // item is the complement
            int first = 0;
            int last = nums.length - 1;

            boolean found = false;
            int index = -1;

            // Perform binary search until the complement is found or the pointers meet
            while (first <= last && !found) {
                int mid = (first + last) / 2;

                // Check if the middle element is the complement
                if (nums[mid] == complement) {
                    // If found, update the index and set found to true
                    index = mid;
                    found = true;
                } else {
                    // If the complement is smaller than the middle element, update the last pointer
                    if (complement < nums[mid]) {
                        last = mid - 1;
                    }
                    // If the complement is larger than the middle element, update the first pointer
                    else {
                        first = mid + 1;
                    }
                }
            }

            index = found ? index : -1;

            // If the complement is found and it's not the same element, return the pair
            if (index != -1 && index != j) {
                return new int[]{nums[j], k - nums[j]};
            }
        }

        return new int[]{};
    }

    /**
     * You can optimize by removing the found flag and directly returning when the complement is found during binary search, reducing unnecessary checks. Also, avoid reassigning index after the loop. Here’s a streamlined version:
     * @param nums
     * @param k
     * @return
     */
    public int[] twoSumUsingBinarySearchOptimized(int[] nums, int k) {
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            int complement = k - nums[j];
            int first = 0, last = nums.length - 1;

            while (first <= last) {
                int mid = (first + last) / 2;
                if (nums[mid] == complement && mid != j) {
                    return new int[]{nums[j], complement};
                } else if (complement < nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    /**
     * Comparing the binary search In the two pointers approach, sumVal is the sum of elements at the left and right pointers, compared directly to the target k. In binary search, nums[mid] is compared to the complement (which is k - nums[j]), and the search space is adjusted by moving first or last based on that comparison. Both adjust their search boundaries based on comparisons, but two pointers move inward from both ends, while binary search narrows down by halving the search space.
     */
}


// Fun fact: In Java, removing public works because the class becomes package-private, allowing multiple top-level classes in one file. Adding public causes errors because Java strictly requires every public top-level class to be in its own file named exactly after that class.
class DryRunSampleInputTest {
    public static void main(String[] args) {
        ATwoSum solution = new ATwoSum();
        int[] nums = {11, 15, 2, 7};
        int target = 26; // 9;
        try {
//            int[] result = solution.twoSumBruteForce(nums, target);
//            int[] result = solution.twoSumUsingBinarySearchOptimized(nums, target);
            int[] result = solution.twoSumUsingBinarySearch(nums, target);
            System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int[][] inputs = {
                {77, 88}, // edge-case: what if we cannot find a sum?
                {1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}
        };

        int[] k = {99, 5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);

//            int[] result = solution.twoSumBruteForceNaive(inputs[i], k[i]);
//            int[] result = solution.twoSumUsingTwoPointers(inputs[i], k[i]);
            int[] result = solution.twoSumUsingBinarySearchOptimized(inputs[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');

            /*
            Pretty format that looks like this:
                5.	Array: [-4, -1, -9, 1, -7]
                    k: -3

                    Result: [-4, 1]
                -----------------------------------------------------------------------------------------------------

                6.	Array: [25, 50, 75, 100, 400]
                    k: 425

                    Result: [25, 400]
                -----------------------------------------------------------------------------------------------------
             */
        }
    }
}