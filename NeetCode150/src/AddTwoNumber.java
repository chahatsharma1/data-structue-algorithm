public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int firstNumber = (l1 != null) ? l1.val : 0;
            int secondNumber = (l2 != null) ? l2.val : 0;

            int sum = firstNumber + secondNumber + carry;
            carry = sum / 10;
            int ans = sum % 10;

            newHead.next = new ListNode(ans);
            newHead = newHead.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}