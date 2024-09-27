package other;

import java.util.*;

public class MyCalendar1_729 {
    Set<int[]> timeSlots;

    public MyCalendar1_729() {
        timeSlots = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
    }

    public boolean book(int start, int end) {
        for (int[] slot : timeSlots) {
            if ((start > slot[0] && start < slot[1]) ||
                    start == slot[0] ||
                    (start < slot[0] && end > slot[0])) {
                return false;
            }
        }
        timeSlots.add(new int[]{start, end});
        return true;
    }
}
