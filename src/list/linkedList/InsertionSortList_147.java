package list.linkedList;

import java.util.Objects;

public class InsertionSortList_147 {

    public static void main(String[] args) {
        ListNode head = parseToLinkedList(new int[] {4,2,1,3});
        ListNode result = new InsertionSortList_147().insertionSortList(head);
    }

    private static ListNode parseToLinkedList(int[] nums) {
        ListNode ret = new ListNode();
        ListNode cur = ret;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return ret.next;
    }
    public ListNode insertionSortList(ListNode head) {
        // base case
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // ordering
        ListNode dummy = new ListNode();
        ListNode curr = head.next;
        dummy.next = head;
        head.next = null; // the first node does not need to be sorted
        ListNode next;
        while (Objects.nonNull(curr)) {
            next = curr.next;
            ListNode position = findInsertionPosition(dummy, curr);
            insertNode(position, curr);
            curr = next;
        }
        return dummy.next;
    }

    private void printNodeList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(head)) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        System.out.println(sb);
    }

    private ListNode findInsertionPosition(ListNode prev, ListNode curr) {
        while (Objects.nonNull(prev.next) && curr.val > prev.next.val) {
            prev = prev.next;
        }
        return prev;
    }

    private void insertNode(ListNode prev, ListNode cur) {
        cur.next = prev.next;
        prev.next = cur;
    }
}
