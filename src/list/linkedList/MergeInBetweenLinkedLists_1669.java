package list.linkedList;

public class MergeInBetweenLinkedLists_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // note that 1 <= a < b < list1.length, so we don't care about edge cases
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        // a should be removed, get its prev
        ListNode list1A = getNodeByPosition(list1, a-1);
        // b should be removed, get its next
        ListNode list1B = getNodeByPosition(list1, b+1);

        list1A.next = list2;
        list2Tail.next = list1B;

        return list1;

    }

    private ListNode getNodeByPosition(ListNode list, int position) {
        ListNode node = list;
        while (position > 0) {
            node = node.next;
            position--;
        }
        return node;
    }
}
