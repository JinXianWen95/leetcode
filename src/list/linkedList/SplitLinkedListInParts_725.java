package list.linkedList;

public class SplitLinkedListInParts_725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        int partSize = size / k;
        int remaining = size % k;

        ListNode[] result = new ListNode[k];
        ListNode prev = head;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode startingPart = curr;
            int currentSize = partSize;
            if (remaining > 0) {
                currentSize++;
                remaining--;
            }

            int j = 0;
            while (j < currentSize && curr != null) {
                prev = curr;
                curr = curr.next;
                j++;
            }

            // cut
            if (prev != null) {
                prev.next = null;
            }
            result[i] = startingPart;
        }

        return result;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
