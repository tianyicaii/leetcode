#include <map>
#include <queue>
#include <set>
#include <vector>


std::map<int, std::set<int>> build_graph(int n, const std::vector<std::vector<int>>& edges) {
    std::map<int, std::set<int>> G;
    for (int i = 0; i < n; ++i) {
        G[i] = std::set<int>();
    }
    for (auto & e : edges) {
        int x = e[0];
        int y = e[1];
        G[x].insert(y);
        G[y].insert(x);
    }
    return G;
}

void mark(std::map<int, std::set<int>> & G, std::set<int> & visited, int x) {
    std::queue<int> q;
    q.push(x);
    visited.insert(x);

    while (!q.empty()) {
        int y = q.front();
        q.pop();
        for (auto z : G[y]) {
            if (visited.count(z)) continue;
            q.push(z);
            visited.insert(z);
        }
    }
}

int countComponents(int n, std::vector<std::vector<int>>& edges) {

    auto G = build_graph(n, edges);
    std::set<int> visited;
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
        if (visited.count(i)) continue;
        cnt += 1;
        mark(G, visited, i);
    }
    return cnt;
}
