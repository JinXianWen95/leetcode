package list.linkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray_3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>(nums.length);
        for (int num : nums) {
            numbers.add(num);
        }

        // skip the start nodes with val in array
        ListNode prev = head;
        while (prev != null && numbers.contains(prev.val)) {
            prev = prev.next;
        }
        head = prev;
        ListNode curr = prev.next;
        while (curr != null) {
            if (numbers.contains(curr.val)) {
                curr = curr.next;
            } else {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        // skip the end nodes with val in array
        prev.next = null;

        return head;
    }
}
