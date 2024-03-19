package list.linkedList;

import java.util.Objects;

public class DeleteNodeInLinkedList_237 {
    // since the node value is unique, we could save the value of nodeToDelete.next in nodeToDelete and delete .next
    // to achieve the same effect
    public void deleteNode(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
