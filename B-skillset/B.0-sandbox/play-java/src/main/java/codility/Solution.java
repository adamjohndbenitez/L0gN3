package codility;

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        boolean[] seen = new boolean[n + 2]; // we care about 1..n+1

        for (int x : A) {
            if (x > 0 && x <= n + 1) {
                seen[x] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!seen[i]) return i;
        }

        return n + 1; // fallback (won't really be reached)
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int spi = s.solution(new int[]{1, 3, 6, 4, 1, 2});
//        int spi = s.solution(new int[]{1, 2, 3});
//        int spi = s.solution(new int[]{-1, -3});
        int spi = s.solution(new int[]{88, 99});
        System.out.println("spi: " + spi);
    }
}

