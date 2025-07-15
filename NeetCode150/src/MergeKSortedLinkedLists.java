import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for(ListNode head : lists){
            if (head != null){
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null){
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
