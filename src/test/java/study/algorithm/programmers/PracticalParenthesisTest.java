package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PracticalParenthesisTest {

    @Test
    public void solution() throws Exception {
        PracticalParenthesis pp = new PracticalParenthesis();

        assertTrue(pp.solution("()()"));
        assertTrue(pp.solution("(())()"));
        assertFalse(pp.solution(")()("));
        assertFalse(pp.solution("(()("));
    }


}