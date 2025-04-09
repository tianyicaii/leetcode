#include <vector>


inline bool is_done(int T, int B, int L, int R) {
    return T == B || L == R;
}

std::vector<int> spiralOrder(std::vector<std::vector<int>>& matrix) {

    std::vector<int> ans;

    if (matrix.empty()) { return ans; }
    if (matrix[0].empty()) { return ans; }

    int T = 0;
    int B = matrix.size();
    int L = 0;
    int R = matrix[0].size();

    while (true) {

        int i = T;
        int j = L;

        // go right
        if (is_done(T, B, L, R)) { break; }
        for (; j < R; j++) {
            ans.push_back(matrix[i][j]);
        }
        --j;
        ++i;
        ++T;

        // go down
        if (is_done(T, B, L, R)) { break; }
        for (; i < B; ++i) {
            ans.push_back(matrix[i][j]);
        }
        --i;
        --j;
        --R;

        // go left
        if (is_done(T, B, L, R)) { break; }
        for(; j >= L; --j) {
            ans.push_back(matrix[i][j]);
        }
        ++j;
        --i;
        --B;

        // go up
        if (is_done(T, B, L, R)) { break; }
        for (; i >= T; --i) {
            ans.push_back(matrix[i][j]);
        }
        ++i;
        ++j;
        ++L;
    }

    return ans;
}