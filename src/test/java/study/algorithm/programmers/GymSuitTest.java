package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class GymSuitTest {

    @Test
    public void 체육복문제() {
        GymSuit gs = new GymSuit();

        assertEquals(5, gs.solution(5, new int[]{2,4}, new int[]{1,3,5}));
        assertEquals(4, gs.solution(5, new int[]{2,4}, new int[]{3}));
        assertEquals(2, gs.solution(3, new int[]{3}, new int[]{1}));
    }

}