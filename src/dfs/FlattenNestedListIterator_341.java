package dfs;

import java.util.*;

public class FlattenNestedListIterator_341 {

    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> deque;
        public NestedIterator(List<NestedInteger> nestedList) {
            deque = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return deque.pollFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!deque.isEmpty() && !deque.peekFirst().isInteger()) {
                List<NestedInteger> nestedIntegerList = deque.pollFirst().getList();
                for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                    deque.addFirst(nestedIntegerList.get(i));
                }
            }

            return !deque.isEmpty() && deque.peekFirst().getList().isEmpty();
        }
    }
}
