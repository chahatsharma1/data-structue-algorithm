import java.util.*;

public class GridColoring {
    int MOD = 1_000_000_007;
    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        genStates(m, 0, new int[m], states);

        int S = states.size();
        List<Integer>[] compat = new ArrayList[S];

        for (int i = 0; i < S; i++) {
            compat[i] = new ArrayList<>();
        }

        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (isCompat(states.get(i), states.get(j))) {
                    compat[i].add(j);
                }
            }
        }

        long[] dp = new long[S];
        Arrays.fill(dp, 1);
        for (int col = 1; col < n; col++) {
            long[] next = new long[S];
            for (int s = 0; s < S; s++) {
                long val = dp[s];
                if (val == 0) continue;
                for (int t : compat[s]) {
                    next[t] = (next[t] + val) % MOD;
                }
            }
            dp = next;
        }

        long ans = 0;
        for (long v : dp) {
            ans = (ans + v) % MOD;
        }
        return (int) ans;
    }

    private void genStates(int m, int row, int[] cur, List<int[]> out) {
        if (row == m) {
            out.add(cur.clone());
            return;
        }
        for (int c = 0; c < 3; c++) {
            if (row > 0 && cur[row - 1] == c) continue;
            cur[row] = c;
            genStates(m, row + 1, cur, out);
        }
    }

    private boolean isCompat(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == b[i]) {
                return false;
            }
        return true;
    }
}
