public class SortedListToBST {
    public TreeNode sorted(ListNode head){
        if (head == null){
            return null;
        }

        if (head.next == null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null){
            prev.next = null;
        }
        TreeNode root = new TreeNode(slow.val);

        root.left = sorted(head);
        root.right = sorted(slow.next);

        return root;
    }
}
