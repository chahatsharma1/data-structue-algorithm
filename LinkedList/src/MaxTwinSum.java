public class MaxTwinSum {
    public int pairSum(ListNode head) {
        if (head == null){
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseLinkedList(slow);

        int max = 0;
        ListNode firstHalf = head;

        while (secondHalf != null){
            max = Math.max(max, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return max;
    }

    private ListNode reverseLinkedList(ListNode slow) {
        ListNode prev = null;
        while (slow != null){
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        return prev;
    }
}
