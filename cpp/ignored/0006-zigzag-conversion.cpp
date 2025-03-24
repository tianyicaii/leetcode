#include <algorithm>
#include <string>
#include <vector>


std::string convert(std::string s, int numRows) {

    if (numRows < 2) { return s; }

    std::vector<std::string> rows(numRows);
    auto it = rows.begin();
    int inc = 1;

    for (char c : s) {
        it->push_back(c);
        if (it == rows.begin() && inc == -1) {
            it = rows.begin() + 1;
            inc = 1;
        } else if (it == rows.end() - 1 && inc == 1) {
            it = rows.end() - 2;
            inc = -1;
        } else {
            it = it + inc;
        }
    }

    std::string ans;
    std::for_each(rows.begin(), rows.end(), [&ans] (const std::string & row) {ans.append(row);});
    return ans;
}
