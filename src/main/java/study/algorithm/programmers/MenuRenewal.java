package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {

  private Map<String, Integer> map;

  public String[] solution(String[] orders, int[] course) {
    List<String> answer = new ArrayList<>();
    map = new HashMap<>();
    int maxOrderCount = 0;

    for (String order : orders) {
      boolean[] visited = new boolean[order.length()];

      if (maxOrderCount < order.length()) {
        maxOrderCount = order.length();
      }

      for (int i = 0; i < course.length; i++) {
        if (order.length() >= course[i]) {
          combination(order.split(""), visited, 0, course[i]);
        }
      }
    }

    for (int courseCount : course) {
      int max = maxNumberOfOrders(courseCount);

      if (max < 2) {
        continue;
      }

      for (String menu : map.keySet()) {
        if (menu.length() == courseCount && map.get(menu) == max) {
          answer.add(menu);
        }
      }
    }

    answer.sort(String::compareTo);
    return answer.toArray(new String[answer.size()]);
  }

  private int maxNumberOfOrders(int courseCount) {
    int max = 0;
    for (String menu : map.keySet()) {
      if (menu.length() == courseCount) {
        if (max < map.get(menu)) {
          max = map.get(menu);
        }
      }
    }
    return max;
  }

  private void combination(String[] menus, boolean[] visited, int start, int pickCount) {
    if (pickCount == 0) {
      String notSortedCourseText = getCourse(menus, visited);
      char[] temp = notSortedCourseText.toCharArray();
      Arrays.sort(temp);
      String course = new String(temp);
      map.put(course, map.getOrDefault(course, 0) + 1);
      return;
    } else {
      for (int i = start; i < menus.length; i++) {
        visited[i] = true;
        combination(menus, visited, i + 1, pickCount - 1);
        visited[i] = false;
      }
    }
  }

  private String getCourse(String[] menus, boolean[] visited) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < visited.length; i++) {
      if (visited[i]) {
        sb.append(menus[i]);
      }
    }
    return sb.toString();
  }

}
