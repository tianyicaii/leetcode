#include <functional>
#include <map>
#include <queue>
#include <vector>
#include <string>


std::map<std::string, std::priority_queue<std::string, std::vector<std::string>, std::function<bool(const std::string &, const std::string)>>> build_G(const std::vector<std::vector<std::string>>& tickets) {
    std::map<std::string, std::priority_queue<std::string, std::vector<std::string>, std::function<bool(const std::string &, const std::string)>>> G;
    for (const auto & t : tickets) {
        if (!G.count(t[0])) {
            G[t[0]] = std::priority_queue<std::string, std::vector<std::string>, std::function<bool(const std::string &, const std::string)>>(
                [] (const std::string & a, const std::string & b) { return a > b; });
        }
        G[t[0]].push(t[1]);
    }
    return G;
}


std::vector<std::string> dfs(const std::string & from, std::map<std::string, std::priority_queue<std::string, std::vector<std::string>, std::function<bool(const std::string &, const std::string)>>> & G) {

    std::vector<std::string> ans;
    ans.push_back(from);
    if (!G.count(from) || G[from].empty()) return ans;

    auto & edges = G[from];
    while (!edges.empty()) {
        std::string next = edges.top();
        edges.pop();
        auto sub_path = dfs(next, G);
        ans.insert(ans.begin(), sub_path.begin(), sub_path.end());
    }
    return ans;
}



std::vector<std::string> findItinerary(std::vector<std::vector<std::string>>& tickets) {

    std::vector<std::string> ans;
    auto G = build_G(tickets);
    return dfs("JFK", G);
}

