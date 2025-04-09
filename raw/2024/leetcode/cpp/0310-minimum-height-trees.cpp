#include <map>
#include <queue>
#include <set>
#include <vector>


std::map<int, int> in_degree(int n, const std::map<int, std::set<int>> & G) {
    std::map<int, int> I;
    for (int i = 0; i < n; ++i) {
        I[i] = 0;
    }
    for (auto & x : G) {
        for (auto y : x.second) {
            I[y] += 1;
        }
    }
    return I;
}


std::map<int, std::set<int>> build_graph(int n, const std::vector<std::vector<int>> & edges) {
    std::map<int, std::set<int>> G;
    for (int i = 0; i < n; ++i) {
        G[i] = std::set<int>();
    }
    for (const auto & e : edges) {
        int x = e[0];
        int y = e[1];
        G[x].insert(y);
        G[y].insert(x);
    }
    return G;
}


std::vector<int> findMinHeightTrees(int n, std::vector<std::vector<int>>& edges) {

    if (n == 1) return {0};

    auto G = build_graph(n, edges);
    auto I = in_degree(n, G);
    std::queue<int> q;
    std::set<int> visited;
    for (auto i : I) {
        if (i.second == 1) {
            q.push(i.first);
            visited.insert(i.first);
        }
    }
    while (visited.size() < n) {

        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            int x = q.front();
            q.pop();
            for (auto e : G[x]) {
                if (visited.count(e)) continue;
                if (--I[e] == 1) {
                    q.push(e);
                    visited.insert(e);
                }
            }
        }
    }
    std::vector<int> ans;
    while (!q.empty()) {
        ans.push_back(q.front());
        q.pop();
    }
    return ans;
}
