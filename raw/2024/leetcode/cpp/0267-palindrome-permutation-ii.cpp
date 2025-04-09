#include <map>
#include <string>
#include <vector>


void gen(std::vector<std::string> & ans, std::string & path, std::map<char, int> & cnt, int N) {

    if (path.size() == N) {
        ans.push_back(path);
        return;
    }
    for (auto & i : cnt) {

        if (!i.second) continue;

        i.second -= 2;
        path = i.first + path + i.first;
        gen(ans, path, cnt, N);
        path = path.substr(1, path.size() - 2);
        i.second += 2;
    }
}


std::vector<std::string> generatePalindromes(std::string s) {

    std::map<char, int> cnt;
    for (char c : s) {
        cnt[c] += 1;
    }

    char c = 0;
    for (auto & i : cnt) {
        if (i.second % 2) {
            c = i.first;
            i.second -= 1;
            break;
        }
    }
    for (auto & i : cnt) {
        if (i.second % 2) {
            return {};
        }
    }

    std::string path;
    std::vector<std::string> ans;
    if (c) {
        path = std::string() + c;  // cannot to_string()
    }

    gen(ans, path, cnt, s.size());
    return ans;
}
