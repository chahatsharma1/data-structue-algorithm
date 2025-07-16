public class ReverseKGroupInLL {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) {
                break;
            }
            ListNode groupNext = kthNode.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode tempNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNext;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kthNode;

            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}