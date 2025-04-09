package lintcode;

public class I0123WordSearch {

    int R;
    int C;
    char[][] board;
    boolean[][] visited;
    String word;
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        this.board = board;
        this.word = word;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited = new boolean[R][C];
                if (dfs(0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private boolean dfs(int index, int i, int j) {
        if (word.charAt(index) != board[i][j]) return false;
        if (index == word.length() - 1) return true;
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (inBound(x, y) && !visited[x][y] && dfs(index + 1, x, y)) return true;
        }
        visited[i][j] = false;
        return false;
    }

}
