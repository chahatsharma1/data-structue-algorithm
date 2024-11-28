import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] arr : connections){
            int from = arr[0];
            int to = arr[1];

            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;
        int count = 0;

        while (!queue.isEmpty()){
            int city = queue.poll();

            for (int[] neighbor : graph.get(city)){
                int nextCity = neighbor[0];
                int direction = neighbor[1];
                if (!visited[nextCity]){
                    visited[nextCity] = true;
                    count += direction;
                    queue.add(nextCity);
                }
            }
        }
        return count;
    }
}
