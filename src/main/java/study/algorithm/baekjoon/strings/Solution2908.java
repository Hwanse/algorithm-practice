package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numberTexts = br.readLine().split(" ");
        int[] numbers = new int[numberTexts.length];

        for (int i = 0; i < numbers.length; i++) {
            String reversedNumberText = reverseNumberText(numberTexts[i]);
            numbers[i] = Integer.parseInt(reversedNumberText);
        }

        int biggerNumber = Math.max(numbers[0], numbers[1]);
        System.out.print(biggerNumber);
    }

    public static String reverseNumberText(String numberText) {
        StringBuilder sb = new StringBuilder();
        for (int i = numberText.length() - 1; i >= 0; i--) {
            sb.append(numberText.charAt(i));
        }
        return sb.toString();
    }

}
