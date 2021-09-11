package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            int index = word.indexOf(alphabet);
            System.out.print(index + " ");
        }
    }

}
