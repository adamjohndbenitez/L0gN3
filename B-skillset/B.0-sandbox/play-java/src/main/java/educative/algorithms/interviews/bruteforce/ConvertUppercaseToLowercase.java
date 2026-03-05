package educative.algorithms.interviews.bruteforce;

public class ConvertUppercaseToLowercase {

        public static void main(String[] args) {
            String[] testInputs = {
                    "already lower",
                    "HELLO WORLD!",
                    "Hello123WORLD!",
                    "",
                    null,
                    "MiXeD CaSe 123!"
            };
            for (String input : testInputs) {
                System.out.println("Input: " + input);
                String recResult = recursiveDivideAndConquerToLower(input);
                System.out.println("Recursive Output: " + recResult);
                String iterResult = iterativeToLower(input);
                System.out.println("Iterative Output: " + iterResult);
                System.out.println();
            }
        }

        // Public API: recursive divide-and-conquer
        public static String recursiveDivideAndConquerToLower(String s) {
            if (s == null || s.isEmpty()) return s;
            char[] arr = s.toCharArray();
            return helper(arr, 0, arr.length - 1);
        }

        // Helper: recursive divide-and-conquer on char array and index range
        private static String helper(char[] arr, int left, int right) {
            if (left > right) return "";
            if (left == right) {
                char c = arr[left];
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + ('a' - 'A')); //'a'=97,'A'=65;97-65=32
                }
                return String.valueOf(c);
            }
            int mid = left + (right - left) / 2;
            String leftResult = helper(arr, left, mid);
            String rightResult = helper(arr, mid + 1, right);
            return leftResult + rightResult;
        }

        // Iterative baseline for comparison
        public static String iterativeToLower(String s) {
            if (s == null || s.isEmpty()) return s;
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + ('a' - 'A'));
                }
                sb.append(c);
            }
            return sb.toString();
        }


}
