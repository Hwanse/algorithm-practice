package study.algorithm.programmers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class OpenChattingRoomTest {

  @Test
  public void solution() throws Exception {
    OpenChattingRoom or = new OpenChattingRoom();
    Assert.assertArrayEquals(
        or.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}),
        new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
  }

}