import org.junit.jupiter.api.Test;

public class PalindromeLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void run() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);

        boolean answer = isPalindrome(head);
        System.out.println(answer);
    }

    private boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode rev = new ListNode(-1);

        while (fast != null) {
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
                rev = new ListNode(slow.val, rev);
            }
            slow = slow.next;
        }

        while (slow != null && rev.val > -1) {
            if (slow.val != rev.val) {
                return false;
            }

            slow = slow.next;
            rev = rev.next;
        }

        return true;
    }

}
