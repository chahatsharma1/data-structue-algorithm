import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()){
            int room = stack.pop();

            for (int key : rooms.get(room)){
                if (!visited[key]){
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean check : visited){
            if (!check){
                return false;
            }
        }
        return true;
    }
}
