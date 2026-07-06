package citi.karat.Iheap;

import java.util.*;

public class ATopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // First, we count how many times each number appears using a HashMap.
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency - sorting by "Compare two numbers by looking up their frequencies in the map." (smaller frequency) has higher priority or at the head of the queue.
        // Then we use a min heap to keep only the top k frequent numbers.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        // Keep only k most frequent elements in heap
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);

            if (minHeap.size() > k) { // as the minHeap size is added, we only want k, so we cut off the head:
                minHeap.poll(); // cut off the head of the queue where it sorted as the minimum value is at the head.
            }
        }

        // Build result
        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] inputNums = new int[][]{
                {1,1,1,2,2,3},
//                {3,2,2,1,1,1},
//                {1,2,2,3,3,3},
//                {1,2,2,3,3,3,4},

                {1},
                {4,4,4,6,6,7,7,7,7,8},
        };

        int[] k = {2,1,2};

        for (int i = 0; i < inputNums.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputNums[i]));
            System.out.println("\tk: " + k[i]);

            int[] result = topKFrequent(inputNums[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println(String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}

class ATopKFrequentElementsAJKarat {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        int[][] inputNums = new int[][] {
                {1,1,1,2,2,3},
                {1},
                {4,4,4,6,6,7,7,7,7,8},
        };
        int[] k = {2,1,2};
        for (int i = 0; i < inputNums.length; i++) {
            System.out.println((i+1) + ".\tArray: " + Arrays.toString(inputNums[i]));
            System.out.println("\tk: " + k[i]);
            int[] result = topKFrequent(inputNums[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println(String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }
        return result;
    }
}