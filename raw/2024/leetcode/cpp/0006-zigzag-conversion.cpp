#include <string>
#include <vector>

std::string convert(std::string s, int numRows) {

    if (numRows < 2) { return s; }

    std::vector<std::string> rows(numRows + 1);
    auto r_it = rows.begin() + 1;
    auto s_it = s.begin();

    while (true) {
        if (s_it == s.end()) { break; }
        while (s_it != s.end() && r_it != rows.end()) {
            r_it->push_back(*s_it++);
            r_it ++;
        }
        if (r_it == rows.end()) { r_it = rows.end() - 2; }
        while (s_it != s.end() && r_it != rows.begin()) {
            r_it->push_back(*s_it++);
            r_it --;
        }
        if (r_it == rows.begin()) { r_it = rows.begin() + 2; }
    }

    std::string ans;
    for (auto it = rows.begin() + 1; it != rows.end(); it++) {

        ans.append(*it);
    }
    return ans;

}
