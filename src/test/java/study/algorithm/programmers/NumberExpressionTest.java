package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NumberExpressionTest {

    @Test
    public void test() throws Exception {
        NumberExpression ne = new NumberExpression();

        assertEquals(4, ne.solution(15));
    }


}