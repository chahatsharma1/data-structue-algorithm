import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);

        for (int num : nums){
            add(num);
        }
    }

    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
        } else if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
