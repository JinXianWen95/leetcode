package other;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MyCalendar2_731 {

    Set<int[]> bookings;
    Set<int[]> ovelappings;

    public MyCalendar2_731() {
        bookings = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        ovelappings = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
    }

    public boolean book(int start, int end) {
        for (int[] slot : ovelappings) {
            if (Math.max(slot[0], start) < Math.min(slot[1], end)) {
                return false;
            }
        }
        insert(start, end);
        return true;
    }

    private void insert(int start, int end) {
        for (int[] slot : bookings) {
            if (Math.max(slot[0], start) < Math.min(slot[1], end)) {
                ovelappings.add(new int[]{Math.max(start, slot[0]), Math.min(end, slot[1])});
            }
        }
        bookings.add(new int[]{start, end});
    }
}
