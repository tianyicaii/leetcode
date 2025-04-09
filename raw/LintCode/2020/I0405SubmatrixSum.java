package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0405SubmatrixSum {
    
    public int[][] submatrixSum(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        int[][] prefixSum = new int[R+1][C+1];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) prefixSum[i+1][j+1] = matrix[i][j] + prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j];
        }

        for (int i = 0; i < R; i++) {
            for (int height = 1; i + height <= R; height++) {
                Map<Integer, Integer> twoSum = new HashMap<>();
                twoSum.put(0, -1);  // caution
                for (int j = 0; j < C; j++) {
                    int currentRectangleSize = prefixSum[i+height][j+1] - prefixSum[i][j+1];
                    if (twoSum.containsKey(currentRectangleSize)) return new int[][] { new int[] {i, twoSum.get(currentRectangleSize) + 1}, new int[] {i+height-1, j}};
                    twoSum.put(currentRectangleSize, j);
                }
            }
        }

        return new int[][] {};
    }

}
