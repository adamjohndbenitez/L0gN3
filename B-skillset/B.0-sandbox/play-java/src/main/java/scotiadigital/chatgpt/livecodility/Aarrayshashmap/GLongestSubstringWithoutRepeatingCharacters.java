package scotiadigital.chatgpt.livecodility.Aarrayshashmap;

import java.util.HashMap;
import java.util.Map;

public class GLongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        GLongestSubstringWithoutRepeatingCharacters g = new GLongestSubstringWithoutRepeatingCharacters();
        System.out.println("Output: " + g.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        // Map stores the last index where each character appeared
        Map<Character, Integer> seen = new HashMap<>();

        // Left pointer of sliding window
        int left = 0;

        // Stores the length of the longest substring found
        int maxLen = 0;

        // Right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // If character already exists inside current window
            if (seen.containsKey(c) && seen.get(c) >= left) {

                // Move the left pointer right after the previous occurrence
                left = seen.get(c) + 1;
            }

            // Update the character's latest position
            seen.put(c, right);

            // Update maximum length of substring
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
