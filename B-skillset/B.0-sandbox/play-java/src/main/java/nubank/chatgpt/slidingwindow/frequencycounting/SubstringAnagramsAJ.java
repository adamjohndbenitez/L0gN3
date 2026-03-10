package nubank.chatgpt.slidingwindow.frequencycounting;

public class SubstringAnagramsAJ {

    public static void main(String[] args) {
        String s = "caabab";
        String t = "aba";

        System.out.println("Input: s = '" + s + "', t = '" + t + "'");
        int output = substring_anagrams(s, t); // return the number of substrings in s that are anagrams of t.
        System.out.println("Output: " + output);
        // Output: 2
        // Explanation: There is an anagram of t starting at index 1 ("caabab") and another starting at index 2 ("caabab")
        // A substring of s qualifies as an anagram of t if it contains exactly the same characters as t in any order.
        // starting at index 0 ("caabab") of s "caa" is NOT an anagram of t "aba"
        // starting at index 1 ("caabab") of s "aab" is an anagram of t "aba"
        // starting at index 2 ("caabab") of s "aba" is an anagram of t "aba"
        // starting at index 3 ("caabab") of s "bab" is NOT an anagram of t "aba"
    }

    /**
     *
     * we can use the fixed sliding window technique because a window of len_t is guaranteed to slide through every substring of this length.
     *
     * len_t = 3
     *
     * [c a a] b a b  -->  c [a a b] a b  -->  c a [a b a] b  -->  c a a [b a b]  -->
     *  ^   ^                 ^   ^                 ^   ^                 ^   ^
     *  |   |                 |   |                 |   |                 |   |
     *  l   r                 l   r                 l   r                 l   r
     *
     *
     * t = a b a
     * expected_freqs = [2 1 0 ... 0]
     *                   a b c     z
     *
     *
     *
     * @param s
     * @param t
     * @return count
     */
    public static Integer substring_anagrams(String s, String t) {
        // For a substring in s to be an anagram of t, it must have the same length as t (denoted as len_t).
        int len_s = s.length(), len_t = t.length();
        // just return 0, if the length of `t` exceeds / greater than the length of `s` since it is impossible to form an anagram of `t` from the substrings of `s`.
        if (len_t > len_s) {
            return 0;
        }

        // we need a way to store the frequencies of the characters in string t. We could use a hash map for this, or an array, expected_freqs, to store the frequencies of each character in string t.
        int[] expected_freqs = new int[26]; // expected_freqs is an integer array of size 26, with each index representing one of the lowercase English letters (0 for 'a', 1 for 'b', and so on, up to 25 for 'z').
        for (char c : t.toCharArray()) { // char[] c = {'a', 'b', 'a'};
            // ASCII character 'a' 97, ASCII character 'b' 98, ASCII character 'c' 99;
            // expected_freqs['a' 97 - 'a' 97] = 0; expected_freqs[0] = expected_freqs[0] + 1; int[] expected_freqs = {1, 0, 0, ... 0};
            // expected_freqs['b' 98 - 'a' 97] = 1; expected_freqs[1] = expected_freqs[1] + 1; int[] expected_freqs = {1, 1, 0, ... 0};
            // expected_freqs['a' 97 - 'a' 97] = 0; expected_freqs[0] = expected_freqs[0] + 1; int[] expected_freqs = {2, 1, 0, ... 0};
            expected_freqs[c - 'a'] += 1;
        } // expected_freqs = {2, 1, 0, ... 0}  |  [a, b, c, ... z]

        // To set up the sliding window algorithm, let’s define the following components:
        int left = 0, right = 0; // (1) Left and right pointers: Initialize both at the start of the string to define the window's boundaries.
        int[] window_freqs = new int[26]; // (2) window_freqs: Use an array of size 26 to keep track of the frequencies of characters within the window.
        int count = 0; // (3) count: Maintain a variable to count the number of anagrams detected.

        // Before we slide the window, we first need to expand it to a fixed length of len_t. This can be done by advancing the right pointer until the window length is equal to len_t.
        while (right < len_s) {

            // ASCII character 'a' 97, ASCII character 'b' 98, ASCII character 'c' 99;
            // (1) window_freqs[`s.charAt(0 right)` 'c' 99 - 'a' 97] = 2; window_freqs[2] = window_freqs[2] + 1; int[] window_freqs = {0, 0, 1, ... 0};
            // (2) window_freqs[`s.charAt(1 right)` 'a' 97 - 'a' 97] = 0; window_freqs[0] = window_freqs[0] + 1; int[] window_freqs = {1, 0, 1, ... 0};
            // (3) window_freqs[`s.charAt(2 right)` 'a' 97 - 'a' 97] = 0; window_freqs[0] = window_freqs[0] + 1; int[] window_freqs = {2, 0, 1, ... 0};
            //        until the window length = 3 is equal to len_t = 3. satisfy the if statement below applies -> window_freqs[s.charAt(left) - 'a'] -= 1;
            // (5) window_freqs[`s.charAt(3 right)` 'b' 98 - 'a' 97] = 1; window_freqs[1] = window_freqs[1] + 1; int[] window_freqs = {2, 1, 0, ... 0}; count += 1 applies `isMatch = true`
            // (7) window_freqs[`s.charAt(4 right)` 'a' 97 - 'a' 97] = 0; window_freqs[0] = window_freqs[0] + 1; int[] window_freqs = {2, 1, 0, ... 0}; count += 1 applies `isMatch = true`
            // (9) window_freqs[`s.charAt(5 right)` 'b' 98 - 'a' 97] = 1; window_freqs[1] = window_freqs[1] + 1; int[] window_freqs = {1, 2, 0, ... 0};
            window_freqs[s.charAt(right) - 'a'] += 1;

            // range of indices, say from left to right (inclusive, meaning both left and right are part of the window). Adding 1: 2 - 0 + 1 = 3. This correctly tells us there are 3 elements in the window. Example: If left is 0 and right is 2, the elements of t:"aba" are at indices 0, 1, and 2. Hence if we are not adding 1, right - left would be 2 - 0 = 2. This gives you the distance between the pointers, not the count of elements.
            if ((right - left) + 1 == len_t) {
                boolean isMatch = true; // a match indicator.
                // one for each lowercase English letter requires only 26 comparisons so time complexity is constant O(1)
                for (int i = 0; i < 26; i++) { // this loop is for both window_freqs & expected_freqs comparison.
                    // when iterated here, once we have a single frequency count not matching for window & expected, we break the entire loop then tag the match identifier as no match. then proceed to moving left & right pointer adding +1 moving to the right, -1 at the index of the character in the window_freqs where the previous left was Then +1 at the index of the character in the window_freqs where the new right.
                    if (window_freqs[i] != expected_freqs[i]) {
                        isMatch = false;
                        break;
                    }
                }
                // check if it’s an anagram of t by checking if the expected_freqs and window_freqs arrays are the same.
                if (isMatch) {
                    count += 1;
                }

                // ASCII character 'a' 97, ASCII character 'b' 98, ASCII character 'c' 99;
                // (4) window_freqs[`s.charAt(0 left)` 'c' 99 - 'a' 97] = 2; window_freqs[2] = window_freqs[2] - 1; int[] window_freqs = {2, 0, 0, ... 0};
                // (6) window_freqs[`s.charAt(1 left)` 'a' 97 - 'a' 97] = 0; window_freqs[0] = window_freqs[0] - 1; int[] window_freqs = {1, 1, 0, ... 0};
                // (8) window_freqs[`s.charAt(2 left)` 'a' 97 - 'a' 97] = 0; window_freqs[0] = window_freqs[0] - 1; int[] window_freqs = {1, 1, 0, ... 0};
                // (10) window_freqs[`s.charAt(3 left)` 'b' 98 - 'a' 97] = 1; window_freqs[1] = window_freqs[1] - 1; int[] window_freqs = {1, 1, 0, ... 0};
                window_freqs[s.charAt(left) - 'a'] -= 1;

                left += 1; // we advance the left, only when If the window has reached the expected fixed length which is lenT:3
            }

            right += 1; // we advance the right, only when right < lenS: 6 which is up until 5.
        }

        return count;
    }
}
