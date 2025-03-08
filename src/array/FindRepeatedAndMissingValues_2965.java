package array;

public class FindRepeatedAndMissingValues_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] values = new boolean[grid.length * grid.length];
        int[] result = new int[2];
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (values[ints[j] - 1]) {
                    result[0] = ints[j];
                } else {
                    values[ints[j]-1] = true;
                }
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (!values[i]) {
                result[1] = i+1;
                break;
            }
        }
        return result;
    }
}
