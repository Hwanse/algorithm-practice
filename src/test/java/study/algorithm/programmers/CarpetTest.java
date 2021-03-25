package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarpetTest {

    @Test
    public void solution() throws Exception {
        Carpet carpet = new Carpet();

        assertArrayEquals(new int[]{4,3}, carpet.solution(10, 2));
        assertArrayEquals(new int[]{3,3}, carpet.solution(8, 1));
        assertArrayEquals(new int[]{8,6}, carpet.solution(24, 24));
    }


}