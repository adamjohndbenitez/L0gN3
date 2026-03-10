package nubank.chatgpt.slidingwindow.frequencycounting;

public class SubstringAnagramsClean {

    public static void main(String[] args) {
        String s = "caabab";
        String t = "aba";

        System.out.println("Input: s = '" + s + "', t = '" + t + "'");
        int output = substring_anagrams(s, t);
        System.out.println("Output: " + output);
    }

    public static Integer substring_anagrams(String s, String t) {
        int len_s = s.length(), len_t = t.length();
        if (len_t > len_s) {
            return 0;
        }
        int[] expected_freqs = new int[26];
        for (char c : t.toCharArray()) {
            expected_freqs[c - 'a'] += 1;
        }
        int left = 0, right = 0;
        int[] window_freqs = new int[26];
        int count = 0;
        while (right < len_s) {
            window_freqs[s.charAt(right) - 'a'] += 1;
            if ((right - left) + 1 == len_t) {
                boolean isMatch = true;
                for (int i = 0; i < 26; i++) {
                    if (window_freqs[i] != expected_freqs[i]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    count += 1;
                }
                window_freqs[s.charAt(left) - 'a'] -= 1;
                left += 1;
            }
            right += 1;
        }
        return count;
    }
}
