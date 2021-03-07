package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThieveryTest {

    @Test
    public void solution() {
        Thievery t = new Thievery();
        assertEquals(4, t.solution(new int[]{1, 2, 3, 1}));
    }

}