package citi.karat.Bstrings;

import scotiadigital.chatgpt.livecodility.Aarrayshashmap.DValidAnagram;

import java.util.Map;

/**
 *
 * Problem Statement
 *
 * Given two strings s and t, determine whether t is an anagram of s.
 *
 * An anagram is a word or phrase formed by rearranging all the letters of another word using every character exactly once.
 *
 * Return:
 *
 * true if t is an anagram of s
 * false otherwise
 * Example 1
 * Input:
 * s = "anagram"
 * t = "nagaram"
 *
 * Output:
 * true
 *
 * Why?
 *
 * anagram
 *
 * a -> 3
 * n -> 1
 * g -> 1
 * r -> 1
 * m -> 1
 *
 * nagaram
 *
 * n ->1
 * a ->3
 * g ->1
 * r ->1
 * m ->1
 *
 * Both contain exactly the same letters.
 *
 * Example 2
 * Input:
 *
 * s = "rat"
 * t = "car"
 *
 * Output:
 *
 * false
 *
 * Because
 *
 * rat
 *
 * r
 * a
 * t
 *
 * car
 *
 * c
 * a
 * r
 *
 * The second string has c instead of t.
 *
 */
public class AValidAnagram {
    public static void main(String[] args) {
        String s = "aacc", t = "ccac"; // returns true
//        String s = "listen", t = "silent"; // returns true
//        String s = "anagram", t = "nagaram"; // returns true
//        String s = "rat", t = "car"; // returns false
        System.out.println("Input: s = " + s + ", t = " + t);
        AValidAnagram anagram = new AValidAnagram();
        System.out.println("Output: " + anagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        // Step 1: If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create a frequency counter for letters a-z
        // Since we only have 26 lowercase letters, we use a fixed array
        int[] count = new int[26]; // O(1) (constant space complexity) The array size is fixed: It does not grow with input size, so it is constant space.

        // Step 3: Count characters from the first string
        // Example: "anagram"
        for (char c : s.toCharArray()) {
            count[c - 'a']++; // count characters in s → O(n) (linear time complexity)
        }

        // Step 3: Count characters from the first string
        // Example: "anagram"
        for (char c : t.toCharArray()) {
            count[c - 'a']--; // subtract characters in t → O(n) (linear time complexity)
        }

        // Step 5: Verify all frequencies return to zero
        // If any index is not zero, characters do not match
        for (int n : count) {
            if (n != 0) return false;
        }

        // All character frequencies matched
        return true;
    }

    /**
     * Clarify assumptions: "Are the strings limited to lowercase English letters?" If yes, an array of size 26 is the most efficient. Otherwise, I'd use a HashMap<Character, Integer>.
     * Time O(n) - linear, Space O(1) - constant for lowercase English letters since The array never grows.
     * Since 26 is a constant, Space = O(26) = O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            count[c - 'a']--;
        }
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This works even when the strings can contain Unicode characters or a much larger character set.
     * Time O(n) - linear and Space O(k) - linear with a HashMap, where k is the number of distinct characters.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramUsingHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
