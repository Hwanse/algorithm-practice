package study.algorithm.programmers;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkillTreesTest {

  @Test
  public void skillTreeTest() {
    SkillTrees st = new SkillTrees();
    String[] skillTrees = new String[] {"BACDE","CBADF","AECB","BDA"};

    int result = st.solution("CBD", skillTrees);
    assertEquals(2, result);
  }

}