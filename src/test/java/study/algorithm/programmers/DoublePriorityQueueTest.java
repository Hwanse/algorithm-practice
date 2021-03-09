package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoublePriorityQueueTest {

    @Test
    public void solution() throws Exception {
        DoublePriorityQueue dq = new DoublePriorityQueue();

        assertArrayEquals(new int[] {0,0}, dq.solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        assertArrayEquals(new int[] {333,-45}, dq.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));

    }


}