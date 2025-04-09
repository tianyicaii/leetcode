#include <queue>
#include <utility>
#include <vector>

void wallsAndGates(std::vector<std::vector<int>>& rooms) {

    int M = rooms.size();
    int N = rooms[0].size();

    const int dx[4] = {-1, 1, 0, 0};
    const int dy[4] = {0, 0, -1, 1};

    std::vector<std::vector<bool>> visited(M, std::vector<bool>(N));

    std::queue<std::pair<int, int>> q;

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (rooms[i][j] == 0) {
                visited[i][j] = true;
                q.push({i, j});
            }
        }
    }

    int distance = 1;
    while (!q.empty()) {
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {

            std::pair<int, int> cood = q.front();
            q.pop();
            for (int d = 0; d < 4; ++d) {
                int x = cood.first + dx[d];
                int y = cood.second + dy[d];
                if (x >= 0 && x < M && y >=0 && y < N && rooms[x][y] != -1 && !visited[x][y]) {
                    visited[x][y] = true;
                    rooms[x][y] = distance;
                    q.push({x, y});
                }
            }
        }
        distance += 1;
    }
}
