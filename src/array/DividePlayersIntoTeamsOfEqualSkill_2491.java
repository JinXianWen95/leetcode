package array;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill_2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int left = 0;
        int right = skill.length - 1;
        long pairSum = skill[left] + skill[right];
        long result = (long) skill[left++] * (long) skill[right--];
        while (left < right) {
            if (skill[left] + skill[right] != pairSum) {
                return -1;
            }
            result += (long) skill[left++] * (long) skill[right--];
        }

        return result;
    }
}
