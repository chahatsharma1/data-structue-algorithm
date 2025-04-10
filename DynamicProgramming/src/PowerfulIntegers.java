public class PowerfulIntegers {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return count(finish, limit, s) - count(start - 1, limit, s);
    }

    private long count(long bound, long limit, String s){
        String num = String.valueOf(s);
        int n = num.length();
        Long[][][] dp = new Long[n + 1][2][2];
        return dfs(0, 1, 1, num, "", s, limit, dp);
    }

    private long dfs(int currentPosition, int insideLimit, int leadingZero, String num, String current, String suffix, int limit, Long[][][] dp){
        if (currentPosition == num.length()){
            String actual = current.replaceFirst("^0+", "");
            return actual.endsWith(suffix) ? 1 : 0;
        }
        if (dp[currentPosition][insideLimit][leadingZero] != null){
            return dp[currentPosition][insideLimit][leadingZero];
        }

    }
}
