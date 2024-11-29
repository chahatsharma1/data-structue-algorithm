import java.util.PriorityQueue;
import java.util.HashSet;

public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> pq;
    private final HashSet<Integer> set;
    private int nextSmallest;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if (num < nextSmallest && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}
