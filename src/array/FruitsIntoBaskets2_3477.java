package array;

public class FruitsIntoBaskets2_3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = 0;
        boolean[] placed = new boolean[baskets.length];

        for (int fruit : fruits) {
            boolean isPlaced = false;
            for (int i = 0; i < baskets.length; i++) {
                if (!placed[i] && baskets[i] >= fruit) {
                    placed[i] = true;
                    isPlaced = true;
                    break;
                }
            }

            if (!isPlaced) {
                result++;
            }
        }

        return result;
    }
}
