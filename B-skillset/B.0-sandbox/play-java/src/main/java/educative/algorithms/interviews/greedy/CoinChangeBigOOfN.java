package educative.algorithms.interviews.greedy;

/**
 *
 * For the greedy coin change algorithm provided, the time complexity is O(n), where n is the number of coins used to make the change (not the number of coin denominations).
 *
 * Here’s why:
 *
 * The outer loop iterates through each coin denomination (which is usually a small, constant number).
 * The inner while loop subtracts coins from the amount until it can’t anymore. In the worst case, it could run as many times as the amount itself (if you only have coins of 1).
 *
 */
public class CoinChangeBigOOfN {
        public static void makeChange(int amount, int[] coins) {
            System.out.println("Coins used to make change for " + amount + ":");
            for (int coin : coins) {
                while (amount >= coin) {
                    amount -= coin;
                    System.out.print(coin + " ");
                }
            }
            System.out.println();
        }

        public static void main(String[] args) {
//            int[] coins = {25, 10, 5, 1}; // US coin denominations
            int[] coins = {10, 25, 1, 5};
            int amount = 63;
            makeChange(amount, coins);
        }
}
