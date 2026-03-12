package nubank.chatgpt.Blongestsubstringwithoutrepeatingcharacters.linear;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * ByteByteGo > 05 Sliding windows > Longest Substring With Unique Characters
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println("Input: s = '"+s+"'");
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("Output: "+l.longest_substring_with_unique_chars(s));
        System.out.println("Output: "+l.longestSubstringWithUniqueCharactersAJ(s));
    }

    /**
     * categorize any window in to two ways: <br>
     * 1. Unique Characters - expand the window by advancing the right pointer to find longer window that also don't have duplicates. <br>
     * 2. Duplicate Characters (at least 1 char of a frequency > 1) - shrink the window by advancing the left pointer until it no longer has duplicates. <br>
     * Time complexity: O(n) (Linear) because we traverse the string linearly with 2-pointers(left&right)
     * @param s
     * @return maxLen
     */
    public Integer longestSubstringWithUniqueCharactersAJ(String s) {
        // To implement the sliding window technique, we should establish the following:
        // Left and right pointers: Initialize both at the start of the string to define the window's boundaries.
        int left = 0, right = 0;

        // hash_set: maintain a hash set to record the unique characters within the window, updating it as the window expands. Note, the hashset shown in the diagram displays its state before the character at the right pointer is added to it.
        Set<Character> uniqueChars = new HashSet<>();

        // returning value is the maximum length of the window that are all unique characters.
        int maxLen = 0;

        // right is the indication that we will reach the length of `s`
        while (right < s.length()) {

            // If any duplicate char, shrink the window until it's there is no more duplicates in the window.
            while (uniqueChars.contains(s.charAt(right))) {
                uniqueChars.remove(s.charAt(left++)); // instead of left++, we can do below:
//                left += 1;
            }

            // Once we have all the unique chars in the window, update 'maxLen' which ever is the larger value from the previous length of the window or the current length of the window.
            maxLen = Math.max(maxLen, (right - left) + 1); // adding 1 since we begin with 0.

            // Add the char of the right pointer, Then advance the right.
            uniqueChars.add(s.charAt(right));
            right += 1;
        }

        return maxLen;
    }

    public Integer longest_substring_with_unique_chars(String s) {
        int maxLen = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            // If we encounter a duplicate character in the window, shrink the window until
            // it’s no longer a duplicate.
            while (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left += 1;
            }
            // Once there are no more duplicates in the window, update 'maxLen' if the
            // current window is larger.
            maxLen = Math.max(maxLen, right - left + 1);
            hashSet.add(s.charAt(right));
            // Expand the window.
            right += 1;
        }
        return maxLen;
    }
}