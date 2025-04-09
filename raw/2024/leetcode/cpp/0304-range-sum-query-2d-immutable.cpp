#include <vector>

class NumMatrix {

    std::vector<std::vector<int>> dp;

public:

    NumMatrix(std::vector<std::vector<int>>& matrix) {

        int M = matrix.size();
        int N = matrix[0].size();

        dp = std::vector<std::vector<int>>(M + 1, std::vector<int>(N + 1));

        for (int i = 0; i < matrix.size(); ++i) {
            int sum = 0;
            for (int j = 0; j < matrix[0].size(); ++j) {
                sum += matrix[i][j];
                dp[i + 1][j + 1] = dp[i][j + 1] + sum;
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int a = dp[row1][col1];
        int b = dp[row2 + 1][col1];
        int c = dp[row1][col2 + 1];
        int d = dp[row2 + 1][col2 + 1];
        return d - b - c + a;
    }
};

