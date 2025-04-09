#include <vector>

int maximalRectangle(std::vector<std::vector<char>>& matrix) {


    int M = matrix.size();
    int N = matrix[0].size();


    std::vector<std::vector<int>> H(M, std::vector<int>(N));
    std::vector<std::vector<int>> L(M, std::vector<int>(N));
    std::vector<std::vector<int>> R(M, std::vector<int>(N));

    int ans = 0;

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (matrix[i][j] == '0') {
                H[i][j] = 0;
            }
            else {
                if (i == 0) {
                    H[i][j] = 1;
                } else {
                    H[i][j] = H[i-1][j] + 1;
                }
            }
        }
    }

    for (int i = 0; i < M; ++i) {
        int left = 0;
        for (int j = 0; j < N; ++j) {
            if (matrix[i][j] == '0') {
                left = j + 1;
                L[i][j] = 0;  // so that next line will find possible max
            } else {
                if (i == 0) {
                    L[i][j] = left;
                } else {
                    if (matrix[i-1][j] == '0') {  // not bounded by prev line
                        L[i][j] = left;
                    } else {
                        L[i][j] = std::max(left, L[i-1][j]);
                    }
                }
            }
        }
    }

    for (int i = 0; i < M; ++i) {
        int right = N;
        for (int j = N-1; j >= 0; --j) {
            if (matrix[i][j] == '0') {
                right = j;
                R[i][j] = N;  // so that next line will find possible max
            } else {
                if (i == 0) {
                    R[i][j] = right;
                } else {
                    if (matrix[i-1][j] == '0') {  // not bounded by prev line
                        R[i][j] = right;
                    } else {
                        R[i][j] = std::min(right, R[i-1][j]);
                    }
                }
            }
        }
    }

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            ans = std::max(ans, (R[i][j] - L[i][j]) * H[i][j]);
        }
    }

    return ans;
}

