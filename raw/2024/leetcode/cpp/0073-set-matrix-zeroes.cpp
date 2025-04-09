#include <vector>

void setZeroes(std::vector<std::vector<int>>& matrix) {


    bool set_first_row = false;
    bool set_first_col = false;

    int m = matrix.size();
    int n = matrix[0].size();

    for (int j = 0; j < n; ++j) {
        if (matrix[0][j] == 0) { set_first_row = true; }
    }
    for (int i = 0; i < m; ++i) {
        if(matrix[i][0] == 0) { set_first_col = true; }
    }

    for (int i = 1; i < m; ++i) {
        for (int j = 1; j < n; ++j) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }

    for (int i = 1; i < m; ++i) {
        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    if (set_first_row) {
        for (int j = 0; j < n; ++j) {
            matrix[0][j] = 0;
        }
    }
    if (set_first_col) {
        for (int i = 0; i < m; ++i) {
            matrix[i][0] = 0;
        }
    }

}
