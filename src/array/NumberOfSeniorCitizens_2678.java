package array;

import java.util.stream.Stream;

public class NumberOfSeniorCitizens_2678 {
    public int countSeniors(String[] details) {
        return (int) Stream.of(details)
                .filter(detail -> detail.charAt(11) > '6' || (detail.charAt(11) == '6' && detail.charAt(12) > '0'))
                .count();
    }
}
