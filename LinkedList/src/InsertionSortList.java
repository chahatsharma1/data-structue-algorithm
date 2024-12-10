public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null){
            ListNode prev = dummy;
            ListNode next = current.next;

            while (prev.next != null && prev.next.val < current.val){
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        return dummy.next;
    }
}
