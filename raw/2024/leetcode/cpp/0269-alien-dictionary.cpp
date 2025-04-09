#include <map>
#include <queue>
#include <set>
#include <string>
#include <vector>


std::vector<char> get_top_order(std::map<char, std::set<char>> graph, std::map<char, int> inorder) {
    std::vector<char> ans;
    std::queue<char> q;
    for (auto i : inorder) {
        if (i.second == 0) q.push(i.first);
    }
    while (!q.empty()) {
        char c = q.front();
        ans.push_back(c);
        q.pop();
        for (char e : graph[c]){
            if ((--inorder[e]) == 0) {
                q.push(e);
            }
        }
    }
    for (auto & i : inorder) {
        if (i.second) return {};
    }
    return ans;
}


std::map<char, int> get_indegree(const std::map<char, std::set<char>> & graph) {
    std::map<char, int> ans;
    for (auto x : graph) {
        ans[x.first] += 0;
        for (auto e : x.second) {
            ans[e] += 1;
        }
    }
    return ans;
}


std::map<char, std::set<char>> build_graph(const std::vector<std::string> & words) {
    std::map<char, std::set<char>> graph;
    for (auto & w : words) {
        for (char c : w) {
            graph[c] = {};
        }
    }
    for (int i = 0; i < words.size(); ++i) {
        for (int j = i + 1; j < words.size(); ++j) {
            auto & s1 = words[i];
            auto & s2 = words[j];
            int k = 0;
            while (k < s1.size() && k < s2.size() && s1[k] == s2[k]) ++k;
            if (k < s1.size() && k < s2.size()) {
                graph[s1[k]].insert(s2[k]);
            }
            if (k == s2.size() && k < s1.size()) return {};
        }
    }
    return graph;
}

std::string alienOrder(std::vector<std::string>& words) {
    std::map<char, std::set<char>> g = build_graph(words);
    std::map<char, int> inorder = get_indegree(g);
    std::vector<char> order = get_top_order(g, inorder);
    return std::string(order.begin(), order.end());
}
