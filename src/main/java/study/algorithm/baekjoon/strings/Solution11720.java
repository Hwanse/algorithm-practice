package study.algorithm.baekjoon.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String numberString = br.readLine();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += numberString.charAt(i) - '0';
        }

        System.out.println(sum);
    }

}
