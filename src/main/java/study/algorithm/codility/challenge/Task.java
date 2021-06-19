package study.algorithm.codility.challenge;

public class Task {

    public String solution(String S, int K) {
        char[] tokens = new char[S.length()];

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = S.charAt(i);
        }

        for (int i = 0; i < K; i++) {
            int[] alphabets = alphabetArray(tokens);
            int firstIndex = firstIndex(alphabets, 0);

            if (! checkAndSort(tokens, firstIndex)) {
                continue;
            }

            move(tokens, firstIndex, firstIndex - 1);
        }

        return new String(tokens);
    }

    private int[] alphabetArray(char[] tokens) {
        int[] alphabet = new int[tokens.length];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = tokens[i] - 'a';
        }

        return alphabet;
    }


    private int firstIndex(int[] alphabet, int start) {
        int min = 'z' - 'a';
        int minIndex = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (min > alphabet[i]) {
                min = alphabet[i];
                minIndex = i;
            }
        }

        if (minIndex == 0) {
            return firstIndex(alphabet, start + 1);
        }

        return minIndex;
    }

    private boolean checkAndSort(char[] tokens, int minIndex) {

        for (int i = 0; i < minIndex - 1; i++) {
            if (tokens[i] - tokens[i + 1] > 0) {
                move(tokens, i, i +1);
                return false;
            }
        }

        return true;
    }

    private void move(char[] tokens, int target, int target2) {
        char temp = tokens[target];
        tokens[target] = tokens[target2];
        tokens[target2] = temp;
    }

}
