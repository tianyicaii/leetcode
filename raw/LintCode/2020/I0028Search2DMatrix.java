package lintcode;



/*

    描述
    写出一个高效的算法来搜索 m × n矩阵中的值。

    这个矩阵具有以下特性：

    每行中的整数从左到右是排序的。
    每行的第一个数大于上一行的最后一个整数。

*/


public class I0028Search2DMatrix {
    

    public boolean searchMatrix(int[][] matrix, int target) {

        int R = matrix.length;
        if (R == 0) return false;
        int C = matrix[0].length;

        int left = 0;
        int right = R * C;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (get(matrix, mid) >= target) right = mid;
            else left = mid + 1;
        }

        if (left == R * C) return false;
        return get(matrix, left) == target;
        
    }

    private int get(int[][] m, int i) {
        return m[i/m[0].length][i%m[0].length];
    }


}
