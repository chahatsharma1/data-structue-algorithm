public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode firstHead = head;
        ListNode secondHead = reverse(middle.next);
        middle.next = null;

        while(secondHead != null){
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = head.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = nextNode;

            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return prev;
    }
}
