#include <algorithm>
#include <map>
#include <string>
#include <vector>

class WordDistance {
public:

    std::map<std::string, std::vector<int>> cnt;
    int N;

    WordDistance(std::vector<std::string>& wordsDict) {
        N = wordsDict.size();
        int i = 0;
        for (const auto & s : wordsDict) {
            cnt[s].push_back(i++);
        }
    }

    int shortest(std::string word1, std::string word2) {

        const auto & left = cnt[word1];
        const auto & right = cnt[word2];
        int i = 0, j = 0;
        int ans = N;
        while (i < left.size() && j < right.size()) {
            int p = left[i];
            int q = right[j];
            if (p < q) { ans = std::min(ans, q - p); ++i; }
            else { ans = std::min(ans, p - q); ++j; }
        }
        return ans;
    }

};
