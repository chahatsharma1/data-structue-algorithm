public class NumberOfSmoothDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        long count = 1;   
        long length = 1;  

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                length++;
            } else {
                length = 1;
            }
            count += length;
        }
        return count;
    }
}