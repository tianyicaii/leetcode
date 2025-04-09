#include <queue>
#include <set>
#include <string>
#include <vector>


bool is_valid(std::string s) {
    int num_open = 0;
    for (auto c : s) {
        if (c == '(') num_open += 1;
        else if (c == ')') num_open -= 1;
        if (num_open < 0) return false;
    }
    return num_open == 0;
}


std::vector<std::string> get_neighbors(std::string s) {
    std::vector<std::string> ans;
    for (int i = 0; i < s.size(); ++i) {
        if (s[i] == '(' || s[i] == ')') {
            std::string e = s;
            e.erase(i, 1);
            ans.push_back(e);
        }
    }
    return ans;
}


std::vector<std::string> removeInvalidParentheses(std::string s) {

    std::vector<std::string> ans;
    std::queue<std::string> q;
    q.push(s);
    std::set<std::string> visited;
    visited.insert(s);
    bool found = false;

    while (!q.empty() && !found) {
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            std::string x = q.front();
            q.pop();
            if (is_valid(x)) {
                found = true;
                ans.push_back(x);
            }
            std::vector<std::string> neighbors = get_neighbors(x);
            for (auto & y : neighbors) {
                if (visited.count(y)) continue;
                q.push(y);
                visited.insert(y);
            }
        }
    }

    return ans;
}
