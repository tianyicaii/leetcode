package lintcode;

import java.util.PriorityQueue;

public class I0364TrappingRainWater2 {
    

    class Cell implements Comparable<Cell> {
        int r;
        int c;
        int h;
        Cell(int r, int c, int h) { this.r = r; this.c = c; this.h = h; }

        @Override
        public int compareTo(Cell other) {
            return this.h - other.h;
        }

    }

    int[][] height;
    boolean[][] visited;
    int R;
    int C;
    PriorityQueue<Cell> pq;
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public int trapRainWater(int[][] heights) {
        this.height = heights;
        R = heights.length;
        C = heights[0].length;
        visited = new boolean [R][C];
        pq = new PriorityQueue<>();


        for (int j = 0; j < C; j++) {
            pq.add(new Cell(0, j, heights[0][j]));
            pq.add(new Cell(R-1, j, heights[R-1][j]));
            visited[0][j] = true;
            visited[R-1][j] = true;
        }
        for (int i = 0; i < R; i++) {
            pq.add(new Cell(i, 0, heights[i][0]));
            pq.add(new Cell(i, C-1, heights[i][C-1]));
            visited[i][0] = true;
            visited[i][C-1] = true;
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Cell c = pq.poll();
            for (int d = 0; d < 4; d++) {
                int x = c.r + dx[d];
                int y = c.c + dy[d];
                if (inBound(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    ans += Math.max(0, c.h - heights[x][y]);
                    pq.add(new Cell(x, y, Math.max(heights[x][y], c.h)));
                }
            }
        }

        return ans;
    }


}
