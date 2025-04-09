#include <vector>

inline bool is_done(int T, int B, int L, int R) {
    return T == B || L == R;
}

std::vector<std::vector<int>> generateMatrix(int n) {

    std::vector<std::vector<int>> ans(n, std::vector<int>(n));

    int T = 0;
    int B = n;
    int L = 0;
    int R = n;
    int c = 1;

    while (true) {

        int i = T;
        int j = L;

        // go right
        if (is_done(T, B, L, R)) { break; }
        for (; j < R; j++) {
            ans[i][j] = c++;
        }
        --j;
        ++i;
        ++T;

        // go down
        if (is_done(T, B, L, R)) { break; }
        for (; i < B; ++i) {
            ans[i][j] = c++;
        }
        --i;
        --j;
        --R;

        // go left
        if (is_done(T, B, L, R)) { break; }
        for(; j >= L; --j) {
            ans[i][j] = c++;
        }
        ++j;
        --i;
        --B;

        // go up
        if (is_done(T, B, L, R)) { break; }
        for (; i >= T; --i) {
            ans[i][j] = c++;
        }
        ++i;
        ++j;
        ++L;
    }

    return ans;
}
