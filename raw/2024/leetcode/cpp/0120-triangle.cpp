#include <algorithm>
#include <vector>

int minimumTotal(std::vector<std::vector<int>>& triangle) {

    std::vector<std::vector<int>> dp;

    for (int i = 0; i < triangle.size(); ++i) {
        int sz = triangle[i].size();
        dp.push_back(std::vector<int>(sz));
        for (int j = 0; j < sz; ++j) {
            if (i == 0) dp[i][j] = triangle[i][j];
            else if (j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
            else if (j == sz-1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            else {
                dp[i][j] = std::min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
    }

    // find min
    const auto & last_row = dp.back();
    int min_sum = last_row[0];
    for (int j = 1; j < last_row.size(); ++j) {
        min_sum = std::min(min_sum, last_row[j]);
    }
    return min_sum;
}
