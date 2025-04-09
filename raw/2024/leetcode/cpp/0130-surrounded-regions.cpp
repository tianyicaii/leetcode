#include <vector>

const int dx[4] {-1, 1, 0, 0};
const int dy[4] {0, 0, -1, 1};

void solve(std::vector<std::vector<char>>& board, int i, int j) {

    if (i < 0 || i == board.size() || j < 0 || j == board[0].size()) return;
    if (board[i][j] == 'X') return;
    board[i][j] = 'X';
    for (int d = 0; d < 4; ++d) {
        solve(board, i + dx[d], j + dy[d]);
    }
}

void solve(std::vector<std::vector<char>>& board) {

    auto visited = board;
    int M = board.size();
    int N = board[0].size();

    for (int i = 0; i < M; ++i) {
        solve(visited, i, 0);
        solve(visited, i, N-1);
    }
    for (int j = 0; j < N; ++j) {
        solve(visited, 0, j);
        solve(visited, M - 1, j);
    }

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (visited[i][j] == 'O') {
                board[i][j] = 'X';
            }
        }
    }
}
