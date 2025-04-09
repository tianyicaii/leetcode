#include <map>
#include <set>
#include <vector>

bool dfs(std::set<int> & seen, std::map<int, std::set<int>> & g, int x, int prev) {
    seen.insert(x);
    for (int e : g[x]) {
        if (e == prev) continue;
        if (seen.count(e)) return false;
        dfs(seen, g, e, x);
    }
    return true;
}

bool validTree(int n, std::vector<std::vector<int>>& edges) {

    std::map<int, std::set<int>> g;
    for (const auto & e : edges) {
        g[e[0]].insert(e[1]);
        g[e[1]].insert(e[0]);
    }
    std::set<int> seen;

    if (!dfs(seen, g, 0, -1)) return false;
    return seen.size() == n;
}
