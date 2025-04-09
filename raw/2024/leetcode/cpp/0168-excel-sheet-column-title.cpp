#include <string>

std::string convertToTitle(int columnNumber) {

    std::string ans;

    while (columnNumber) {

        int r = columnNumber % 26;
        columnNumber /= 26;

        if (!r) {
            ans.push_back('Z');
            columnNumber -= 1;
        } else {
            ans.push_back(r + 'A' - 1);
        }
    }
    return std::string(ans.rbegin(), ans.rend());

}
