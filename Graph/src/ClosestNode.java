import java.util.*;

public class ClosestNode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);
        
        int minDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }
        
        return result;
    }

    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        int current = start, d = 0;
        while (current != -1 && dist[current] == -1) {
            dist[current] = d++;
            current = edges[current];
        }

        return dist;
    }
}
