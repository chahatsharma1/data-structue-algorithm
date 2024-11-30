import java.util.PriorityQueue;

public class HireWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++, left++){
            leftHeap.add(costs[left]);
        }

        for (int i = 0; i < candidates && left <= right; i++, right--){
            rightHeap.add(costs[right]);
        }
        long cost = 0;

        for (int i = 0; i < k; i++){
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())){
                cost += leftHeap.poll();
                if (left <= right){
                    leftHeap.add(costs[left++]);
                }
            } else {
                cost += rightHeap.poll();
                if (left <= right){
                    rightHeap.add(costs[right--]);
                }
            }
        }
        return cost;
    }
}
