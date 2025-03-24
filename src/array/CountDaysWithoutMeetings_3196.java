package array;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings_3196 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int latestEnd = 0;
        for (int i = 0; i < meetings.length; i++) {
            result += Math.max(meetings[i][0] - latestEnd - 1, 0);
            latestEnd = Math.max(latestEnd, meetings[i][1]);
        }
        result += days - latestEnd;

        return result;
    }
}
