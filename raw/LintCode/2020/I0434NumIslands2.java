package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0434NumIslands2 {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    class UF {

        int[] id;
        int[] sz;
        int cnt;

        UF(int N) {
            id = new int[N];
            sz = new int[N];
            cnt = N;
            for (int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a == b) return;

            if (sz[a] > sz[b]) {
                id[b] = a;
                sz[a] += sz[b];
            } else {
                id[a] = b;
                sz[b] += sz[a];
            }
            cnt -= 1;
        }
    }

    boolean[][] board;
    int R;
    int C;
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    boolean inBound(Point p) {
        return p.x >= 0 && p.x < R && p.y >= 0 && p.y < C;
    }

    boolean isLand(Point p) {
        return board[p.x][p.y];
    }

    List<Point> neighbors(Point p) {
        List<Point> ans = new ArrayList<>();
        for (int d = 0; d < 4; d++) {
            Point q = new Point(p.x + dx[d], p.y + dy[d]);
            if (inBound(q) && isLand(q)) ans.add(q);
        }
        return ans;
    }

    int getId(Point p) {
        return p.x * C + p.y;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {

        this.board = new boolean[n][m];
        this.R = n;
        this.C = m;
        List<Integer> ans = new ArrayList<>();
        UF uf = new UF(n * m);
        int numWater = n * m;

        if (operators == null) return ans;
        for (Point p : operators) {
            if (!board[p.x][p.y]) {
                board[p.x][p.y] = true;
                numWater --;
                for (Point q : neighbors(p)) uf.union(getId(p), getId(q));
            }
            ans.add(uf.cnt - numWater);
        }
        return ans;
    }
    
}
