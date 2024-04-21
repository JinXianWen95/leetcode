package other;

import java.util.Iterator;
import java.util.Objects;

public class PeekingIterator_284 implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iterator;
    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (hasNext()) {
            this.next = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer cur = this.next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }
        return cur;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(next) || iterator.hasNext();
    }
}
