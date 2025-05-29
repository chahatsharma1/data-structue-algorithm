import java.util.*;

public class ConnectingEvenTrees {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] graph1 = buildGraph(edges1, n);
        List<Integer>[] graph2 = buildGraph(edges2, m);

        int[] levels1 = new int[n];
        int evenCount1 = dfsSetLevels(graph1, 0, -1, 0, levels1);
        int[] targets1 = new int[n];
        for (int i = 0; i < n; i++)
            targets1[i] = (levels1[i] % 2 == 0) ? evenCount1 : n - evenCount1;

        int[] levels2 = new int[m];
        int evenCount2 = dfsSetLevels(graph2, 0, -1, 0, levels2);
        int maxTargets2 = Math.max(evenCount2, m - evenCount2);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = targets1[i] + maxTargets2;

        return ans;
    }

    private int dfsSetLevels(List<Integer>[] graph, int u, int parent, int level, int[] levels) {
        levels[u] = level;
        int evenCount = level % 2 == 0 ? 1 : 0;
        for (int v : graph[u]) {
            if (v != parent)
                evenCount += dfsSetLevels(graph, v, u, level + 1, levels);
        }
        return evenCount;
    }

    private List<Integer>[] buildGraph(int[][] edges, int size) {
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
