package study.algorithm.programmers;

public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int[][] sumTriangle = new int[triangle.length][triangle.length];
        int maxLevel = triangle.length - 1;

        for (int i = 0; i < triangle[maxLevel].length; i++) {
            sumTriangle[maxLevel][i] = triangle[maxLevel][i];
        }

        for (int level = maxLevel - 1; level >= 0; level--) {

            for (int idx = 0; idx <= level; idx++) {

                sumTriangle[level][idx] = triangle[level][idx]
                    + Math.max(sumTriangle[level + 1][idx], sumTriangle[level + 1][idx + 1]);

            }
        }

        return sumTriangle[0][0];
    }

}
