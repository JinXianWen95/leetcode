package array;

public class ShortestDistanceToTargetStringInCircularArray_2515 {
    public static void main(String[] args) {
        new ShortestDistanceToTargetStringInCircularArray_2515().closestTarget(new String[]{
                "ibkgecmeyx","jsdkekkjsb","gdjgdtjtrs","jsdkekkjsb","jsdkekkjsb","jsdkekkjsb","gdjgdtjtrs","msjlfpawbx","pbgjhutcwb","gdjgdtjtrs"},
                "pbgjhutcwb", 0);
    }
    public int closestTarget(String[] words, String target, int startIndex) {
        int distance = 0;
        while (distance < (words.length/2 + 1)) {
            if (words[(startIndex+distance) % words.length].equals(target) || words[(startIndex-distance+words.length) % words.length].equals(target)) {
                return distance;
            }
            distance++;
        }
        return -1;
    }
}
