public class BestTImeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] < prices[i]) {
                i = j; // Found a new lower price → update buy day
            } else {
                max = Math.max(max, prices[j] - prices[i]); // Track best profit
            }
        }
        return max;
    }
}
