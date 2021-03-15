package study.algorithm.programmers;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxAndMin {

    public String solution(String s) {
        String[] numberTexts = s.split(" ");

        int max = getIntStream(numberTexts).max().orElseThrow();
        int min = getIntStream(numberTexts).min().orElseThrow();

        return String.format("%d %d", min, max);
    }

    private IntStream getIntStream(String[] numberTexts) {
        return Arrays.stream(numberTexts)
                     .mapToInt(Integer::parseInt);
    }

}
