package codility;

class SolutionAJ {
    public int solution(int[] A) {
        // Implement your solution here
        int spi = 0;
        int[] lesserValues = new int[A.length];
        // Calculating the lesser values of each.
        for (int i = 0; i < A.length; i++) {
            lesserValues[i] = A[i] - 1;
        }
        // Comparing both given A to lesser values.
        for (int i = 0; i < A.length; i++) {

        }
        return spi;
    }

    public static void main(String[] args) {
        SolutionAJ s = new SolutionAJ();
        int spi = s.solution(new int[]{1, 3, 6, 4, 1, 2});
//        int spi = s.solution(new int[]{1, 2, 3});
//        int spi = s.solution(new int[]{-1, -3});
//        int spi = s.solution(new int[]{88, 99});
        System.out.println("spi: " + spi);
    }
}

