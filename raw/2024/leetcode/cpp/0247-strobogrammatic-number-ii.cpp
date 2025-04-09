#include <map>
#include <queue>
#include <string>


std::map<char, char> pairs = {
    {'0', '0'},
    {'1', '1'},
    {'6', '9'},
    {'8', '8'},
    {'9', '6'},
};


std::vector<std::string> findStrobogrammatic(int n) {


    std::vector<std::string> ans;
    if (n == 0) return ans;
    if (n == 1) return {"0", "1", "8"};

    std::queue<std::string> q;
    if (n % 2) {
        q.push("0");
        q.push("1");
        q.push("8");
    } else {
        q.push("");
    }

    while (!q.empty()) {
        int sz = q.size();
        for (int i = 0; i < sz; ++i) {
            std::string s = q.front();
            q.pop();
            for (const auto i : pairs) {
                std::string next = i.first + s + i.second;
                if (next.size() == n) {
                    if (next[0] != '0') {
                        ans.push_back(next);
                    }
                }
                else q.push(next);
            }
        }
    }

    return ans;
}
