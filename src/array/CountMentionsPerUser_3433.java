package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountMentionsPerUser_3433 {
  public static void main(String[] args) {
    new CountMentionsPerUser_3433().countMentions(3, List.of(List.of("MESSAGE","5","HERE"),
        List.of("OFFLINE","10","0"), List.of("MESSAGE","15","HERE"), List.of("OFFLINE","18","2")));
  }


  public int[] countMentions(int numberOfUsers, List<List<String>> events) {
    List<List<String>> copyEvents = new ArrayList<>(events);
    copyEvents.sort(
        Comparator.comparing((List<String> a) -> Integer.parseInt(a.get(1)))
            // if offline and message have the same timestamp, we should first process offline event
            .thenComparing((List<String> a) -> a.get(0), Comparator.reverseOrder()));
    int[] result = new int[numberOfUsers];

    int[] userOfflineTimestamp = new int[numberOfUsers]; // 0 means online
    int countAll = 0;

    for (List<String> event : copyEvents) {
      if (event.get(0).equals("MESSAGE")) {
        if (event.get(2).equals("ALL")) {
          countAll++;
        } else if (event.get(2).equals("HERE")) {
          for (int i = 0; i < userOfflineTimestamp.length; i++) {
            if (userOfflineTimestamp[i] == 0 || userOfflineTimestamp[i] <= Integer.parseInt(event.get(1)) - 60) {
              result[i]++;
              userOfflineTimestamp[i] = 0;
            }
          }
        } else {
          String[] ids = event.get(2).split(" ");
          for (String id : ids) {
            result[Integer.parseInt(id.substring(2))]++;
          }
        }
      } else { // offline event
        int id = Integer.parseInt(event.get(2));
        userOfflineTimestamp[id] = Integer.parseInt(event.get(1));
      }
    }

    for (int i = 0; i < result.length; i++) {
      result[i] += countAll;
    }

    return result;
  }
}
