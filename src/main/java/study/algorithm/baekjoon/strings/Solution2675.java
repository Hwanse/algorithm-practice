package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder[] resultBuilders = new StringBuilder[t];

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int loopCount = Integer.parseInt(input.split(" ")[0]);
            String characters = input.split(" ")[1];
            resultBuilders[i] = new StringBuilder();

            for (int charIndex = 0; charIndex < characters.length(); charIndex++) {
                for (int printCount = 0; printCount < loopCount; printCount++) {
                    char token = characters.charAt(charIndex);
                    resultBuilders[i].append(token);
                }
            }
        }

        for (StringBuilder builder : resultBuilders) {
            System.out.println(builder.toString());
        }
    }

}
