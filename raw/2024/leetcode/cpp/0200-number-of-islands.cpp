#include <queue>
#include <utility>
#include <vector>


const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};

int M;
int N;

void bfs(std::vector<std::vector<char>>& grid, std::vector<std::vector<bool>>& visited, int i, int j) {

    std::queue<std::pair<int, int>> q;

    q.push({i, j});

    while (!q.empty()) {
        auto cood = q.front();
        q.pop();
        for (int d = 0; d < 4; ++d) {
            int x = cood.first + dx[d];
            int y = cood.second + dy[d];
            if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && grid[x][y] == '1') {
                q.push({x, y});
                visited[x][y] = true;
            }
        }
    }
}

int numIslands(std::vector<std::vector<char>>& grid) {

    M = grid.size();
    N = grid[0].size();

    std::vector<std::vector<bool>> visited(M, std::vector<bool>(N));
    int ans = 0;

    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {

            if (visited[i][j]) continue;
            if (grid[i][j] != '1') continue;
            ans += 1;
            visited[i][j] = true;
            bfs(grid, visited, i, j);
        }
    }
    return ans;
}
