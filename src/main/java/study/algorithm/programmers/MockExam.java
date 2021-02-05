package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

  public int[] solution(int[] answers) {
    int[][] guessAnswers = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    List<Student> students = Student.createStudents(guessAnswers.length, guessAnswers);

    for (Student student : students) {
      student.calculateScore(answers);
    }

    // 최다 득점수 산출
    int max = students.stream()
        .mapToInt(Student::getCountAnswer)
        .max()
        .getAsInt();

    // 1등한 학생들의 배열을 반환
    int[] result = students.stream()
        .filter(student -> max == student.getCountAnswer())
        .mapToInt(Student::getStudentNo)
        .toArray();

    return result;
  }

}

class Student implements Comparable<Student> {

  private int studentNo;
  private int countOfAnswer;
  private int[] guessAnswer;

  public static List<Student> createStudents(int count, int[][] guessAnswers) {
    List<Student> students = new ArrayList<>();

    for (int i = 0; i < count; i++) {
      students.add(new Student(i + 1, guessAnswers[i]));
    }

    return students;
  }

  public Student(int studentNo, int[] guessAnswer) {
    this.studentNo = studentNo;
    countOfAnswer = 0;
    this.guessAnswer = guessAnswer;
  }

  public void calculateScore(int[] answers) {

    for (int i = 0; i < answers.length; i++) {
      int targetIndex = i % this.guessAnswer.length;

      if (answers[i] == this.guessAnswer[targetIndex]) {
        countOfAnswer++;
      }
    }

  }

  public int getStudentNo() {
    return this.studentNo;
  }

  public int getCountAnswer() {
    return this.countOfAnswer;
  }

  @Override
  public int compareTo(Student st) {
    return st.getCountAnswer() - this.countOfAnswer;
  }

}