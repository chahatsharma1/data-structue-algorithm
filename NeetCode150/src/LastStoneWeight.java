import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b -a);

        for (int num : stones){
            maxHeap.add(num);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                int x = maxHeap.poll();
                if(x != y){
                    maxHeap.offer(y - x);
                }
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}