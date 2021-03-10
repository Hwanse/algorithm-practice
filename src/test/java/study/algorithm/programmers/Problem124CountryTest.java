package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem124CountryTest {

    @Test
    public void solution() {
        Problem124Country pc = new Problem124Country();

        assertEquals("1", pc.solution(1));
        assertEquals("2", pc.solution(2));
        assertEquals("4", pc.solution(3));
        assertEquals("11", pc.solution(4));
    }

}