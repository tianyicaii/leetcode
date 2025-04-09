#include <map>
#include <queue>
#include <set>
#include <vector>

bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {

    std::vector<int> order;

    std::map<int, std::set<int>> G;
    std::map<int, int> D;

    for (int i = 0; i < numCourses; ++i) {
        D[i] = 0;
    }

    for (const auto & p : prerequisites) {

        int first = p.back();
        int second = p.front();

        if (G[first].count(second)) continue;  // already processed
        G[first].insert(second);
        D[second] += 1;
    }

    std::queue<int> Q;
    for (const auto & i : D) {
        if (i.second == 0) {
            Q.push(i.first);
        }
    }

    while (!Q.empty()) {
        int next = Q.front();
        order.push_back(next);
        Q.pop();
        for (auto n : G[next]) {
            D[n] -= 1;
            if (D[n] == 0) Q.push(n);
        }        
    }

    return order.size() == numCourses;

}

