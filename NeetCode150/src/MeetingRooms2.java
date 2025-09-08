import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals.getFirst().end);

        for (int i = 1; i < intervals.size(); i++) {
            if (!minHeap.isEmpty() && intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals.get(i).end);
        }

        return minHeap.size();
    }
}
