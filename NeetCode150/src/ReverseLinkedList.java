public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode current = head;

        while(current != null){
            ListNode temp = current.next;
            current.next = dummy;
            dummy = current;
            current = temp;
        }
        return dummy;
    }
}
