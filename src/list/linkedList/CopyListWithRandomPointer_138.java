package list.linkedList;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {
    public Node copyRandomList(Node head) {
        /* FIRST SOLUTION */
        // first create all copied nodes with val (and without next and random)
        Map<Node, Node> nodeMap = copyAllNodes(head);
        // put in the map null key/value so that we have uniform code for null next/random case
        nodeMap.put(null, null);
        // for each copied node set next and random
        for (Map.Entry<Node, Node> entry : nodeMap.entrySet()) {
            if (entry.getKey() == null) {
                continue;
            }
            entry.getValue().next = nodeMap.get(entry.getKey().next);
            entry.getValue().random = nodeMap.get(entry.getKey().random);
        }
        // return nodeMap.get(head);

        /* SECOND SOLUTION */
        // interweave the original list with new nodes
        if (head == null) {
            return null;
        }
        interweave(head);
        return assignRandomAndExtractCopiedList(head);

    }

    private Map<Node, Node> copyAllNodes(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        while (head != null) {
            nodeMap.put(head, new Node(head.val));
            head = head.next;
        }
        return nodeMap;
    }

    private void interweave(Node head) {
        while (head != null) {
            Node temp = head.next;
            head.next = new Node(head.val);
            head.next.next = temp;
            head = temp;
        }
    }

    private Node assignRandomAndExtractCopiedList(Node head) {
        // assign random to copied nodes
        Node curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node oldCurr = head;
        Node newCurr = head.next;
        // extract copied nodes
        while (oldCurr != null) {
            oldCurr.next = oldCurr.next.next;
            newCurr.next = newCurr.next != null ? newCurr.next.next : null;
            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

}
