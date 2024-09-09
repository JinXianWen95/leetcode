package array;

import java.util.Arrays;

public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2]; // number of 5, 10
        for (int bill : bills) {
            if (bill == 20) {
                if (money[1] == 0) {
                    money[0] -= 3;
                } else {
                    money[1]--;
                    money[0]--;
                }
            } else if (bill == 10) {
                money[0]--;
                money[1]++;
            } else {
                money[0]++;
            }

            if (money[0] < 0 || money[1] < 0) {
                return false;
            }
        }
        return true;
    }
}
