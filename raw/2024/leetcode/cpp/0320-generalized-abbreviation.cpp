#include <vector>
#include <string>


void helper(std::vector<std::string> & ans, const std::string & word, std::string & path, int index) {
    if (index == word.size()) {
        ans.push_back(path);
        return;
    }

    // no abbr
    path.push_back(word[index]);
    helper(ans, word, path, index + 1);
    path.pop_back();

    // abbr
    if (path.empty() || (path.back() <= 'z' && path.back() >= 'a')) {
        for (int i = index; i < word.size(); ++i) {
            int len = i - index + 1;
            std::string abbr = std::to_string(len);
            path.append(abbr);
            helper(ans, word, path, i + 1);
            path.erase(path.end() - abbr.size(), path.end());
        }
    }
}


std::vector<std::string> generateAbbreviations(std::string word) {

    std::vector<std::string> ans;
    std::string path;
    helper(ans, word, path, 0);
    return ans;
}
