package dp;

public class FindTheMaximumLengthOfValidSubsequenceI_3201 {
    public int maximumLength(int[] nums) {
        boolean[] parityArray = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parityArray[i] = nums[i] % 2 == 0;
        }

        int firstEvenIndex = -1;
        int firstOddIndex = -1;
        for (int i = 0; i < parityArray.length; i++) {
            if (nums[i] % 2 == 0 && firstEvenIndex == -1) {
                firstEvenIndex = i;
            } else if (nums[i] % 2 != 0 && firstOddIndex == -1) {
                firstOddIndex = i;
            }
        }

        return Math.max(Math.max(Math.max(computeMaxSubsequence(parityArray, firstEvenIndex, true),
                computeMaxSubsequence(parityArray, firstEvenIndex, false)),
                computeMaxSubsequence(parityArray, firstOddIndex, true)),
                computeMaxSubsequence(parityArray, firstOddIndex, false));
    }

    private int computeMaxSubsequence(boolean[] parityArray, int startIndex, boolean paritySubsequence) {
        if (startIndex == -1) {
            return 0;
        }
        boolean startParity =  parityArray[startIndex];

        int result = 1;
        if (startParity && paritySubsequence) {
            for (int i = startIndex + 1; i < parityArray.length; i++) {
                if (parityArray[i]) {
                    result++;
                }
            }
        } else if (startParity && !paritySubsequence) {
            boolean lookingForParity = false;
            for (int i = startIndex + 1; i < parityArray.length; i++) {
                if (parityArray[i] == lookingForParity) {
                    result++;
                    lookingForParity = !lookingForParity;
                }
            }
        } else if (!startParity && paritySubsequence) {
            boolean lookingForParity = true;
            for (int i = startIndex + 1; i < parityArray.length; i++) {
                if (parityArray[i] == lookingForParity) {
                    result++;
                    lookingForParity = !lookingForParity;
                }
            }
        } else {
            for (int i = startIndex + 1; i < parityArray.length; i++) {
                if (!parityArray[i]) {
                    result++;
                }
            }
        }

        return result;
    }
}
