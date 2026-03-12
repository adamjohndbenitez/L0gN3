package scotiadigital.chatgpt.livecodility.Xcodilitytechnicalinterviewtaskone;

import java.util.*;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {
        // Implement your solution here
        // We are counting the frequency of the chars.
        Map<Character, Integer> freqs = new HashMap<>();

        // 2 pointer algo
        int left = 0, right = S.length();

        // convert S to charArr.
        char[] charArr = S.toCharArray();

        // dynamic sliding window
        while (left < right) {

            //
            if (charArr[left] == charArr[right]) {
                left++;
                right--;

            } else {
                break;
            }


        }

        return "";
    }
}
