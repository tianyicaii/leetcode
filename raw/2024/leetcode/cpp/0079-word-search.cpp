#include <vector>
#include <string>


std::vector<std::vector<char>> B;
std::vector<std::vector<bool>> F;
int M;
int N;
std::string W;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

bool dfs(int i, int j, int idx) {

    if (B[i][j] != W[idx]) return false;
    if (idx == W.size() - 1) return true;

    F[i][j] = true;
    for (int d = 0; d < 4; d++) {
        int x = i + dx[d];
        int y = j + dy[d];
        if (x >= 0 && x < M && y >= 0 && y < N && F[x][y] == false) {
            if (dfs(x, y, idx+1)) return true;
        }
    }
    F[i][j] = false;
    return false;
}

bool exist(std::vector<std::vector<char>>& board, std::string word) {

    B = board;
    M = board.size();
    N = board[0].size();
    F = std::vector<std::vector<bool>>(M, std::vector<bool>(N));
    W = word;

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (dfs(i, j, 0)) return true;
        }
    }
    return false;
}
