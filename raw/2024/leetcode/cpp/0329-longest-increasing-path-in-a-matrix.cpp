#include <map>
#include <queue>
#include <set>
#include <utility>
#include <vector>


const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};


std::map<std::pair<int, int>, int> in_degree(std::map<std::pair<int, int>, std::set<std::pair<int, int>>> & G) {
    std::map<std::pair<int, int>, int> in_d;
    for (auto & v : G) {
        in_d[v.first] += 0;
        for (auto & e : v.second) {
            in_d[e] += 1;
        }
    }
    return in_d;
}


std::map<std::pair<int, int>, std::set<std::pair<int, int>>> build_graph(std::vector<std::vector<int>>& matrix) {

    int M = matrix.size();
    int N = matrix[0].size();

    std::map<std::pair<int, int>, std::set<std::pair<int, int>>> G;

    for (int i = 0; i < M; ++i) {
        for (int j = 0; j < N; ++j) {

            G[{i, j}];

            for (int d = 0; d < 4; ++d) {
                int x = i + dx[d];
                int y = j + dy[d];
                if (x >= 0 && x < M && y >= 0 && y < N && matrix[i][j] < matrix[x][y]) {
                    G[{i, j}].insert({x, y});
                }
            }
        }
    }
    return G;
}


int longestIncreasingPath(std::vector<std::vector<int>>& matrix) {

    std::map<std::pair<int, int>, std::set<std::pair<int, int>>> graph = build_graph(matrix);
    std::map<std::pair<int, int>, int> in_d = in_degree(graph);

    std::queue<std::pair<int, int>> q;
    for (auto v : in_d) {
        if (v.second == 0) {
            q.push(v.first);
        }
    }
    int depth = 0;
    while (!q.empty()) {
        depth += 1;
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            std::pair<int, int> x = q.front();
            q.pop();
            for (auto & y : graph[x]) {
                in_d[y] -= 1;
                if (in_d[y] == 0) {
                    q.push(y);
                }
            }
        }
    }
    return depth;
}
