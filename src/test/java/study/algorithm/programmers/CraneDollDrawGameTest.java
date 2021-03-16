package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CraneDollDrawGameTest {

    @Test
    public void solution() {
        CraneDollDrawGame cd = new CraneDollDrawGame();

        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };

        int[] moves = new int[] {1,5,3,5,1,2,1,4};

        assertEquals(4, cd.solution(board, moves));
    }


}