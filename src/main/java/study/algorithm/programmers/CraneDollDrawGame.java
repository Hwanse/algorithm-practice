package study.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CraneDollDrawGame {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int count = 0;

        DollBoard dollBoard = new DollBoard();
        dollBoard.setup(board);

        for (int move : moves) {

            int lineNumber = move - 1;

            if (dollBoard.nLineHasDoll(lineNumber)) {
                count += dollBoard.moveDollInBucket(bucket, lineNumber);
            }

        }

        return count;
    }


}

class DollBoard {

    private List<Stack<Integer>> dollBoard;

    public DollBoard() {
        dollBoard = new ArrayList<>();
    }

    public void setup(int[][] board) {
        int width = board[0].length;
        int height = board.length;

        for (int x = 0; x < width; x++) {
            Stack<Integer> line = new Stack<>();
            for (int y = height - 1; y >= 0; y--) {
                int doll = board[y][x];
                if (doll != 0) {
                    line.push(doll);
                }
            }
            dollBoard.add(line);
        }
    }

    public boolean nLineHasDoll(int line) {
        return  this.dollBoard.get(line).size() > 0;
    }

    public int moveDollInBucket(Stack<Integer> bucket, int line) {
        int doll = dollBoard.get(line).pop();
        int clearCount = 0;

        if (!bucket.isEmpty() && bucket.peek() == doll) {
            bucket.pop();
            clearCount = 2;
        } else {
            bucket.push(doll);
        }

        return clearCount;
    }

}