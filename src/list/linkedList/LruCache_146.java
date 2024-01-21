import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class LRUCache {
    private Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode valueNode = cache.get(key);
        // move the node to the head
        deleteNode(valueNode);
        addNode(valueNode);
        return valueNode.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode cacheNode = cache.get(key);
        // existing key just update its value and update its position in the list
        if (!Objects.isNull(cacheNode)) {
            cacheNode.value = value;
            deleteNode(cacheNode);
            addNode(cacheNode);
            return;
        }
        // a new key-value pair, if the list is full remove the least used item from list and cache
        if (size == capacity) {
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        // insert the node at the head and add it to the cache
        DoubleLinkedNode mostRecentNode = new DoubleLinkedNode(key, value);
        addNode(mostRecentNode);
        cache.put(key, mostRecentNode);
    }

    public void deleteNode(DoubleLinkedNode node) {
        DoubleLinkedNode temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
        size--;
    }

    // the node is always added to head and is the most recently used node
    private void addNode(DoubleLinkedNode node) {
        DoubleLinkedNode temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
        size++;
    }

    // double linked node for linked list
    private static class DoubleLinkedNode {
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        int value;
        int key;
        public DoubleLinkedNode() {
            prev = null;
            next = null;
        }

        public DoubleLinkedNode(int key, int value) {
            prev = null;
            next = null;
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */