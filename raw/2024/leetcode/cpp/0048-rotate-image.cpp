#include <vector>


int N = 0;

void swap(int & i, int & j) {
    int t = i;
    i = j;
    j = t;
}

void transpose(std::vector<std::vector<int>>& matrix) {
    for (int i = 0; i != N; ++i) {
        for (int j = i + 1; j != N; ++j) {
            swap(matrix[i][j], matrix[j][i]);
        }
    }
}

void reflect(std::vector<std::vector<int>>& matrix) {
    for (int i = 0; i != N; ++i) {
        for (int j = 0; j != N/2; ++j) {
            swap(matrix[i][j], matrix[i][N-j-1]);
        }
    }
}

void rotate(std::vector<std::vector<int>>& matrix) {
    N = matrix.size();
    transpose(matrix);
    reflect(matrix);
}
