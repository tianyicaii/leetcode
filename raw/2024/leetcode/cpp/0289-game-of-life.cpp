#include <vector>


int get_num_neighbors(std::vector<std::vector<int>>& board, int i, int j) {
    int ans = 0;
    for (int r = i-1; r <= i+1; ++r) {
        for (int c = j-1; c <= j+1; ++c) {
            if (r >= 0 && r < board.size() && c >= 0 && c < board[0].size()) {
                if (r == i && c == j) continue;
                if (board[r][c]) ans += 1;
            }
        }
    }
    return ans;
}


void gameOfLife(std::vector<std::vector<int>>& board) {

    int M = board.size();
    int N = board[0].size();

    std::vector<std::vector<int>> board_2(M, std::vector<int>(N));

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {

            int n = get_num_neighbors(board, i, j);

            if (board[i][j] == 0) {
                if (n == 3) board_2[i][j] = 1;
                else board_2[i][j] = 0;
            } else {
                if (n < 2) board_2[i][j] = 0;
                else if (n > 3) board_2[i][j] = 0;
                else board_2[i][j] = 1;
            }
        }
    }
    board = board_2;
}
