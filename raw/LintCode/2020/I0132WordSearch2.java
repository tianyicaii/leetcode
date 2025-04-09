package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class I0132WordSearch2 {
    

    private class TrieNode {
        HashMap<Character, TrieNode> links = new HashMap<>();
        boolean isWord = false;
    }

    private void addWord(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!curr.links.containsKey(c)) curr.links.put(c, new TrieNode());
            curr = curr.links.get(c);
        }
        curr.isWord = true;
    }

    TrieNode root;
    Set<String> ans;
    char[][] board;
    boolean[][] visited;
    int R;
    int C;

    public List<String> wordSearchII(char[][] board, List<String> words) {
        root = new TrieNode();
        for (String w : words) addWord(w);
        ans = new HashSet<>();
        this.board = board;
        R = board.length;
        C = board[0].length;
        visited = new boolean[R][C];
        if (root.isWord) ans.add("");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (root.links.containsKey(board[i][j])) dfs(new StringBuilder(), i, j, root.links.get(board[i][j]));
            }
        }
        return new ArrayList<>(ans);
    }

    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    private boolean inBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private void dfs(StringBuilder path, int i, int j, TrieNode curr) {
        visited[i][j] = true;
        path.append(board[i][j]);
        if (curr.isWord) ans.add(path.toString());

        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (inBound(x, y) && curr.links.containsKey(board[x][y]) && !visited[x][y]) dfs(path, x, y, curr.links.get(board[x][y]));
        }

        visited[i][j] = false;
        path.delete(path.length() - 1, path.length());
    }

}
