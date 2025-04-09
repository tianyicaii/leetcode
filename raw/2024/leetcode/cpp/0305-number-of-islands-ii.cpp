#include <set>
#include <utility>
#include <vector>

class UF {

private:
    std::vector<int> roots;
    std::vector<int> sz;

public:

    int cnt = 0;

    UF(int N) : roots(N), sz(N, 1) {
        for (int i = 0; i < N; ++i) {
            roots[i] = i;
        }
    }

    int find(int x) {
        while (roots[x] != x) {
            roots[x] = roots[roots[x]];
            x = roots[x];
        }
        return x;
    }

    void connect(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (sz[px] < sz[py]) {
            connect(y, x);
        } else {
            roots[py] = px;
            sz[px] += sz[py];
            cnt -= 1;
        }
    }
};


std::vector<int> numIslands2(int m, int n, std::vector<std::vector<int>>& positions) {

    int N = m * n;
    std::vector<int> ans;
    std::set<std::pair<int, int>> land;
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    UF uf(N);
    for (const auto & p : positions) {
        int i = p[0];
        int j = p[1];

        if (!land.count({i, j})) {

            land.insert({i, j});
            uf.cnt += 1;

            for (int d = 0; d < 4; ++d) {
                int x = i + dx[d];
                int y = j + dy[d];
                if (x >= 0 && x < m && y >= 0 && y < n && land.count({x, y})) {
                    uf.connect(i * n + j, x * n + y);
                }
            }
        }

        ans.push_back(uf.cnt);
    }

    return ans;
}
