package nubank.chatgpt.Atwosum.time;

public class LinearTimeVSQuadraticTime {
    public static void main(String[] args) {
        int n = 50000;

        // O(n) - Linear Time
        long startN = System.nanoTime();
        long sumN = 0;
        for (int i = 0; i < n; i++) {
            sumN += i;
        }
        long endN = System.nanoTime();
        System.out.println("Linear O(n) took: " + (endN - startN) / 1_000_000.0 + " ms (Result: " + sumN + ")");

        // O(n^2) - Quadratic Time
        long startN2 = System.nanoTime();
        long sumN2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumN2 += (i + j);
            }
        }
        long endN2 = System.nanoTime();
        System.out.println("Quadratic O(n^2) took: " + (endN2 - startN2) / 1_000_000.0 + " ms (Result: " + sumN2 + ")");
    }
}
