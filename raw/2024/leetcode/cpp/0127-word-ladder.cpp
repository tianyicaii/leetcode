#include <queue>
#include <set>
#include <vector>
#include <string>


std::vector<std::string> neighbors(std::string w) {
    std::vector<std::string> ans;
    for (auto i = w.begin(); i != w.end(); ++i) {
        for (char c = 'a'; c <= 'z'; ++c) {
            if (*i == c) continue;
            ans.push_back(std::string(w.begin(), i) + c + std::string(i + 1, w.end()));
        }
    }
    return ans;
}

int ladderLength(std::string beginWord, std::string endWord, std::vector<std::string>& wordList) {

    int ans = 0;

    std::set<std::string> d(wordList.begin(), wordList.end());
    std::queue<std::string> q;
    q.push(beginWord);

    while (!q.empty()) {
        int sz = q.size();
        ans += 1;
        for (int c = 0; c < sz; ++c) {
            auto w = q.front();
            q.pop();
            if (w == endWord) return ans;
            for (auto & n : neighbors(w)) {
                auto it = d.find(n);
                if (it != d.end()) {
                    q.push(n);
                    d.erase(it);
                }
            }
        }
    }

    return 0;
}
