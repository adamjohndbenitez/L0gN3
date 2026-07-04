package citi.karat.Chashmap;

import java.util.*;

/**
 * Source: https://www.educative.io/courses/algorithms-coding-interviews-java/challenge-find-duplicates-in-array
 * Challenge: Find Duplicates in Array
 * Explore methods to detect duplicates in arrays by designing clear step-by-step algorithms. This lesson helps you understand the logic behind identifying repeated elements and practice coding solutions in Java to strengthen your problem-solving skills.
 * Problem statement
 * Given an array, find all the duplicates that exist in that array.
 * <p>
 * Input
 * An integer array.
 * <p>
 * Output
 * The output is an ArrayList containing the duplicates if they exist and an empty ArrayList if they don’t.
 * <p>
 * Sample input
 * int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};
 * Sample output
 * ArrayList <Integer> output = {3, 4, 100};
 */
public class AContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 5, 4, 100, 100};
        AContainsDuplicate  solution = new AContainsDuplicate();
        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Duplicate Output: " + solution.findDuplicatesByBruteForce(arr));
    }

    /**
     * This solution iterates over the input array for each given element, starting from the element after the given element, and checks if another element is equal to it or not. If it is equal, then it is added to the output list —duplicates. However, when you have more than 2 copies of any given element, the element is added to the ArrayList as many times as it is present. This does not look great, as shown in the case of the array on line 25 (11 occurs thrice in the output).
     * The array is iterated once for each element present so the time complexity is in O(n^2) quadratic .
     * @param arr
     * @return List<Integer> duplicates
     */
    private List<Integer> findDuplicatesByBruteForce(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    duplicates.add(arr[i]);
                }
            }
        }

        return duplicates;
    }

    /**
     * This solution is the exact same as solution #1. The only difference is that if a duplicate is encountered, it checks if it is already present in the duplicates list to avoid adding it twice.
     * while this is more “accurate” than method findDuplicatesByBruteForce(), it is not as time-efficient. The time complexity is in O(n^2) quadratic.
     * @param arr
     * @return
     */
    private List<Integer> findDuplicatesByBruteForceAlreadyCountedDuplicate(int[] arr) {
        List<Integer> duplicates = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && duplicates.contains(arr[i])) {
                    duplicates.add(arr[i]);
                }
            }
        }

        return duplicates;
    }

    /**
     *
     * The time complexity of this version is in O(n) since the input array is iterated over once. The space complexity is O(n).
     * This is the most efficient solution. It uses a HashMap<Integer, Integer> to map the number against the number of times that they appear. So the entries in the hash table would look like:
     * 3     <->    2
     * 5     <->    2
     * 11    <->    3
     * @param arr
     * @return
     */
    public List<Integer> findDuplicatesUsingHashing(int[] arr) {
        ArrayList < Integer > duplicates = new ArrayList < Integer > (arr.length);
        int n = arr.length;
        Map< Integer, Integer > map = new HashMap < > ();
        int count = 0;
        boolean dup = false;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int index = 0;
        for (Map.Entry< Integer, Integer > entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey()); // if frequence > 1, add it to the array list
                dup = true;
            }
        }
        return duplicates; // empty array list is retured in case of no duplicates found

    }
}

/**
 * The interview prompt:  find duplicates in an array including the brute force approach and the more efficient hashing technique.
 * Clarifying questions to ask:
 * Brute-force idea:
 * Optimal approach:
 * Complete Java solution
 * Dry run with sample input:
 * Time & space complexity:
 * Edge cases:
 * Common mistakes:
 * Likely follow-up questions:
 */
class AContainsDuplicateAJKarat {

    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");
        int[] arr = {1, 3, 4, 3, 5, 4, 100, 100};
        AContainsDuplicateAJKarat solution = new AContainsDuplicateAJKarat();
        System.out.println("Input: arr = " + Arrays.toString(arr));
        // System.out.println("Duplicate Output: " + solution.findDuplicatesByBruteForce(arr));
        System.out.println("Duplicate Output: " + solution.findDuplicatesUsingHashingOrHashMap(arr));
    }

    private List<Integer> findDuplicatesByBruteForce(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        // the 2 loops (nested) make the time complexity O(n^2) quadratic
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j && !duplicates.contains(arr[i])) {
                    duplicates.add(arr[i]); // due to storing duplicates in an ArrayList, the space complexity is O(k), where k is the number of duplicates found.
                }
            }
        }
        return duplicates;
    }

    private List<Integer> findDuplicatesUsingHashingOrHashMap(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<Integer>(arr.length); // why initialize the ArrayList with arr.length, just to optimize memory allocation and avoid resizing during additions. It doesn't limit the list size but sets the starting capacity.
        int arrLen = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // O(n) linear time complexity because it iterates throught the array once to build the HashMap, counting occurences in constant time per element.
        for (int i = 0; i < arrLen; i++) {
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]); // count as the value of the map.
                map.put(arr[i], count + 1); // O(n) linear space complexity because in the worst case, all elements are uinique and stored as keys in the HashMap.
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }
}
