package array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeOfTriangle_3024 {
    public String triangleType(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (numSet.size() == 1) {
            return "equilateral";
        }

        if (!isValidTriangle(nums[0], nums[1], nums[2])) {
            return "none";
        }

        if (numSet.size() == 2) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    private boolean isValidTriangle(int x, int y, int z) {
        return (x+y) > z && (x+z) > y && (y+z) > x;
    }
}
