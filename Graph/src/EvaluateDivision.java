import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!graph.containsKey(c) || !graph.containsKey(d)){
                ans[i] = -1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                ans[i] = dfs(c, d, graph, visited, 1.0);
            }
        }
        return ans;
    }

    private double dfs(String current, String end, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited, double value){
        if (current.equals(end)){
            return value;
        }

        visited.add(current);

        HashMap<String, Double> adj = graph.get(current);
        for (String string : adj.keySet()){
            if (!visited.contains(string)){
                double ans = dfs(string, end, graph, visited, value * adj.get(string));
                if (ans != -1.0){
                    return ans;
                }
            }
        }
        return -1.0;
    }
}
