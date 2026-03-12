package scotiadigital.chatgpt.livecodility.Aarrayshashmap;

/**
 *
 * First, I check if the strings have different lengths. If they do, they cannot be anagrams. Then I use a frequency array of size 26 to count occurrences of each character. I increment the count for characters in the first string and decrement for characters in the second string. If the strings are anagrams, all counts should return to zero.
 *
 */
public class DValidAnagram {

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println("Input: s = " + s + ", t = " + t);
        DValidAnagram anagram = new DValidAnagram();
        System.out.println("Output: " + anagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        // Step 1: If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // Step 2: Create a frequency counter for letters a-z
        // Since we only have 26 lowercase letters, we use a fixed array
        int[] count = new int[26]; // O(1) (constant space complexity) The array size is fixed: It does not grow with input size, so it is constant space.

        // Step 3: Count characters from the first string
        // Example: "anagram"
        for (char c : s.toCharArray()) count[c - 'a']++; // count characters in s → O(n) (linear time complexity)

        // Step 3: Count characters from the first string
        // Example: "anagram"
        for (char c : t.toCharArray()) count[c - 'a']--; // subtract characters in t → O(n) (linear time complexity)

        // Step 5: Verify all frequencies return to zero
        // If any index is not zero, characters do not match
        for (int n : count) {
            if (n != 0) return false;
        }

        // All character frequencies matched
        return true;
    }
}
