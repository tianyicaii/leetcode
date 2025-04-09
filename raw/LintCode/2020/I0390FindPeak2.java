package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0390FindPeak2 {
    

    int L;
    int R;
    int T;
    int B;
    int[][] A;
    int x;
    int y;

    private boolean isLeftLarger() { return A[x][y-1] > A[x][y]; }
    private boolean isRightLarger() { return A[x][y+1] > A[x][y]; }
    private boolean isAboveLarger() { return A[x-1][y] > A[x][y]; }
    private boolean isBelowLarger() { return A[x+1][y] > A[x][y]; }

    private void seekHorizontalMax() {
        for (int j = L+1; j < R; j++) {
            if (A[x][j] > A[x][y]) y = j;
        }
    }

    private void seekVerticalMax() {
        for (int i = T+1; i < B; i++) {
            if (A[i][y] > A[x][y]) x = i;
        }
    }

    private boolean isPeak() {
        return A[x][y] > A[x-1][y]
                && A[x][y] > A[x+1][y]
                && A[x][y] > A[x][y-1]
                && A[x][y] > A[x][y+1];
    }

    private void seekMid() {
        x = (T + B) / 2;
        y = (L + R) / 2;
    }

    private void goLeft() { R = y; }
    private void goRight() { L = y; }
    private void goUp() { B = x; }
    private void goDown() { T = x; }

    public List<Integer> findPeakII(int[][] A) {
        this.A = A;
        L = 0;
        T = 0;
        B = A.length-1;
        R = A[0].length;

        while (true) {
            seekMid();
            seekVerticalMax();
            if (isLeftLarger()) goLeft();
            else if (isRightLarger()) goRight();
            if (isPeak()) break;
            seekMid();
            seekHorizontalMax();
            if (isAboveLarger()) goUp();
            else if (isBelowLarger()) goDown();
            if (isPeak()) break;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(x);
        ans.add(y);
        return ans;
    }
}
