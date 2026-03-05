package educative.algorithms.interviews.bruteforce;

/**
 *
 * - Brute force is the most straightforward way to solve a problem by checking all possible solutions without any shortcuts or optimizations.
 *   It guarantees finding a solution if one exists, but it’s usually inefficient.
 *
 * - Linear search is a classic example of the brute force approach, where each element in an array is checked one by one until the target is found or the array ends.
 *   The time complexity for linear search (and brute force in general) is O(n), meaning it may need to check every element in the worst case.
 *
 */
public class MaxFindNumMinBigOOfNLinearSearch {
    public static int maximum_index(int array[], int array_size) {
        int max_index = 0; // initialize index to 0
        int max_val = Integer.MIN_VALUE; // set max value to least number
        for (int i = 0; i < array_size; i++) // loop through each element in array
        {
            if (max_val < array[i]) {
                max_val = array[i];
                max_index = i;
            }
        }
        return max_index;
    }
    public static int find_index(int array[], int to_find) // takes an array of integers and an integer to find, then returns index of element if exists otherwise -1
    {
        for (int i = 0; i < array.length; i++) // loop through each element in the array
        {
            if (array[i] == to_find) // check if this is the element you want to find
            {
                return i; // if found return its index
            }
        }
        return -1; // element not found, return -1
    }
    public static int minimum_index(int array[], int array_size) {
        int min_index = 0; // initialize index to 0
        int min_val = Integer.MAX_VALUE; // set min value to largest number
        for (int i = 0; i < array_size; i++) // loop through each element in array
        {
            if (min_val > array[i]) {
                min_val = array[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
        int array_size = 9;
        int number_to_search = 7;
        int[] nums = {2, 4, 6, 3, 5, 7, 9, 1, 8};
        int max_index = maximum_index(nums, array_size);
        int min_index = minimum_index(nums, array_size);
        int index_found = find_index(nums, 7);

        System.out.println("The MAX number " + nums[max_index] + " is found at index " + max_index);

        if (index_found != -1)
            System.out.println("The number " + number_to_search + " is found at " + index_found);

        else
            System.out.println("The number " + number_to_search + " is NOT found");

        System.out.println("The MIN number " + nums[min_index] + " is found at index " + min_index);
    }
}
