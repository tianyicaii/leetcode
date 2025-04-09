#include <vector>

int get(std::vector<std::vector<int>>& matrix, int idx) {
    int n = matrix[0].size();
    int i = idx / n;
    int j = idx % n;
    return matrix[i][j];
}

bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {

    int b = 0;
    int m = matrix.size();
    int n = matrix[0].size();
    int e = m * n;

    while (b < e) {
        m = b + (e - b) / 2;
        int v = get(matrix, m);
        if (v > target) { e = m; }
        else if (v < target) { b = m+1; }
        else { return true; }
    }

    return false;
}
