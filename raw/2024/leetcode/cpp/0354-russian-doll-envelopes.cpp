#include <map>
#include <queue>
#include <set>
#include <vector>


// - - //


bool contains(const std::vector<int> & i, const std::vector<int> & j) {
    return i[0] > j[0] && i[1] > j[1];
}


int maxEnvelopes_(std::vector<std::vector<int>>& envelopes) {

    int N = envelopes.size();
    std::map<int, std::set<int>> G;

    for (int i = 0; i < N; ++i) {
        for (int j = i + 1; j < N; ++j) {
            if (contains(envelopes[i], envelopes[j])) {
                G[i].insert(j);
            }
            if (contains(envelopes[j], envelopes[i])) {
                G[j].insert(i);
            }
        }
    }

    std::map<int, int> in_d;
    for (int i = 0; i < N; ++i) {
        in_d[i] = 0;
    }
    for (auto & v : G) {
        for (int i : v.second) {
            in_d[i] += 1;
        }
    }

    std::queue<int> q;
    for (auto & v : in_d) {
        if (!v.second) q.push(v.first);
    }

    int depth = 1;
    while (!q.empty()) {
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            int v = q.front();
            q.pop();
            for (int e : G[v]) {
                in_d[e] -= 1;
                if (in_d[e] == 0) q.push(e);
            }
        }
        depth += 1;
    }
    return depth;
}
