package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerTriangleTest {

    @Test
    public void solution() {
        IntegerTriangle it = new IntegerTriangle();

        assertEquals(30, it.solution(new int[][]{
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        }));
    }

}