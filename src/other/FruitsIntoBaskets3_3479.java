package other;

public class FruitsIntoBaskets3_3479 {

    public static void main(String[] args) {
        new FruitsIntoBaskets3_3479().numOfUnplacedFruits(new int[] {4,2,5}, new int[] {3,5,4});
    }
    // root decomposition
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int m = (int) Math.sqrt(baskets.length);
        int section = (int) Math.ceil((double) baskets.length / m);
        int[] maxPerSection = new int[section];

        for (int i = 0; i < baskets.length; i++) {
            maxPerSection[i/m] = Math.max(baskets[i], maxPerSection[i/m]);
        }

        int result = 0;
        for (int fruit : fruits) {
            boolean isPlaced = false;

            for (int i = 0; i < section; i++) {
                if (fruit > maxPerSection[i]) {
                    continue;
                }

                // find the left-most available basket in this section
                maxPerSection[i] = 0; // needs to be updated
                for (int j = 0; j < m; j++) {
                    int pos = i * m + j;
                    if (pos < baskets.length && baskets[pos] >= fruit && !isPlaced) {
                        baskets[pos] = 0;
                        isPlaced = true;
                    }

                    // update max of section since it could be placed by a fruit
                    if (pos < baskets.length) {
                        maxPerSection[i] = Math.max(maxPerSection[i], baskets[pos]);
                    }
                }
                break;
            }
            if (!isPlaced) {
                result++;
            }
        }

        return result;
    }
}
