package slidingWindow;

public class FruitIntoBaskets_904 {
    public static void main(String[] args) {
        new FruitIntoBaskets_904().totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4});
    }
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }

        int fruitALastIndex = -1;
        int fruitBLastIndex = -1;
        int fruitA = -1;
        int fruitB = -1;
        int result = 0;
        int count = 0;

        for (int i = 0; i < fruits.length; i++) {
            // initialize and update the last two type fruit and their last index
            if (fruitA == -1 || fruitA == fruits[i]) {
                fruitA = fruits[i];
                fruitALastIndex = i;
            } else if ((fruitB == -1 && fruits[i] != fruitA) || fruits[i] == fruitB) {
                fruitB = fruits[i];
                fruitBLastIndex = i;
            }

            // when encounter the third fruit type, shrink the window
            if (fruitA != -1 && fruitB != -1 && fruits[i] != fruitA && fruits[i] != fruitB) {
                if (fruitALastIndex < fruitBLastIndex) {
                    count = i - fruitALastIndex - 1;
                    fruitALastIndex = i;
                    fruitA = fruits[i];
                } else {
                    count = i - fruitBLastIndex - 1;
                    fruitBLastIndex = i;
                    fruitB = fruits[i];
                }
            }
            count++;
            result = Math.max(result, count);
        }

        return result == 0 ? fruits.length : result;
    }
}
