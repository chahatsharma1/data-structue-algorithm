import java.util.*;

public class MinimumScoreAfterRemovalOfTree {
    private List<Integer>[] tree;
    private int[] nums;
    private int[] xorSubtree;
    private int[] in, out;
    private int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        tree = new ArrayList[n];
        xorSubtree = new int[n];
        in = new int[n];
        out = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        int totalXor = dfs(0, -1);

        List<int[]> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            if (in[e[0]] > in[e[1]]) {
                edgeList.add(new int[]{e[0], e[1]});
            } else {
                edgeList.add(new int[]{e[1], e[0]});
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < edgeList.size(); i++) {
            for (int j = i + 1; j < edgeList.size(); j++) {
                int[] e1 = edgeList.get(i);
                int[] e2 = edgeList.get(j);

                int x = e1[0];
                int y = e2[0];
                int a;
                int b;
                int c;

                if (isAncestor(x, y)) {
                    a = xorSubtree[y];
                    b = xorSubtree[x] ^ xorSubtree[y];
                    c = totalXor ^ xorSubtree[x];
                } else if (isAncestor(y, x)) {
                    a = xorSubtree[x];
                    b = xorSubtree[y] ^ xorSubtree[x];
                    c = totalXor ^ xorSubtree[y];
                } else {
                    a = xorSubtree[x];
                    b = xorSubtree[y];
                    c = totalXor ^ xorSubtree[x] ^ xorSubtree[y];
                }

                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    private int dfs(int node, int parent) {
        in[node] = time++;
        xorSubtree[node] = nums[node];
        for (int nei : tree[node]) {
            if (nei == parent) {
                continue;
            }
            xorSubtree[node] ^= dfs(nei, node);
        }
        out[node] = time++;
        return xorSubtree[node];
    }

    private boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }
}
