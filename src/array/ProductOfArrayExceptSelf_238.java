package array;

public class ProductOfArrayExceptSelf_238 {
    // the easiest way is to compute the product of all array elements and then divide each element,
    // but the division is not allowed, and we would have problem with 0
    // idea: compute the product of left and right arrays of each element i -> time complexity O(n)
    public static void main(String[] args) {
        new ProductOfArrayExceptSelf_238().productExceptSelf(new int[]{1,2,3,4});
    }
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length+1];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct[i+1] = leftProduct[i] * nums[i];
        }
        rightProduct[nums.length-1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            rightProduct[i-1] = rightProduct[i] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
