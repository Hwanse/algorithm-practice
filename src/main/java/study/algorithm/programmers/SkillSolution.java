package study.algorithm.programmers;

public class SkillSolution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {

            String convertedSkillTree = convertSkillTree(skill, skillTree);

            if (skill.startsWith(convertedSkillTree)) {
                answer++;
            }
        }

        return answer;
    }

    private String convertSkillTree(String skill, String skillTree) {
        String[] stringArr = skillTree.split("");
        StringBuffer sb = new StringBuffer();

        for (String str : stringArr) {
            if (skill.contains(str)) {
                sb.append(str);
            }
        }

        return sb.toString();
    }

}
