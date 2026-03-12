package scotiadigital.chatgpt.livecodility.Aarrayshashmap;

import java.util.Arrays;

/**
 *
 * I iterate through the prices once while tracking the minimum price seen so far. For each price, I compute the profit if I sold on that day and update the maximum profit accordingly. This results in an O(n) time and O(1) space solution.
 *
 */
public class EBestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Prices: " + Arrays.toString(prices));
        EBestTimeToBuyAndSellStock e = new EBestTimeToBuyAndSellStock();
        System.out.println("Output: " + e.maxProfit(prices));
    }


    public int maxProfit(int[] prices) {

        // Step 1: Track the minimum stock price seen so far
        int minPrice = Integer.MAX_VALUE; // Why Space Complexity is O(1) (constant): We only store two variables, No extra memory grows with input size, since we only replace the value reassigning to the variable. Space = O(1) (Constant)

        // Step 2: Track the maximum profit found so far
        int maxProfit = 0;

        // Step 3: Iterate through each day's price
        for (int price : prices) { // Why Time Complexity is O(n) (Linear Time): We scan the array once.

            // Update the minimum price if we find a cheaper day to buy
            minPrice = Math.min(minPrice, price); // Each iteration performs constant operations: Math.min

            // Calculate profit if we sell today
            int profit = price - minPrice;

            // Update the maximum profit if this trade is better
            maxProfit = Math.max(maxProfit, profit); // Each iteration performs constant operations: Math.max
        }

        // Step 4: Return the best profit found
        return maxProfit;
    }
}
