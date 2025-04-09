package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0477SurroundedRegions {
    



    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    char[][] board;
    boolean[][] visited;
    int R;
    int C;
    Queue<Integer> I;
    Queue<Integer> J;

    boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    void enqueue(int i, int j) {
        I.offer(i);
        J.offer(j);
        visited[i][j] = true;
    }

    public void surroundedRegions(char[][] board) {
        this.board = board;
        this.R = board.length;
        if (R == 0) return;
        this.C = board[0].length;
        if (C == 0) return;
        this.visited = new boolean[R][C];
        this.I = new LinkedList<>();
        this.J = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            if (board[i][0] == 'O') enqueue(i, 0);
            if (board[i][C-1] == 'O') enqueue(i, C-1);
        }
        for (int j = 0; j < C; j++) {
            if (board[0][j] == 'O') enqueue(0, j);
            if (board[R-1][j] == 'O') enqueue(R-1, j);
        }

        bfs();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    void bfs() {
        while (!I.isEmpty()) {
            int i = I.poll();
            int j = J.poll();
            for (int d = 0; d < 4; d++) {
                int x = i + dx[d];
                int y = j + dy[d];
                if (inBound(x, y) && board[x][y] == 'O' && !visited[x][y]) enqueue(x, y);
            }
        }
    }
}
