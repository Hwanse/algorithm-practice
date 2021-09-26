package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String trimmedText = text.trim();

        if (trimmedText.isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = trimmedText.split(" ");
            System.out.println(words.length);
        }
    }

}
