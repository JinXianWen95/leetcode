import java.util.*;

public class RepeatedDnaSequence_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        Set<String> memory = new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
            String currentSequence = s.substring(i, i+10);
            if (!memory.add(currentSequence)) {
                result.add(currentSequence);
            }
        }
        return new ArrayList<>(result);
    }
}
