package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkillSolutionTest {

    @Test
    public void solution() {
        SkillSolution ss = new SkillSolution();

        assertEquals(2, ss.solution("CBD", new String[] {
            "BACDE", "CBADF", "AECB", "BDA"
        }));
    }

}