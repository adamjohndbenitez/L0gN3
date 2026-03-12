package nubank.chatgpt.Blongestsubstringwithoutrepeatingcharacters.optimizedlinear;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * ByteByteGo > 05 Sliding windows > Longest Substring With Unique Characters
 *
 */
public class OptimizedLongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "cabcdeca";
        System.out.println("Input: s = '" + s + "'");
        OptimizedLongestSubstringWithoutRepeatingCharacters l = new OptimizedLongestSubstringWithoutRepeatingCharacters();
        System.out.println("Output: " + l.longest_substring_with_unique_chars_optimized(s));
        System.out.println("Output: " + l.optimizedLongestSubstringWithUniqueCharactersAJ(s));
    }

    public Integer longest_substring_with_unique_chars_optimized(String s) {
        int maxLen = 0;
        Map<Character, Integer> prevIndexes = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char currChar = s.charAt(right);
            // If a previous index of the current character is present in the current
            // window, it's a duplicate character in the window.
            if (prevIndexes.containsKey(currChar) && prevIndexes.get(currChar) >= left) {
                // Shrink the window to exclude the previous occurrence of this character.
                left = prevIndexes.get(currChar) + 1;
            }
            // Update 'maxLen' if the current window is larger.
            maxLen = Math.max(maxLen, right - left + 1);
            prevIndexes.put(currChar, right);
            // Expand the window.
            right++;
        }
        return maxLen;
    }

    /**
     * The optimization has to do with how we shrink the window when encountering a duplicate character. <br>
     * a new strategy for advancing the left pointer, if we know the index of the previous occurrence of 'c',
     * we can move our left pointer immediately past that index to remove it from the window
     *     left            right
     *      |              |
     *   c  a  b  c  d  e  c  a
     *            |
     *            duplicate to right pointer.
     *
     *
     * @param s
     * @return maxLen
     */
    public Integer optimizedLongestSubstringWithUniqueCharactersAJ(String s) {
        // To implement the sliding window technique, we should establish the following:
        // Left and right pointers: Initialize both at the start of the string to define the window's boundaries.
        int left = 0, right = 0;

        // use a hash map (prev_indexes) to store the previous index of each character in the string.
        Map<Character, Integer> prevIndexesOfChars = new HashMap<>();

        // returning value is the maximum length of the window that are all unique characters.
        int maxLen = 0;

        // right is the indication that we will reach the length of `s`
        while (right < s.length()) {

            // current character:
            char currChar = s.charAt(right);

            // If any duplicate char, shrink the window until it's there is no more duplicates in the window.
            // just ensure the previous character's index is in the window.
            // inside the window: left < prevcharindx < right
            // outside the window: prevcharindx < left < right
            if (prevIndexesOfChars.containsKey(currChar) && prevIndexesOfChars.get(currChar) >= left) {
                // Shrink the window to exclude the previous occurrence of this character.
                left = prevIndexesOfChars.get(currChar) + 1;
            }

            // Once we have all the unique chars in the window, update 'maxLen' which ever is the larger value from the previous length of the window or the current length of the window.
            maxLen = Math.max(maxLen, (right - left) + 1); // adding 1 since we begin with 0.

            // Add the char of the right pointer, Then advance the right.
            prevIndexesOfChars.put(currChar, right);
            right += 1;
        }

        return maxLen;
    }


}