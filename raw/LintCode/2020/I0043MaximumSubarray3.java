package lintcode;

public class I0043MaximumSubarray3 {
    

    public int maxSubArray(int[] nums, int k) {

        int N = nums.length;
        int[][] local = new int[k + 1][N + 1];
        int[][] global = new int[k + 1][N + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= N; j++) {

                if (i == 1 && j == 1) {
                    local[i][j] = nums[j-1];
                    global[i][j] = local[i][j];
                }

                else if (i == 1) {
                    local[i][j] = Math.max(nums[j-1], local[i][j-1] + nums[j-1]);
                    global[i][j] = Math.max(global[i][j-1], local[i][j]);
                }

                else if (i == j) {
                    local[i][j] = nums[j-1];
                    global[i][j] = global[i-1][j-1] + local[i][j];
                }

                else {
                    local[i][j] = Math.max(nums[j-1] + global[i-1][j-1], nums[j-1] + local[i][j-1]);
                    global[i][j] = Math.max(global[i][j-1], local[i][j]);
                }

            }
        }
        

        return global[k][N];
    }

}
