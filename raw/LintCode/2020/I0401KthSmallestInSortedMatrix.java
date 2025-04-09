package lintcode;

import java.util.PriorityQueue;

public class I0401KthSmallestInSortedMatrix {

    class Cell implements Comparable<Cell> {
        int i;
        int j;
        int v;
        Cell(int i, int j, int v) { this.i = i; this.j = j; this.v = v; }
        @Override
        public int compareTo(Cell other) { return this.v - other.v; }
    }

    int[][] matrix;
    boolean[][] visited;
    int R;
    int C;
    PriorityQueue<Cell> pq;

    boolean inBound(int i, int j) { return i < R && j < C; }
    void addRight(int i, int j) { add(i, j+1); }
    void addDown(int i, int j) { add(i+1, j); }
    void add(int x, int y) {
        if (!inBound(x, y)) return;
        if (visited[x][y]) return;
        pq.offer(new Cell(x, y, matrix[x][y]));
        visited[x][y] = true;
    }

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        this.R = matrix.length;
        this.C = matrix[0].length;
        this.visited = new boolean[R][C];
        this.pq = new PriorityQueue<>();
        add(0, 0);
        while (k-- > 1) {
            Cell min = pq.poll();
            addRight(min.i, min.j);
            addDown(min.i, min.j);
        }
        return pq.poll().v;
    }


    int countLess(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int i = R-1;
        int j = 0;
        int ans = 0;
        while (i >= 0 && j < C) {
            int v = matrix[i][j];
            if (v < target) {
                ans += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return ans;
    }

    public int kthSmallest_(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[R-1][C-1];
        if (k >= R * C) return right;
        k -= 1;  // zero based index

        while (left < right - 1) {
            int mid = left + (right - left)/2;
            int numLessThanMid = countLess(matrix, mid);
            if (k >= numLessThanMid) left = mid;
            else right = mid;
        }
        return left;
    }
}
