#include <map>
#include <vector>


std::vector<std::vector<int>> multiply(std::vector<std::vector<int>>& mat1, std::vector<std::vector<int>>& mat2) {

    int M = mat1.size();
    int K = mat1[0].size();
    int N = mat2[0].size();

    std::vector<std::vector<int>> ans(M, std::vector<int>(N));
    std::vector<std::map<int, int>> rows(M, std::map<int, int>());
    std::vector<std::map<int, int>> cols(N, std::map<int, int>());

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < K; ++j) {
            if (mat1[i][j]) {
                rows[i].insert({j, mat1[i][j]});
            }
        }
    }

    for (int j = 0; j < N; ++j) {
        for (int i = 0; i < K; ++i) {
            if (mat2[i][j]) {
                cols[j].insert({i, mat2[i][j]});
            }
        }
    }

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            // for (int k = 0; k < K; ++k)
            auto row_it = rows[i].begin();
            auto col_it = cols[j].begin();
            int sum = 0;
            while (row_it != rows[i].end() && col_it != cols[j].end()) {
                if (row_it->first == col_it->first) {
                    sum += row_it->second * col_it->second;
                    ++row_it;
                    ++col_it;
                } else if (row_it->first < col_it->first) {
                    ++row_it;
                } else {
                    ++col_it;
                }
            }
            ans[i][j] = sum;
        }
    }

    return ans;
}