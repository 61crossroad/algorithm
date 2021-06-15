import org.junit.jupiter.api.Test;

public class MergeKSortedLists {
    
    @Test
    public void run() {
        ListNode[] input = new ListNode[3];
        ListNode c = new ListNode(5);
        ListNode b = new ListNode(4, c);
        ListNode a = new ListNode(1, b);
        input[0] = a;
        c = new ListNode(4);
        b = new ListNode(3, c);
        a = new ListNode(1, b);
        input[1] = a;
        b = new ListNode(6);
        a = new ListNode(2, b);
        input[2] = a;

        ListNode answer = mergeKLists(input);
        for (; answer != null; answer = answer.next) {
            System.out.print(answer.val + " -> ");
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;
        ListNode end = null;

        while (true) {
            boolean isEmpty = true;
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min.val) {
                    isEmpty = false;
                    min = lists[i];
                    index = i;
                }
            }

            if (!isEmpty) {
                if (answer == null) {
                    ListNode pop = lists[index];
                    lists[index] = pop.next;
                    pop.next = null;
                    answer = pop;
                    end = pop;
                } else {
                    ListNode pop = lists[index];
                    lists[index] = pop.next;
                    pop.next = null;
                    end.next = pop;
                    end = pop;
                }
            } else {
                break;
            }
        }

        return answer;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
