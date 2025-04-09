package lintcode;

public class I0038Search2DMatrix2 {

    public int searchMatrix(int[][] matrix, int target) {

        int cnt = 0;
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            int x = matrix[i][j];
            if (x == target) {
                cnt ++;
                i --;
                j ++;
            }
            else if (x < target) j++;
            else i--;
        }

        return cnt;
    }
}
