#include <algorithm>
#include <cstdlib>
#include <string>
#include <vector>

int shortestDistance(std::vector<std::string>& wordsDict, std::string word1, std::string word2) {

    int i1 = -1;
    int i2 = -1;
    int ans = wordsDict.size();

    for (int i = 0; i < wordsDict.size(); ++i) {
        if (wordsDict[i] == word1) i1 = i;
        if (wordsDict[i] == word2) i2 = i;
        if (i1 != -1 && i2 != -1) ans = std::min(ans, std::abs(i1 - i2));
    }
    return ans;
}