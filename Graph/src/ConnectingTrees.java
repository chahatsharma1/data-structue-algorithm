import java.util.*;

public class ConnectingTrees {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] ans = new int[edges1.length + 1];
        List<List<Integer>> graph1 = buildGraph(edges1);
        List<List<Integer>> graph2 = buildGraph(edges2);
        int maxReachableInGraph2 = 0;

        if (k > 0)
            for (int i = 0; i < edges2.length + 1; ++i)
                maxReachableInGraph2 = Math.max(maxReachableInGraph2, dfs(graph2, i, -1, k - 1));

        for (int i = 0; i < edges1.length + 1; ++i)
            ans[i] = maxReachableInGraph2 + dfs(graph1, i, -1, k);

        return ans;
    }

    private int dfs(List<List<Integer>> graph, int u, int prev, int k) {
        if (k == 0)
            return 1;
        int res = 0;
        for (int v : graph.get(u)) {
            if (v != prev) {
                res += dfs(graph, v, u, k - 1);
            }
        }
        return 1 + res;
    }

    private List<List<Integer>> buildGraph(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; ++i)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
