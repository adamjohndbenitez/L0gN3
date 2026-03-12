package scotiadigital.chatgpt.livecodility.Aarrayshashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FMergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        FMergeIntervals f = new FMergeIntervals();
        System.out.println("Output: " + Arrays.deepToString(f.merge(intervals)));
    }


    public int[][] merge(int[][] intervals) {

        // Step 1: If there are 0 or 1 intervals, nothing to merge
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 2: Sort intervals by their start time
        // This ensures overlapping intervals appear next to each other
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Why Time Complexity is O(n log n) (Linearithmic): The dominant operation is sorting. Sorting complexity: O(n log n) (Linearithmic)

        // Step 3: List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Start with the first interval as the current interval
        int[] current = intervals[0];
        merged.add(current);

        // Step 4: Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // If intervals overlap
            // Example: current = [1,3], next = [2,6]
            if (next[0] <= current[1]) {

                // Extend the current interval's end
                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap, start a new interval
                current = next;
                merged.add(current);
            }
        }

        // Step 5: Convert list back to array format
        return merged.toArray(new int[merged.size()][]);
    }
}
