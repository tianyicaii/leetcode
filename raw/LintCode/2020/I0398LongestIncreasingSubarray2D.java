package lintcode;

public class I0398LongestIncreasingSubarray2D {
    

    int[][] matrix;
    int[][] visited;
    int R;
    int C;

    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    private boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        this.matrix = matrix;
        this.R = matrix.length;
        if (R == 0) return 0;
        this.C = matrix[0].length;
        if (C == 0) return 0;
        this.visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dfs(i, j);
            }
        }
        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        if (visited[i][j] >= 1) return visited[i][j];
        visited[i][j] = 1;  // at least one
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (inBound(x, y) && matrix[x][y] < matrix[i][j]) visited[i][j] = Math.max(visited[i][j], dfs(x, y)+1);
        }
        return visited[i][j];
    }
}
