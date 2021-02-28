package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class LifeBoatTest {

    @Test
    public void solution() {
        LifeBoat lb = new LifeBoat();

        assertEquals(3, lb.solution(new int[]{70, 50, 80, 50}, 100));
        assertEquals(3, lb.solution(new int[]{70, 80, 50}, 100));
    }

}