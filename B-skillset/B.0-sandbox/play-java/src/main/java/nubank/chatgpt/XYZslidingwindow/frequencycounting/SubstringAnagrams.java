package nubank.chatgpt.XYZslidingwindow.frequencycounting;

/**
 *
 *
 * only the frequency of each letter to check if a window is an anagram of t.
 * By comparing the frequency of each character in a window against the frequencies of characters in string t, we can determine if that window is an anagram of t.
 *
 *
 */
public class SubstringAnagrams {

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

    public static Integer substring_anagrams(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        // A small optimization we can make is returning 0 if t's length exceeds the length of s because forming an anagram of t from the substrings of s is impossible if t is longer.
        if (lenT > lenS) {
            return 0;
        }
        int count = 0; // count: Maintain a variable to count the number of anagrams detected.
        //  we need a way to store the frequencies of the characters in string t. expected_freqs, to store the frequencies of each character in string t.
        int[] expectedFreqs = new int[26]; // expected_freqs is an integer array of size 26, with each index representing one of the lowercase English letters (0 for 'a', 1 for 'b', and so on, up to 25 for 'z').
        int[] windowFreqs = new int[26]; // window_freqs: Use an array of size 26 to keep track of the frequencies of characters within the window.

        // Populate 'expectedFreqs' with the characters in string 't'.
        for (char c : t.toCharArray()) {
            expectedFreqs[c - 'a'] += 1;
        }

        // To set up the sliding window algorithm, let’s define the following components:
        int left = 0, right = 0; // Left and right pointers: Initialize both at the start of the string to define the window's boundaries.
        while (right < lenS) {
            // Add the character at the right pointer to 'windowFreqs' before sliding the
            // window.
            // ASCII character 'a' 97, ASCII character 'b' 98, ASCII character 'c' 99;
            //      Before we slide the window, we first need to expand it to a fixed length of len_t(lenT).
            // `s.charAt(0 right)` 'c' 99 - 'a' 97 fixed = 2 index; windowFreqs[2 index] = windowFreqs[2 index] + 1; [0, 0, 1 ... 0] == [a, b, c ... z]; left is still 0 here, only moving right +1. window length = 1
            // `s.charAt(1 right)` 'a' 97 - 'a' 97 fixed = 0 index; windowFreqs[0 index] = windowFreqs[0 index] + 1; [1, 0, 1 ... 0] == [a, b, c ... z]; left is still 0 here, only moving right +1. window length = 2
            // `s.charAt(2 right)` 'a' 97 - 'a' 97 fixed = 0 index; windowFreqs[0 index] = windowFreqs[0 index] + 1; [2, 0, 1 ... 0] == [a, b, c ... z]; left is still 0 here, only moving right +1. window length = 3
            //        until the window length = 3 is equal to len_t = 3.
            // `s.charAt(3 right)` 'b' 98 - 'a' 97 fixed = 1 index; windowFreqs[1 index] = windowFreqs[1 index] + 1; [2, 1, 1 ... 0] == [a, b, c ... z]
            // `s.charAt(4 right)` 'a' 97 - 'a' 97 fixed = 0 index; windowFreqs[0 index] = windowFreqs[0 index] + 1; [1, 1, 1 ... 0] == [a, b, c ... z]
            // `s.charAt(5 right)` 'b' 98 - 'a' 97 fixed = 1 index; windowFreqs[1 index] = windowFreqs[1 index] + 1; [2, 2, 1 ... 0] == [a, b, c ... z]
            windowFreqs[s.charAt(right) - 'a'] += 1;
            // If the window has reached the expected fixed length, we advance the left
            // pointer as well as the right pointer to slide the window.
            if (right - left + 1 == lenT) { // For a substring in s to be an anagram of t, it must have the same length as t (denoted as len_t).
                boolean isMatch = true;
                for (int i = 0; i < 26; i++) {
                    // windowFreqs[0] 2 != expectedFreqs[0] 2 -> false, since if statement is false just skipped & proceed to next i which is 1
                    // windowFreqs[1] 0 != expectedFreqs[1] 1 -> true, since if statement is true, isMatch = false & break the loop.
                    if (windowFreqs[i] != expectedFreqs[i]) { // if the expected_freqs and window_freqs arrays are NOT the same
                        isMatch = false;
                        break;
                    }
                }
                // we can check if it’s an anagram of t by checking if the expected_freqs and window_freqs arrays are the same.
                if (isMatch) {
                    count += 1;
                }
                // Remove the character at the left pointer from 'windowFreqs' before
                // advancing the left pointer.
                // windowFreqs[s.charAt(0 left) 'c' 99 - 'a' 97]
                // windowFreqs[99 - 97 = 2]
                // windowFreqs[2] = windowFreqs[2] - 1; whatever value is in index 2 will be deducted and store back itself on index 2.
                windowFreqs[s.charAt(left) - 'a'] -= 1;
                left += 1; // we advance the left, only when If the window has reached the expected fixed length which is lenT:3
            }
            right += 1; // we advance the right, only when right < lenS: 6 which is up until 5.
        }

        return count; // Once we’ve finished processing all substrings of length len_t, we can return count, which represents the number of anagrams found.
    }
}
