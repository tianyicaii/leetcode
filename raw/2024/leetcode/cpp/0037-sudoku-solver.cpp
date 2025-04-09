#include <vector>
#include <set>

const int N = 9;
const int M = 3;


std::set<char> get_used_digits(std::vector<std::vector<char>>& board, int i, int j) {
    std::set<char> ans;

    for (int c = 0; c < N; c++) {
        if (board[i][c] != '.') { ans.insert(board[i][c]); }
    }
    for (int r = 0; r < N; r++) {
        if (board[r][j] != '.') { ans.insert(board[r][j]); }
    }

    int R = i / M;
    int C = j / M;
    for (int r = 0; r < M; r++) {
        for (int c = 0; c < M; c++) {
            if (board[R * M + r][C * M + c] != '.') {
                ans.insert(board[R * M + r][C * M + c]);
            }
        }
    }
    return ans;
}

bool fill(std::vector<std::vector<char>>& board) {


    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; j++) {

            if (board[i][j] == '.') {
                auto used_digits = get_used_digits(board, i, j);
                if (used_digits.size() == N) { return false; }
                for (int d = 1; d <= 9; d++) {
                    char dd = d + '0';
                    if (used_digits.find(dd) != used_digits.end()) { continue; }
                    board[i][j] = dd;
                    if (fill(board)) { return true; }

                }

                board[i][j] = '.';
                return false;
            }
        }
    }
    return true;
}

void solveSudoku(std::vector<std::vector<char>>& board) {
    fill(board);
}
