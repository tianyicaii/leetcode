package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0433NumIslands {
    


    int R;
    int C;
    boolean[][] grid;
    boolean[][] visited;

    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};
    
    boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public int numIslands(boolean[][] grid) {
        this.grid = grid;
        this.R = grid.length;
        if (R == 0) return 0;
        this.C = grid[0].length;
        if (C == 0) return 0;
        this.visited = new boolean[R][C];
        int ans = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    bfs(i, j);
                    ans += 1;
                }
            }
        }

        return ans;
    }

    void bfs(int i, int j) {

        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();

        r.offer(i);
        c.offer(j);
        visited[i][j] = true;

        while (!r.isEmpty()) {
            int a = r.poll();
            int b = c.poll();
            for (int d = 0; d < 4; d++) {
                int x = a + dx[d];
                int y = b + dy[d];
                if (inBound(x, y) && grid[x][y] && !visited[x][y]) {
                    visited[x][y] = true;
                    r.offer(x);
                    c.offer(y);
                }
            }
        }
    }
}
