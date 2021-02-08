package study.algorithm.programmers;

public class SkillTrees {

  public int solution(String skill, String[] skill_trees) {
    int count = 0;

    for (String skillTree : skill_trees) {
      String tmpSkillTree = convertSkillTree(skill, skillTree);

      if (skill.startsWith(tmpSkillTree)) {
        count++;
      }
    }

    return count;
  }

  private String convertSkillTree(String skill, String skillTree) {
    StringBuilder sb = new StringBuilder();
    String[] skills = skillTree.split("");

    for (String skillName : skills) {
      if (skill.contains(skillName)) {
        sb.append(skillName);
      }
    }

    return sb.toString();
  }

}
