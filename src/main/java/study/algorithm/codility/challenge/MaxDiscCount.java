package study.algorithm.codility.challenge;

import java.util.*;

public class MaxDiscCount {

    public int solution(int[] A, int L, int R) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        left.push(L);
        right.push(R);

        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        int max = 0;
        int count = 0;
        char flag = 'L';
        for (int i = 0; i < 2; i++) {
            Stack<Integer> leftClone = (Stack<Integer>) left.clone();
            Stack<Integer> rightClone = (Stack<Integer>) right.clone();

            for (int j = 0; j < A.length; j++) {
                int currentDisk = A[j];
                if (R < currentDisk && currentDisk < L) {
                    switch (flag) {
                        case 'L': leftQueue.offer(currentDisk);
                            break;
                        case 'R': rightQueue.offer(currentDisk);
                            break;
                    }
                    count++;
                } else if (currentDisk < L) {
                    if (!leftQueue.contains(currentDisk)) {
                        leftQueue.offer(currentDisk);
                        count++;
                    }
                } else if (currentDisk > R) {
                    if (!rightQueue.contains(currentDisk)) {
                        rightQueue.offer(currentDisk);
                        count++;
                    }
                }
            }

            leftQueue.stream().forEach(disk -> leftClone.push(disk));
            rightQueue.stream().forEach(disk -> rightClone.push(disk));

            max = Math.max(count, max);

            count = 0;
            flag = 'R';
            leftQueue.clear();
            rightQueue.clear();
        }

        return max;
    }

}
