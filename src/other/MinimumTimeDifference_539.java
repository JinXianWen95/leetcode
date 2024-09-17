package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>(timePoints.size());

        for (String time : timePoints) {
            minutes.add(getMinutes(time));
        }
        Collections.sort(minutes);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            result = Math.min(result, minutes.get(i) - minutes.get(i-1));
        }
        return Math.min(result, 60*24 - minutes.get(minutes.size()-1) - minutes.get(0));
    }

    private int getMinutes(String time) {
        String[] minimum = time.split(":");
        return Integer.parseInt(minimum[0]) * 60 + Integer.parseInt(minimum[1]);
    }
}
