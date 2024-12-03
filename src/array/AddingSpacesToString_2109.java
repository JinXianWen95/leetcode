package array;

public class AddingSpacesToString_2109 {

    public String addSpaces(String s, int[] spaces) {
        if (spaces.length == 0) {
            return s;
        }
        spaces = extendArraySize(spaces, s.length());
        char[] result = new char[s.length() + spaces.length-1];
        char[] input = s.toCharArray();
        int i = 0;
        int j = 0;
        int resultIndex = 0;
        while (i < input.length) {
            int spaceIndex = spaces[j++];
            while (i < spaceIndex) {
                result[resultIndex++] = input[i++];
            }
            if (i < input.length) {
                result[resultIndex++] = ' ';
            }
        }
        return new String(result);
    }

    private static int[] extendArraySize(int[] array, int value){
        int[] temp = array.clone();
        array = new int[array.length + 1];
        System.arraycopy(temp, 0, array, 0, temp.length);
        array[array.length-1] = value;
        return array;
    }
}
