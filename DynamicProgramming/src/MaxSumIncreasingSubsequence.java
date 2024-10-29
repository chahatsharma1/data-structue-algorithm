public class MaxSumIncreasingSubsequence {
    public int maxSumIS(int[] arr, int n) {
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n];
        System.arraycopy(arr, 0, dp, 0, n);

        for (int i = 1; i < n; i++){
            for (int j = 0; j < i ; j++) {
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        int sum = 0;
        for (int num : dp){
            sum = Math.max(sum, num);
        }
        return sum;
    }
}
