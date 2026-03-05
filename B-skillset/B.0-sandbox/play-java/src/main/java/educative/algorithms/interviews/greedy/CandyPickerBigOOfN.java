package educative.algorithms.interviews.greedy;

/**
 *
 * simplify or demystify
 *
 * Here’s a super simple Java code example that shows a greedy algorithm in a way that’s easy for kids to understand. Let’s say you have a jar of candies, and you always want to pick the biggest candy first until you can’t pick any more:
 *
 * Here’s a super simple Java code example that shows a greedy algorithm in a way that’s easy for kids to understand. Let’s say you have a jar of candies, and you always want to pick the biggest candy first until you can’t pick any more:
 *
 * To make sure the greedy approach works, you should always sort the coin denominations from largest to smallest before running the algorithm.
 *
 * This GreedyCandyPicker example has a time complexity of O(n log n) because of the sorting step (Arrays.sort(candies)), where n is the number of candies. Sorting takes O(n log n) time. After sorting, the loop that picks candies runs in O(n) time, but the sorting dominates the overall complexity.
 *
 * So, the total time complexity is O(n log n) due to the sorting. If the candies were already sorted, then just picking them would be O(n).
 *
 * The time complexity O(n log n) for sorting comes from how efficient sorting algorithms (like Java’s built-in Arrays.sort) work. Most efficient sorting algorithms, such as Merge Sort or Quick Sort, use a divide-and-conquer approach:
 *
 * They repeatedly split the array into smaller parts (which takes log n steps, since each split halves the array).
 * At each level of splitting, they process all n elements (so that’s n work per level).
 * When you multiply the number of levels (log n) by the work per level (n), you get O(n log n).
 * So, sorting an array of n items usually takes O(n log n) time. That’s why, in the GreedyCandyPicker example, the sorting step is the most time-consuming part.
 *
 * The GreedyCandyPicker example has a time complexity of O(n log n) because of the sorting step (Arrays.sort(candies)),
 *
 * The time complexity O(n log n) for sorting comes from how efficient sorting algorithms (like Java’s built-in Arrays.sort) work. Most efficient sorting algorithms, such as Merge Sort or Quick Sort, use a divide-and-conquer approach:
 *
 * They repeatedly split the array into smaller parts (which takes log n steps, since each split halves the array).
 * At each level of splitting, they process all n elements (so that’s n work per level).
 * When you multiply the number of levels (log n) by the work per level (n), you get O(n log n).
 * So, sorting an array of n items usually takes O(n log n) time. That’s why, in the GreedyCandyPicker example, the sorting step is the most time-consuming part.
 *
 */
public class CandyPickerBigOOfN {
    public static void main(String[] args) {
        int[] candies = {5, 2, 9, 1, 7}; // Different sizes of candies
        java.util.Arrays.sort(candies); // Sort the candies from smallest to biggest. the total time complexity is O(n log n) due to the sorting.
        System.out.println("Picking candies from biggest to smallest:");
        for (int i = candies.length - 1; i >= 0; i--) {
            System.out.println("Picked candy of size: " + candies[i]);
        }
    }
}
