package study.algorithm.programmers;

import java.util.Arrays;

public class GymSuit {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = initStudentsGymsuit(n, lost, reserve);

        for (int i = 0; i < students.length; i++) {
            if (isLostStudent(students[i])) {
                if (i > 0 && isReserveStudent(i - 1, students)) {
                    shareGymSuit(students, i - 1, i);
                } else if (i < n - 1 && isReserveStudent(i + 1, students)) {
                    shareGymSuit(students, i + 1, i);
                }
            }
        }

        return (int) Arrays.stream(students)
            .filter(suitCount -> suitCount > 0)
            .count();
    }

    private boolean isReserveStudent(int index, int[] students) {
        return students[index] > 1;
    }

    private boolean isLostStudent(int gymSuitCount) {
        return gymSuitCount == 0;
    }

    private void shareGymSuit(int[] students, int reserveStudent, int lostStudent) {
        students[lostStudent] += 1;
        students[reserveStudent] -= 1;
    }

    public int[] initStudentsGymsuit(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = 1;
        }

        for (int studentId : reserve) {
            students[studentId - 1] += 1;
        }

        for (int studentId : lost) {
            students[studentId - 1] -= 1;
        }

        return students;
    }

}