package list.linkedList;

import java.util.Objects;

public class SortList_148 {

    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(), temp = ret;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val >= l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if (Objects.nonNull(l1)) {
            temp.next = l1;
        }
        if (Objects.nonNull(l2)) {
            temp.next = l2;
        }
        return ret.next;
    }

}
