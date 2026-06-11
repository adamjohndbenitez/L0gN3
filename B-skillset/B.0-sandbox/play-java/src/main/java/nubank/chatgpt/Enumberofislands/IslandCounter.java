package nubank.chatgpt.Enumberofislands;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class IslandCounter {

    public static void main(String[] args) {
        // 1. Create the outer ArrayList
        List<List<Integer>> matrix = new ArrayList<>();

        // 2. Create and populate each inner ArrayList (row)
        // Row 0: [1, 0, 1, 0]
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));

        // Row 1: [1, 1, 1, 0]
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0)));

        // Row 2: [0, 1, 0, 0]
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0)));

        // Row 3: [0, 0, 0, 0]
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));

        // Now you can call the count_islands function
        IslandCounter solver = new IslandCounter();
        int numberOfIslands = solver.count_islands(matrix);

        System.out.println("Number of islands: " + numberOfIslands); // Expected output: 2
    }
    public int count_islands(List<List<Integer>> matrix) {
        if (matrix == null || matrix.isEmpty()) return 0;
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If a land cell is found, perform DFS to explore the full island,
                // and include this island in our count.
                if (matrix.get(r).get(c) == 1) {
                    dfs(r, c, matrix);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, List<List<Integer>> matrix) {
        // Mark the current land cell as visited.
        matrix.get(r).set(c, -1);
        // Define direction vectors for up, down, left, and right.
        int[][] dirs = { /*up*/{-1, 0}, /*down*/{1, 0}, /*left*/{0, -1}, /*right*/{0, 1} };
        // Recursively call DFS on each neighboring land cell to continue exploring this island.
        for (int[] d : dirs) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (isWithinBounds(nextR, nextC, matrix) && matrix.get(nextR).get(nextC) == 1) {
                dfs(nextR, nextC, matrix);
            }
        }
    }

    private boolean isWithinBounds(int r, int c, List<List<Integer>> matrix) {
        return r >= 0 && r < matrix.size() &&
                c >= 0 && c < matrix.get(0).size();
    }
}
