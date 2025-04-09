#include <queue>
#include <set>
#include <vector>
#include <string>


std::vector<std::string> neighbors(std::string w, std::set<std::string>& d) {
    std::vector<std::string> ans;
    for (auto i = w.begin(); i != w.end(); ++i) {
        for (char c = 'a'; c <= 'z'; ++c) {
            if (*i == c) continue;
            std::string n = std::string(w.begin(), i) + c + std::string(i + 1, w.end());
            if (d.find(n) != d.end()) ans.push_back(n);
        }
    }
    return ans;
}


int ladderLength(std::string beginWord, std::string endWord, std::set<std::string>& d, std::set<std::string>& p) {

    int ans = 0;

    std::queue<std::string> q;
    q.push(beginWord);

    while (!q.empty()) {
        int sz = q.size();
        ans += 1;
        for (int c = 0; c < sz; ++c) {
            auto w = q.front();
            p.insert(w);
            q.pop();

            if (w == endWord) return ans;
            else {
                for (auto & n : neighbors(w, d)) {
                    auto it = d.find(n);
                    if (it != d.end()) {
                        q.push(n);
                        d.erase(it);
                    }
                }
            }
        }
    }

    return 0;
}


void dfs(std::string w, std::string endWord, std::set<std::string>& d, int len, std::vector<std::string>& path, std::vector<std::vector<std::string>>& ans) {

    path.push_back(w);

    if (len == 1) {
        if (w == endWord) {
            ans.push_back(std::vector<std::string>(path.rbegin(), path.rend()));
        }
    } else {
        for (auto n : neighbors(w, d)) {
            auto it = d.find(n);
            if (it != d.end()) {
                d.erase(it);
                dfs(n, endWord, d, len-1, path, ans);
                d.insert(n);
            }
        }
    }

    path.pop_back();
}


std::vector<std::vector<std::string>> findLadders(std::string beginWord, std::string endWord, std::vector<std::string>& wordList) {

    std::set<std::string> d(wordList.begin(), wordList.end());
    d.insert(beginWord);
    std::set<std::string> p;
    int len = ladderLength(beginWord, endWord, d, p);
    if (!len) return {};

    std::vector<std::vector<std::string>> ans;
    std::vector<std::string> path;
    dfs(endWord, beginWord, p, len, path, ans);

    return ans;
}
