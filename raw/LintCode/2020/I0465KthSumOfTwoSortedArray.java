package lintcode;

import java.util.PriorityQueue;

public class I0465KthSumOfTwoSortedArray {

    class Cell implements Comparable<Cell> {
        int a;
        int b;
        int v;
        Cell(int a, int b) {
            this.a = a;
            this.b = b;
            this.v = A[a] + B[b];
        }
        public int compareTo(Cell other) {
            if (this.v < other.v) return -1;
            if (this.v == other.v) return 0;
            return 1;
        }
    }

    int[] A;
    int[] B;
    boolean[][] visited;
    PriorityQueue<Cell> pq = new PriorityQueue<>();

    boolean inBound(int a, int b) {
        return a < A.length && b < B.length;
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        this.A = A;
        this.B = B;
        visited = new boolean[A.length][B.length];
        pq.offer(new Cell(0, 0));
        for (int i = 1; i < k; i++) {
            Cell c = pq.poll();
            int nexta = c.a + 1;
            int nextb = c.b + 1;
            if (inBound(nexta, c.b) && !visited[nexta][c.b]) {
                pq.offer(new Cell(nexta, c.b));
                visited[nexta][c.b] = true;
            }
            if (inBound(c.a, nextb) && !visited[c.a][nextb]){
                pq.offer(new Cell(c.a, nextb));
                visited[c.a][nextb] = true;
            }
        }
        return pq.poll().v;
    }




    int countLess(int v) {
        int i = A.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < B.length) {
            if (A[i] + B[j] >= v) {
                i--;
            } else {
                count += (i + 1);
                j++;
            }
        }
        return count;
    }
    public int kthSmallestSum_(int[] A, int[] B, int k) {
        this.A = A;
        this.B = B;
        k -= 1;
        int min = A[0] + B[0];
        int max = A[A.length - 1] + B[B.length - 1];
        if (countLess(max) <= k) return max;

        while (min < max - 1) {
            int mid = (max - min) / 2 + min;
            if (countLess(mid) > k) max = mid;
            else min = mid;
        }
        return min;
    }
}
