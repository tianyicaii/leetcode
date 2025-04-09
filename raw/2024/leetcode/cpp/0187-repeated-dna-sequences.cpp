#include <set>
#include <string>
#include <vector>
#include <map>


std::vector<std::string> findRepeatedDnaSequences(std::string s) {

    std::map<char, int> to_d = {
        {'A', 0},
        {'C', 1},
        {'G', 2},
        {'T', 3},
    };

    std::set<int> seen;
    std::set<std::string> ans;

    int Q = 0;
    int N = 10;
    int i = 0;
    int mask = 3;

    if (s.size() < N) return {};

    while (i < N) {
        int d = to_d[s[i]];
        Q <<= 2;
        Q |= d;
        if (i != 0) mask <<= 2;
        ++i;
    }

    seen.insert(Q);

    while (i != s.size()) {
        int d = to_d[s[i]];
        ++i;
        Q &= ~mask;
        Q <<= 2;
        Q |= d;
        if (seen.count(Q)) {
            ans.insert(s.substr(i-N, N));
        }
        seen.insert(Q);
    }

    return std::vector<std::string>(ans.begin(), ans.end());
}
