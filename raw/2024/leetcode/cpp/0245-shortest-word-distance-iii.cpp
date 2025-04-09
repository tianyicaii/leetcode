#include <algorithm>
#include <cstdlib>
#include <string>
#include <vector>

std::vector<int> find(const std::vector<std::string> & lst, const std::string & w) {
    std::vector<int> ans;
    for (int i = 0; i < lst.size(); ++i) {
        if (lst[i] == w) ans.push_back(i);
    }
    return ans;
}

int shortestWordDistance(std::vector<std::string>& wordsDict, std::string word1, std::string word2) {
    if (word1 == word2) {
        int ans = wordsDict.size();
        std::vector<int> p = find(wordsDict, word1);
        for (int i = 1; i < p.size(); ++i) {
            ans = std::min(ans, p[i] - p[i-1]);
        }
        return ans;
    } else {
        int ans = wordsDict.size();
        std::vector<int> p1 = find(wordsDict, word1);
        std::vector<int> p2 = find(wordsDict, word2);

        for (int i = 0, j = 0; i < p1.size() && j < p2.size(); ) {
            int x = p1[i];
            int y = p2[j];
            ans = std::min(ans, std::abs(x - y));
            if (x < y) ++i;
            else ++j;
        }
        return ans;
    }


}
