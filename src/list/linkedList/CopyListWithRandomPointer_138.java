package list.linkedList;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {
    public Node copyRandomList(Node head) {
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
        return nodeMap.get(head);
    }

    private Map<Node, Node> copyAllNodes(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        while (head != null) {
            nodeMap.put(head, new Node(head.val));
            head = head.next;
        }
        return nodeMap;
    }

}
