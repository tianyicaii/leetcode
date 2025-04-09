#include <vector>

int get_distance(std::vector<int> cnts) {

    int left = 0;
    int right = cnts.size() - 1;
    int L_cost = cnts[left];
    int R_cost = cnts[right];
    int cost = 0;
    while (left < right) {
        if (L_cost < R_cost) {
            left += 1;
            cost += L_cost;
            L_cost += cnts[left];
        } else {
            right -= 1;
            cost += R_cost;
            R_cost += cnts[right];
        }
    }
    return cost;
}

int minTotalDistance(std::vector<std::vector<int>>& grid) {

    int M = grid.size();
    int N = grid[0].size();
    std::vector<int> row(M);
    std::vector<int> col(N);

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (grid[i][j]) {
                row[i] += 1;
                col[j] += 1;
            }
        }
    }
    return get_distance(row) + get_distance(col);
}
