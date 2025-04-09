#include <vector>

bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {

    int M = matrix.size();
    int N = matrix[0].size();

    int i = M - 1;
    int j = 0;

    while (j < N && i >= 0) {

        int v = matrix[i][j];
        if (v == target) return true;
        if (v < target) j++;
        else i--;
    }

    return false;
}

