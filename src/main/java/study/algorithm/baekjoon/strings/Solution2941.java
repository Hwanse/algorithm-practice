package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO 입력받은 문자열을 순서대로 읽어나가면서 문자를 치환해주어야 한다
 * 현재 로직으로는 문제 해결에 예외 케이스가 있음
 */
public class Solution2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        AlphabetReader alphabetReader = new AlphabetReader();
        int length = alphabetReader.countTheStringLength(inputString);

        System.out.println(length);
    }

}

class AlphabetReader {

    private Set<String> words;

    public AlphabetReader() {
        this.words = new HashSet<>();
        words.add("c=");
        words.add("c-");
        words.add("dz=");
        words.add("d-");
        words.add("lj");
        words.add("nj");
        words.add("s=");
        words.add("z=");
    }

    public int countTheStringLength(String inputWords) {
        String replacedWords = convertAlphabet(inputWords);
        System.out.println(replacedWords);
        return replacedWords.length();
    }

    private String convertAlphabet(String inputWords) {
        StringBuilder sb = new StringBuilder();
        String replacedWords = inputWords;

        for (String croatianAlphabet : words) {
            if (replacedWords.contains(croatianAlphabet)) {
                replacedWords = replacedWords.replaceAll(croatianAlphabet, " ");
            }
        }

        return replacedWords;
    }
}