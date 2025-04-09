#include <vector>
#include <set>

bool is_ok(std::set<char> & seen, char c) {
    if (c == '.') { return true; }
    if (seen.find(c) != seen.end()) { return false; }
    seen.insert(c);
    return true;
}

bool isValidSudoku(std::vector<std::vector<char>>& board) {

    int N = 9;
    int C = 3;

    for (int i = 0; i < N; ++i) {
        std::set<char> seen;
        for (int j = 0; j < N; j++) {
            if (!is_ok(seen, board[i][j])) {
                return false;
            }
        }
    }

    for (int i = 0; i < N; ++i) {
        std::set<char> seen;
        for (int j = 0; j < N; j++) {
            if (!is_ok(seen, board[j][i])) {
                return false;
            }
        }
    }

    for (int i = 0; i < N/C; ++i) {
        for (int j = 0; j < N/C; j++) {
            std::set<char> seen;
            for (int r = 0; r < C; r++) {
                for (int c = 0; c < C; c++) {
                    if (!is_ok(seen, board[C * i + r][C * j + c])) {
                        return false;
                    }
                }
            }
        }
    }

    return true;
}
